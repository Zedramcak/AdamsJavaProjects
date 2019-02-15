/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adamovikarty;

import java.util.ArrayList;

/**
 *
 * @author Adam
 */
public class Hrac {
    private final String jmeno;
    private ArrayList<Karta> hand;
    private int body;
    
    public Hrac(String jmeno){
        this.jmeno=jmeno;
        hand = new ArrayList<>();
        body=0;
        
    }

    /**
     * @return the hand
     */
    public ArrayList<Karta> getHand() {
        return hand;
    }
    
    public String UkazKarty(){
        int pocetKaret=hand.size();
        String s="";
        for (int i =0;i<pocetKaret;i++){
            s+=hand.get(i).toString();
        }
        return s;
    }

    /**
     * @return the body
     */
    public int getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(int body) {
        this.body = body;
    }
    
    @Override
    public String toString(){
    return jmeno;
}
    
}
