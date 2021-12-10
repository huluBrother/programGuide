package org.algorithm.array;

import java.util.*;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(res,ans,candidates,target);
        return res;
    }


    public void dfs(List<List<Integer>> res, List<Integer> ans,int candidates[],int target){
        if(target == 0){
            if(!res.contains(ans)){
                res.add(new ArrayList<>(ans));
            }
            return;
        }

        Set<Integer> level = new HashSet<>();
        for(int i=0;i<candidates.length;i++){
            //-1标记为已经被访问过了
            if(candidates[i] != -1){
                int value = candidates[i];
                //当层不重复搜索
                if(level.contains(value)){
                    continue;
                }
                level.add(value);
                candidates[i] = -1;
                if(target - value >= 0){
                    if(ans.size() > 0 && value < ans.get(ans.size() - 1)){
                        candidates[i] = value;
                        continue;
                    }
                    ans.add(value);
                    dfs(res,ans,candidates,target-value);
                    ans.remove(ans.size() - 1);
                }
                candidates[i] = value;
            }
        }
    }

    public static void main(String[] args) {
        int candidates[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = 27;
        List<List<Integer>> lists = new CombinationSum2().combinationSum2(candidates, target);
        System.out.println(lists);
    }
}
