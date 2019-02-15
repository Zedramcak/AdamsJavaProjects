/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrapper;

import DB.Database;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Adam
 */
public class Wrapper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Database database = new Database("sezona","root","");
            String[] columns3 = {"nazev","zkratka"};
            Object[] params3 = {};
            ResultSet rs = database.select("tymy", columns3, params3);
            while (rs.next()){
                System.out.println(rs.getString("nazev")+" - "+rs.getString("zkratka"));
            }
        }
        catch(SQLException ex){
            System.out.println("error - "+ex.getMessage());
        }
        
        
    }
    
}
