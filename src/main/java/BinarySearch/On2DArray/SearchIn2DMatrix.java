package BinarySearch.On2DArray;

public class SearchIn2DMatrix {

    public static void main(String[] args) {
        SearchIn2DMatrix solMatrix = new SearchIn2DMatrix();
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };
        boolean isFound = solMatrix.searchMatrix(matrix, 13);
        System.out.println(isFound ? "Element is Found" : "Element is not Found");

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int rowLeft = 0, rowRight = m - 1;

        while (rowLeft <= rowRight) {
            int rowMid = rowLeft + (rowRight - rowLeft) / 2;

            if (matrix[rowMid][0] > target) {
                rowRight = rowMid - 1;
                continue;
            } else if (matrix[rowMid][n - 1] < target) {
                rowLeft = rowMid + 1;
                continue;
            }

            int colLeft = 0, colRight = n - 1;
            

            while (colLeft <= colRight) {
                int colMid = colLeft + (colRight - colLeft) / 2;
                int currentEle = matrix[rowMid][colMid];
                if (currentEle == target) {
                    return true;
                } else if (currentEle > target) {
                    colRight = colMid - 1;
                } else {
                    colLeft = colMid + 1;
                }
            }

            break;
            
        }

        return false;

    }

}