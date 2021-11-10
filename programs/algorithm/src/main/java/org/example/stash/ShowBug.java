package org.example.stash;

import java.util.*;

// # /**
// #  * 找出数组中重复的数据
// #  * 给定一个长度为 n 的正整数数组 a，其中 1 ≤ a [i] ≤ n , 其中有些元素出现两次而其他元素出现一次。
// #  * 找到所有出现两次的元素。
// #  * 要求：
// #  * 1. 不能使用任何额外空间
// #  * 2. 在 O (n) 时间复杂度内解决
// #  *
// #  * 示例：
// #  * 输入: [4,3,2,7,8,2,3,1]
// #  * 输出: [2,3]
// #  **/
public class ShowBug {
    public static void main(String[] args) {
        int arrs[] = {2,7,8,4,4,2,3,1};
        Set<Integer> r = res(arrs);
        System.out.println(r);
    }

    public static Set<Integer> res(int arrs[]){
        Set<Integer> r = new HashSet<Integer>();
        for(int i=0;i<arrs.length;i++){
            int num = arrs[i];
            if(num < 0) {
                num = num * -1;
            }
            if (arrs[num-1]<0){
                r.add(num);
            }
            arrs[num - 1] = arrs[num - 1] * -1;

        }
        return r;
    }
}
