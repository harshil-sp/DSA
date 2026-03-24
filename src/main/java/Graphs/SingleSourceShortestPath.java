package Graphs;

import Graphs.Helper.WeightedGraph;
import Helper.InterfaceMaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class SingleSourceShortestPath {
    public static void main(String[] args) throws IOException {
        InterfaceMaker ifm = new InterfaceMaker("Graphs\\Inputs");
        BufferedReader scanner = new BufferedReader(ifm.getFile("DijkstrasAlgo.txt"));

        int T = Integer.parseInt(scanner.readLine());
        while (T-- > 0) {
            String[] basicInput = scanner.readLine().split(" ");
            int vertices = Integer.parseInt(basicInput[0]);
            int edges = Integer.parseInt(basicInput[1]);

            WeightedGraph g = new WeightedGraph(vertices);
            while (edges-- > 0) {
                String[] input = scanner.readLine().split(" ");
                g.addEdge(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            }

            System.out.println(Arrays.toString(g.getShortestPathFrom(1, false)));
        }

    }
}
