/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceskycountdown;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Adam
 */
public class HraSlova {
    private final ArrayList<String> databaze;
    private ArrayList<String> samohlasky;
    private ArrayList<String> souhlasky;
    private ArrayList<String> hrac;
    private final Scanner sc = new Scanner(System.in,"UTF-8");
    private Random r = new Random();
    
    public HraSlova(){
        databaze = new ArrayList<>();
        hrac=new ArrayList<>();
        samohlasky = new ArrayList<>();
        souhlasky = new ArrayList<>();
        nactiPismena();
        nactiDatabazi();
    }
    
    public boolean prohledejDatabazi(String slovo){
        return databaze.contains(slovo);
    }
    
    private void nactiDatabazi(){
        ArrayList<String> pomocna = new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new FileReader("Databaze.txt"))){
            String s;
            while((s=br.readLine())!=null){
                pomocna.add(s.trim().toLowerCase());
            }
        }
        catch (Exception e){
            System.err.println("Nepodařilo se načíst databázi");
        }
        
        for (String s:pomocna){
            if (s.length()<=9){
                databaze.add(s);
            }
        }
    }
    
    private void nactiPismena(){
        String sam = "aeiouyáéíóúůýěaeiouyáéíóúůýě";
        String sou = "bcdfghjklmnpqrstvwxzčďňřšťžbcdfghjklmnpqrstvwxzčďňřšťž";
        for (Character c:sam.toCharArray())
            samohlasky.add(c.toString());
        for (Character c:sou.toCharArray())
            souhlasky.add(c.toString());
    }
    
    private void dejPismenaHraci(){
        for (int i=0;i<9;i++){
            if (i>0){
                System.out.print("Vybrana pismena: ");
                for (String c:hrac){
                    System.out.printf("%s ",c);
                }
                System.out.println();
            }
            System.out.println("Vyberte "+(i+1)+". pismeno:\n"
                             + "1 - souhlaska\n"
                             + "2 - samohlaska");
            int vyber = Integer.parseInt(sc.nextLine().trim());
            while (vyber<1||vyber>2){
                System.out.println("Napiste \"1\" pro souhlasku nebo \"2\" pro samohlasku");
                vyber = Integer.parseInt(sc.nextLine().trim());
            }
            if (vyber==1){
                int a = r.nextInt(souhlasky.size());
                hrac.add(souhlasky.get(a));
                souhlasky.remove(a);
            }
            else{
                int a = r.nextInt(samohlasky.size());
                hrac.add(samohlasky.get(a));
                samohlasky.remove(a);
            }
            
        }
        System.out.print("Vybrana pismena: ");
            for (String c:hrac){
                System.out.printf("%s ",c);
            }
        System.out.println();
    }
    
    public void pridejSlovo(String s){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("databaze.txt",true))){
            bw.write(s);
            bw.newLine();
            bw.flush();
        }
        catch (Exception e){
            System.err.println("Nepodarilo se pridat nove slovo");
        }
        nactiDatabazi();
    }

    /**
     * @return the databaze
     */
    public ArrayList<String> getDatabaze() {
        return databaze;
    }
    
    
}
