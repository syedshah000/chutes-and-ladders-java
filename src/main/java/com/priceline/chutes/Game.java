package com.priceline.chutes;
import java.util.*;

public class Game {

    private Random random = new Random();
    Player dijkstra = new Player("dijkstra");
    Player turing = new Player("turing");
    Player hopper = new Player("hopper");
    Player torvalds = new Player("torvalds");

    public Player playGame(){
         Player[] players = new Player[]{dijkstra, turing, hopper, torvalds};
        Board board = new Board();

        while(true){
            for (Player currentPlayer : players) {
                int spinResult = spin();
                System.out.println("Current Player : " + currentPlayer.getName());
               // System.out.println("Spin result :" + spinResult);
                int nextPosition = currentPlayer.getPosition() + spinResult;
                if (nextPosition > 100){
                    continue;
                    /*
                     'break;'
                     stops the other players turn until current player moves or wins
                     replacing it with 'continue;' starts the next iteration upon invocation
                     */
                }
                BoardSquare nextSquare = board.getSquareAtPosition(nextPosition);
                nextPosition += nextSquare.getNumberSquaresToSkip();
                if (nextPosition < 100) {
                    currentPlayer.setPosition(nextPosition);
                   // System.out.println("Current Position: " + currentPlayer.getPosition());
                } else if (nextPosition == 100) {
                    return currentPlayer;//The winner!
                }
            } 
        }
    }

    private int spin(){
        return random.nextInt(6) + 1;
    }

    public static void main(String[] args) {
        try {
            Player winner = new Game().playGame();
            System.out.println("The winner is: " + winner.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
