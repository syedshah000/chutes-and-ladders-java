package com.priceline.chutes;

public class RunnerClass {
    private static final String WINNER_PROMPT = "The winner is : ";

    public static void main(String[] args) {
        try {
            UserInput userInput = new UserInput();
            Player winner = new Game().playGame(userInput.getPlayers());
            System.out.println(WINNER_PROMPT + winner.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

