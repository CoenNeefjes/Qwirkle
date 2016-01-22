package game;

import player.Player;
import tile.Color;
import tile.Shape;
import tile.Tile;

public class Board {
	
	public static final int DIM = 183;
	
	private Tile[][] board;
	
	public Board() {
		board = new Tile[DIM][DIM];
		reset();
	}

    //Creates a copy of the board for the AI
	public Board deepCopy() {
		Board b = new Board();
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				b.setTile(i, j, this.getTile(i, j));
			}
		}
		return b;
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
//        System.out.println(getTile(91, 91));
//        System.out.println("" + row + col);
//        Tile tile = board[row][col];
//        return tile.toString().equals("EMPTY EMPTY");
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

	public boolean validMove(int row, int col, Tile tile) {
		//TO DO: Read rules, implement validmove for tile part
		boolean ans = false;
		if (0 <= row * col && row * col < DIM * DIM) {
			ans = (isEmptyBoard() && row == 91 && col == 91) || (!isEmptyBoard() && isEmpty(row, col));
		}
		return ans;
	}



    public boolean gameOver() {
        return false;
    }


    public void reset() {
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				board[i][j] = new Tile(Color.EMPTY, Shape.EMPTY);
			}
		}
	}

    public int[] getBoundaries() {
        int[] boundaries = new int[4];
        //Four values in integer array.
        // Value 0 is the rightmost value of the playing board;
        // Value 1 is the leftmost value of the playing board;
        // Value 2 is the upmost value of the playing board and
        // Value 3 is the lowest value of the playing board.

        //Get right extreme boundary
        int maxRightIndex = 0;
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                if (!getTile(i,j).toString().equals("EMPTY EMPTY") && j > maxRightIndex) {
                    maxRightIndex = j;
                }
            }
        }
        boundaries[0] = maxRightIndex;

        //Get left extreme boundary
        int minLeftIndex = DIM;
        for (int i = DIM-1; i > 0; i--) {
            for (int j = DIM-1; j > 0; j--) {
                if (!getTile(i,j).toString().equals("EMPTY EMPTY") && j < minLeftIndex) {
                    minLeftIndex = j;
                }
            }
        }
        boundaries[1] = minLeftIndex;

        //Get upper extreme boundary
        int maxUpIndex = 0;
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                if (!getTile(i,j).toString().equals("EMPTY EMPTY") && i > maxUpIndex) {
                    maxUpIndex = j;
                }
            }
        }
        boundaries[2] = maxUpIndex;

        //Get lower extreme boundary
        int minDownIndex = DIM;
        for (int i = DIM-1; i > 0; i--) {
            for (int j = DIM-1; j > 0; j--) {
                if (!getTile(i,j).toString().equals("EMPTY EMPTY") && j < minDownIndex) {
                    minDownIndex = j;
                }
            }
        }
        boundaries[3] = minDownIndex;
        return boundaries;

    }

//    public int testCount() {
//        int counter = 0;
//        for (int i = 0; i < DIM; i++) {
//            for (int j = 0; j < DIM; j++) {
//                if (!getTile(i,j).toString().equals("EMPTY EMPTY")) counter++;
//            }
//        }
//        return counter;
//    }

    public String toString() {
        String res = "";
        int[] boundaries = getBoundaries();
        int emptyMargin = 3; //For aesthetic purposes.
        for (int i = boundaries[3] - emptyMargin; i < (boundaries[2] + emptyMargin+1); i++) {
            for (int j = boundaries[1] - emptyMargin; j < boundaries[0] + emptyMargin+1; j++) {
                if (getTile(i,j).toString().equals("EMPTY EMPTY")) {
                    res = res + "              | ";
                } else {
                    res = res + getTile(i,j).toString() + " | ";
                }

            }
            res = res + "\n";
        }
        return res;
    }
	
	

}
