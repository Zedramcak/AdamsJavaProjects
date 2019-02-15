package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean doYouWantToPlay = true;

        while(doYouWantToPlay){
            System.out.println("Welcome to Tic Tac Toe! Pick your side!");
            System.out.println();
            System.out.println("Enter a single character, that you will play with");

            char playerToken = in.nextLine().charAt(0);

            System.out.println("Enter a single character, that computer will play with");

            char PCToken = in.nextLine().charAt(0);

            TicTacToe game = new TicTacToe(playerToken,PCToken);
            AI ai = new AI();

            System.out.println("\nChoose a number where you want to place your token.\n");
            TicTacToe.printIndexBoard();

            while (game.gameOver().equals("notOver")){
                if (game.currentMarker==game.userMarker){
                    System.out.println("Your turn");
                    int spot = in.nextInt();
                    while(!game.playTurn(spot)){
                        System.out.println("Spot "+spot+" is taken or out of range");
                        spot = in.nextInt();
                    }

                }else
                {
                    System.out.println("Computers turn");

                    int aiSPot = ai.pickSpot(game);
                    game.playTurn(aiSPot);
                }
                game.printBoard();
            }
            System.out.println(game.gameOver());
            System.out.println();

            System.out.println("Do you want to play again? y/n");
            char response = in.next().charAt(0);
            if (response=='n'){
                doYouWantToPlay=false;
            }

        }
    }
}
