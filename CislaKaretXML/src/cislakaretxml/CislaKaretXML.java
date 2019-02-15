/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cislakaretxml;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author Adam
 */
public class CislaKaretXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Generator g = new Generator();
        ArrayList<Karta> karty = new ArrayList<>();
        g.generuj(100);
        for (Karta k : g.getKarty()){
            karty.add(k);
        }
        for (Karta k : karty){
            System.out.println(k.toString());
        }
        
        XMLOutputFactory xof = XMLOutputFactory.newInstance();
        XMLStreamWriter xsw = null;
        try
        {
            xsw = new IndentingXMLStreamWriter(xof.createXMLStreamWriter(new FileWriter("karty.xml")));
            xsw.writeStartDocument();
            xsw.writeStartElement("karty");
            
            for (Karta k : karty)
            {
                xsw.writeStartElement("karta");
                xsw.writeAttribute("cislo", Long.toString(k.getCislo()));
                xsw.writeEndElement();
                xsw.writeStartElement("pin");
                xsw.writeCharacters(Integer.toString(k.getPin()));
                xsw.writeEndElement();
                xsw.writeStartElement("prostredky");
                xsw.writeCharacters(Double.toString(k.getProstredky()));
                xsw.writeEndElement();
            }
            xsw.writeEndElement();
            xsw.writeEndDocument();
            xsw.flush();
        }
        catch (IOException | XMLStreamException e)
        {
            System.err.println("Chyba pri zapisu: "+e.getMessage());
        }
        finally
        {
            try
            {
                if(xsw!=null)
                {
                    xsw.close();
                }
            }
            catch (XMLStreamException e)
            {
                System.err.println("Chyba pri uzavirani souboru: "+e.getMessage());
            }
        }
    }
    
}
