package org.algorithm.array;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.Arrays;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        int i = 0;
        while(i < nums.length){

            int value = nums[i] - 1;
            if(value < 0 || value >= nums.length || value == i){
                i++;
            }else{
                int temp = nums[value];
                nums[value] = nums[i];
                nums[i] = temp;
                //前边的位置已经存在了
                if(nums[i] == nums[value]){
                    nums[i] = -1;
                    i++;
                }
            }
        }

        for(i = 0;i<nums.length;i++){
            if(nums[i] - 1 != i){
                return i + 1;
            }
        }
        return nums.length+1;

    }

    /*
     */
    public int firstMissingPositive1(int[] nums) {
        boolean first = true;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                first = false;
                break;
            }
        }
        if(first) return 1;

        for(int i=0;i<nums.length;i++){
            if(nums[i] <= 0){
                nums[i] = 1;
            }
        }

        for(int i=0;i<nums.length;i++){
            int pos = Math.abs(nums[i]) - 1;
            nums[pos] = Math.abs(nums[pos]) * -1;
        }

        for(int i = 0;i<nums.length;i++){
            if(nums[i] > 0){
                return i+1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int nums[] = {1,1};
        int ans = new FirstMissingPositive().firstMissingPositive(nums);
        System.out.println(ans);
    }
}
