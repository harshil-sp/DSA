package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class CycleDetection {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int nodes = scanner.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= nodes; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 1; i <= nodes; i++) {

            System.out.print("\nEnter number of edges for node " + i + ": ");
            int edge = scanner.nextInt();

            System.out.print("\nEnter edges: ");
            for (int j = 0; j < edge; j++) {
                graph.get(i).add(scanner.nextInt());
            }
        }

        for (ArrayList<Integer> integers : graph) {
            for (Integer number : integers) {
                System.out.print(number + " ");
            }
            System.out.print("\n");
        }
    }
}
