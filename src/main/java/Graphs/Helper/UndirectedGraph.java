package Graphs.Helper;

import Graphs.Helper.PairHelper.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This class, Undirected graph, implements the graph interface and have functions and featured related to undirected graph
 * the features reflects...
 * -> storage mode...
 * -> adding edge...
 * -> showing graph...
 * -> etc.
 *
 * @author HENIL RAKESHBHAI MISTRY
 * */
public class UndirectedGraph implements Graph {

    /**
     * Storage information is stored over here...
     * if the variable, ADJ_MATRIX is set in constructor then explicitly it will be using matrix to store and represent
     * graph...
     * otherwise the storage type will be adjacency list
     * */
    public static final int ADJ_MATRIX = 1001;
    public static final int ADJ_LIST = 1002;
    private static final int TYPE = UN_DIRECTED;
    private static int STORAGE_MODE = ADJ_LIST;

    // for storing the total number of vertices...
    public int vertices;
    // for storing the adjacency matrix...
    private int[][] adj_matrix;
    // for storing adjacency list...
    private ArrayList<ArrayList<Integer>> adj_list;


    // all available constructors ======================================================================================
    /**
     * @param n number of vertices...
     * The constructor for this class, it accepts the number of vertices, the edges can be added and stored later...
     * */
    public UndirectedGraph(int n) {
        this(n,STORAGE_MODE);
    }

    /**
     * This constructor for this class, it will accept the number of vertices and the storage mode that you may want...
     * whether to use adjacency matrix or adjacency list for storing graph information...
     *
     * @param n number of vertices...
     * @param storage_mode mode of storage that you want
     *
     * */
    public UndirectedGraph(int n, int storage_mode) {
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

    // all available methods ===========================================================================================
    @Override
    public void addEdge(int i, int j) {
        if(STORAGE_MODE == ADJ_MATRIX) {
            this.adj_matrix[i][j] = 1;
            this.adj_matrix[j][i] = 1;
        } else {
            this.adj_list.get(i).add(j);
            this.adj_list.get(j).add(i);
        }
    }

    @Override
    public void showGraph() {
        if(STORAGE_MODE == ADJ_MATRIX) {
            for (int i=0; i<this.adj_matrix.length; i++) {
                for (int j=0; j<=i; j++) {
                    if(this.adj_matrix[i][j] == 1) {
                        System.out.println("("+i+", "+j+")");
                    }
                }
            }
        } else {
            for (int i=0; i<this.adj_list.size(); i++) {
                System.out.println(i+" ==> "+this.adj_list.get(i));
            }
        }
    }

    /**
     * BFS algorithm for traversing the graph...
     * This algorithm will traverse the graph and will return the list of vertices that are there in graph and connected together
     * no matter how many disconnected graph is there in the graph...
     *
     * @return list of vertices that are connected together in the graph...
     * */
    public List<Integer> getForcedBFS() {
        List<Integer> result = new ArrayList<>();

        boolean[] visited = new boolean[this.vertices+1];
        if(STORAGE_MODE == ADJ_MATRIX) {
            for (int i=1; i<this.vertices; i++) {
                if(visited[i]==false) {

                    Queue<Integer> q = new LinkedList<>();
                    q.add(i);
                    visited[i] = true;

                    while (!q.isEmpty()) {
                        int curr = q.poll();
                        result.add(curr);
                        for (int j=1; j<this.vertices; j++) {
                            if(this.adj_matrix[curr][j] == 1 && visited[j] == false) {
                                q.add(j);
                                visited[j] = true;
                            }
                        }
                    }

                }
            }
        } else {
            for (int i=1; i<this.vertices; i++) {
                if(visited[i]==false) {

                    Queue<Integer> q = new LinkedList<>();
                    q.add(i);
                    visited[i] = true;

                    while (!q.isEmpty()) {
                        int curr = q.poll();
                        result.add(curr);
                        for (int j : this.adj_list.get(i)) {
                            if(visited[j] == false) {
                                q.add(j);
                                visited[j] = true;
                            }
                        }
                    }

                }
            }
        }

        return result;
    }

    /**
     * BFS algorithm for traversing the graph...
     * This algorithm will traverse the graph and will return the list of vertices that are connected with the given vertex...
     *
     * @param start vertex that you want to check the connected vertices...
     * @return list of vertices that are connected with the given vertex...
     * */
    public List<Integer> getBFS(int start) {
        List<Integer> result = new ArrayList<>();

        boolean[] visited = new boolean[this.vertices+1];
        if(STORAGE_MODE == ADJ_MATRIX) {
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            visited[start] = true;

            while (!q.isEmpty()) {
                int curr = q.poll();
                result.add(curr);
                for (int j=1; j<this.vertices; j++) {
                    if(this.adj_matrix[curr][j] == 1 && visited[j] == false) {
                        q.add(j);
                        visited[j] = true;
                    }
                }
            }
        } else {
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            visited[start] = true;

            while (!q.isEmpty()) {
                int curr = q.poll();
                result.add(curr);
                for (int j : this.adj_list.get(curr)) {
                    if(visited[j] == false) {
                        q.add(j);
                        visited[j] = true;
                    }
                }
            }
        }

        return result;
    }


    /**
     * DFS helper method for traversing the graph if the STORAGE_MODE is ADJ_MATRIX...
     *
     * @param i vertex that you want to check the connected vertices...
     * @param matrix adjacency matrix of the graph...
     * @param result list of vertices that are connected with the given vertex...
     * @param visited array of boolean values that will help to check whether the vertex is visited or not...
     * */
    private void dfsHelperMatrix(int i, int[][] matrix, List<Integer> result, boolean[] visited) {
        visited[i] = true;
        result.add(i);
        for (int j=1; j<this.vertices; j++) {
            if(matrix[i][j] == 1 && visited[j] == false) {
                dfsHelperMatrix(j, matrix, result, visited);
            }
        }
    }

    /**
     * DFS helper method for traversing the graph if the STORAGE_MODE is ADJ_LIST...
     *
     * @param i vertex that you want to check the connected vertices...
     * @param list adjacency list of the graph...
     * @param result list of vertices that are connected with the given vertex...
     * @param visited array of boolean values that will help to check whether the vertex is visited or not...
     * */
    private void dfsHelperList(int i, ArrayList<ArrayList<Integer>> list, List<Integer> result, boolean[] visited) {
        visited[i] = true;
        result.add(i);
        for (int j : list.get(i)) {
            if (visited[j] == false) {
                dfsHelperList(j, list, result, visited);
            }
        }
    }

    /**
     * DFs algorithm for traversing the graph...
     * This algorithm will traverse the graph and will return the list of vertices that are connected and the disconnected
     * components in the graph are also traversed...
     *
     * @return list of vertices that are connected with the given vertex...
     * */
    public List<Integer> getForcedDFS() {
        List<Integer> result = new ArrayList<>();

        boolean[] visited = new boolean[this.vertices+1];
        if(STORAGE_MODE == ADJ_MATRIX) {
            for (int i=1; i<this.vertices; i++) {
                if(!visited[i]) {
                    dfsHelperMatrix(i, this.adj_matrix, result, visited);
                }
            }
        } else {
            for (int i=1; i<this.vertices; i++) {
                if(!visited[i]) {
                    dfsHelperList(i, this.adj_list, result, visited);
                }
            }
        }

        return result;
    }

    /**
     * DFS algorithm for traversing the graph...
     * This algorithm will traverse the graph and will return the list of vertices that are connected with the given vertex...
     *
     * @param start vertex that you want to check the connected vertices...
     * @return list of vertices that are connected with the given vertex...
     * */
    public List<Integer> getDFS(int start) {
        List<Integer> result = new ArrayList<>();

        boolean[] visited = new boolean[this.vertices+1];
        if(STORAGE_MODE == ADJ_MATRIX) {
            dfsHelperMatrix(start, this.adj_matrix, result, visited);
        } else {
            dfsHelperList(start, this.adj_list, result, visited);
        }

        return result;
    }

    /**
     * this function will let you know that whether the graph contains a cycle or not...
     * @return true if the graph contains a cycle otherwise false...
     * */
    public boolean isCyclic() {
        boolean result = false;

        boolean[] visited = new boolean[this.vertices+1];
        if (STORAGE_MODE == ADJ_MATRIX) {
            for (int i=1; i<this.adj_matrix.length; i++) {
                if (!visited[i]) {
                    result = isCyclicHelperMatrix(i, this.adj_matrix, visited);
                    if (result) {
                        break;
                    }
                }
            }
        } else {
            for (int i=1; i<this.adj_list.size(); i++) {
                if (!visited[i]) {
                    result = isCyclicHelperList(i, this.adj_list, visited);
                    if (result) {
                        break;
                    }
                }
            }
        }

        return result;
    }

    /**
     * this method will help to check whether the graph is cyclic or not...
     * when the storage mode is ADJ_LIST...
     *
     * @param i vertex that you want to check the connected vertices...
     * @param adj_list adjacency list of the graph...
     * @param visited array of boolean values that will help to check whether the vertex is visited or not...
     *
     * @return true if the graph is cyclic else false...
     * */
    private boolean isCyclicHelperList(int i, ArrayList<ArrayList<Integer>> adj_list, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, -1));
        visited[i] = true;

        while(!q.isEmpty()) {
            int node = q.peek().nodeVal;
            int parent = q.peek().parentVal;
            q.remove();

            for (int j : this.adj_list.get(node)) {
                if (!visited[j]) {
                    q.add(new Pair(j, node));
                    visited[j] = true;
                } else if (j != parent) {
                    System.out.println("Cycle detected...at node : "+j+", starting call from node : "+i+",  parent node is : "+parent);
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * this function will be used to check whether the graph is cyclic or not...
     * when the graph is cyclic, then the function will return true...
     * when the Storage Mode is ADJ_MATRIX...
     *
     * @param i vertex that you want to check the connected vertices...
     * @param adj_matrix adjacency matrix of the graph...
     * @param visited array of boolean values that will help to check whether the vertex is visited or not...
     *
     * @return true if the graph is cyclic...
     * */
    private boolean isCyclicHelperMatrix(int i, int[][] adj_matrix, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, -1));
        visited[i] = true;

        while (!q.isEmpty()) {
            int node = q.peek().nodeVal;
            int parent = q.peek().parentVal;
            q.remove();

            for(int j=1; j<adj_matrix[0].length; j++) {
                if (adj_matrix[node][j] == 1 && !visited[j]) {
                    q.add(new Pair(j, node));
                    visited[j] = true;
                } else if (adj_matrix[node][j] == 1 && j != parent) {
                    System.out.println("Cycle detected...at node : "+j+", starting call from node : "+i+",  parent node is : "+parent);
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * This method will return the list of vertices that are connected to the given vertex...
     * @param vertex vertex that you want to find the connected vertices...
     * @return list of connected vertices...
     * */
    public List<Integer> getConnectedVertices(int vertex) {
        List<Integer> result = new ArrayList<>();
        if (STORAGE_MODE == ADJ_MATRIX) {
            for (int i = 1; i < this.vertices; i++) {
                if (this.adj_matrix[vertex][i] == 1) {
                    result.add(i);
                }
            }
        } else {
            result = this.adj_list.get(vertex);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> getAdj_list() {
        return this.adj_list;
    }
}
