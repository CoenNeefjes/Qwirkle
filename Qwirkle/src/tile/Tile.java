package tile;

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
}
