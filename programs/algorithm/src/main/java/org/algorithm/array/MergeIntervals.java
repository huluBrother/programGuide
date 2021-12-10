package org.algorithm.array;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    //保证intervals严格有序
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        int res[][] = new int[intervals.length][];
        res[0] = new int[]{intervals[0][0],intervals[0][1]};
        int num =0;
        for(int i=1;i<intervals.length;i++){

            if(intervals[i][0] <= res[num][0]){
                res[num][0] = intervals[i][0];
                res[num][1] = Math.max(intervals[i][1],res[num][1]);
            }else if(intervals[i][0] <= res[num][1]){
                res[num][1] = Math.max(intervals[i][1],res[num][1]);
            }else{
                num++;
                res[num] = new int[]{intervals[i][0],intervals[i][1]};
            }
        }
        int ans[][] = new int[num + 1][2];
        for(int i=0;i<= num;i++){
            ans[i][0] = res[i][0];
            ans[i][1] = res[i][1];
        }
        return ans;
    }
}
