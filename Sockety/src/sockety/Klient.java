/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockety;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.UnknownHostException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adam
 */
public class Klient {
    
    private Socket clientSocket;
    private Scanner in;
    
    public Klient(){
        try{
            this.clientSocket = new Socket("localhost",8080);
            System.out.println("Spusteni klienta probehlo uspesne.");
            this.in = new Scanner(System.in);
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(this.clientSocket.getOutputStream()));
            while (true){
                String temp = in.nextLine();
                out.write(temp+"\r\n");
                out.flush();
                System.out.println("Zprava \""+temp+"\" byla odeslana.");
            }            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public static void main(String[] args){
        Klient klient = new Klient();
    }
}
