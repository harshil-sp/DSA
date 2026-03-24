package NonLinear.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class DepthFirstSearch {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = new Scanner(System.in).nextInt();
        int m = new Scanner(System.in).nextInt();

        // Adjacency List
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        // adding arraylist at all nodes
        for (int i = 0; i < n + 1; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }

        // making an adjacency list
        for (int i = 0; i < m; i++) {
            String[] edge = input.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);

            // adding edge in adjacency list
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        System.out.println("DFS is " + dfs(n, adjacencyList));
    }

    private static ArrayList<Integer> dfs(int n, ArrayList<ArrayList<Integer>> adjacencyList) {

        // dfs list
        ArrayList<Integer> dfs = new ArrayList<>();

        // // visited nodes list
        boolean[] visitedNodes = new boolean[n + 1];

        // visiting every node
        for (int i = 1; i < n + 1; i++) {

            // checking if node is visited or not
            if (!visitedNodes[i]) {
                dfsOfGraph(i, visitedNodes, adjacencyList, dfs);
            }
        }

        // returning bfs list
        return dfs;
    }

    private static void dfsOfGraph(int i, boolean[] visitedNodes, ArrayList<ArrayList<Integer>> adjacencyList, ArrayList<Integer> dfs) {

        // added visited node in dfs
        dfs.add(i);

        // make it visit true
        visitedNodes[i] = true;

        for (Integer integer : adjacencyList.get(i)) {
            if (!visitedNodes[integer]) {
                dfsOfGraph(integer, visitedNodes, adjacencyList, dfs);
            }
        }
    }
}
