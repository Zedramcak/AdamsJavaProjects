/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockety;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Adam
 */
public class Server {
    private ServerSocket serverSocket;
    private ArrayList<BufferedReader> clientBuffReaders;
    
    public Server(){
        try{
            this.serverSocket = new ServerSocket(8080);
            System.out.println("Spusteni serveru probehlo uspesne.\n"
                    + "Cekam na pripojeni klienta...\n");
            this.clientBuffReaders = new ArrayList<>();
            
            this.clients();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    private void clients(){
        Thread acceptThread = new Thread(() -> {
            while(true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    clientBuffReaders.add(new BufferedReader(new InputStreamReader(clientSocket.getInputStream())));
                    System.out.println("Klient se pripojil.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
            }
        });
        acceptThread.start();
        while(true){
            synchronized(clientBuffReaders){
                for (BufferedReader in:clientBuffReaders){
                    try {
                        if(in.ready()){
                            System.out.println(in.readLine());                        
                        }else{
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        Server server = new Server();
    } 
}
