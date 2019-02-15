package com.company;

public class Sith implements Character{

    public String weapon = "lightsaber";

    public Sith(){};

    @Override
    public void attack() {
        System.out.println("The Sith attacks YOU!");
    }

    @Override
    public void heal() {
        System.out.println("The Sith heals himself");
    }

    @Override
    public String getWeapon() {
        return weapon;
    }
}
