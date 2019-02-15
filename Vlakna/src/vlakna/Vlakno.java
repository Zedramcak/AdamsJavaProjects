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
class Vlakno extends Thread {
    private final String zprava;
    
    public Vlakno(String zprava){
        this.zprava=zprava;
    }
    
    @Override
    public void run(){
        int pozice = 0;
        while(pozice<zprava.length()){
            System.out.print(zprava.charAt(pozice++));
            try{
                Thread.sleep(1);
            }catch (InterruptedException ex){
                System.out.printf("Vlakno se zpravou \"%s\" preruseno",zprava);
                return;
            }
        }
    }
}
