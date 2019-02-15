/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adamovikarty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Adam
 */
public class Hra {
    private Balicek b;
    private final ArrayList<Karta> rozdane;
    private int pocetHracu;
    private final Hrac hrac;
    private final ArrayList<Karta> stul;
    private final ArrayList<Karta> komb;
    
    public Hra(int pocetHracu, String jmeno){
        b = new Balicek();
        rozdane = new ArrayList<>();
        this.pocetHracu=pocetHracu;
        hrac = new Hrac(jmeno);
        stul = new ArrayList<>();
        komb = new ArrayList<>();
    }
    
    private void hracVen(){
        pocetHracu-=1;
    }
    
    public void novaHra(){
        b = new Balicek();
        rozdatKartyHraci();
        rozdatKartyNaStul();
    }
    
    private void rozdatKartyHraci(){
        hrac.getHand().clear();
        for(int i=0;i<2;i++){
            Karta k = b.getKarty().get((int)(Math.random()*b.getKarty().size()));
            hrac.getHand().add(k);
            b.getKarty().remove(k);
        }        
    }
    
    private void rozdatKartyNaStul(){
        getStul().clear();
        for(int i=0;i<5;i++){
            Karta k = b.getKarty().get((int)(Math.random()*b.getKarty().size()));
            getStul().add(k);
            b.getKarty().remove(k);
        }
    }
    
    /**
     *
     * @return 
     */
    public boolean royalFlush(){
        getKomb().clear();                
        int cross=0;
        int diamond=0;
        int hearth=0;
        int spade=0;
        getHrac().getHand().forEach((k) -> {
            getKomb().add(k);
        });
        stul.forEach((k) -> {
            getKomb().add(k);
        });

        for (Karta i : getKomb()){
            if (i.getHodnota()>7&&i.getHodnota()<13){
                switch (i.getBarva()){
                    case 0:
                      cross+=1;
                      break;
                    case 1:
                        diamond+=1;
                        break;
                    case 2:
                        hearth+=1;
                        break;
                    case 3:
                        spade+=1;
                }
            }
        }
        Collections.sort(komb,Karta.PoradiHodnot);
        Collections.sort(komb,Karta.PoradiBarev);
        
        return cross==5||diamond==5||hearth==5||spade==5;
    }
    
    public boolean streightFlush(){
        getKomb().clear();                
        getHrac().getHand().forEach((k) -> {
            getKomb().add(k);
        });
        stul.forEach((k) -> {
            getKomb().add(k);
        });
        Collections.sort(komb,Karta.PoradiHodnot);
        Collections.sort(komb,Karta.PoradiBarev);
        int postup = 0;
        for (int i=0;i<komb.size()-1;i++){
            if (komb.get(i).getBarva()!=komb.get(i+1).getBarva()){
                postup=0;
                continue;
            }
            if (komb.get(i).getHodnota()==komb.get(i+1).getHodnota()+1)
                postup++;
            if (postup==4){
                return true;
            }
        }
        return false;
    }
    
    public boolean poker(){
        getKomb().clear();                
        getHrac().getHand().forEach((k) -> {
            getKomb().add(k);
        });
        stul.forEach((k) -> {
            getKomb().add(k);
        });
        Collections.sort(komb,Karta.PoradiHodnot);
        for (int i=0;i<komb.size()-3;i++){
            if (komb.get(i).getHodnota()==komb.get(i+1).getHodnota()&&komb.get(i+1).getHodnota()==komb.get(i+2).getHodnota()&&komb.get(i+2).getHodnota()==komb.get(i+3).getHodnota()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean fullHouse(){
        getKomb().clear();
        getHrac().getHand().forEach((k) -> {
            getKomb().add(k);
        });
        stul.forEach((k) -> {
            getKomb().add(k);
        });
        Collections.sort(komb, Karta.PoradiHodnot);
        boolean trojice = false;
        boolean par = false;
        for (int i=1;i<komb.size()-1;i++){
            if (komb.get(i-1).getHodnota()==komb.get(i).getHodnota()&&komb.get(i).getHodnota()==komb.get(i+1).getHodnota()){
                trojice = true;
                i++;
                continue;
            }
            if (komb.get(i-1).getHodnota()==komb.get(i).getHodnota()&&komb.get(i).getHodnota()!=komb.get(i+1).getHodnota()){
                par = true;
            }
        }
        
        return trojice&&par;
    }
    
    public boolean flush(){
        getKomb().clear();
        getHrac().getHand().forEach((k) -> {
            getKomb().add(k);
        });
        stul.forEach((k) -> {
            getKomb().add(k);
        });
        Collections.sort(komb, Karta.PoradiBarev);
        int barva5 = 0;
        for (int i=0;i<komb.size()-1;i++){
            if (barva5 ==4)
                return true;
            if (komb.get(i).getBarva()==komb.get(i+1).getBarva()){
                barva5++;
            }
            else{
                barva5 = 0;
            }
        }
        return false;
    }
    
    public boolean postupka(){
        getKomb().clear();
        getHrac().getHand().forEach((k) -> {
            getKomb().add(k);
        });
        stul.forEach((k) -> {
            getKomb().add(k);
        });
        Collections.sort(komb,Karta.PoradiHodnot);
        ArrayList<Karta> a = PomocPostupka(komb,0);
        int pomoc = 0;
        for (int i=0;i<a.size()-1;i++){
            if (pomoc == 4)
                return true;
            if (a.get(i).getHodnota()==a.get(i+1).getHodnota()+1)
                pomoc++;
            else
                pomoc=0;
        }
        return false;
    }
    
    private ArrayList<Karta> PomocPostupka(ArrayList<Karta> k, int i){
        if (i>=k.size()-1)
            return k;
        if (k.get(i).getHodnota()==k.get(i+1).getHodnota()){
            k.remove(i+1);
            return PomocPostupka(k,i);
        }
        return PomocPostupka(k,i+1);
    }
    
    public boolean threeOfKind(){
        getKomb().clear();
        getHrac().getHand().forEach((k) -> {
            getKomb().add(k);
        });
        stul.forEach((k) -> {
            getKomb().add(k);
        });
        Collections.sort(komb, Karta.PoradiHodnot);
        for (int i=0;i<komb.size()-2;i++){
            if (komb.get(i).getHodnota()==komb.get(i+1).getHodnota()&&komb.get(i+1).getHodnota()==komb.get(i+2).getHodnota()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean doublePair(){
        getKomb().clear();
        getHrac().getHand().forEach((k) -> {
            getKomb().add(k);
        });
        stul.forEach((k) -> {
            getKomb().add(k);
        });
        Collections.sort(komb, Karta.PoradiHodnot);
        int pary =0;
        for (int i=0;i<komb.size()-1;i++){
            if (pary==2)
                return true;
            if (komb.get(i).getHodnota()==komb.get(i+1).getHodnota()){
                pary++;
                i++;
            }
        }
        return false;
    }
    
    public boolean pair(){
        getKomb().clear();
        getHrac().getHand().forEach((k) -> {
            getKomb().add(k);
        });
        stul.forEach((k) -> {
            getKomb().add(k);
        });
        Collections.sort(komb, Karta.PoradiHodnot);
        for (int i=0;i<komb.size()-1;i++){
            if (komb.get(i).getHodnota()==komb.get(i+1).getHodnota())
                return true;
        }
        return false;
    }
    
    /**
     * @return the hrac
     */
    public Hrac getHrac() {
        return hrac;
    }

    /**
     * @return the stul
     */
    public ArrayList<Karta> getStul() {
        return stul;
    }

    /**
     * @return the komb
     */
    public ArrayList<Karta> getKomb() {
        return komb;
    }
    
    
    
}