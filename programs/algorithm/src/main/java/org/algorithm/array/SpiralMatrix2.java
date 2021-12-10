package org.algorithm.array;

import java.util.Arrays;

public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int res[][] = new int[n][n];

        int cnt = 1;
        int row = 0;
        int col = 0;
        int direct = 0;
        while(cnt <= n*n){

            if(direct == 0){
                while(col < n && res[row][col] == 0){
                    res[row][col] = cnt++;
                    col++;
                }
                col--;//恢复
                row++;//下一行起始位置
                direct = 1;
            }else if(direct == 1){
                while(row < n && res[row][col] == 0){
                    res[row][col] = cnt++;
                    row++;
                }
                row--;//恢复
                col--;//下一行起始位置
                direct = 2;
            }else if(direct == 2){
                while(col >= 0 && res[row][col] == 0){
                    res[row][col] = cnt++;
                    col--;
                }
                col++;//恢复
                row--;//下一行起始位置
                direct = 3;
            }else if(direct == 3){
                while(row >= 0 && res[row][col] == 0){
                    res[row][col] = cnt++;
                    row--;
                }
                row++;//恢复
                col++;//下一行起始位置
                direct = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ints = new SpiralMatrix2().generateMatrix(4);
        for(int i=0;i<ints.length;i++){
            System.out.println(Arrays.toString(ints[i]));
        }
    }

}
