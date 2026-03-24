package NonLinear.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {
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

        System.out.println("BFS is " + bfs(n, adjacencyList));
    }

    public static ArrayList<Integer> bfs(int numberOfNodes, ArrayList<ArrayList<Integer>> adjacencyList) {

        // bfs list
        ArrayList<Integer> bfs = new ArrayList<>();

        // visited nodes list
        boolean[] visitedNodes = new boolean[numberOfNodes + 1];

        // visiting every node
        for (int i = 1; i < numberOfNodes + 1; i++) {

            // checking if node is visited or not
            if (!visitedNodes[i]) {

                // making a queue
                Queue<Integer> bfsQueue = new LinkedList<>();
                bfsQueue.add(i);

                // node i is visited
                visitedNodes[i] = true;

                while (!bfsQueue.isEmpty()) {

                    // deleting node which is visited
                    Integer node = bfsQueue.poll();
                    bfs.add(node);

                    for (Integer integer : adjacencyList.get(node)) {
                        if (!visitedNodes[integer]) {
                            visitedNodes[integer] = true;
                            bfsQueue.add(integer);
                        }
                    }
                }
            }
        }

        // returning bfs list
        return bfs;
    }
}
