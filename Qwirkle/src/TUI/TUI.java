package TUI;

import game.Board;
import game.move.Choice;
import game.move.Move;
import game.move.Swap;
import tile.Color;
import tile.Shape;
import tile.Tile;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Rens on 13-1-2016.
 */
public class TUI {

    public Choice chooseMove(Board board, Set<Tile> hand) {
        Scanner in = new Scanner(System.in);
        System.out.println("If you want to move, enter \"move please mister\". If you want to swap, enter \"swap please mister\"");
        if (in.hasNext()) {
            String choice = in.next();
            if (choice.equals("move please mister")) {
                return Choice.move;
            } else if (choice.equals("swap please mister")) {
                return Choice.swap;
            } else {
                System.out.println("Invalid move");
                return null;
            }
        } else {
            System.out.println("Invalid command");
            return null;
        }
    }


    public Move makeMove(Board board, Set<Tile> hand) {
        Move move;
        Tile[] moveTiles = new Tile[6];
        int[] moveRows = new int[6];
        int[] moveCols = new int[6];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            if (in.hasNext()) {
                String tileName = in.next();
                if (tileName.equals("END")) {
                    move = new Move(moveTiles, moveCols, moveRows);
                    System.out.println(move);
                    return move;
                }
                char colorChar = tileName.charAt(0);
                char shapeChar = tileName.charAt(1);
                moveTiles[i] = new Tile(colorCharToColor(colorChar), shapeCharToShape(shapeChar));
                System.out.println("Tile is " + moveTiles[i]);
                if (in.hasNext()) {
                    moveRows[i] = Integer.parseInt(in.next());
                    if (in.hasNext()) {
                        moveCols[i] = Integer.parseInt(in.next());
                    }
                }
            }
        }
        move = new Move(moveTiles, moveCols, moveRows);
        return move;
    }

    public Swap makeSwap(Set<Tile> hand) {
        return null;
    }

    public Color colorCharToColor(char colorCode) {
        Color color;
        switch (colorCode) {
            case ('R'):
                color = Color.RED;
                break;
            case ('O'):
                color = Color.ORANGE;
                break;
            case ('B'):
                color = Color.BLUE;
                break;
            case ('Y'):
                color = Color.YELLOW;
                break;
            case ('G'):
                color = Color.GREEN;
                break;
            case ('P'):
                color = Color.PURPLE;
                break;
            default:
                color = Color.EMPTY;
        }
        return color;
    }

    public Shape shapeCharToShape(char shapeCode) {
        Shape shape;
        switch (shapeCode) {
            case ('o'):
                shape = Shape.CIRCLE;
                break;
            case ('d'):
                shape = Shape.DIAMOND;
                break;
            case ('s'):
                shape = Shape.SQUARE;
                break;
            case ('c'):
                shape = Shape.CLOVER;
                break;
            case ('x'):
                shape = Shape.CROSS;
                break;
            case ('*'):
                shape = Shape.STAR;
                break;
            default:
                shape = Shape.EMPTY;
        }
        return shape;
    }

}
