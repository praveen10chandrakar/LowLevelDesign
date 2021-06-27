package com.praveen10.learn.java.LowLevelDesign.snakeladder;

import java.util.ArrayList;

public final class FirstSquareRole extends SquareRole {

    private ArrayList <Player> players = new ArrayList<>();

    public FirstSquareRole(Square square) {
        super(square);
    }

    @Override
    public boolean isFirstSquare() {
        return true;
    }

    @Override
    public void enter(Player player) {
        players.add(player);
        player.setSquare(square);
    }

    @Override
    public void leave(Player player) {
        players.remove(player);
    }

    @Override
    public boolean isOccupied() {
        return !players.isEmpty();
    }
}
