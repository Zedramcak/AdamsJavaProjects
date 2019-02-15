package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to hangman!");
        System.out.println();
        boolean continuePlay = true;
        while(continuePlay){
            System.out.println("START");
            Hangman game = new Hangman();

            do {
                System.out.println();
                System.out.println(game.drawPicture());
                System.out.println();
                System.out.println(game.getFormalCurrentGuess());
                System.out.println(game.mysteryWord);

                System.out.println();
                System.out.println("Enter your guess.");
                char guess = (in.next().toLowerCase().charAt(0));
                System.out.println();

                while(game.isGuessedAlready(guess)){
                    System.out.println("Already guessed. Try again");
                    guess = (in.next().toLowerCase().charAt(0));
                }

                if (game.playGuess(guess))
                    System.out.println("Great choice");
                else
                    System.out.println("Not in this word");
            }while(!game.gameOver());

            System.out.println();
            System.out.println("Do you want to play another game? y/n");
            Character response = (in.next().toLowerCase()).charAt(0);
            continuePlay = response=='y';
        }

    }
}
