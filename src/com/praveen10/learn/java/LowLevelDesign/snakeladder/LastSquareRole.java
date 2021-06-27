package com.praveen10.learn.java.LowLevelDesign.snakeladder;

public final class LastSquareRole extends SquareRole {

    public LastSquareRole(Square square) {
        super(square);
    }

    @Override
    public boolean isLastSquare() {
        return true;
    }
}
