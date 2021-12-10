package org.algorithm.array;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length  - 1;

        for(int row=0;row<(n/2 + 1);row++){
            for(int col = row;col < (n/2 + 1);col++){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[n-col][row];
                matrix[n-col][row] = matrix[n-row][n-col];
                matrix[n-row][n-col] = matrix[col][n-row];
                matrix[col][n-row] = temp;
            }
        }
    }
}
