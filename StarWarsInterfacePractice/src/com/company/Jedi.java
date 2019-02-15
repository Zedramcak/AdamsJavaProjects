package com.company;

public class Jedi implements Character{

    public String weapon = "FORCE";
    @Override
    public void attack() {
        System.out.println("The Jedi attacks the Sith!");
    }

    @Override
    public void heal() {
        System.out.println("The Jedi heals you!");
    }

    @Override
    public String getWeapon() {
        return weapon;
    }
}
