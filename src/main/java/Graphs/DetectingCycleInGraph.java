package Graphs;

import Graphs.Helper.DirectedGraph;
import Graphs.Helper.Exceptions.LoopFormingEdgeException;

import java.io.IOException;

public class DetectingCycleInGraph {
    public static void main(String[] args) throws IOException, LoopFormingEdgeException {
        /*
        InterfaceMaker Interface = new InterfaceMaker("Graphs//Inputs");
        BufferedReader scanner = new BufferedReader(Interface.getFile("GeneralGraph.txt"));

        int t = Integer.parseInt(scanner.readLine());
        ArrayList<UndirectedGraph> graphs = new ArrayList<>();

        // getting all the graphs...
        while (t-- > 0) {
            String[] input = scanner.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            graphs.add(new UndirectedGraph(n,UndirectedGraph.ADJ_MATRIX));
            while (m-- > 0) {
                String[] edge = scanner.readLine().split(" ");
                int u = Integer.parseInt(edge[0]);
                int v = Integer.parseInt(edge[1]);
                graphs.get(graphs.size() - 1).addEdge(u, v);
            }
        }
        // all the graphs are ready...

        for (UndirectedGraph graph : graphs) {
//            graph.showGraph();
            System.out.println(graph.isCyclic() ? "YES" : "NO");
        }
        */

        // directed graph cycle detection...
        DirectedGraph g = new DirectedGraph(9);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(4,5);
        g.addEdge(3,6);
        g.addEdge(6,5);
        g.addEdge(7,2);
        g.addEdge(7,8);
        g.addEdge(8,9);
        g.addEdge(9,7);
        g.showGraph();
        System.out.println(g.isCyclic()?"YES" : "NO");
    }
}
