/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql_zkouska;

import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Adam
 */
public class SQL_zkouska {

    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args){
        SQLTrida sql = new SQLTrida();
        sql.vypis();
        System.out.println("V tabulce je "+sql.pocetTymu()+" tymu");
        
        
    }
    
}
