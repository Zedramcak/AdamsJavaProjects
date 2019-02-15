/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textoveprsi;
import java.util.Comparator;
/**
 *
 * @author Adam
 */
public class Karta{
    private final int hodnota;
    private final int barva;

    public Karta(int hodnota, int barva){
        this.hodnota=hodnota;
        this.barva=barva;
    }
    public int getBarva() {
        return barva;
    }

    public int getHodnota(){
        return hodnota;
    }
    
    public String getHodnotaBarva(){
        return String.valueOf(barva)+String.valueOf(hodnota);
    }
    
    @Override
    public String toString(){
        String barvy;
        String hodnoty;
        switch (getBarva()){
            case 0:
                barvy = "zaludy";
                break;
            case 1:
                barvy = "srdce";
                break;
            case 2:
                barvy = "zeleny";
                break;
            case 3:
                barvy = "kule";
                break;
            default:
                barvy = "CHYBA!";
        }
        switch (getHodnota()){
            case 3:
                hodnoty = "10";
                break;
            case 4:
                hodnoty = "spodek";
                break;
            case 5:
                hodnoty = "svrsek";
                break;
            case 6:
                hodnoty = "kral";
                break;
            case 7:
                hodnoty = "Eso";
                break;
            default:
                hodnoty = String.format("%d", getHodnota()+7);
        }
        String karta = String.format("%s %s", hodnoty, barvy);
        return karta;
    }

    public static Comparator<Karta>PoradiHodnot = (Karta k1, Karta k2) -> {
        int poradi1 = k1.getHodnota();
        int poradi2 = k2.getHodnota();
        
        return poradi2 - poradi1;
    };
    
    public static Comparator<Karta>PoradiBarev = (Karta k1, Karta k2) -> {
        int poradi1 = k1.getBarva();
        int poradi2 = k2.getBarva();
        
        return poradi2 - poradi1;
    };


   

    
    
}
