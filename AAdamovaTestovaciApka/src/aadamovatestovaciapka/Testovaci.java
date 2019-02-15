/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadamovatestovaciapka;

/**
 *
 * @author Adam
 */
public class Testovaci {
    
    public String notString(String s){
        if (s.startsWith("not ")){
            return s;
        }
        else
            return "not "+s;
    }
    public String missingChar(String str, int n) {
        char[] ch = str.toCharArray();
        String a = "";
        for (int i = 0; i<ch.length;i++){
            if (i!=n)
                a+=ch[i];
        }   
        return a;
    }   
    public String frontBack(String str) {
        if (str.length()==1)
            return str;
        else{
            char[] ch = str.toCharArray();
            String a = "";
            char pomoc = ch[0];
            ch[0]=ch[str.length()-1];
            ch[str.length()-1]=pomoc;
            for (int i = 0; i<ch.length;i++)
                a+=ch[i];   
            return a;
        }
    }
    public String front3(String str) {
        if (str.length()<=3)
            return str+str+str;
        else{
            char[] ch = new char[3];
            for (int i=0;i<3;i++)
                ch[i]=str.charAt(i);
            String s="";
            for (int i=0;i<3;i++){
                for (char c:ch){
                    s+=c;
                }
            }
            return s;
        } 

    }
    
    public String front22(String str) {
        if (str.length()<=2)
            return str+str+str;
        else{
            char[] ch = new char[2];
            for (int i=0;i<2;i++)
                ch[i]=str.charAt(i);
            String s="";
            
            for (char c:ch)
                s+=c;
            
            return s+str+s;
        }
    }
    
    public String delDel(String str) {
        if (str.length()<4)
            return str;
        else{
        char[] ch = new char[3];
        char[] konecny = str.toCharArray();
        for (int i=1;i<4;i++){
            ch[i-1]=str.charAt(i);
        }
        String del = "";
        for (char c:ch)
            del+=c;
        if (del.equals("del")){
            str = "";
            for (int i=0;i<konecny.length;i++){
                if (i>=1&&i<=3)
                    continue;
            str+=konecny[i];
            }
          return str;
        }
        else
          return str;
        }
    }

    public boolean mixStart(String str) {
        return str.substring(1, 2).equals("ix");
        
    }
    
    public String startOz(String str) {
        if (o1(str)&&z2(str))
          return "oz";
        else if (!o1(str)&&z2(str))
          return "z";
        else if (o1(str)&&!z2(str))
          return "o";
        else
          return str;
      }

    private boolean z2(String s){
      return s.substring(1,2).equals("z");
    }
    private boolean o1(String s){
      return s.substring(0,1).equals("o");
    }
    
    public int intMax(int a, int b, int c) {
        if (a>b){
            if (a>c)
                return a;
            else
                return c;
        }
        else{
            if (b>c)
                return b;
            else
                return c;
        }
            
    }
    
    public int max1020(int a, int b) {
        if (jeVRange(a)&&jeVRange(b)){
            if (a>b)
                return a;
            else
              return b;
        }
        else if (jeVRange(a)&&a>b)
            return a;
        else if (jeVRange(b)&&b>a)
            return b;
        else
            return 0;
    }

    private boolean jeVRange(int a){
      return a>=10&&a<=20;
    }
    
    public boolean stringE(String str) {
        int pocitadlo =0;
        char[] ch = str.toLowerCase().toCharArray();
        for (char c:ch){
            if (c=='e')
                pocitadlo++;
        }
        return pocitadlo>=1&&pocitadlo<=3;
        
    }
    
    public String endUp(String str) {
        if (str.length()<=3)
            return str.toUpperCase();
        else{
            String velke = str.substring(str.length()-3);
            char[] ch = str.toCharArray();
            String vysledek="";
            for (int i =0; i<ch.length-3;i++){
                vysledek+=ch[i];
                
            }
            return vysledek+velke.toUpperCase();
            
        }
    }
    
    public String frontTimes(String str, int n) {
        String vysledek = "";
        if (str.length()<=3){
            for (int i =0;i<n;i++)
                vysledek+=str;
        }
        else{
            char[] ch = str.toCharArray();
            String p3 = "";
            for (int i =0; i<3;i++)
                p3+=ch[i];
            for (int i =0;i<n;i++)
                vysledek+=p3;
        }
        return vysledek;
    }
    
    public int last2(String str) {
        if (str.length()<2)
            return 0;
        else{
          String vzor = str.substring(str.length()-2);
          int pocitadlo = 0;
          for (int i=0;i<str.length()-2;i++){
            if(str.substring(i,i+2).equals(vzor)){
              pocitadlo++;
            }
          }
          return pocitadlo;
        }
    }
    
    public String stringYak(String str) {
    char[] ch = str.toCharArray();
    String goal = "";
    for (int i=0;i<ch.length;i++){
        if (i<ch.length-2){
            if (!(ch[i]=='y'&&ch[i+2]=='k')){
                goal+=ch[i];
            }
            else{
                i+=2;
            }
        }
        else
            goal+=ch[i];
    }
    return goal;
    }

    public boolean love6(int a, int b) {
        return ((a==6||b==6)||(a+b==6||Math.abs(a-b)==6));
    }

    public String endX(String str) {
        if (str.substring(str.length()-countX(str)).equals(repeatX("x",countX(str)))){
            return str.substring(0,str.length()-countX(str))+repeatX("x",countX(str));
        }
        if (str.startsWith("x"))
            return endX(str.substring(1)+"x");
        else
            return str.charAt(0)+endX(str.substring(1));
    }
    
    
    private String repeatX(String c, int count){
        if (count==1){
            return c;
        }
        if (count==0){
            return "";
        }
        return c+repeatX(c,count-1); 
    } 
    
    private int countX(String str){
        if (str.length()<=1){
            if (str.startsWith("x"))
                return 1;
            else 
                return 0;
        }
        if (str.startsWith("x"))
                return 1+countX(str.substring(1,str.length()));
            else 
                return 0+countX(str.substring(1,str.length()));
    }
    
    public String parenBit(String str) {
        if (!str.startsWith("("))
            return parenBit(str.substring(1));
        if(!str.endsWith(")"))
            return parenBit(str.substring(0,str.length()-1));
        return str;
    }
    
    public boolean splitArray(int[] nums){
        
        return true;
        
    }
    
    
}
