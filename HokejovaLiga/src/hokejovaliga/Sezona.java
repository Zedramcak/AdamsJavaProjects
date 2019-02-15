/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hokejovaliga;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Adam
 */
public class Sezona {
    private final Scanner sc = new Scanner(System.in,"UTF-8");
    
    /**
     * Nasimuluje sezonu ceske extraligy a WSM ligy vcetne playoff a baraze
     */
    public void odehrajCeskouSezonu(){

        //Pomocny objekt Tym
        Tym t = new Tym("Tym1","tym",0,0,0);

        int cisloSezony = 0;
        boolean dalsiSezona=true;
        boolean sledovat = sledovani();
        // Vytvoreni lig
        Liga extraliga = new Liga("Extraliga Ledniho Hokeje",sledovat);
        Liga wsm = new Liga("WSM Liga",false);    

        dosadTymy(extraliga,wsm);

        while (dalsiSezona){
            cisloSezony++;
            System.out.println("Vitame vas u "+cisloSezony+". sezony!");

            extraliga.vynulujBody();
            wsm.vynulujBody();
            //odehrani jednotlivych kol
            for (int i = 0; i<(extraliga.getUcastnici().size()-1)*4; i++){
                if (sledovat) System.out.printf("vysledky a poradi po %d.kole%n", i+1);
                extraliga.odehrajKolo();
                wsm.odehrajKolo();
            }

            //vytvoreni ligy o udrzeni a baraze
            Liga oUdrzeni = new Liga("O Udrzeni",sledovat);
            Liga baraz = new Liga("baraz",sledovat);
            //naplneni a odehrani ligy o udrzeni
            for (int i=1;i<=4;i++){
                oUdrzeni.getUcastnici().add(extraliga.getUcastnici().get(extraliga.getUcastnici().size()-1));
                extraliga.getUcastnici().remove(extraliga.getUcastnici().size()-1);
            }
            for (int i=0;i<(oUdrzeni.getUcastnici().size()-1)*4;i++){
                oUdrzeni.odehrajKolo();
            }
            //vyhlaseni vitezu lig
            System.out.println(extraliga.vyhlasVitezeZC());
            System.out.println(wsm.vyhlasVitezeZC());


            extraliga.playOff();
            wsm.playOff();


            System.out.println();
            sc.nextLine();
            System.out.println("Do baraze sestupuji "+oUdrzeni.getUcastnici().get(3).getNazev()+ " a "+ oUdrzeni.getUcastnici().get(2).getNazev());
            //prida finalisty WSM ligy do baraze a odebere je z WSM ligy
            for (Tym b:wsm.getFinalisti()){
                baraz.getUcastnici().add(b);
                wsm.getUcastnici().remove(b);
            }

            wsm.getFinalisti().clear();

            sc.nextLine();

            System.out.println();

            //Odebere dva nejhorsi tymy Extraligy a prida je do baraze
            for (int i=1;i<=2;i++){
                baraz.getUcastnici().add(oUdrzeni.getUcastnici().get(oUdrzeni.getUcastnici().size()-i));
                extraliga.getUcastnici().remove(oUdrzeni.getUcastnici().get(oUdrzeni.getUcastnici().size()-i));
            }
            for (int i=0;i<2;i++){
                extraliga.getUcastnici().add(oUdrzeni.getUcastnici().get(i));
            }


            System.out.print("O Extraligu budou hrat tyto tymy: ");
            for (Tym b:baraz.getUcastnici()){
                System.out.printf("%S, ", b.getNazev());
            }
            System.out.println();
            System.out.println();
            sc.nextLine();

            //vynuluje body tymu v barazi a odehraje baraz
            baraz.vynulujBody();
            for (int i=0;i<(baraz.getUcastnici().size()-1)*4;i++){
                baraz.odehrajKolo();
            }

            System.out.printf("Do Extraligy postupuji %S a %S %n",baraz.getUcastnici().get(0).getNazev(),baraz.getUcastnici().get(1).getNazev());
            System.out.printf("Z baraze sestupuji %S a %S %n",baraz.getUcastnici().get(2).getNazev(),baraz.getUcastnici().get(3).getNazev());
            sc.nextLine();

            //prida prvni dva tymy z baraze do extraligy a posledni dva do WSM ligy
            for (int i=0;i<2;i++){
                extraliga.getUcastnici().add(baraz.getUcastnici().get(i));
            }
            for (int i=1;i<=2;i++)
            {
                wsm.getUcastnici().add(baraz.getUcastnici().get(baraz.getUcastnici().size()-i));
            }
            //vymaze tymy z baraze
            baraz.getUcastnici().clear();

            //vynuluje body v obou ligach
            extraliga.vynulujBody();
            wsm.vynulujBody();

            //Zepta se uzivatele, zda-li chce nasimulovat dalsi sezonu s novymy tymy
            System.out.println("Chcete nasimulovat dalsi sezonu?\n"
                             + "1 - ano\n"
                             + "2 - ne\n");
            int dalsi;
            try{
                dalsi = Integer.parseInt(sc.nextLine().trim());
            }
            catch (Exception e){
                dalsi = 3;
            }
            while (dalsi!=1&&dalsi!=2){
                System.out.println("Vyberte 1 pro dalsi sezonu nebo 2 pro ukonceni programu.");
                dalsi = Integer.parseInt(sc.nextLine().trim());
            }
            if (dalsi == 2)
                dalsiSezona=false;
            
        }
    }

    /**
     * Dosadi tymy do jednotlivych lig
     * @param extraliga prvni liga
     * @param wsm druha liga
     */
    private void dosadTymy(Liga extraliga,Liga wsm){
        extraliga.dosadTymy("Pirati Chomutov", "CHO",20,18,92);
        extraliga.dosadTymy("HC Sparta Praha", "SPA",20,20,95);
        extraliga.dosadTymy("HC Zlin", "ZLN",18,18,89);
        extraliga.dosadTymy("HK Hradec Kralove", "HRK",18,19,90);
        extraliga.dosadTymy("HC Dukla Jihlava", "JIH",19,17,88);
        extraliga.dosadTymy("HC Olomouc", "OLO",18,17,87);
        extraliga.dosadTymy("BK Mlada Boleslav", "MLB",20,20,90);
        extraliga.dosadTymy("HC Vitkovice", "VIT",19,17,88);
        extraliga.dosadTymy("HC Plzen", "PLZ",18,17,88);
        extraliga.dosadTymy("HC Ocelari Trinec", "TRI",20,20,90);
        extraliga.dosadTymy("HC Dynamo Pardubice", "PAR",18,17,89);
        extraliga.dosadTymy("HC Kometa Brno", "KOM",20,19,93);
        extraliga.dosadTymy("Bili Tygri Liberec", "LIB",20,19,92);
        extraliga.dosadTymy("HC Litvinov", "LIT",18,18,89);
        wsm.dosadTymy("HC Ceske Budejovice", "CBU",17,15,90);
        wsm.dosadTymy("HC Karlovi Vary", "HKV",16,16,89);
        wsm.dosadTymy("HC Kladno", "KLA",16,17,90);
        wsm.dosadTymy("HC Slavia Praha", "SLA",16,16,90);
        wsm.dosadTymy("SK Horacka Slavia Trebic", "HST",15,15,86);
        wsm.dosadTymy("HC Slovan Usti nad Labem", "SLO",16,15,86);
        wsm.dosadTymy("LHK Jestrabi Prostejov", "JPR",15,14,87);
        wsm.dosadTymy("HC Benatky nad Jizerou", "BEN",15,14,85);
        wsm.dosadTymy("HC Frydek-Mistek", "FRM",15,15,86);
        wsm.dosadTymy("HC Prerov", "PRE",16,14,86);
        wsm.dosadTymy("HC Stadion Litomerice","STA",15,14,87);
        wsm.dosadTymy("AZ Havirov", "AZH",15,14,87);
        wsm.dosadTymy("SK Kadan", "KAD",15,12,86);
        wsm.dosadTymy("HC Vsetin", "VSE",15,11,88);
    }

    /**
     * Necha uzivatele rozhodnout, zda-li chce podrobne vypisy z extraligy
     * @return true -> zobrazi podrobne vysledky -> zobrazi pouze vyherce hlavni casti, play-off a baraze
     */
    private boolean sledovani(){
        System.out.println("Prejete si videt podrobne vysledky?\n"
                +  "1 - ano\n"
                +  "2 - ne\n");
        int sledovani = Integer.parseInt(sc.nextLine().trim());
        while (sledovani!=1&&sledovani!=2){
            System.out.println("Vyberte 1 pro zobrazovani vysledku nebo 2 pokud chcete videt jen vyherce");
            sledovani = Integer.parseInt(sc.nextLine().trim());
        }
        if (sledovani==2)
            return false;
        return true;
    }
}

