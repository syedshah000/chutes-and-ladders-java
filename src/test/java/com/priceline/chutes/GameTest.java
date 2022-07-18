package com.priceline.chutes;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {
    private static final int HUNDRED = 100;

    @Test
    public void playGameShouldReturnAWinnerFromFourPlayers(){
        List<Player> listOfPlayers = new ArrayList<>();
        listOfPlayers.add(0,new Player("Djisktra"));
        listOfPlayers.add(0,new Player("hoopper"));
        listOfPlayers.add(0,new Player("John"));
        listOfPlayers.add(0,new Player("Wick"));

        Player winner = new Game().playGame(listOfPlayers);
        assertTrue(!winner.getName().isEmpty());
        assertEquals(HUNDRED,winner.getPosition());
    }

    @Test
    public void playGameShouldReturnAWinnerFromThreePlayers(){
        List<Player> listOfPlayers = new ArrayList<>();
        listOfPlayers.add(0,new Player("hoopper"));
        listOfPlayers.add(0,new Player("John"));
        listOfPlayers.add(0,new Player("Wick"));

        Player winner = new Game().playGame(listOfPlayers);
        assertTrue(!winner.getName().isEmpty());
        assertEquals(HUNDRED,winner.getPosition());
    }
    @Test
    public void playGameShouldReturnAWinnerFromTwoPlayers(){
        List<Player> listOfPlayers = new ArrayList<>();
        listOfPlayers.add(0,new Player("Djisktra"));
        listOfPlayers.add(0,new Player("Wick"));

        Player winner = new Game().playGame(listOfPlayers);
        assertTrue(!winner.getName().isEmpty());
        assertEquals(HUNDRED,winner.getPosition());
    }
}
