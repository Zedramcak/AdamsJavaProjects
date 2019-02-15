package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer,Integer> array = new HashMap<Integer,Integer>();
        int n = in.nextInt();
        for (int i=1;i<=n;i++)
            array.put(in.nextInt(),i);
        for (int i=1;i<=n;i++)
            System.out.println(array.get(array.get(i)));
    }
}
