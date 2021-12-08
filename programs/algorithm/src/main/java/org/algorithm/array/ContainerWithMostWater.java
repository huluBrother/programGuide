package org.algorithm.array;

public class ContainerWithMostWater {


    /*

    正确性证明：
若暴力枚举，水槽两板围成面积 S(i, j)S(i,j) 的状态总数为 C(n, 2)C(n,2) 。

假设状态 S(i, j)S(i,j) 下 h[i] < h[j]h[i]<h[j] ，在向内移动短板至 S(i + 1, j)S(i+1,j) ，则相当于消去了 {S(i, j - 1), S(i, j - 2), ... , S(i, i + 1)}S(i,j−1),S(i,j−2),...,S(i,i+1) 状态集合。而所有消去状态的面积一定都小于当前面积（即 < S(i, j)<S(i,j)），因为这些状态：

短板高度：相比 S(i, j)S(i,j) 相同或更短（即 \leq h[i]≤h[i] ）；
底边宽度：相比 S(i, j)S(i,j) 更短；
因此，每轮向内移动短板，所有消去的状态都 不会导致面积最大值丢失 ，证毕
     */

    /*
    实际上还有几道题也是用到了这样的缩减搜索空间的思想：
167. 两数之和 II - 输入有序数组
240. 搜索二维矩阵 II
       https://leetcode-cn.com/problems/container-with-most-water/solution/on-shuang-zhi-zhen-jie-fa-li-jie-zheng-que-xing-tu/
     */

    public int maxArea(int[] height) {
        int res = 0;

        int left = 0;
        int right = height.length - 1;
        while(left < right){
            //计算当前最大的面积
            res = Math.max(res, (right-left) * Math.min(height[left],height[right]));
            //缩减搜索空间
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        int res = new ContainerWithMostWater().maxArea(height);
        System.out.println(res);
    }
}
