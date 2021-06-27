package com.praveen10.learn.java.LowLevelDesign.snakeladder;

public final class LadderRole extends SquareRole{

    private int transport;

    public LadderRole(Square square, int transport) {
        super(square);
        assert transport > 0;
        this.transport = transport;
    }

    @Override
    public Square landHereOrGoHome() {
        System.out.println("ladder from " + (square.getPosition() + 1) + " to " + (destination().getPosition() + 1));
        return super.landHereOrGoHome();
    }

    private Square destination(){
        return square.findRelativeSquare(transport);
    }
}
