package com.company;

import java.util.Random;

public class Match {
    private Team team1;
    private Team team2;
    private Random randomGenerator;

    private Team winner;
    private Team looser;

    public Match(Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
    }

    private void round(){
        if (randomGenerator.nextInt() < 0.5) {
            team1.addWin();
            team2.addLoss();
        } else {
            team2.addWin();
            team1.addLoss();
        }
    }

    public void oneMatch(){


        // erase previous wins or loses
        team1.deleteWinsAndLosts();
        team2.deleteWinsAndLosts();

        do{

        }while(false);

        // set each team win/loss difference
        team1.setDiffereenceBetweenPoints();
        team2.setDiffereenceBetweenPoints();

    }

    public Team getWinner() {
        return winner;
    }

    public Team getLooser() {
        return looser;
    }


}
