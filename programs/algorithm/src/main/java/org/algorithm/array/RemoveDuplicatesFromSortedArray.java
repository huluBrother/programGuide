package org.algorithm.array;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int pos = 1;
        int size = nums.length;
        while(pos < size){
            if(nums[pos] == nums[pos-1]){
                for(int i=pos;i < size - 1;i++){
                    nums[i] = nums[i+1];
                }
                size--;
            }else{
                pos++;

            }

        }
        return pos;
    }

    public int removeDuplicates2(int[] nums) {
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                p++;
                nums[p] = nums[q];
            }
            q++;
        }
        return p+1;
    }


    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,2,2,3,3,4};
        int res = new RemoveDuplicatesFromSortedArray().removeDuplicates(nums);
        System.out.println(res);
    }
}
