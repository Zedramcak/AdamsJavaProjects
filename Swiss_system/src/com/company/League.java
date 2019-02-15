package com.company;

import java.util.List;

public class League {
    private String name;
    private List<Team> attendants;

    private List<Team> winners;
    private List<Team> loosers;

    // first oneMatch
    private List<Team> bascet10;
    private List<Team> bascet01;

    // second oneMatch
    private List<Team> bascet20;
    private List<Team> bascet11;
    private List<Team> bascet02;

    // third oneMatch
    private List<Team> bascet30;
    private List<Team> bascet21;
    private List<Team> bascet12;
    private List<Team> bascet03;

    //fourth oneMatch
    private List<Team> bascet31;
    private List<Team> bascet13;
    private List<Team> bascet22;

    // fifth oneMatch
    private List<Team> bascet32;
    private List<Team> bascet23;

    public League(String nameOfTheLeague){
        name = nameOfTheLeague;
    }

    public League(){
        name = "New League";
    }


    public void startLeague(){
        System.out.printf("Welcome to new season of %s",name);
    }

}
