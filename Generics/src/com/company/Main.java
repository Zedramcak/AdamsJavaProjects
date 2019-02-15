package com.company;

public class Main{

    public static <T extends Comparable<T>> T findMax(T a, T b){
        int n = a.compareTo(b);
        if (n<0) return b;
        else return a;
    }

    public static void main(String[] args) {

        System.out.println(findMax(2,3));
        System.out.println(findMax(3,2));
        System.out.println(findMax(3,3));

        System.out.println(findMax(2.9,3.0));

        System.out.println(findMax('a','b'));

        //Main k = new Main();

        //System.out.println(k,k);
    }

}
