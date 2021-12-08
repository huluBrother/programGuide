package org.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        if(nums.length < 3){
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            //重复搜索，剔除
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            //剩下的全部是正数部分
            if(nums[i] > 0){
                break;
            }
            //确定搜索空间为[i+1,n],[0,i-1]空间已经在之前被搜索 过了
            int left = i + 1;
            int right = nums.length -1;
            while(left < right){
                if(nums[left] + nums[right] + nums[i] == 0){
                    List<Integer> ans = Arrays.asList(nums[i],nums[left],nums[right]);
                    res.add(ans);
                    //子空间重复，剔除搜索
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {-2,0,1,1,2};
        List<List<Integer>> lists = new ThreeSum().threeSum(nums);
        System.out.println(lists);
    }
}
