package Graphs.Helper;

import Graphs.Helper.Exceptions.LoopFormingEdgeException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @DAGS directed acyclic graphs, is very important to manage dependencies...
 * */
public class DirectedAcyclicGraph extends DirectedGraph {

    // only and only default option of constructor...
    public DirectedAcyclicGraph(int n) {
        super(n);
    }

    /**
     * Adding an edge will take more time now in DAGs because everytime you add new edge the computer will look out
     * that edge is not forming any loop.
     *
     * @param i source vertex
     * @param j destination vertex
     * */
    public void addEdge(int i, int j) {
        super.addEdge(i, j);
        if (super.isCyclic()) {
            this.removeEdge(i,j);
            try {
                throw new LoopFormingEdgeException(i,j);
            } catch (LoopFormingEdgeException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void removeEdge(int i, int j) {
        this.adj_list.get(i).remove((Object) j);
    }

    /**
     * @Kahn's_Algorithm this algorithm uses BFS as base to get the topological sorting of a DAGs
     * This algorithm maintains two arrays of size of total vertices...
     *
     * @Indegree_Array to keep track of the In degree of each vertices
     * @Visited_Array to keep track of which vertices are visited
     * */
    public ArrayList<Integer> getTopologicalOrder() {
        ArrayList<Integer> topologicalOrder = new ArrayList<>();

        boolean[] Visited = new boolean[this.vertices];
        int[] In_Degree = new int[this.vertices];

        // making in degree...
        for (int i=1; i<this.adj_list.size(); i++) {
            for (int node : this.adj_list.get(i)) {
                In_Degree[node] += 1;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=1 ;i<In_Degree.length; i++) {
            if (In_Degree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            topologicalOrder.add(node);

            for (int neighbours : this.adj_list.get(node)) {
                if (--In_Degree[neighbours] == 0) {
                    q.add(neighbours);
                }
            }
        }

        return topologicalOrder;
    }
}
