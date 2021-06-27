package com.praveen10.learn.java.LowLevelDesign.snakeladder;

import java.util.LinkedList;

public class Game {

    private Board board = null;
    private LinkedList<Player> players = new LinkedList<Player>();
    private Player winner;

    public void play() {
        assert !players.isEmpty();
        assert board != null;

        Die die = new Die();
        startGame();

        System.out.println("Initial State: \n" + this);
        while (notOver()){
            int roll = die.roll();
            System.out.println("Current player is " + currentPlayer() + " and rolls " + roll);
            movePlayer(roll);
            System.out.println("State: \n" + this);
        }

        System.out.println(winner + " has won!");
    }

    private Player currentPlayer() {
        assert players.size() > 0;
        return players.peek();
    }

    private void movePlayer(int roll) {
        Player currentPlayer = players.remove();
        currentPlayer.moveForward(roll);
        players.add(currentPlayer);
        if (currentPlayer.wins()){
            winner = currentPlayer;
        }
    }

    private boolean notOver() {
        return winner == null;
    }

    private void startGame() {
        placePlayersAtFirstSquare();
        winner = null;
    }

    private void placePlayersAtFirstSquare() {
        for (Player player: players){
            board.firstSquare().enter(player);
        }
    }

    @Override
    public String toString () {
        String str = new String ();
        for ( Player player : players ) {
            str += player.getName() + " is at square " + ( player.position()+1) + "\n";
        }
        return str;
    }

    private final class Die{
        private static final int MINVALUE = 1;
        private static final int MAXVALUE = 6;

        public int roll(){
            return random(MINVALUE, MAXVALUE);
        }

        private int random(int minvalue, int maxvalue) {
            assert minvalue < maxvalue;
            return (int) (minvalue + Math.round((maxvalue - minvalue) * Math.random()));
        }
    }


    public Game(String[] playerNames, int numSquares, int[][] snakes, int[][] ladders) {
        makeBoard(numSquares, ladders, snakes);
        makePlayers(playerNames);
    }

    private void    makePlayers(String[] playerNames) {
        assert playerNames.length > 0;
        System.out.println("Players are: ");

        int i = 0;
        for (String str: playerNames){
            Player player = new Player(str);
            players.add(player);
            System.out.println(i + " . " + str);
            i++;
        }
    }

    private void makeBoard(int numSquares, int[][] ladders, int[][] snakes) {
        board = new Board(numSquares, ladders, snakes);
    }


}
