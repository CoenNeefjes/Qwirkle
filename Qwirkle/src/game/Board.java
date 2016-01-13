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

	public int[] indexToRowCol(int index) {
		int[] ans = new int[2];
		ans[0] = index / DIM;
		ans[1] = index % DIM;
		return ans;
	}

	public Tile getTile(int row, int col) {
		return board[row][col];
	}

	public Tile getTile(int index) {
		int[] a = indexToRowCol(index);
		return board[a[0]][a[1]];
	}

	public void setTile(int row, int col, Tile tile) {
		if (validMove(row, col, tile)) {
			board[row][col] = tile;
		} else {
			System.out.println("Invalid move");
		}
	}

	public void setTile(int index, Tile tile) {
		int[] a = indexToRowCol(index);
		if (validMove(a[0], a[1], tile)) {
			board[a[0]][a[1]] = tile;
		} else {
			System.out.println("Invalid move");
		}
	}

	public boolean isEmpty(int row, int col) {
		return board[row][col].toString().equals("EMPTY EMPTY");
	}

	public boolean isEmpty(int index) {
		int[] a = indexToRowCol(index);
		return board[a[0]][a[1]].toString().equals("EMPTY EMPTY");
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
		//TO DO: Read rules, implement validmove for tile part
		boolean ans = false;
		if (0 <= row * col && row * col < DIM * DIM) {
			ans = (isEmptyBoard() && row == 91 && col == 91) || (!isEmptyBoard() && isEmpty(row, col));
		}
		return ans;
	}

	public boolean validMove(int index, Tile tile) {
		//TO DO: Read rules, implement validmove for tile part
		int[] a = indexToRowCol(index);
		boolean ans = false;
		if (0 <= index && index < DIM * DIM) {
			ans = (isEmptyBoard() && a[0] == 91 && a[1] == 91) || (!isEmptyBoard() && isEmpty(a[0], a[1]));
		}
		return ans;
	}

	public void reset() {
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				board[i][j] = new Tile(Color.EMPTY, Shape.EMPTY);
			}
		}
	}

	
/*
	public static void main(String[] args) {
		Board board = new Board();
		Tile tile = new Tile(Color.BLUE, Shape.CIRCLE);
		int[] index = new int[2];
		index = board.indexToRowCol(16745);
		System.out.println(index[0]);
		System.out.println(index[1]);

	}*/
	
	

}
