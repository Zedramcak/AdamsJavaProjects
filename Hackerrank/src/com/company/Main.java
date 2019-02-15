package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            List<String> list = new ArrayList<>();
            int nalezeno = 0;
            if(op.equals("add")){
                list.add(contact);
                System.err.println(list.size());
            }
            else{
                for (String s:list) {
                    if (s.startsWith(contact))
                        nalezeno++;
                }
                System.out.println(nalezeno);
            }
        }
    }
}
