package tile;

public enum Shape {
	
	CIRCLE('c'),
    DIAMOND('d'),
    SQUARE('s'),
    CLOVER('c'),
    CROSS('x'),
    STAR('*'),
    EMPTY('e');

    private char shapeChar;

    Shape (char shapeChar) {
        this.shapeChar = shapeChar;
    }

    public char getShapeChar() {
        return shapeChar;
    }

    public static class ShapeNotFoundException extends Exception {

        public ShapeNotFoundException(char shapeChar) {
            super("" + shapeChar + " not found.");
        }
    }

    public static Shape shapeCharToShape(char shapeCode) throws ShapeNotFoundException {
        Shape shape;
        switch (shapeCode) {
            case ('o'):
                return Shape.CIRCLE;
            case ('d'):
                return Shape.DIAMOND;
            case ('s'):
                return Shape.SQUARE;
            case ('c'):
                return Shape.CLOVER;
            case ('x'):
                return Shape.CROSS;
            case ('*'):
                return Shape.STAR;
        }
        throw new ShapeNotFoundException(shapeCode);
    }
}
