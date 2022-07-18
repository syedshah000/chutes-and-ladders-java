package com.priceline.chutes;
import java.util.*;

public class Game {

    private static final int HUNDRED = 100;
    private Random random = new Random();
    private int spin(){
        return random.nextInt(6) + 1;
    }

    public Player playGame(List<Player> players){
        Board board = new Board();
        while(true){
            for (Player currentPlayer : players) {
                int spinResult = spin();
                int nextPosition = currentPlayer.getPosition() + spinResult;
                if (nextPosition > HUNDRED){
                    continue;
                }
                BoardSquare nextSquare = board.getSquareAtPosition(nextPosition);
                nextPosition += nextSquare.getNumberSquaresToSkip();
                if (nextPosition < HUNDRED) {
                    currentPlayer.setPosition(nextPosition);
                } else if (nextPosition == HUNDRED) {
                    currentPlayer.setPosition(nextPosition);
                    return currentPlayer;//The winner!
                }
            } 
        }
    }
}
