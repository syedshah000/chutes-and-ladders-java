package com.priceline.chutes;
import java.util.*;

public class Game {

    private Random random = new Random();
    private static final String WELCOME_PROMPT = "Welcome to Chutes and Ladders !\n";
    private static final String NUMBER_OF_PLAYERS_PROMPT = " Enter number of players (Min. 2, Max 4)\n";
    private static final String ENTER_NAME_PROMPT = "\nPlease enter player ";
    private static final String NAME = " name:\n";
    private static final String INVALID_NUM_OF_PLAYERS_PROMPT = "Invalid Entry !! Minimum Players:2 , Maximum Players:4\n";
    private static final String WINNER_PROMPT = "The winner is : ";
    private static final int HUNDRED = 100;
    private static final int MIN_NUM_OF_PLAYERS = 2;
    private static final int MAX_NUM_OF_PLAYERS = 4;

    public Player playGame(List<Player> players){
        Board board = new Board();

        while(true){
            for (Player currentPlayer : players) {
                int spinResult = spin();
                int nextPosition = currentPlayer.getPosition() + spinResult;
                if (nextPosition > HUNDRED){
                    continue;
                    /**
                     * using 'break' stops the turn of other players until current
                     * player does not win or move closer to 100th box
                     *
                     * Replacing 'break' with 'continue' skips the current player and
                     * moves on to the next player
                     */
                }
                BoardSquare nextSquare = board.getSquareAtPosition(nextPosition);
                nextPosition += nextSquare.getNumberSquaresToSkip();
                if (nextPosition < HUNDRED) {
                    currentPlayer.setPosition(nextPosition);
                } else if (nextPosition == HUNDRED) {
                    return currentPlayer;//The winner!
                }
            } 
        }
    }

    private int spin(){
        return random.nextInt(6) + 1;
    }

    /**
     * read input from console to build players list.
     */
    public List<Player> getPlayers(){
        List<Player> players = new ArrayList<>();
        int numberOfPlayers =0;
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

    public static void main(String[] args) {
        try {
            Player winner = new Game().playGame( new Game().getPlayers());
            System.out.println(WINNER_PROMPT + winner.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
