package org.algorithm.array;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i] = Math.max(nums[i-1] + nums[i],nums[i]);
            ans = Math.max(ans,nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

    }

}
