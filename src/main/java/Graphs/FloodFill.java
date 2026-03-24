package Graphs;

import Global.ArrayPrinter;
import Global.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        FloodFill floodFill = new FloodFill();
        int[][] resultImage = floodFill.floodFill(image, 0, 0, 0);

        ArrayPrinter.printAnyArray(resultImage);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] visited = new int[m][n];

        bfs(image, sr, sc, color, image[sr][sc], visited);

        return image;
    }

    public void bfs(int[][] image, int sr, int sc, int color, int iniCol, int[][] visited) {
        int m = image.length;
        int n = image[0].length;
        image[sr][sc] = color;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair != null) {
                int row = pair.first;
                int col = pair.second;
                visited[row][col] = 1;

                if (row - 1 >= 0 && image[row - 1][col] == iniCol) {
                    image[row - 1][col] = color;
                    if (visited[row - 1][col] != 1) {
                        queue.add(new Pair(row - 1, col));
                    }
                }
                if (col + 1 < n && image[row][col + 1] == iniCol) {
                    image[row][col + 1] = color;
                    if (visited[row][col + 1] != 1) {
                        queue.add(new Pair(row, col + 1));
                    }
                }
                if (col - 1 >= 0 && image[row][col - 1] == iniCol) {
                    image[row][col - 1] = color;
                    if (visited[row][col - 1] != 1) {
                        queue.add(new Pair(row, col - 1));
                    }
                }
                if (row + 1 < m && image[row + 1][col] == iniCol) {
                    image[row + 1][col] = color;
                    if (visited[row + 1][col] != 1) {
                        queue.add(new Pair(row + 1, col));
                    }
                }
            }

            ArrayPrinter.printAnyArray(visited);
            System.out.println();
        }

    }
}
