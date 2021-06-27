package com.praveen10.learn.java.LowLevelDesign.snakeladder;

public class Square {

    private Board board = null;
    private int position;
    private Player player;
    private SquareRole squareRole = null;

    public Square(int position, Board board){
        assert position > 0;
        this.position = position;
        this.board = board;
    }

    public Player getPlayer(){
        return player;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public Square findFirstSquare(){
        return board.firstSquare();
    }

    public Square findLastSquare(){
        return board.lastSquare();
    }

    public int getPosition() {
        return position;
    }

    public Square findRelativeSquare ( int moves ){
        return board.findSquare(position + moves);
    }

    public void setSquareRole(SquareRole role){
        assert squareRole != null;

        squareRole = role;
    }

    public Square landHereOrGoHome() {
        return squareRole.landHereOrGoHome();
    }

    public boolean isOccupied() {
        return squareRole.isOccupied();
    }

    public void enter(Player player) {
        squareRole.enter(player);
    }

    public void leave(Player player) {
        squareRole.leave(player);
    }

    public boolean isLastSquare() {
        return squareRole.isLastSquare();
    }

    public Square moveAndLand(int moves) {
        return squareRole.moveAndLand(moves);
    }
}
