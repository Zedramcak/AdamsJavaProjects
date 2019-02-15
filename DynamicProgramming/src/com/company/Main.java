package com.company;

import java.math.BigInteger;
import java.util.*;

class MyQueue<T>{

    LinkedList<T> q;

    public MyQueue(){
        q = new LinkedList<>();
    }

    public void enqueue(T i) {
        q.add(i);
    }

    public void dequeue() {
        q.removeFirst();
    }

    public T peek() {
        return q.peekFirst();
    }
}


public class Main {

    public static int fibRec(int n){
        if(n<=2)
            return 1;
        return fibRec(n-1)+fibRec(n-2);
    }

    public static long bottomUpFib(long n){
        long[] k = new long[(int)n];
        for (int i = 0; i < n; i++) {
            if (i<2)
                k[i] = 1;
            else
                k[i] = k[i-1]+k[i-2];
        }
        return k[(int) (n-1)];
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] x = new int[n];
        int xxw = 0;
        int wSum = 0;

        for(int i = 0; i<n; i++){
            x[i] = in.nextInt();
        }

        for(int i = 0; i<n; i++){
            int w = in.nextInt();
            xxw += x[i]*w;
            wSum+=w;
        }

        System.out.printf("%.1f", xxw/wSum);
    }

    private static BigInteger modifiedFib(int t1, int t2, int n) {
        BigInteger[] output = new BigInteger[n];
        output[0] = new BigInteger(String.valueOf(t1));
        output[1] = new BigInteger(String.valueOf(t2));
        for (int i = 2; i <output.length ; i++) {
            output[i] = output[i-2].add(output[i-1].pow(2));
        }
        return output[n-1];
    }
}
