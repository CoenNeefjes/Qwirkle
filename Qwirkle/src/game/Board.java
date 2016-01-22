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
	 * Creates a new board and calls the reset() method to empty the board.
	 */
	public Board() {
		board = new Tile[DIM][DIM];
		reset();
	}

    /**
     * Creates a copy of the board for the AI.
     * 
     * @return the complete board
     */
	public Board deepCopy() {
		Board b = new Board();
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				b.setTile(i, j, this.getTile(i, j));
			}
		}
		return b;
	}

	/**
	 * gets the tile at the given row and column.
	 * 
	 * @param row Integer
	 * @param col Integer
	 * @return the Tile that is at the given coordinates
	 */
	public Tile getTile(int row, int col) {
		return board[row][col];
	}


	/**
	 * puts a tile on the row and column
	 * 
	 * @param row Integer
	 * @param col Integer
	 * @param tile Tile
	 */
	public void setTile(int row, int col, Tile tile) {
		if (validMove(row, col, tile)) {
			board[row][col] = tile;
		} else {
//			System.out.println("Invalid move");
		}
	}

	/**
	 * returns a boolean whether the tile at the coordinates
	 * is empty or not.
	 * 
	 * @param row Integer
	 * @param col Integer
	 * @return boolean whether the place on the board is empty
	 */
	public boolean isEmpty(int row, int col) {
//        System.out.println(getTile(91, 91));
//        System.out.println("" + row + col);
//        Tile tile = board[row][col];
//        return tile.toString().equals("EMPTY EMPTY");
        return board[row][col].toString().equals("EMPTY EMPTY");

	}

	/**
	 * returns a boolean whether the entire board is empty or not.
	 * 
	 * @return boolean whether the board is empty
	 */
	public boolean isEmptyBoard() {
		boolean ans = true;
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				if (!isEmpty(i,j)) ans = false;
			}
		}
		return ans;
	}
	
	/**
	 * returns a boolean wheter the given tile at the given coordinates is valid
	 * 
	 * @param row Integer
	 * @param col Integer
	 * @param tile Tile (the Tile that needs to be checked)
	 * @return boolean whether the move is valid
	 */
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
		boolean differentTiles = false;
		//First, check if there are lines of 6 tiles attacked to the tile you want to place 
		//(if you want to place a tile, the current line must be shorter than 6 tiles)
		boolean lineOfSix = true;
		for (int i = 1; i < 7; i++) {
			if (isEmpty(row, col+i) && isEmpty(row, col-i) && isEmpty(row+i, col) && isEmpty(row-i, col)) lineOfSix = false;
		}
		for (int i = 1; i < 6; i++) {
			if (equalTiles(tile, getTile(row, col+i)) || equalTiles(tile, getTile(row, col-i)) || 
					equalTiles(tile, getTile(row+i, col)) || equalTiles(tile, getTile(row-i, col))) differentTiles = true;
		}
		//You want lineOfSix to be false because if it is true then there are no empty tiles within 6 of the tile to be placed
		//You want differentTiles to be false, becuase if it is true then there are other tiles in the surroundings which
		//are the same

		return !(lineOfSix || differentTiles);
	}
	
	public boolean equalTiles(Tile tile1, Tile tile2) {
		return tile1.getColor().equals(tile2.getColor()) && tile1.getShape().equals(tile2.getShape());
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
