/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hokejovaliga;

import java.util.Comparator;

/**
 *
 * @author Adam
 */
public class Tym {
    private final String nazev;
    private final String zkratka;
    private int body;
    private int vstrelene;
    private int obdrzene;
    private int vyhry;
    private int prohry;
    private int prohryPoProdlouzeni;
    private int vyhryPoProdlouzeni;
    private int odehrano;
    private final int utok;
    private final int obrana;
    private final int brana;
    
    /**
     *
     * @param nazev Nazev tymu
     * @param zkratka 3mistna zkratka
     * @param utok sila utoku
     * @param obrana sila obrany
     * @param brana sila brankare
     */
    public Tym(String nazev, String zkratka,int utok, int obrana,int brana){
        this.nazev=nazev;
        this.zkratka = zkratka;
        body = 0;
        vstrelene=0;
        obdrzene=0;
        vyhry=0;
        prohry=0;
        prohryPoProdlouzeni=0;
        vyhryPoProdlouzeni=0;
        odehrano=0;
        this.utok=utok;
        this.obrana=obrana;
        this.brana=brana;
    }
    
    public void vynulovat(){
        body = 0;
        vstrelene=0;
        obdrzene=0;
        vyhry=0;
        prohry=0;
        prohryPoProdlouzeni=0;
        vyhryPoProdlouzeni=0;
        odehrano=0;
    }
    /**
     *
     * @param vstrelene
     * @param obdrzene
     * @param prodlouzeni
     */
    public void zapas(int vstrelene, int obdrzene, boolean prodlouzeni){
        this.vstrelene+=vstrelene;
        this.obdrzene+=obdrzene;
        odehrano+=1;
        if (!prodlouzeni){
            if(vstrelene>obdrzene){
                vyhry+=1;
                body+=3;
            }
            else{
                prohry+=1;
            }
        }
        else{
            if (vstrelene>obdrzene){
                vyhryPoProdlouzeni+=1;
                body+=2;
            }
            else{
                prohryPoProdlouzeni+=1;
                body+=1;
            }
        }
        
    }
    

    /**
     * @return the body
     */
    public int getBody() {
        return body;
    }

    

    /**
     * @return the vstrelene
     */
    public int getVstrelene() {
        return vstrelene;
    }

    

    /**
     * @return the obdrzene
     */
    public int getObdrzene() {
        return obdrzene;
    }

    

    /**
     * @return the vyhry
     */
    public int getVyhry() {
        return vyhry;
    }

    

    /**
     * @return the prohry
     */
    public int getProhry() {
        return prohry;
    }

    

    /**
     * @return the prohryPoProdlouzeni
     */
    public int getProhryPoProdlouzeni() {
        return prohryPoProdlouzeni;
    }

    /**
     *
     * @return
     */
    public int getVyhryPoProdlouzeni() {
        return vyhryPoProdlouzeni;
    }
    
    @Override
    public String toString(){
        return String.format("%S   %02d %03d %02d %02d %02d %02d %03d %03d %d", getZkratka(), odehrano, body, vyhry, vyhryPoProdlouzeni, prohryPoProdlouzeni, prohry, vstrelene, obdrzene, vstrelene-obdrzene);
    }
    
    /**
     *
     */
    public static Comparator<Tym>PodleBodu = (Tym t1, Tym t2) -> {
        int poradi1 = t1.getBody();
        int poradi2 = t2.getBody();
        
        return poradi2 - poradi1;
    };
    
    /**
     *
     */
    public static Comparator<Tym>PodleVyher = (Tym t1, Tym t2) -> {
        int poradi1 = t1.getVyhry();
        int poradi2 = t2.getVyhry();
        
        return poradi2 - poradi1;
    };
    
    /**
     *
     */
    public static Comparator<Tym>PodleGolu = (Tym t1, Tym t2) -> {
        int poradi1 = t1.getVstrelene();
        int poradi2 = t2.getVstrelene();
        
        return poradi2 - poradi1;
    };

    /**
     * @return the nazev
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * @return the zkratka
     */
    public String getZkratka() {
        return zkratka;
    }
    
    /**
     *
     * @param t
     * @return
     */
    public boolean Equals(Tym t){
        return (getZkratka().equals(t.getZkratka()));
    }

    /**
     * @return the utok
     */
    public int getUtok() {
        return utok;
    }

    /**
     * @return the obrana
     */
    public int getObrana() {
        return obrana;
    }

    /**
     * @return the brana
     */
    public int getBrana() {
        return brana;
    }
    
}
