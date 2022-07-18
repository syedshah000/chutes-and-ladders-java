package com.priceline.chutes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    private static final String WELCOME_PROMPT = "Welcome to Chutes and Ladders !\n";
    private static final String NUMBER_OF_PLAYERS_PROMPT = " Enter number of players (Min. 2, Max 4)\n";
    private static final String ENTER_NAME_PROMPT = "\nPlease enter player ";
    private static final String NAME = " name:\n";
    private static final String INVALID_NUM_OF_PLAYERS_PROMPT = "Invalid Entry !! Minimum Players:2 , Maximum Players:4\n";
    private static final int MIN_NUM_OF_PLAYERS = 2;
    private static final int MAX_NUM_OF_PLAYERS = 4;

    List<Player> players = new ArrayList<>();
    int numberOfPlayers =0;


    public UserInput() {
    }

    /**
     * read input from console to build players list.
     */
    public List<Player> getPlayers(){
        Scanner scan = new Scanner(System.in);
        System.out.println(WELCOME_PROMPT + "\n" + NUMBER_OF_PLAYERS_PROMPT);

        while(scan.hasNext()) {
            try {
                numberOfPlayers = scan.nextInt();
            } catch (InputMismatchException e) {
                scan.next();
            }
            if (numberOfPlayers >= MIN_NUM_OF_PLAYERS && numberOfPlayers <= MAX_NUM_OF_PLAYERS) {
                break;
            } else {
                System.out.println(INVALID_NUM_OF_PLAYERS_PROMPT);
                System.out.println(NUMBER_OF_PLAYERS_PROMPT);
            }
        }

        for(int i=0; i<numberOfPlayers; i++){
            System.out.println(ENTER_NAME_PROMPT + i + NAME);
            players.add(i,new Player(scan.next()));
        }
        return players;
    }
}
