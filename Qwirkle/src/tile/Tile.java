package tile;

import game.Board;

public class Tile {


	private final Color color;
	private final Shape shape;

	public Tile (Color color, Shape shape) {
		this.color = color;
		this.shape = shape;
	}

//    public Tile () {
//        System.out.println("Empty tile constructor called, only use this for test purposes");
//        this.color = Color.EMPTY;
//        this.shape = Shape.EMPTY;
//    }

	public Color getColor() {
		return color;
	}

	public Shape getShape() {
		return shape;
	}

	public String toString() {
//        String result = "" + color + " " + shape;
//        return String.format("%1$14s", "" + color + " " + shape);
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
