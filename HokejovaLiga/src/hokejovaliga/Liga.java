/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hokejovaliga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 *
 * @author Adam
 */
public class Liga {
    private final String nazev;
    private final List<Tym> ucastnici;
    private final Random r = new Random();
    private final Scanner sc = new Scanner(System.in,"UTF-8");
    private final List<Zapas> zapasy;
    private final boolean sledovat;
    private final List<Tym> finalisti = new ArrayList<>();
    private final List<Tym> playoff = new ArrayList<>();
    private Tym vitezZC;
    private Tym vitezPO;
    
    /**
     *
     * @param nazev nazev 
     * @param sledovat sledovani ligy
     */
    public Liga(String nazev,boolean sledovat){
        this.nazev=nazev;
        ucastnici = new ArrayList<>();
        zapasy = new ArrayList<>();
        this.sledovat=sledovat;
    }
    
    /**
     *
     * @return seradi pole ucastnici podle poctu bodu a vypise tym na prvnim miste
     */
    public String vyhlasVitezeZC(){
        ucastnici.sort(Comparator.comparingInt(Tym::getBody).thenComparingInt(Tym::getVyhry).thenComparingInt(Tym::getVstrelene).reversed());
        
        vitezZC = ucastnici.get(0);
        return String.format("Vitezem zakladni casti souteze \"%S\" se stava tym %S s celkovym ziskem %d bodu", nazev, getVitezZC().getNazev(),getVitezZC().getBody());
    }
    /**
     * odehraje jedno hraci kolo souteze
     */
    public void odehrajKolo(){
        vytvorZapasy();
        List<Tym> odehrano = new ArrayList<>();
        for (int i=0;i<ucastnici.size()/2;i++){
            odehraj(zapasy.get(0).getT1(),zapasy.get(0).getT2());
            zapasy.remove(0);
        }
        ucastnici.sort(Comparator.comparingInt(Tym::getBody).thenComparingInt(Tym::getVyhry).thenComparingInt(Tym::getVstrelene).reversed());
        if (sledovat) vypisTymy(ucastnici);
        if (sledovat) sc.nextLine();
    }
    
    /**
     *
     *
     */
    public void playOff(){
        getPlayoff().clear();
        ucastnici.sort(Comparator.comparingInt(Tym::getBody).thenComparingInt(Tym::getVyhry).thenComparingInt(Tym::getVstrelene).reversed());;
        for (int i=0;i<10;i++){
            getPlayoff().add(ucastnici.get(i));
        }
        if (sledovat)   {
            System.out.printf("Zacina predkolo Play Off ligy \"%S\"\n"
            + "V nem se utkaji tyto tymy:\n",getNazev());
            System.out.printf("%S proti %S a %S proti %S\n",getPlayoff().get(6).getNazev(),getPlayoff().get(9).getNazev(),getPlayoff().get(7).getNazev(),getPlayoff().get(8).getNazev());
        }
        sledovat();
        Tym ctf1 = seriePlayOff(getPlayoff().get(6),getPlayoff().get(9),3);
        sledovat();
        Tym ctf2 = seriePlayOff(getPlayoff().get(7),getPlayoff().get(8),3);
        sledovat();
        if (getPlayoff().indexOf(ctf2)<getPlayoff().indexOf(ctf1)){
            Tym p = ctf2;
            ctf2 = ctf1;
            ctf1 = p;
        }
        if (sledovat){
        System.out.printf("PAVOUK PLAY OFF %S             \n"
                        + "%S---\\                        \n" 
                        + "       -----SF1\\               \n"
                        + "%S---/         \\              \n"
                        + "                 F1             \n"
                        + "%S---\\         / \\            \n"
                        + "       -----SF2/   \\           \n"
                        + "%S---/             \\          \n"
                        + "                     SAMPION    \n"
                        + "%S---\\             /           \n"
                        + "       -----SF3\\   /            \n"
                        + "%S---/         \\ /             \n"
                        + "                 F2             \n"
                        + "%S---\\         /               \n"
                        + "       -----SF4/                \n"
                        + "%S---/                         \n",getNazev(),getPlayoff().get(0).getZkratka()
                ,ctf2.getZkratka(),getPlayoff().get(2).getZkratka(),getPlayoff().get(5).getZkratka(),getPlayoff().get(4).getZkratka()
                ,getPlayoff().get(3).getZkratka(),ctf1.getZkratka(),getPlayoff().get(1).getZkratka());
        sc.nextLine();
        }
        if (sledovat) System.out.println("Zacinaji Ctvrtfinale:");
        sledovat();
        Tym sf1 = seriePlayOff(getPlayoff().get(0),ctf2,4);
        sledovat();
        Tym sf2 = seriePlayOff(getPlayoff().get(1),ctf1,4);
        sledovat();
        Tym sf3 = seriePlayOff(getPlayoff().get(2),getPlayoff().get(5),4);
        sledovat();
        Tym sf4 = seriePlayOff(getPlayoff().get(3),getPlayoff().get(4),4);
        sledovat();
        if (sledovat){
        System.out.printf("PAVOUK PLAY OFF %S             \n"
                        + "%S---\\                        \n" 
                        + "       -----%S\\               \n"
                        + "%S---/         \\              \n"
                        + "                 F1             \n"
                        + "%S---\\         / \\            \n"
                        + "       -----%S/   \\           \n"
                        + "%S---/             \\          \n"
                        + "                     SAMPION    \n"
                        + "%S---\\             /           \n"
                        + "       -----%S\\   /            \n"
                        + "%S---/         \\ /             \n"
                        + "                 F2             \n"
                        + "%S---\\         /               \n"
                        + "       -----%S/                \n"
                        + "%S---/                         \n",getNazev(),getPlayoff().get(0).getZkratka(),sf1.getZkratka()
                ,ctf2.getZkratka(),getPlayoff().get(2).getZkratka(),sf3.getZkratka(),getPlayoff().get(5).getZkratka(),getPlayoff().get(4).getZkratka(),sf4.getZkratka()
                ,getPlayoff().get(3).getZkratka(),ctf1.getZkratka(),sf2.getZkratka(),getPlayoff().get(1).getZkratka());
        sc.nextLine();
        }
        if (sledovat) System.out.println("Zacinaji semifinale:");
        Tym f1 = seriePlayOff(sf1,sf3,4);
        sledovat();
        Tym f2 = seriePlayOff(sf4,sf2,4);
        sledovat();
        if (sledovat) System.out.println("VE FINALE SE UTKAJI TYMY "+f1.getNazev().toUpperCase()+" A "+f2.getNazev().toUpperCase());
        sledovat();
        if (sledovat){
        System.out.printf("PAVOUK PLAY OFF %S             \n"
                        + "%S---\\                        \n" 
                        + "       -----%S\\               \n"
                        + "%S---/         \\              \n"
                        + "                 %S             \n"
                        + "%S---\\         / \\            \n"
                        + "       -----%S/   \\           \n"
                        + "%S---/             \\          \n"
                        + "                     SAMPION    \n"
                        + "%S---\\             /           \n"
                        + "       -----%S\\   /            \n"
                        + "%S---/         \\ /             \n"
                        + "                 %S             \n"
                        + "%S---\\         /               \n"
                        + "       -----%S/                \n"
                        + "%S---/                         \n",getNazev(),getPlayoff().get(0).getZkratka(),sf1.getZkratka()
                ,ctf2.getZkratka(),f1.getZkratka(),getPlayoff().get(2).getZkratka(),sf3.getZkratka(),getPlayoff().get(5).getZkratka(),getPlayoff().get(4).getZkratka(),sf4.getZkratka()
                ,getPlayoff().get(3).getZkratka(),f2.getZkratka(),ctf1.getZkratka(),sf2.getZkratka(),getPlayoff().get(1).getZkratka());
        sc.nextLine();
        }
        getFinalisti().add(f2);
        getFinalisti().add(f1);
        Tym sampion = finalePO(f1,f2);
        sledovat();
        if(sampion.Equals(getPlayoff().get(0))){
            System.out.printf("%S Uspesne ziskavaji v letosni sezone double%n", sampion.getNazev());
            sledovat();
        }
        if (sledovat) System.out.printf("PAVOUK PLAY OFF %S             \n"
                        + "%S---\\                        \n" 
                        + "       -----%S\\               \n"
                        + "%S---/         \\              \n"
                        + "                 %S             \n"
                        + "%S---\\         / \\            \n"
                        + "       -----%S/   \\           \n"
                        + "%S---/             \\          \n"
                        + "                     %S    \n"
                        + "%S---\\             /           \n"
                        + "       -----%S\\   /            \n"
                        + "%S---/         \\ /             \n"
                        + "                 %S             \n"
                        + "%S---\\         /               \n"
                        + "       -----%S/                \n"
                        + "%S---/                         \n",getNazev(),getPlayoff().get(0).getZkratka(),sf1.getZkratka()
                ,ctf2.getZkratka(),f1.getZkratka(),getPlayoff().get(2).getZkratka(),sf3.getZkratka(),getPlayoff().get(5).getZkratka(),sampion.getNazev(),getPlayoff().get(4).getZkratka(),sf4.getZkratka()
                ,getPlayoff().get(3).getZkratka(),f2.getZkratka(),ctf1.getZkratka(),sf2.getZkratka(),getPlayoff().get(1).getZkratka());
        sledovat();
        vitezPO = sampion;
    }
    
    private Tym finalePO(Tym f1, Tym f2){
        int cisloZapasu = 0;
        int vyhryF1=0;
        int vyhryF2=0;
        while (vyhryF1<4&&vyhryF2<4){
            cisloZapasu++;
            boolean domaci = true;
            if (cisloZapasu==3||cisloZapasu==4||cisloZapasu==6)
                domaci = false;
            int golyf1=0;
            int golyf2=0;
            if(domaci){
                if (sledovat) System.out.printf("%d.utkani finale Play-OFF se uskutecni na stadionu tymu %S%n", cisloZapasu, f1.getNazev());
                if (sledovat) sc.nextLine();
                golyf1 += r.nextInt(4);
                golyf2 += r.nextInt(3);
                if (sledovat) System.out.printf("Po prvni tretine je stav %d:%d%n", golyf1,golyf2);
                if (sledovat) sc.nextLine();
                golyf1 += r.nextInt(4);
                golyf2 += r.nextInt(3);
                if (sledovat) System.out.printf("Po druhe tretine je stav %d:%d%n", golyf1,golyf2);
                if (sledovat) sc.nextLine();
                golyf1 += r.nextInt(4);
                golyf2 += r.nextInt(3);
                if(golyf1>golyf2){
                    if (sledovat) System.out.printf("Konec zapasu. %S vitezi %d:%d%n", f1.getNazev(),golyf1,golyf2);
                    if (sledovat) sc.nextLine();
                    vyhryF1++;
                }
                else if(golyf2>golyf1){
                    if (sledovat) System.out.printf("Konec zapasu. %S vitezi %d:%d%n", f2.getNazev(),golyf1,golyf2);
                    if (sledovat) sc.nextLine();
                    vyhryF2++;
                }
                else{
                    if (sledovat) System.out.println("Prodluzuje se za stavu "+golyf1+":"+golyf2+"!");
                    if (sledovat) sc.nextLine();
                    if(Math.random()>=0.42){
                        if (sledovat) System.out.printf("Konec zapasu. %S vitezi %d:%d po prodlouzeni%n", f1.getNazev(),golyf1+1,golyf2);
                        if (sledovat) sc.nextLine();
                        vyhryF1++;
                    }
                    else{
                        if (sledovat) System.out.printf("Konec zapasu. %S vitezi %d:%d po prodlouzeni%n", f2.getNazev(),golyf1,golyf2+1);
                        if (sledovat) sc.nextLine();
                        vyhryF2++;
                    }
                        
                        
                }
            }
            else{
                if (sledovat) System.out.printf("%d.utkani finale Play-OFF se uskutecni na stadionu tymu %S%n", cisloZapasu, f2.getNazev());
                if (sledovat) sc.nextLine();
                golyf1 += r.nextInt(3);
                golyf2 += r.nextInt(4);
                if (sledovat) System.out.printf("Po prvni tretine je stav %d:%d%n", golyf2,golyf1);
                if (sledovat) sc.nextLine();
                golyf1 += r.nextInt(3);
                golyf2 += r.nextInt(4);
                if (sledovat) System.out.printf("Po druhe tretine je stav %d:%d%n", golyf2,golyf1);
                if (sledovat) sc.nextLine();
                golyf1 += r.nextInt(3);
                golyf2 += r.nextInt(4);
                if(golyf1>golyf2){
                    if (sledovat) System.out.printf("Konec zapasu. %S vitezi %d:%d%n", f1.getNazev(),golyf2,golyf1);
                    if (sledovat) sc.nextLine();
                    vyhryF1++;
                }
                else if(golyf2>golyf1){
                    if (sledovat) System.out.printf("Konec zapasu. %S vitezi %d:%d%n", f2.getNazev(),golyf2,golyf1);
                    if (sledovat) sc.nextLine();
                    vyhryF2++;
                }
                else{
                    if (sledovat) System.out.println("Prodluzuje se za stavu "+golyf2+":"+golyf1+"!");
                    if (sledovat) sc.nextLine();
                    if(Math.random()>=0.42){
                        if (sledovat) System.out.printf("Konec zapasu. %S vitezi %d:%d po prodlouzeni%n", f2.getNazev(),golyf2+1,golyf1);
                        if (sledovat) sc.nextLine();
                        vyhryF2++;
                    }
                    else{
                        if (sledovat) System.out.printf("Konec zapasu. %S vitezi %d:%d po prodlouzeni%n", f1.getNazev(),golyf2,golyf1+1);
                        if (sledovat) sc.nextLine();
                        vyhryF1++;
                    }
                }
            }
        }
        if(vyhryF1==4){
            System.out.printf("%S VYHRAVA PLAY OFF %S!!! VE FINALE PORAZI %S %d:%d NA ZAPASY%n",f1.getNazev(),nazev,f2.getNazev(),vyhryF1,vyhryF2);
            return f1;
        }
        else{
            System.out.printf("%S VYHRAVA PLAY OFF %S!!! VE FINALE PORAZI %S %d:%d NA ZAPASY%n",f2.getNazev(),nazev,f1.getNazev(),vyhryF2,vyhryF1);
            return f2;
        }
    }
    
    private Tym seriePlayOff(Tym t1,Tym t2, int vyhry){
        int vyhryT1=0;
        int vyhryT2=0;
        while (vyhryT1<vyhry&&vyhryT2<vyhry){
            int golT1 = r.nextInt(7);
            int golT2 = r.nextInt(5);
            
            
            if(golT1==golT2){
                if(Math.random()>=0.5)
                    golT1++;
                else
                    golT2++;
            }
            
            if (golT1>golT2){
                vyhryT1++;
                if (sledovat) System.out.println(vyhryT1+". Vyhra tymu "+t1.getNazev());
            }
            else{
                vyhryT2++;
                if (sledovat) System.out.println(vyhryT2+". Vyhra tymu "+t2.getNazev());
            }
        }
        if (vyhryT1==vyhry){
            if(sledovat) System.out.println(t1.getNazev()+" vitezi "+vyhryT1+":"+vyhryT2+" na zapasy");
            return t1;
        }
        else {
            if (sledovat) System.out.println(t2.getNazev()+" vitezi "+vyhryT2+":"+vyhryT1+" na zapasy");
            return t2;
        }
    }
    
    public void vynulujBody(){
        ucastnici.forEach(t ->t.vynulovat());
    }
    
    private void vytvorZapasy(){
        if(zapasy.isEmpty()){
            ArrayList<Tym> domaci = new ArrayList<>();
            ArrayList<Tym> hoste= new ArrayList<>();

            ucastnici.forEach(t->{
            for (int i=0;i<ucastnici.size()-1;i++) {
                domaci.add(t);
                hoste.add(t);
            }
            });
            int kolo = 0;
            while (kolo<(ucastnici.size()-1)*2){
                ArrayList<Tym> odehraliKolo = new ArrayList<>();
                int zapasyKolo = 0;
                while(zapasyKolo<ucastnici.size()/2) {
                    int dom = r.nextInt(domaci.size());
                    int hos = r.nextInt(hoste.size());
                    Tym d = domaci.get(dom);
                    Tym h = hoste.get(hos);
                    Zapas z = new Zapas(d,h);
                    if (d.Equals(h)||zapasy.contains(z)||odehraliKolo.contains(d)||odehraliKolo.contains(h))
                        continue;
                    zapasy.add(z);
                    odehraliKolo.add(d);
                    odehraliKolo.add(h);
                    domaci.remove(dom);
                    hoste.remove(hos);

                    zapasyKolo++;
                }
                kolo++;
            }
        }
    }
    
    private void sledovat(){
        if (sledovat)
            sc.nextLine();
    }
    
    public void dosadTymy(String jmeno,String zkr,int utok, int obrana, int brana){
        ucastnici.add(new Tym(jmeno,zkr,utok,obrana,brana));
    }
    
    private void odehraj(Tym t1, Tym t2){
        int pBT1=0;
        int pBT2=0;
        double sance;
        int domaciU = t1.getUtok()+1;
        int domaciO = t1.getBrana()+1;
        for (int i=0;i<120;i++){
            switch (i%2){
                case 0:
                    sance = (double) r.nextInt(domaciU)/(r.nextInt(t2.getObrana())+1);
                    if (sance>1){
                        sance = (double) t2.getBrana()/100;
                        if (Math.random()>sance){
                            pBT1++;
                        }
                    }
                    break;
                case 1:
                    sance = (double) r.nextInt(t2.getUtok())/(r.nextInt(domaciO)+1);
                    if (sance>1){
                        sance = (double) t1.getBrana()/100;
                        if (Math.random()>sance){
                            pBT2++;
                        }
                    }
            }
        }
        boolean prodlouzeni = false;
        int i=0;
        while (pBT1==pBT2){
            prodlouzeni = true;
            
            switch (i%2){
                case 0:
                    sance = (double) r.nextInt(domaciU)/(r.nextInt(t2.getObrana())+1);
                    if (sance>1){
                        sance = (double) t2.getBrana()/100;
                        if (Math.random()>sance){
                            pBT1++;
                        }
                    }
                    break;
                case 1:
                    sance = (double) r.nextInt(t2.getUtok())/(r.nextInt(domaciO)+1);
                    if (sance>1){
                        sance = (double) t1.getBrana()/100;
                        if (Math.random()>sance){
                            pBT2++;
                        }
                    }
            }
            i++;
        }
        t1.zapas(pBT1, pBT2, prodlouzeni);
        t2.zapas(pBT2, pBT1, prodlouzeni);  
        if (!prodlouzeni){
            if (sledovat) System.out.printf("%S  %d:%d  %S%n", t1.getZkratka(),pBT1,pBT2,t2.getZkratka());
        }
        else{
            if (sledovat) System.out.printf("%S  %d:%dp %S%n", t1.getZkratka(),pBT1,pBT2,t2.getZkratka());
        }
    }
    
    /**
     *
     * @param seznam seznam ucastniku ligy
     */
    public void vypisTymy(List<Tym> seznam){
        String s = "Tym   OZ B   V  VP PP P  VG  OG  ROZ";
        System.out.println(s);
        String carky = "";
        for (int i=0;i<=s.length();i++)
            carky+="-";
        System.out.println(carky);
        ArrayList<Tym> poradi = new ArrayList<>();
        seznam.forEach((t) -> {
            poradi.add(t);
        });
        poradi.sort(Comparator.comparingInt(Tym::getBody).thenComparingInt(Tym::getVyhry).thenComparingInt(Tym::getVstrelene).reversed());
        poradi.forEach((t) -> {
            System.out.println(t);
        });
    }

    /**
     * @return the nazev
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * @return the ucastnici
     */
    public List<Tym> getUcastnici() {
        return ucastnici;
    }

    /**
     * @return the zapasy
     */
    public List<Zapas> getZapasy() {
        return zapasy;
    }

    /**
     * @return the finalisti
     */
    public List<Tym> getFinalisti() {
        return finalisti;
    }

    /**
     * @return the playoff
     */
    public List<Tym> getPlayoff() {
        return playoff;
    }

    /**
     * @return the vitezZC
     */
    public Tym getVitezZC() {
        return vitezZC;
    }

    /**
     * @return the vitezPO
     */
    public Tym getVitezPO() {
        return vitezPO;
    }
    
    
    
}
