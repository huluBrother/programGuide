package org.algorithm.array;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while(fast < nums.length){

            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;

        }
        return slow++;
    }

    public static void main(String[] args) {
        int nums[] = {0,1,2,2,3,0,4,2};
        int val = 2;
        int res = new RemoveElement().removeElement(nums, val);
        for(int i=0;i<res;i++){
            System.out.print(nums[i] + " ");
        }
    }
}
