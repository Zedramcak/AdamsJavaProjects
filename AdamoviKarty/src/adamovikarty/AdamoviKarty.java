/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adamovikarty;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Adam
 */
public class AdamoviKarty {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hra h = new Hra(1,"Adam");
        int pocetPokusu=1000;
        int rf = 0;
        int sf = 0;
        int p = 0;
        int fh = 0;
        int f = 0;
        int s = 0;
        int t = 0;
        int p2 = 0;
        int par = 0;
        
        
        for (int i=0;i<pocetPokusu;i++){
            h.novaHra();
            if(h.royalFlush()){
                rf++;
                continue;
            }
            if(h.streightFlush()){
                sf++;
                continue;
            }
            if(h.poker()){
                p++;
                continue;
            }
            if(h.fullHouse()){
                System.out.println("FH: "+h.getKomb());
                fh++;
                continue;
            }
            if(h.flush()){
                System.out.println("Barva: "+h.getKomb());
                f++;
                continue;
            }
            if (h.postupka()){
                s++;
                continue;
            }
            if (h.threeOfKind()){
                t++;
                continue;
            }
            if(h.doublePair()){
                p2++;
                continue;
            }
            if(h.pair()){
                par++;
            }
        }
        
        System.out.printf("Po %d rozdanich prislo:%n%d kralovskych postupek%n%d postupek v barve%n%d ctveric%n"
                + "%d full housu%n%d barev%n%d postupek%n%d trojic%n%d dvou paru%n%d paru%n", pocetPokusu,rf,sf,p,fh,f,s,t,p2,par);
        
    }
        
}
