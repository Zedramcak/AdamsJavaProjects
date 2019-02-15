/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textoveprsi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adam
 */
public class Prsi {
    private final ArrayList<Karta> hrac1;
    private final ArrayList<Karta> hrac2;
    private Balicek b;
    private final ArrayList<Karta> stul;
    private Karta naStole;
    private final Scanner sc = new Scanner(System.in,"UTF-8");
    
    public Prsi(){
        hrac1 = new ArrayList<>();
        hrac2 = new ArrayList<>();
        stul = new ArrayList<>();
        
    }
    
    public void hra(){
        boolean pokracovat = true;
        while (pokracovat){
            int i=0;
            zacatekHry();
            boolean stoji = false;
            stul.clear();
            stul.add(new Karta(20,5));
            Karta zahrana = new Karta(20,20);
            
            do{
                
                if (i%2==0){
                    System.out.println("HRAJE HRAC 1");
                    tah(hrac1);
                }
                else if(i%2==1){
                    uspi();
                    tahPC(hrac2);
                    uspi();
                    System.out.println("Pocitaci zbyva "+hrac2.size()+" karet\n");
                }
                
                //Kontrola ESA
                if (naStole.getHodnota()==7&&!naStole.equals(zahrana)){
                    i++;
                    zahrana = naStole;
                }
                
                i++;
                if (!maKarty(hrac1)){
                    System.out.println("HRAC VYHRAL");
                    break;
                }
                if (!maKarty(hrac2)){
                    System.out.println("POCITAC VYHRAL");
                    break;
                }
                
            }while(true);
            System.out.println("Chcete hrat znovu?a/n");
            boolean vstup = false;
            String rozhodnuti = "a";
            do{
                try{
                    rozhodnuti = sc.nextLine().trim();
                    if (rozhodnuti.equals("n")||rozhodnuti.equals("a")){
                        break;
                    }
                    System.out.println("Neplatny vyber. Zvolte \"a\" pro pokracovani nebo \"n\" pro ukonceni programu");
                }
                catch (Exception e){
                    
                }
            }while(!vstup);
            if (rozhodnuti.equals("n"))
                break;
        }
    }
    
    private void rozdejKarty(){
        hrac1.clear();
        hrac2.clear();
        for (int i=0;i<8;i++){
            if (i%2==1){
                hrac1.add(b.getKarty().remove(0));
            }
            else{
                hrac2.add(b.getKarty().remove(0));
            }
        }
    }
    
    private void vypisKartyVRuce(ArrayList<Karta> hrac){
        for (Karta k:hrac){
            System.out.printf("%d) %s%n",hrac.indexOf(k)+1,k);
        }
        System.out.printf("%d) vzit si kartu%n", hrac.size()+1);
    }
    
    private void vemKarty(int pocetKaret, ArrayList<Karta> hrac){
        for (int i=0;i<pocetKaret;i++){
            doplnBalicek();
            hrac.add(b.getKarty().remove(0));
        }
    }
    
    private void doplnBalicek(){
        if (b.getKarty().isEmpty()){
            while (!stul.isEmpty()){
                if (stul.get(stul.size()-1).getBarva()==5)
                    stul.remove(stul.size()-1);
                b.getKarty().add(stul.remove(stul.size()-1));
            }
            stul.add(new Karta(20,5));
        }
    }
    
    private boolean maKarty(ArrayList<Karta> hrac){
        return !hrac.isEmpty();
    }
    
    private void zahrajKartu(Karta k){
        stul.add(naStole);
        naStole = k;
    }
    
    private void zacatekHry(){        
        b = new Balicek();
        Collections.shuffle(b.getKarty());
        rozdejKarty();
        naStole=b.getKarty().remove(0);
    }
    
    private void tahPC(ArrayList<Karta> hrac){
        for (Karta k:hrac){
            if (k.getBarva()==naStole.getBarva()||k.getHodnota()==naStole.getHodnota()){
                System.out.println("Pocitac hraje "+k);
                zahrajKartu(hrac.remove(hrac.indexOf(k)));
                return;
            }                
        }
        System.out.println("Pocitac si bere kartu\n");
        vemKarty(1,hrac);
    }
    
    private void tah(ArrayList<Karta> hrac){
        System.out.println("Na stole je "+naStole);
        System.out.println();
        System.out.println("Jakou kartu chcete zahrat?");
        
        boolean vstup = true;
        int vyber = Integer.MIN_VALUE;
        do{
            try{
                vypisKartyVRuce(hrac);
                vyber = Integer.parseInt(sc.nextLine().trim());
                if (vyber>0&&vyber<=hrac.size()+1){
                    vstup=false;
                    break;                    
                }
                else{
                    System.out.println("NEPLATNY VYBER!");
                    System.out.println("Na stole je "+naStole);
                }
            }
            catch (Exception e){
                System.out.println("NEPLATNY VYBER!");
                System.out.println("Na stole je "+naStole);
            }
        }while(vstup);
        while (true){
            if (vyber==hrac.size()+1){
                vemKarty(1,hrac);
                System.out.println("\n");
                break;
            }
            if (hrac.get(vyber-1).getBarva()==naStole.getBarva()||hrac.get(vyber-1).getHodnota()==naStole.getHodnota()){
                zahrajKartu(hrac.remove(vyber-1));
                System.out.println("\n");
                break;
            }
            System.out.println("Nelze zahrat! Na stole je "+naStole+"\n");
            vstup=true;
            do{
                try{
                    vypisKartyVRuce(hrac);
                    vyber = Integer.parseInt(sc.nextLine().trim());
                    if (vyber>0&&vyber<=hrac.size()+1){
                        vstup=false;
                        break;                    
                    }
                    else{
                        System.out.println("NEPLATNY VYBER!");
                        System.out.println("Na stole je "+naStole);
                    }
                }
                catch (Exception e){
                    System.out.println("NEPLATNY VYBER!");
                    System.out.println("Na stole je "+naStole);
                }
            }while(vstup);
            }
        }
    
    private void uspi(){
        try {
                        Thread.sleep(400);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Prsi.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }
}   
