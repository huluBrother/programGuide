package org.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][]{{newInterval[0],newInterval[1]}};
        }
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while(i < intervals.length){
            if(newInterval[0] > intervals[i][1]){
                res.add(new int[]{intervals[i][0],intervals[i][1]});
            }else{
                int nextInterval[] = {-1,-1};
                if(newInterval[0] <= intervals[i][0]){
                    nextInterval[0] = newInterval[0];
                }else{
                    nextInterval[0] = intervals[i][0];
                }
                while( i <intervals.length){
                    if(newInterval[1] >= intervals[i][0] && newInterval[1] < intervals[i][1]){
                        nextInterval[1] = intervals[i][1];
                        i++;
                        break;
                    }else if(newInterval[1] < intervals[i][0]){
                        nextInterval[1] = newInterval[1];
                        break;
                    }
                    i++;
                }
                if( i == intervals.length && nextInterval[1] == -1){
                    nextInterval[1] = newInterval[1];
                }
                res.add(nextInterval);
                break;
            }
            i++;
        }
        for(;i<intervals.length;i++){
            res.add(new int[]{intervals[i][0],intervals[i][1]});
        }
        if(newInterval[0] > intervals[intervals.length-1][0]){
            res.add(newInterval);
        }

        int ans[][] = new int[res.size()][2];
        for(i=0;i<res.size();i++){
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }
        return ans;
    }


    public static void main(String[] args) {
        int intervals[][] = {{1,3}};
        int newIntervals[] = {4,5};
        int[][] insert = new InsertInterval().insert(intervals, newIntervals);
        for(int i=0;i<insert.length;i++)
            System.out.println(Arrays.toString(insert[i]));
    }
}
