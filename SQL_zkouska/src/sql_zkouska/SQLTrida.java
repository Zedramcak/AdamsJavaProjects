/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql_zkouska;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Adam
 */
public class SQLTrida {
    private final Scanner sc = new Scanner(System.in,"Windows-1250");
    private final String adresa = "jdbc:mysql://localhost/tymy?user=root&password=";
    
    public void vypis(){
        try(Connection spojeni = DriverManager.getConnection("jdbc:mysql://localhost/tymy?user=root&password");
        PreparedStatement dotaz = spojeni.prepareStatement("SELECT * FROM seznam_tymu");
        ResultSet vysledky = dotaz.executeQuery();)
        {
            while (vysledky.next()){
                int id = vysledky.getInt(1);
                String nazev = vysledky.getString(2);
                String zkratka = vysledky.getString(3);
                System.out.printf("Id: %d, nazev: %s zkratka: %s%n",id,nazev,zkratka);
            }
        }  
        catch (SQLException ex){
            System.err.println("Chyba pri komunikaci s databazi");
        }
    }
    public void najdiPodleZkratky(){
        System.out.println("Zadejte zkratku:");
        String zkratka = sc.nextLine();
        try (Connection spojeni = DriverManager.getConnection("jdbc:mysql://localhost/tymy?user=root&password=");
            PreparedStatement dotaz = spojeni.prepareStatement("SELECT nazev FROM seznam_tymu WHERE zkratka=?");) {
            dotaz.setString(1, zkratka);
            try (ResultSet vysledky = dotaz.executeQuery()) {
                vysledky.next();
                String nazev = vysledky.getString("Nazev");
                System.out.println("Zkratka " + zkratka + " patri tymu " + nazev);
            }
            catch (SQLException ex){
                System.out.println(ex);
            }
        } catch (SQLException ex) {
        System.out.println("Chyba při komunikaci s databází");
        }
    }
    public void vloz(String nazev,String zkratka){
        System.out.println("Nazev noveho tymu: "+nazev);
        System.out.println("Zkratka noveho tymu: "+zkratka);
        try (Connection spojeni = DriverManager.getConnection("jdbc:mysql://localhost/tymy?user=root&password=");
                PreparedStatement dotaz = spojeni.prepareStatement("INSERT INTO seznam_tymu (nazev, zkratka) VALUES (?,?)");){
            dotaz.setString(1, nazev);
            dotaz.setString(2,zkratka);
            int radku = dotaz.executeUpdate();
            System.out.println(radku);
        }
        catch (SQLException e){
            System.err.println(e);
        }
        
    }
    public void vymaz(String zkratka){
        System.out.println("Bude vymazan tym: "+zkratka);
        try(Connection spojeni = DriverManager.getConnection(adresa);
                PreparedStatement dotaz = spojeni.prepareStatement("DELETE FROM seznam_tymu WHERE zkratka=?");){
            dotaz.setString(1, zkratka);
            int radku = dotaz.executeUpdate();
            System.out.println("Vymazano "+radku+" radku");
        }
        catch (SQLException e){
            System.err.println(e);
        }
    }
    public void upravZkratku(String nazev,String zkratka){
        System.out.println("Bude nastaven zkratka "+zkratka+" u tymu "+nazev);
        try (Connection spojeni = DriverManager.getConnection(adresa);
                PreparedStatement dotaz = spojeni.prepareStatement("UPDATE seznam_tymu SET zkratka=? WHERE nazev=?");){
            dotaz.setString(1, zkratka);
            dotaz.setString(2, nazev);
            int radku = dotaz.executeUpdate();
            System.out.printf("Upraveno %d radku%n",radku);
        }
        catch(SQLException e){
            System.err.println(e);
        }
    }
    public int pocetTymu(){
        try (Connection spojeni = DriverManager.getConnection(adresa);
                PreparedStatement dotaz = spojeni.prepareStatement("SELECT COUNT(*) FROM seznam_tymu");){
            ResultSet vysledek = dotaz.executeQuery();
            vysledek.next();
            return vysledek.getInt(1);
        }
        catch(SQLException ex){
            System.err.println(ex);
        }
        return 0;
    }
    
}
