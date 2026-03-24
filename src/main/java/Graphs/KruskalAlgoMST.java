package Graphs;

import Graphs.Helper.WeightedGraph;
import Helper.InterfaceMaker;

import java.io.BufferedReader;
import java.io.IOException;

public class KruskalAlgoMST {
    public static void main(String[] args) throws IOException {
        InterfaceMaker ifm = new InterfaceMaker("Graphs\\Inputs");
        BufferedReader scanner = new BufferedReader(ifm.getFile("KruskalAlgo.txt"));

        int T = Integer.parseInt(scanner.readLine());
        while (T-- > 0) {
            String[] input_main = scanner.readLine().split(" ");
            int vertices = Integer.parseInt(input_main[0]);
            int edges = Integer.parseInt(input_main[1]);

            WeightedGraph g = new WeightedGraph(vertices);
            while (edges-- > 0) {
                String[] input = scanner.readLine().split(" ");
                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);
                int w = Integer.parseInt(input[2]);

                g.addEdge(u,v,w);
            }
            g.printMinimumSpanningTree();
            g.printKruskalMST();
        }
    }
}
