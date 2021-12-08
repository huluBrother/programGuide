package org;

class Solution {

    public static void main(String[] args) {
        String s = "ABBB";
        int k = 2;
        int i = new Solution().characterReplacement(s, k);
        System.out.println(i);
    }


    public int characterReplacement(String s, int k) {
        int res = 0;

        int slow = 0;
        int fast = slow;
        int nextPos = slow;
        int num  = k;
        while(slow < s.length()){
            fast++; 
            if(s.charAt(slow) != s.charAt(fast)){
                num--;
                nextPos = fast;
                while(num >= 0){

                }
            }
            slow = nextPos;
        }

        return res;
    }

//    public int characterReplacement(String s, int k) {
//        int res = 0;
//        for(int i=0;i<s.length();i++){
//            int temp = 1;
//            int num = k;
//            int next = i+1;
//            while(num >= 0 && next < s.length()){
//                if(s.charAt(next) != s.charAt(i)){
//                    num--;
//                    if(num < 0){
//                        break;
//                    }
//                }
//                temp++;
//                next++;
//            }
//            next = i-1;
//            while(num >= 0 && next >= 0){
//                if(s.charAt(next) != s.charAt(i)){
//                    num--;
//                    if(num < 0){
//                        break;
//                    }
//                }
//                temp++;
//                next--;
//            }
//            res = Math.max(res,temp);
//
//        }
//        return res;
//    }
}
