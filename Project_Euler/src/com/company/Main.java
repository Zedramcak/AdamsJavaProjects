package com.company;

import java.util.Scanner;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pocetRadku = in.nextInt();

        while (pocetRadku>0){
            pocetRadku--;
            int cislo = in.nextInt();
            BigDecimal hledane = new BigDecimal("0");
            hledane = najdiNejvyssi(hledane,cislo);
            System.out.println(hledane);
        }
    }



    public static BigDecimal najdiNejvyssi(BigDecimal hledane, int cislo){
        double i=2.0;
        while(true){
            BigDecimal momentalni = BigDecimal.valueOf(Math.pow(cislo/i,i));
            if (hledane.subtract(momentalni).compareTo(BigDecimal.ZERO)>0)
                break;
            hledane = momentalni;
            i+=1;
        }
        return hledane;
    }
}
