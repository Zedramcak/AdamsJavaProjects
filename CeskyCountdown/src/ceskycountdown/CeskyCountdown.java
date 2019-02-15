/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceskycountdown;

import java.util.Scanner;


/**
 *
 * @author Adam
 */
public class CeskyCountdown {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HraSlova h = new HraSlova();
        Scanner sc = new Scanner(System.in,"Windows-1250");
        String slovo = sc.next().trim();
        System.out.println(slovo);
        slovo = "kočka";
        System.out.println(slovo);
    }
    
}
