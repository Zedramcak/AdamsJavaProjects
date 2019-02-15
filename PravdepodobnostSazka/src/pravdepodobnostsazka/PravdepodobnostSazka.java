/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pravdepodobnostsazka;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author Adam
 */
public class PravdepodobnostSazka {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random r = new Random();
        long pokus = 1;
        ArrayList<Integer> los1 = new ArrayList<>();
        ArrayList<Integer> los2 = new ArrayList<>();
        ArrayList<Integer> vybrane = new ArrayList<>();
        ArrayList<Integer> vybrane2 = new ArrayList<>();
        
        
        
        while(true){
            los1.clear();
            los2.clear();
            while (los1.size()<6){
                int a = r.nextInt(50)+1;
                if (!los1.contains(a))
                    los1.add(a);
            }
            while (los2.size()<2){
                int a = r.nextInt(10)+1;
                if (!los2.contains(a))
                    los2.add(a);
            }
            los1.sort(Comparator.naturalOrder());
            los2.sort(Comparator.naturalOrder());
            vybrane2.clear();
            vybrane.clear();
            while (vybrane.size()<6){
                int a = r.nextInt(50)+1;
                if (!vybrane.contains(a))
                    vybrane.add(a);
            }
            while (vybrane2.size()<2){
                int a = r.nextInt(10)+1;
                if (!vybrane2.contains(a))
                    vybrane2.add(a);
            }
            vybrane.sort(Comparator.naturalOrder());
            vybrane2.sort(Comparator.naturalOrder());
            
            
            pokus++;
            if (pokus%10000000==0) System.out.print(".");
            if (pokus%200000000==0) System.out.println();
            if (los1.equals(vybrane)&&los2.equals(vybrane2))
                break;
        }
        System.out.println("\n"+vybrane+" "+vybrane2);
        System.out.println(pokus);
    }
    
}
