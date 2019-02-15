package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Pocitac> sit = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int pocetPocitacu = sc.nextInt();
        for (int i = 0; i < pocetPocitacu; i++) {
            sit.add(new Pocitac());
        }
        int pocetNakazenych = sc.nextInt();
        for (int i = 0; i < pocetNakazenych; i++) {
            sit.get(sc.nextInt()).cisty = false;
        }
        for (int i = 0; i < pocetPocitacu; i++) {
            int cisloPocitace = sc.nextInt();
            int pocetSousedu = sc.nextInt();
            for (int j = 0; j < pocetSousedu; j++) {
                sit.get(cisloPocitace).sousede.add(sc.nextInt());
            }
        }

        int pocetMinut = 1;
        while(vsechnyNakazene(sit)){
            pocetMinut++;
            for (Pocitac p: sit) {
                if (p.cisty)
                    nakaziSe(p,sit);
            }

        }

        System.out.println(pocetMinut);

    }
    public static boolean vsechnyNakazene(List<Pocitac> sit){
        for (Pocitac p:
             sit) {
            if (p.cisty)
                return true;
        }
        return false;
    }

    public static void nakaziSe(Pocitac p,List<Pocitac> sit){
        int nakazene = 0;
        int potrebaNakazit = p.sousede.size();
        for (Integer i:p.sousede) {
            if (!sit.get(i).cisty)
                nakazene++;
        }
        if (nakazene*2>=potrebaNakazit)
            p.cisty = false;
    }
}
