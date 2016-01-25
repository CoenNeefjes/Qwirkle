package tile;

import game.Board;

public class Tile {


	private final Color color;
	private final Shape shape;

	//@private invariant this.color != null;
	//@private invariant this.shape != null;
	
	//@requires color != null;
	//@requires shape != null;
	//@ensures getColor() == color;
	//@ensures getShape() == shape;
	public Tile (Color color, Shape shape) {
		assert color != null;
		assert shape != null;
		this.color = color;
		this.shape = shape;
		assert getColor() == color;
		assert getShape() == shape;
		assert color != null;
		assert shape != null;
	}

//    public Tile () {
//        System.out.println("Empty tile constructor called, only use this for test purposes");
//        this.color = Color.EMPTY;
//        this.shape = Shape.EMPTY;
//    }

	//@ensures \result != null;
	/*@ pure */ public Color getColor() {
		assert color != null;
		return color;
	}

	//@ensures \result != null;
	/*@ pure */ public Shape getShape() {
		assert shape != null;
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
