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
class BankomatUnsafe {
    private int hotovost = 100;
    
    private synchronized void vyber100(){
        if (hotovost>=100){
            System.out.println("Vybiram 100");
            hotovost-=100;
            System.out.printf("Na ucte zbyva %d.%n",hotovost);
        }
        else{
            System.out.println("Nedostatecna hotovost.");
        }
    }
    
    public void vyberVlakny(){
        Thread vlakno1 = new Thread(this::vyber100);
        System.out.println(hotovost);
        vlakno1.start();
        vyber100();
        if (hotovost<0)
            System.out.println("HOTOVOST JE V MINUSU");
    }
}
