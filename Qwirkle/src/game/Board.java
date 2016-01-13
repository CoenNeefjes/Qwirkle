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

	public Board deepCopy() {
		Board b = new Board();
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				b.setTile(i, j, this.getTile(i, j));
			}
		}
		return b;
	}

    public int index(int row, int col) {
        return row*DIM + col;
    }
	
	public void reset() {
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				board[i][j] = new Tile(Color.EMPTY, Shape.EMPTY);
			}
		}
	}
	
	public Tile getTile(int row, int col) {
		return board[row][col];
	}
	
	public void setTile(int row, int col, Tile tile) {
		if (validMove(row, col, tile)) {
			board[row][col] = tile;
		} else {
			System.out.println("Invalid move");
		}
	}
	
	public boolean isEmpty(int row, int col) {
		return board[row][col].toString().equals("EMPTY EMPTY");
	}

	public boolean isEmptyBoard() {
		boolean ans = true;
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				if (!isEmpty(i,j)) ans = false;
			}
		}
		return ans;
	}

    public boolean isFull() {
        boolean ans = true;
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                if (isEmpty(i,j)) ans = false;
            }
        }
        return ans;
    }

    public boolean validMove(int row, int col, Tile tile) {
		return (isEmptyBoard() && row == 91 && col == 91) || (!isEmptyBoard() && isEmpty(row, col));
    }
	
	
/*
	public static void main(String[] args) {
		Board board = new Board();
		Tile tile = new Tile(Color.BLUE, Shape.CIRCLE);
	}*/
	
	

}
