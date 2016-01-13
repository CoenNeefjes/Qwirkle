package tile;

public class Tile {
	
	private Color color;
	private Shape shape;
	
	public Tile (Color color, Shape shape) {
		this.color = color;
		this.shape = shape;
	}
	
	public String toString() {
		return "" + color + " " + shape;
	}
	
	
	
	
	
	/*
	public boolean isEmpty(int line, int row) {
		return false;
	}
	
	public Shape getShape(int line, int row) {
		return null;
	}
	
	public Color getColor(int line, int row) {
		return null;
	}
	*/
}
