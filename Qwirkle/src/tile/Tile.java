package tile;

public class Tile {
	
	private Color color;
	private Shape shape;

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
}
