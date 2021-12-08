package org.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {


    public List<List<Integer>> fourSum(int[] nums, int target) {

        if(nums.length < 4){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0;i<nums.length;i++){

            if( i != 0 && nums[i] == nums[i-1]){
                continue;
            }

            for(int j=i+1;j<nums.length;j++){
                if(j != i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                int left = j+1;
                int right = nums.length - 1;

                while(left < right){

                    if(nums[i] + nums[j] + nums[left] + nums[right] == target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left < right && nums[left] == nums[left+1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }
                    else if(nums[i] + nums[j] + nums[left] + nums[right] < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {2,2,2,2,2};
        int target = 8;
        List<List<Integer>> lists = new FourSum().fourSum(nums, target);
        System.out.println(lists);
    }
}
