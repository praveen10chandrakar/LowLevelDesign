package com.praveen10.learn.java.LowLevelDesign.snakeladder;

public final class SnakeRole extends SquareRole {

    private int transport;

    public SnakeRole(Square square, int transport) {
        super(square);
        assert  transport < 0 : "A snake shift must be negative.";
        this.transport = transport;
    }

    public Square destination(){
        return square.findRelativeSquare(transport);
    }

}
