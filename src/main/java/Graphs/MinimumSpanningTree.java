package Graphs;

import Graphs.Helper.WeightedGraph;
import Helper.InterfaceMaker;

import java.io.BufferedReader;
import java.io.IOException;

public class MinimumSpanningTree {
    public static void main(String[] args) throws IOException {
        InterfaceMaker ifm = new InterfaceMaker("Graphs\\Inputs");
        BufferedReader scanner = new BufferedReader(ifm.getFile("PrimsAlgo.txt"));

        int T = Integer.parseInt(scanner.readLine());
        while (T-- > 0) {
            String[] input = scanner.readLine().split(" ");
            int vertex = Integer.parseInt(input[0]);
            int edges = Integer.parseInt(input[1]);

            WeightedGraph g = new WeightedGraph(vertex);
            while (edges-- > 0) {
                input = scanner.readLine().split(" ");
                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);
                int w = Integer.parseInt(input[2]);
                g.addEdge(u,v,w);
            }
            g.printMinimumSpanningTree();
        }
    }
}
