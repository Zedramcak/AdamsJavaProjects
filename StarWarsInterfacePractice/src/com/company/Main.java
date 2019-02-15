package com.company;

import java.util.Random;

public class Main {

    public static Character summonCharacter(){
        Random rand = new Random();
        if(Math.abs(rand.nextInt())%2==0){
            return new Sith();
        }
        else{
            return new Jedi();
        }
    }
    public static void main(String[] args) {
	    Sith darthVader = new Sith();
	    Jedi ObiWanKenobi = new Jedi();
	    darthVader.attack();
	    ObiWanKenobi.attack();
	    darthVader.heal();
	    ObiWanKenobi.heal();
	    System.out.println(darthVader.getWeapon());
        System.out.println(ObiWanKenobi.getWeapon());
        Character spy = summonCharacter();
        spy.attack();
        spy.heal();

    }
}
