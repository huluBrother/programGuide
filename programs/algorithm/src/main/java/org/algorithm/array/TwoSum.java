package org.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Given an array of integers `nums` and an integer `target`, return indices(指数，索引) of the two numbers
     *      such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * You can return the answer in any order.
     *
     * Constraints:
     *
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * Only one valid answer exists.
     *
     * Example 1:
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
     *
     * Example 2:
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     */

    /**
     * 思路:
     *      使用哈希表来完成。
     *      因为数组未必是有序的，所以无法使用双指针来完成
     */

    public static void main(String args[]){
        TwoSum solution = new TwoSum();

        int nums[] = {3,2,4};
        int target= 6;

        int[] ints = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }



    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hash = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hash.containsKey(target-nums[i])){
                return new int[]{hash.get(target-nums[i]),i};
            }
            hash.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
