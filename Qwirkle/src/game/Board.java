package game;

import java.util.List;

//import player.Player;
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
	
	private Tile emptyTile = new Tile(Color.EMPTY, Shape.EMPTY);
	
	private /*@ non_null */ Tile[][] board;
	
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
	/*@ requires row >= 0 && row <= DIM && col >= 0 && col <= DIM;
	 */
	/*@ pure */public Tile getTile(int row, int col) {
		return board[row][col];
	}


	/**
	 * puts a tile on the row and column
	 * 
	 * @param row Integer
	 * @param col Integer
	 * @param tile Tile
	 */
	/*@ requires row >= 0 && row <= DIM && col >= 0 && col <= DIM && tile != null;
	 	ensures validMove(row, col, tile) ==> getTile(row, col) == tile;
	 @*/
	public void setTile(int row, int col, Tile tile) {
		if (validMove(row, col, tile)) {
			board[row][col] = tile;
		} else {
			System.out.println(tile.toString());
			System.out.println("Invalid move");
		}
	}
	
	/*@ requires rows.size() == cols.size() && rows.size() == tiles.size() && rows.size() != 0;
	 //UNFINISHED* ensures \forall Tile tile; tiles.contains(tile); getTile(row, col, tile) == tile;
	 */
	public void setTiles(List<Integer> rows, List<Integer> cols, List<Tile> tiles) {
		boolean allValid = true;
		if (rows.size() == cols.size() && rows.size() == tiles.size()) {
			for (int i = 0; i < tiles.size(); i++) {
				if (!validMove(rows.get(i), cols.get(i), tiles.get(i))) allValid = false;
			}
			System.out.println("Check");
			if (allValid) {
				for (int i = 0; i < tiles.size(); i++) {
					setTile(rows.get(i), cols.get(i), tiles.get(i));
				}
			} else {
				System.out.println("Not all tiles are valid");
			}
		} else {
			System.out.println("Check TUI implementation, different list sizes rows cols tiles");
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
	/*@ requires row >= 0 && row <= DIM && col >= 0 && col <= DIM;
	  ensures \result == (board[row][col].equals(emptyTile));
	 */
	private boolean isEmpty(int row, int col) {
        return board[row][col].equals(emptyTile);

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
	 * Checks wheter placing a (given) tile on (given) coordinates is valid.
	 * 
	 * @param row integer, row to check the tile
	 * @param col integer, col to check the tile
	 * @param tile tile, tile to be checked
	 * @return boolean wheter the move is valid or not
	 */
	/*@ pure */public boolean validMove(int row, int col, Tile tile) {
		boolean ans;
		if (row >= 0 && row <= 183 && col >= 0 && col <= 183 && tile != null) {
			if (isEmptyBoard()) {
				ans = (row == 91 && col == 91);
			} else {
				if (isEmpty(row, col)) {
					ans = validMoveAdvanced(row, col, tile);
				} else {
					ans = false;
				}
				
			}
		} else {
			ans = false;
		}
		return ans;
	}
	
	public boolean validMoveAdvanced(int row, int col, Tile tile) {
		boolean[] right = validRight(row, col, tile);
		boolean[] left = validLeft(row, col, tile);
		boolean[] up = validUp(row, col, tile);
		boolean[] down= validDown(row, col, tile);
		boolean empty = right[1] && left[1] && up[1] && down[1];
		return right[0] && left[0] && up[0] && down[0] && !empty;
	}
	
	public boolean[] validRight(int row, int col, Tile tile) {
		boolean empty = false;
		boolean valid = false;
		int length = getLengths(row, col)[0];
		if (length == 0) {
			empty = true;
			valid = true;
		} else if (length == 1) {
			if (tile.getColor() == getTile(row, col+1).getColor() && 
					tile.getShape() != getTile(row, col+1).getShape() ||
					tile.getShape() == getTile(row, col+1).getShape() && 
					tile.getColor() != getTile(row, col+1).getColor()) {
				valid = true;
			} else {
				valid = false;
			}
		} else if (length < 6) {
			boolean go = true;
			for (int i = 1; i <= length && go; i++) {
				if (tile.getColor() == getTile(row, col+i).getColor()) {
					if (tile.getShape() != getTile(row, col+i).getShape()) {
						valid = true;
					} else {
						go = false;
						valid = false;
					}
				} else if (tile.getShape() == getTile(row, col+i).getShape()) {
					valid = true;
				} else {
					go = false;
					valid = false;
				}
			}
		}
		
		boolean[] ans = {valid, empty};
		return ans;
	}
	public boolean[] validLeft(int row, int col, Tile tile) {
		boolean empty = false;
		boolean valid = false;
		int length = getLengths(row, col)[1];
		if (length == 0) {
			empty = true;
			valid = true;
		} else if (length == 1) {
			if (tile.getColor() == getTile(row, col-1).getColor() && 
					tile.getShape() != getTile(row, col-1).getShape() ||
					tile.getShape() == getTile(row, col-1).getShape() && 
					tile.getColor() != getTile(row, col-1).getColor()) {
				valid = true;
			} else {
				valid = false;
			}
		} else if (length < 6) {
			boolean go = true;
			for (int i = 1; i <= length && go; i++) {
				if (tile.getColor() == getTile(row, col-i).getColor()) {
					if (tile.getShape() != getTile(row, col-i).getShape()) {
						valid = true;
					} else {
						go = false;
						valid = false;
					}
				} else if (tile.getShape() == getTile(row, col-i).getShape()) {
					valid = true;
				} else {
					go = false;
					valid = false;
				}
			}
		}
		
		boolean[] ans = {valid, empty};
		return ans;
	}
	public boolean[] validDown(int row, int col, Tile tile) {
		boolean empty = false;
		boolean valid = false;
		int length = getLengths(row, col)[2];
		if (length == 0) {
			empty = true;
			valid = true;
		} else if (length == 1) {
			if (tile.getColor() == getTile(row+1, col).getColor() && 
					tile.getShape() != getTile(row+1, col).getShape() ||
					tile.getShape() == getTile(row+1, col).getShape() && 
					tile.getColor() != getTile(row+1, col).getColor()) {
				valid = true;
			} else {
				valid = false;
			}
		} else if (length < 6) {
			boolean go = true;
			for (int i = 1; i <= length && go; i++) {
				if (tile.getColor() == getTile(row+i, col).getColor()) {
					if (tile.getShape() != getTile(row+i, col).getShape()) {
						valid = true;
					} else {
						go = false;
						valid = false;
					}
				} else if (tile.getShape() == getTile(row+i, col).getShape()) {
					valid = true;
				} else {
					go = false;
					valid = false;
				}
			}
		}
		
		boolean[] ans = {valid, empty};
		return ans;
	}
	public boolean[] validUp(int row, int col, Tile tile) {
		boolean empty = false;
		boolean valid = false;
		int length = getLengths(row, col)[3];
		if (length == 0) {
			empty = true;
			valid = true;
		} else if (length == 1) {
			if (tile.getColor() == getTile(row-1, col).getColor() && 
					tile.getShape() != getTile(row-1, col).getShape() ||
					tile.getShape() == getTile(row-1, col).getShape() && 
					tile.getColor() != getTile(row-1, col).getColor()) {
				valid = true;
			} else {
				valid = false;
			}
		} else if (length < 6) {
			boolean go = true;
			for (int i = 1; i <= length && go; i++) {
				if (tile.getColor() == getTile(row-i, col).getColor()) {
					if (tile.getShape() != getTile(row-i, col).getShape()) {
						valid = true;
					} else {
						go = false;
						valid = false;
					}
				} else if (tile.getShape() == getTile(row-i, col).getShape()) {
					valid = true;
				} else {
					go = false;
					valid = false;
				}
			}
		}
		
		boolean[] ans = {valid, empty};
		return ans;
	}
	
	public int[] getLengths(int row, int col) {
		//Four directions, right, left, up, down.
		//Right:
		int[] fourLengths = {0, 0, 0, 0};
		boolean stop = false;
		while (!stop) {
			if (isEmpty(row, col+(fourLengths[0]+1))) {
				stop = true;
			} else {
				fourLengths[0]++;
			}
		}
		stop = false;
		while (!stop) {
			if (isEmpty(row, col-(fourLengths[1]+1))) {
				stop = true;
			} else {
				fourLengths[1]++;
			}
		}
		stop = false;
		while (!stop) {
			if (isEmpty(row+(fourLengths[2]+1), col)) {
				stop = true;
			} else {
				fourLengths[2]++;
			}
		}
		stop = false;
		while (!stop) {
			if (isEmpty(row-(fourLengths[3]+1), col)) {
				stop = true;
			} else {
				fourLengths[3]++;
			}
		}
		return fourLengths;
	}
	
	
	

	
	public boolean sameTiles(int col, int row, Tile tile) {
		boolean differentTiles = true;
		for (int i = 1; i < 6; i++) {
			if (equalTiles(tile, getTile(row, col+i)) || equalTiles(tile, getTile(row, col-i)) || 
					equalTiles(tile, getTile(row+i, col)) || equalTiles(tile, getTile(row-i, col))) differentTiles = false;
		}
		return differentTiles;
	}
	
	public boolean equalTiles(Tile tile1, Tile tile2) {
		return tile1.getColor().equals(tile2.getColor()) && tile1.getShape().equals(tile2.getShape());
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
                if (!isEmpty(i, j) && j > maxRightIndex) {
                    maxRightIndex = j;
                }
            }
        }
        boundaries[0] = maxRightIndex;

        //Get left extreme boundary
        int minLeftIndex = DIM;
        for (int i = DIM-1; i > 0; i--) {
            for (int j = DIM-1; j > 0; j--) {
                if (!isEmpty(i, j) && j < minLeftIndex) {
                    minLeftIndex = j;
                }
            }
        }
        boundaries[1] = minLeftIndex;

        //Get upper extreme boundary
        int maxUpIndex = 0;
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                if (!isEmpty(i, j) && i > maxUpIndex) {
                    maxUpIndex = j;
                }
            }
        }
        boundaries[2] = maxUpIndex;

        //Get lower extreme boundary
        int minDownIndex = DIM;
        for (int i = DIM-1; i > 0; i--) {
            for (int j = DIM-1; j > 0; j--) {
                if (!isEmpty(i, j) && j < minDownIndex) {
                    minDownIndex = j;
                }
            }
        }
        boundaries[3] = minDownIndex;
        return boundaries;

    }

    public String toString() {
        String res = "";
        int[] boundaries = getBoundaries();
        int emptyMargin = 3; //For aesthetic purposes.
        for (int i = boundaries[3] - emptyMargin; i < (boundaries[2] + emptyMargin+1); i++) {
            for (int j = boundaries[1] - emptyMargin; j < boundaries[0] + emptyMargin+1; j++) {
                if (isEmpty(i, j)) {
                    res = res + "               | ";
                } else {
                    res = res + getTile(i,j).toString() + " | ";
                }

            }
            res = res + "\n";
        }
        return res;
    }
	
	

}
