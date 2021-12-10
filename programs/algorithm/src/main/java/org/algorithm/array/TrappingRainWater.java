package org.algorithm.array;

public class TrappingRainWater {

    public int trap(int[] height) {

        if(height.length < 3){
            return 0;
        }

        int ans = 0;
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];

        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];
        for(int i=1;i<height.length;i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
            rightMax[height.length - 1 - i] = Math.max(height[height.length - 1 - i],rightMax[height.length  - i]);
        }


        for(int i=0;i<height.length;i++){
            int value = Math.min(leftMax[i],rightMax[i]) - height[i];
            if (value > 0) ans += value;
        }
        return ans;
    }


    public static void main(String[] args) {
        int nums[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = new TrappingRainWater().trap(nums);
        System.out.println(trap);
    }
}
