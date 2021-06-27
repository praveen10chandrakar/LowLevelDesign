package com.praveen10.learn.java.LowLevelDesign.snakeladder;

public final class Player {
    private Square square;
    private String name;


    public Player(String name) {
        this.name = name;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public void moveForward(int moves) {
        assert moves > 0;

        square.leave(this);
        square = square.moveAndLand(moves);
        square.enter(this);
    }

    public Square getSquare() {
        return square;
    }

    public boolean wins() {
        return square.isLastSquare();
    }

    public String getName() {
        return name;
    }

    public int position() {
        return square.getPosition();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
