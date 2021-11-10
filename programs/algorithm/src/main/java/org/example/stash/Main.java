package org.example.stash;

import java.util.*;

public class Main{


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String first = sc.nextLine();
        String second = sc.nextLine();
        //String right = exchange(first,second);
        int resNum = 0;


        for(int i=0;i<num;i++){
            char ch = first.charAt(i);
            for(int j=i+1;j<num;j++){

                if(ch == first.charAt(j)){
                    continue;
                }
                if(second.charAt(i) == '1' && second.charAt(j) == '1'){
                    continue;
                }
                resNum++;
            }
        }
        System.out.println(resNum);


    }

    public static String exchange(String s1 ,String s2){
        StringBuffer sb = new StringBuffer();

        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) == '1' || s2.charAt(i) == '1'){
                sb.append('1');
            }else{
                sb.append('0');
            }
        }
        return sb.toString();

    }
}
