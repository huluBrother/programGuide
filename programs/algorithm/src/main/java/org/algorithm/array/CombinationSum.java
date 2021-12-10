package org.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    private static long cnt = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        //backtracking(res,new ArrayList<>(),candidates,target,0);
        dfs(candidates,target,0,new ArrayList<>(),res);

        return res;
    }


    public void dfs(int candidates[],int target,int pos,List<Integer> combina,List<List<Integer>> res){
        cnt++;
        if(pos == candidates.length){
            return;
        }

        if(target == 0){
            res.add(new ArrayList<>(combina));
            return;
        }

        //不需要当前节点
        dfs(candidates,target,pos+1,combina,res);

        //使用当前节点
        if(target - candidates[pos] >= 0){
            combina.add(candidates[pos]);
            dfs(candidates,target-candidates[pos],pos,combina,res);
            combina.remove(combina.size() -1);
        }
    }




    public List<List<Integer>> method1(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrackingSort(res,new ArrayList<>(),candidates,target,0,candidates[0]);

        return res;
    }

    public void backtrackingSort(List<List<Integer>> result,List<Integer> com,int candidates[],int target,int sum,int last){
        cnt++;
        if(sum == target){
            List<Integer> ans = new ArrayList<>(com);
            result.add(ans);
            return;
        }
        int n = com.size();
        for(int i=0;i<candidates.length;i++){
            if(candidates[i] < last){
                continue;
            }
            if(candidates[i] + sum  <= target) {
                com.add(candidates[i]);
                backtrackingSort(result, com, candidates, target, sum + candidates[i],candidates[i]);
                com.remove(n);
            }
        }

    }

    public void backtracking(List<List<Integer>> result,List<Integer> com,int candidates[],int target,int sum){
        cnt++;
        if(sum == target){
            List<Integer> ans = new ArrayList<>(com);
            //这里浪费掉了时间
            Collections.sort(ans);
            if(!result.contains(ans)) {
                result.add(ans);
            }
            return;
        }
        int n = com.size();
        for(int i=0;i<candidates.length;i++){

            if(candidates[i] + sum  <= target) {
                com.add(candidates[i]);
                backtracking(result, com, candidates, target, sum + candidates[i]);
                com.remove(n);
            }
        }

    }

    public static void main(String[] args) {

        /*
        1 <= candidates.length <= 30
        1 <= candidates[i] <= 200
        candidate 中的每个元素都是独一无二的。
        1 <= target <= 500
         */
        int candidates[] = {1};
        int target = 27;
        long begin = System.currentTimeMillis();
        List<List<Integer>> lists = new CombinationSum().combinationSum(candidates, target);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
        System.out.println(lists);
        System.out.println(CombinationSum.cnt);
    }
}
