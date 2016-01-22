package tile;

public enum Color {

    RED('R'),
    ORANGE('O'),
    BLUE('B'),
    YELLOW('Y'),
    GREEN('G'),
    PURPLE('P'),
    EMPTY('E');

    private char colorChar;

    Color(char colorChar) {
        this.colorChar = colorChar;
    }

    public char getColorChar() {
        return colorChar;
    }

    public static class ColorNotFoundException extends Exception {

        public ColorNotFoundException(char numChar) {
            super("" + numChar + " not found");
        }
    }

    public static Color colorCharToColor(char colorCode) throws ColorNotFoundException {
        switch (colorCode) {
            case ('R'):
                return Color.RED;
            case ('O'):
                return Color.ORANGE;
            case ('B'):
                return Color.BLUE;
            case ('Y'):
                return Color.YELLOW;
            case ('G'):
                return Color.GREEN;
            case ('P'):
                return Color.PURPLE;
        }
        throw new ColorNotFoundException(colorCode);
    }

}


