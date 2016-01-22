package game;

import player.Player;
import tile.Color;
import tile.Shape;
import tile.Tile;

/**
 * <h1>Board</h1>
 * Board is the class that holds all the tiles in the form of two Tile arrays to 
 * simulate the rows and columns. 
 * <p>
 * In the Board class are methods for placing tiles,
 * getting tiles and checking if tiles are valid.
 * 
 *
 */

public class Board {
	
	public static final int DIM = 183;
	
	private Tile[][] board;
	
	/**
	 * 
	 */
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
		return(validMoveStart(row, col, tile) || (validMoveNotStart(row, col, tile)) && validSurroundings(row, col, tile));
	}
	
	public boolean validMoveStart(int row, int col, Tile tile) {
		return (isEmptyBoard() && row == 91 && col == 91);
	}
	
	public boolean validMoveNotStart(int row, int col, Tile tile) {
		return (!isEmptyBoard() && isEmpty(row, col) && (row >= 0 && row <= DIM && col >= 0 && col<= DIM));
	}
	
	public boolean validSurroundings(int row, int col, Tile tile) {
		boolean result = false;
		if ((!isEmpty(row, col+1) && !isEmpty(row, col+2) && !isEmpty(row, col+3) && !isEmpty(row, col+4) && !isEmpty(row, col+5) && !isEmpty(row, col+6)) ||
			(!isEmpty(row, col-1) && !isEmpty(row, col-2) && !isEmpty(row, col-3) && !isEmpty(row, col-4) && !isEmpty(row, col-5) && !isEmpty(row, col-6)) ||	
			(!isEmpty(row+1, col) && !isEmpty(row+2, col) && !isEmpty(row+3, col) && !isEmpty(row+4, col) && !isEmpty(row+5, col) && !isEmpty(row+6, col)) ||
			(!isEmpty(row-1, col) && !isEmpty(row-2, col) && !isEmpty(row-3, col) && !isEmpty(row-4, col) && !isEmpty(row-5, col) && !isEmpty(row-6, col)) ){
			result = false;
		} else if(
				((tile.getColor() == board[row+1][col].getColor()) &&
				(tile.getShape() != board[row+1][col].getShape()) && (tile.getShape() != board[row+2][col].getShape()) && (tile.getShape() != board[row+3][col].getShape()) && (tile.getShape() != board[row+4][col].getShape()) && (tile.getShape() != board[row+5][col].getShape()))
				||
				((tile.getColor() == board[row-1][col].getColor()) &&
				(tile.getShape() != board[row-1][col].getShape()) && (tile.getShape() != board[row-2][col].getShape()) && (tile.getShape() != board[row-3][col].getShape()) && (tile.getShape() != board[row-4][col].getShape()) && (tile.getShape() != board[row-5][col].getShape())) 
				||
				((tile.getColor() == board[row][col+1].getColor()) &&
				(tile.getShape() != board[row][col+1].getShape()) && (tile.getShape() != board[row][col+2].getShape()) && (tile.getShape() != board[row][col+3].getShape()) && (tile.getShape() != board[row][col+4].getShape()) && (tile.getShape() != board[row][col+5].getShape()))
				||
				((tile.getColor() == board[row][col-1].getColor()) &&
				(tile.getShape() != board[row][col-1].getShape()) && (tile.getShape() != board[row][col-2].getShape()) && (tile.getShape() != board[row][col-3].getShape()) && (tile.getShape() != board[row][col-4].getShape()) && (tile.getShape() != board[row][col-5].getShape()))
				||
				((tile.getShape() == board[row+1][col].getShape()) &&
				(tile.getColor() != board[row+1][col].getColor()) && (tile.getColor() != board[row+2][col].getColor()) && (tile.getColor() != board[row+3][col].getColor()) && (tile.getColor() != board[row+4][col].getColor()) && (tile.getColor() != board[row+5][col].getColor()))
				||
				((tile.getShape() == board[row-1][col].getShape()) &&
				(tile.getColor() != board[row-1][col].getColor()) && (tile.getColor() != board[row-2][col].getColor()) && (tile.getColor() != board[row-3][col].getColor()) && (tile.getColor() != board[row-4][col].getColor()) && (tile.getColor() != board[row-5][col].getColor()))
				||
				((tile.getShape() == board[row][col+1].getShape()) &&
				(tile.getColor() != board[row][col+1].getColor()) && (tile.getColor() != board[row][col+2].getColor()) && (tile.getColor() != board[row][col+3].getColor()) && (tile.getColor() != board[row][col+4].getColor()) && (tile.getColor() != board[row][col+5].getColor()))
				||
				((tile.getShape() == board[row][col-1].getShape()) &&
				(tile.getColor() != board[row][col-1].getColor()) && (tile.getColor() != board[row][col-2].getColor()) && (tile.getColor() != board[row][col-3].getColor()) && (tile.getColor() != board[row][col-4].getColor()) && (tile.getColor() != board[row][col-5].getColor()))
				) {
			return true;
		}
		return result;
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
