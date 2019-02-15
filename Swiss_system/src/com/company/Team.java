package com.company;


import java.util.List;

public class Team {
    private String name;
    private int wins;
    private int loses;

    private int differeenceBetweenPoints;
    private List<Team> teamsThatTheyPlayedWith;

    private int noNameNumber = 1;


    /**
     * @param name Name of the team
     * @param wins Number of wins
     * @param losts Number of looses
     * @param noNameNumber Number of team without name
    */

    public Team(){
        name = String.format("No name %d", noNameNumber);
        noNameNumber++;
        wins = 0;
        loses = 0;
        differeenceBetweenPoints = 0;
    }

    public Team(String name){
        this.name = name;
        wins = 0;
        loses = 0;
    }

    public void deleteWinsAndLosts(){
        wins = 0;
        loses = 0;
    }

    public void setDiffereenceBetweenPoints(){
        differeenceBetweenPoints = wins - loses;
    }

    public void addWin(){
        wins++;
    }

    public void addLoss(){
        loses++;
    }

    public int getWins() {
        return wins;
    }

    public int getLoses() {
        return loses;
    }

}
