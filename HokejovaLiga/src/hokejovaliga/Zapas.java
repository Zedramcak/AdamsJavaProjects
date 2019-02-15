/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hokejovaliga;



/**
 *
 * @author Adam
 */
public class Zapas {
    private final Tym t1;
    private final Tym t2;
    
    /**
     *
     * @param t1
     * @param t2
     */
    public Zapas(Tym t1, Tym t2){
         this.t1=t1;
         this.t2=t2;
    }

    /**
     * @return the t1
     */
    public Tym getT1() {
        return t1;
    }

    /**
     * @return the t2
     */
    public Tym getT2() {
        return t2;
    }
    
    /**
     *
     * @param z1
     * @return
     */
    public boolean equals(Zapas z1){
        return (getT1()==z1.t1)&&(getT2()==z1.t2);
    }
    
    @Override
    public String toString(){
        return String.format("%Svs.%S", t1.getZkratka(),t2.getZkratka());
    }
}
