package org.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int cnt = matrix.length * matrix[0].length;
        int k = 0;
        int direct = 0;
        int m = 0;
        int n = 0;
        while(k < cnt){
            if(direct == 0){//向右走
                while (!(n == matrix[0].length || matrix[m][n] > 100 )){
                    ans.add(matrix[m][n]);
                    matrix[m][n] = 101;
                    n++;
                    k++;
                }
                m++;
                n--;
                direct = 1;
            }else if(direct == 1){
                while (!(m == matrix.length || matrix[m][n] > 100)){
                    ans.add(matrix[m][n]);
                    matrix[m][n] = 101;
                    m++;
                    k++;
                }
                n--;
                m--;
                direct = 2;
            }else if(direct == 2){
                while (!(n < 0 || matrix[m][n] > 100)){
                    ans.add(matrix[m][n]);
                    matrix[m][n] = 101;
                    n--;
                    k++;
                }
                n++;
                m--;
                direct = 3;
            }else if(direct == 3){
                while (!(m < 0|| matrix[m][n] > 100)){
                    ans.add(matrix[m][n]);
                    matrix[m][n] = 101;
                    m--;
                    k++;
                }
                n++;
                m++;
                direct = 0;
            }

        }
        return ans;
    }


    public static void main(String[] args) {
        int matrix[][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        List<Integer> integers = new SpiralMatrix().spiralOrder(matrix);
        System.out.println(integers);

    }
}
