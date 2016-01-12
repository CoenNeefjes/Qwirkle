package game;

import tile.Color;
import tile.Shape;
import tile.Tile;

public class Board {
	
	public static final int DIM = 183;
	
	private Tile[][] board;
	
	public Board () {
		board = new Tile[DIM][DIM];
		reset();
	}
	
	public void reset() {
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				board[i][j] = new Tile(Color.EMPTY, Shape.EMPTY);
			}
		}
	}
	
	public Tile getTile(int i, int j) {
		return board[i][j];
	}
	
	public void setTile(int i, int j, Tile tile) {
		board[i][j] = tile;
	}
	
	public boolean isEmpty(int i, int j) {
		return board[i][j].toString().equals("EMPTYEMPTY");
	}
	
	
	/*
	public static void main(String[] args) {
		Board board = new Board();
		Tile tile = new Tile(Color.BLUE, Shape.CIRCLE);
		board.setTile(13, 60, tile);
		System.out.println(board.getTile(13, 60));
		System.out.println(board.isEmpty(6, 6));
		System.out.println(board.isEmpty(13, 60));
	} */
	
	

}
