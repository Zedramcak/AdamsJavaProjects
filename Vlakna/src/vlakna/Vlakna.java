/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlakna;

/**
 *
 * @author Adam
 */
public class Vlakna {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
        for (int i=0;i<100;i++){
            BankomatUnsafe bankomat = new BankomatUnsafe();
            bankomat.vyberVlakny();
            
        }
    }
    
}
