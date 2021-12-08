package org.algorithm.array;

import java.util.Arrays;

public class ThreeSumClosest {


    public int threeSumClosest(int[] nums, int target) {
        //初始值如何确定呢？
        int res = nums[0]+ nums[1] + nums[2];

        //先对数据进行排序
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){

            if(i != 0 && nums[i-1] == nums[i]){
                continue;
            }
            int left = i+1;
            int right = nums.length - 1;

            while(left < right){

                int value = nums[i] + nums[left] + nums[right];

                if(Math.abs(res - target) > Math.abs(value - target)){
                    res = value;
                }

                if(value < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int nums[] = {-1,2,1,-4};
        int target = 1;
        int res = new ThreeSumClosest().threeSumClosest(nums, target);
        System.out.println(res);
    }
}
