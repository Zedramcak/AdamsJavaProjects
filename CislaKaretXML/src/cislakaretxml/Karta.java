/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cislakaretxml;

/**
 *
 * @author Adam
 */
public class Karta {
    private final long cislo;
    private final int pin;
    private double prostredky;
    
    public Karta(long cislo, int pin, double prostredky){
        this.cislo=cislo;
        this.pin=pin;
        this.prostredky=prostredky;
    }

    /**
     * @return the cislo
     */
    public long getCislo() {
        return cislo;
    }

    /**
     * @return the pin
     */
    public int getPin() {
        return pin;
    }

    /**
     * @return the prostredky
     */
    public double getProstredky() {
        return prostredky;
    }

    /**
     * @param prostredky the prostredky to set
     */
    public void setProstredky(double prostredky) {
        this.prostredky = prostredky;
    }
    
    
}
