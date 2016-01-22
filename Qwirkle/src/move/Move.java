package move;

import tile.Tile;

import java.util.List;

public class Move {
	
//	private Tile[] tile;
//	private int[] col;
//	private int[] row;

    private List<Tile> tiles;
    private List<Integer> cols;
    private List<Integer> rows;

//    public Move(Tile[] tiles, int[] col, int[] row) {
//        this.tile = tiles;
//        this.col = col;
//        this.row = row;
//    }

    public Move(List<Tile> tiles, List<Integer> cols, List<Integer> rows) {
        this.tiles = tiles;
        this.cols = cols;
        this.rows = rows;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public List<Integer> getCols() {
        return cols;
    }

    public List<Integer> getRows() {
        return rows;
    }

    public String toString() {
        if (tiles.size() == rows.size() && rows.size() == cols.size()) {
            String result = "Tiles, rows and cols: \n";
            for (int i = 0; i < tiles.size(); i++) {
                result += "tile "+ (i+1) +" is "  + tiles.get(i) + ", row "+ (i+1) +" is " + rows.get(i) +
                        ", col "+ (i+1) +" is " + cols.get(i) + "\n";
            }
            return result;
        }
        return "invalid move";
    }

}
