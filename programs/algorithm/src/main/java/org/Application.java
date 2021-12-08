package org;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Application {

    public static void main(String[] args) {
        String words[] = {"abcw","baz","foo","bar","xtfn","abcdef"};
        new Application().maxProduct(words);
    }

    public int maxProduct(String[] words) {
        int res = 0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(isLegal(words[i],words[j])){
                    Math.max( res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    public boolean isLegal(String left,String right){
        int num[] = new int[26];
        for(int i=0;i<left.length();i++){
            num[left.charAt(i) - 'a']++;
        }
        for(int j=0;j<right.length();j++){
            if(num[right.charAt(j) - 'a'] != 0){
                return false;
            }
        }
        return true;
    }


}
