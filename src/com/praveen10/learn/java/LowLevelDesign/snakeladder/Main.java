package com.praveen10.learn.java.LowLevelDesign.snakeladder;

public class Main {

    public static void main(String[] args) {
	    String [] playerNames = {"A", "B", "C", "D"};
	    int numSquares = 12;

	    int [][] snakesFromTo = {{11, 5}};
	    int [][] laddersFromTo = {{2, 6}, {7, 9}};

	    Game game = new Game(playerNames, numSquares, snakesFromTo, laddersFromTo);
	    game.play();

    }
}
