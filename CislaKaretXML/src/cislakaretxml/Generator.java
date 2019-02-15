/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cislakaretxml;

import java.util.ArrayList;

/**
 *
 * @author Adam
 */
public class Generator {
    
    public ArrayList<Karta> karty;
    
    public void generuj(int pocetKaret){
        for (int i=0;i<pocetKaret;i++){
            double a = Math.random();
            double c = Math.random();
            double f = Math.random();
            double castka = f*1000000;
            while (c<0.1){
                c = Math.random();
            }
            Integer pin = (int)(c*10000);
            while(a<0.1){
                a = Math.random();
            }
            long b = (long) Math.pow(10, 16);
            b*= a;
            karty.add(new Karta(b,pin,castka));
        }
    }

    /**
     * @return the karty
     */
    public ArrayList<Karta> getKarty() {
        return karty;
    }
}
