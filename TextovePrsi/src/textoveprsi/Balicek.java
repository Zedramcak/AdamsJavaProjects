/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textoveprsi;

import java.util.ArrayList;

/**
 *
 * @author Adam
 */
public final class Balicek {
    private final ArrayList<Karta> karty;
    
    public Balicek(){
        karty = new ArrayList<>();
        napln();
    }
    
    public void napln(){
        for (int i=0;i<4;i++){
            for(int j=0;j<8;j++){
                getKarty().add(new Karta(j,i));
            }
        }
    }

    /**
     * @return the karty
     */
    public ArrayList<Karta> getKarty() {
        return karty;
    }
    
}
