package Graphs;

import Graphs.Helper.DirectedAcyclicGraph;

public class TopologicalSorting {
    public static void main(String[] args) {
        DirectedAcyclicGraph g = new DirectedAcyclicGraph(6);
        g.addEdge(6, 1);
        g.addEdge(6, 3);
        g.addEdge(5, 1);
        g.addEdge(5, 2);
        g.addEdge(3, 4);
        g.addEdge(4, 2);
        g.addEdge(2, 1);
//        loop forming edge is here
//        g.addEdge(1, 4);
        System.out.println(g.getTopologicalOrder());
    }
}
