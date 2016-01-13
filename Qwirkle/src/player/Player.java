package player;

import game.Board;
import tile.Tile;

public abstract class Player {
	
	private String name;
	private int playerNumber;

    public Player(String name, int playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
    }

    public String getName() {
        return name;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public abstract int determineMove(Board board);

    public void makeMove(int row, int col, Tile tile) {
        Board board = new Board();
        if (board.validMove(row, col, tile)) {
            board.setTile(row, col, tile);
        }
    }


}
