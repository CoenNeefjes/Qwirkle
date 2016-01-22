package tile;

import game.Board;

public class Tile {


	private final Color color;
	private final Shape shape;

	public Tile (Color color, Shape shape) {
		this.color = color;
		this.shape = shape;
	}



	public Color getColor() {
		return color;
	}

	public Shape getShape() {
		return shape;
	}

	public String toString() {
        return "" + color + " " + shape;
	}
	
    @Override
    public boolean equals(Object o) {
    	if (o instanceof Tile) {
    		Tile t = (Tile) o;
    		return t.getColor().equals(this.color) && t.getShape().equals(this.shape);
    	}
    	return false;
    }
}
