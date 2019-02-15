package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Hangman {

    String mysteryWord;
    StringBuilder currentGuess;
    ArrayList<Character> previousGuesses = new ArrayList<>();

    int maxTries = 6;
    int currentTry = 0;

    ArrayList<String> dictionary = new ArrayList<>();
    private static FileReader fileReader;
    private static BufferedReader bufferedReader;

    public Hangman() throws IOException {
        initializeStream();
        mysteryWord = pickWord();
        currentGuess = initializeCurrentGuess();
    }

    private StringBuilder initializeCurrentGuess() {
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < mysteryWord.length()*2;i++){
            if(i%2==0)
                current.append("_");
            else
                current.append(" ");
        }
        return current;
    }

    private String pickWord() {
        Random ran = new Random();
        int wordIndex = Math.abs(ran.nextInt()) % dictionary.size();
        return dictionary.get(wordIndex);
    }

    private void initializeStream() throws IOException{
        try {
            File inFile = new File("dictionary.txt");
            fileReader = new FileReader(inFile);
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line!=null){
                if(!line.endsWith("'s")&&!line.contains("'")&&line.length()>4)
                    dictionary.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        }catch(IOException e){
            System.err.println("Could not init streams");
        }
    }

    public String getFormalCurrentGuess(){
        return "Current Guess: " + currentGuess.toString();
    }

    public String drawPicture(){
        switch (currentTry){
            case 0: return noPersonDrwa();
            case 1: return addHeadDraw();
            case 2: return addBodyDraw();
            case 3: return addFirstArmDraw();
            case 4: return addSecondArmDraw();
            case 5: return addFirstLegDraw();
            default: return fullPersonDraw();
        }
    }


    private String fullPersonDraw() {
       return(
                " - - - - -\n"+
                        "|        |\n"+
                        "|        O\n" +
                        "|      / | \\ \n"+
                        "|        |\n" +
                        "|       / \\ \n" +
                        "|\n" +
                        "|\n");
    }

    private String addFirstLegDraw() {
        return(
                " - - - - -\n"+
                        "|        |\n"+
                        "|        O\n" +
                        "|      / | \\ \n"+
                        "|        |\n" +
                        "|       / \n" +
                        "|\n" +
                        "|\n");
    }

    private String addSecondArmDraw() {
        return(
                        " - - - - -\n"+
                        "|        |\n"+
                        "|        O\n" +
                        "|      / | \\ \n"+
                        "|        |\n" +
                        "|       \n" +
                        "|\n" +
                        "|\n");
    }

    private String addFirstArmDraw() {
        return(
                        " - - - - -\n"+
                        "|        |\n"+
                        "|        O\n" +
                        "|      / |\n"+
                        "|        |\n" +
                        "|         \n" +
                        "|\n" +
                        "|\n");
    }

    private String addBodyDraw() {
        return(
                        " - - - - -\n"+
                        "|        |\n"+
                        "|        O\n" +
                        "|        |\n"+
                        "|        |\n" +
                        "|        \n" +
                        "|\n" +
                        "|\n");
    }

    private String addHeadDraw() {
        return(
                " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|       \n"+
                "|       \n" +
                "|       \n" +
                "|\n" +
                "|\n");
    }

    private String noPersonDrwa() {
        return(
                " - - - - -\n"+
                "|        |\n"+
                "|        \n" +
                "|      \n"+
                "|        \n" +
                "|        \n" +
                "|\n" +
                "|\n");
    }

    public boolean gameOver() {
        if (didWeWin()){
            System.out.println();
            System.out.println("VICTORY");
            return true;
        }else if (didWeLose()){
            System.out.println();
            System.out.println("LOOSER! You were looking for: "+mysteryWord);
            return true;
        }

        return false;
    }

    private boolean didWeLose() {
        return currentTry>=maxTries;
    }

    private boolean didWeWin() {
        String guess = getCondensedCurrentGuess();
        return guess.length()==mysteryWord.length();
    }

    public boolean isGuessedAlready(char c) {
        return previousGuesses.contains(c);
    }

    public boolean playGuess(char c) {
        boolean goodGuess = false;
        previousGuesses.add(c);
        for (int i = 0; i < mysteryWord.length(); i++) {
            if (mysteryWord.charAt(i)==c){
                currentGuess.setCharAt(i*2,c);
                goodGuess = true;

            }
        }

        if(!goodGuess){
            currentTry++;
        }

        return goodGuess;
    }

    public String getCondensedCurrentGuess() {
        String guess = currentGuess.toString();
        guess.replace(" ","").replace("_","");
        return guess;
    }
}
