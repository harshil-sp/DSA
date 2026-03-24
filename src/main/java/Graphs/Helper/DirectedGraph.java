package Graphs.Helper;

import java.util.ArrayList;

public class DirectedGraph implements Graph {


    public static final int ADJ_MATRIX = 1001;
    public static final int ADJ_LIST = 1002;
    private static final int TYPE = UN_DIRECTED;
    private static int STORAGE_MODE = ADJ_LIST;

    // for storing the total number of vertices...
    public int vertices;
    // for storing the adjacency matrix...
    private int[][] adj_matrix;
    // for storing adjacency list...
    protected ArrayList<ArrayList<Integer>> adj_list;

    public DirectedGraph(int n) {
        this(n,STORAGE_MODE);
    }

    public DirectedGraph(int n, int storage_mode) {
        vertices = n+1;
        if(storage_mode == ADJ_MATRIX) {
            this.adj_matrix = new int[vertices][vertices];
            STORAGE_MODE = ADJ_MATRIX;
        } else {
            this.adj_list = new ArrayList<>();
            for(int i=0; i<vertices; i++) {
                this.adj_list.add(new ArrayList<>());
            }
            STORAGE_MODE = ADJ_LIST;
        }
    }

    /**
     * This method will be used to make a new edge connecting vertices, a and b both together.
     *
     * @param i
     * @param j
     */
    @Override
    public void addEdge(int i, int j) {
        if(STORAGE_MODE == ADJ_MATRIX) {
            this.adj_matrix[i][j] = 1;
        } else {
            this.adj_list.get(i).add(j);
        }
    }

    /**
     * This method will be used to show the final connections of a graph. Which are all the vertices connected together?
     */
    @Override
    public void showGraph() {
        if(STORAGE_MODE == ADJ_MATRIX) {
            for (int i=0; i<this.adj_matrix.length; i++) {
                for (int j=0; j<this.adj_matrix[0].length; j++) {
                    if(this.adj_matrix[i][j] == 1) {
                        System.out.println("("+i+" ---> "+j+")");
                    }
                }
            }
        } else {
            for (int i=0; i<this.adj_list.size(); i++) {
                System.out.println(i+" ==> "+this.adj_list.get(i));
            }
        }
    }

    public boolean isCyclic() {
        boolean result = false;

        boolean[] visited = new boolean[this.vertices+1];
        boolean[] DFSVisited = new boolean[this.vertices+1];

        if (STORAGE_MODE == ADJ_MATRIX) {
            System.out.println("Work is pending...");
        } else {
            for (int i=1; i<this.adj_list.size(); i++) {
                if (!visited[i]) {
                    result = cyclicHelperList(i,visited,DFSVisited);
                    if (result) {
                        break;
                    }
                }
            }
        }

        return result;
    }

    private boolean cyclicHelperList(int i, boolean[] vis, boolean[] dfsvis) {
        vis[i] = true;
        dfsvis[i] = true;
        for (int neighbour : this.adj_list.get(i)) {
            if (!vis[neighbour]) {
                if (cyclicHelperList(neighbour, vis, dfsvis)) return true;
            } else if(dfsvis[neighbour]) {
                System.out.println("Detected at node : "+neighbour+" parent node is : "+i);
                return true;
            }
        }
        dfsvis[i] = false;
        return false;
    }

    public ArrayList<Integer> getDirectNeighbours(int i) {
        return this.adj_list.get(i);
    }

    public ArrayList<Integer> getDFS(int start) {
        ArrayList<Integer> result = new ArrayList<>();

        boolean[] visited = new boolean[this.vertices+1];
        for (int neighbour : this.adj_list.get(start)) {
            if (!visited[neighbour]) {
                dfsHelperList(neighbour, this.adj_list, result, visited);
            }
        }
        return result;
    }

    private void dfsHelperList(int i, ArrayList<ArrayList<Integer>> adj_list, ArrayList<Integer> result, boolean[] visited) {
        visited[i] = true;
        result.add(i);
        for (int j : adj_list.get(i)) {
            if (!visited[j]) {
                dfsHelperList(j, adj_list, result, visited);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> getAdj_list() {
        return this.adj_list;
    }
}
