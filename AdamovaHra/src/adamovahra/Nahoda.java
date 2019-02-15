/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adamovahra;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Adam
 */
public class Nahoda {
    private final Random random;
    private final ArrayList<Integer> pravdepodobnost;
    
    public Nahoda(){
        random = new Random();
        pravdepodobnost = new ArrayList<>();
        
    }
    
    public void napln(){
        for (int i = 1;i<=19;i++)
            pravdepodobnost.add(0);
        pravdepodobnost.add(1);
    }

    /
    public boolean kritickyZasah(){
        return pravdepodobnost.get(random.nextInt(pravdepodobnost.size()))==1;
    }
    
    
    
}
