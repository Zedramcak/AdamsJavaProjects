package com.company;

import java.util.ArrayList;

public class Main {

    public static int findNumsOfRepetitions(String s, char c){
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==c)
                sum++;
        }
        return sum;
    }

    public static int[] findNumsOfRepetitionsv1(String s, char[] c){
        int[] sums = new int[c.length];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <c.length ; j++) {
                if(s.charAt(i)==c[j]){
                    sums[j]+=1;
                }
            }
        }
        return sums;
    }


    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        System.out.println(findNumsOfRepetitions("abca",'a'));

        long endTime = System.currentTimeMillis();
        long duration = endTime-startTime;
        System.out.println("Test "+duration+"ms");
    }
}
