package TUI;

import game.Board;
import player.HumanPlayer;
import tile.Color;
import tile.Shape;
import tile.Tile;
import java.util.Scanner;

/**
 * Created by Rens on 13-1-2016.
 */
public class TUI {

    public int[] determineMove(Board board) {
        int[] ans = new int[2];
        Scanner in = new Scanner(System.in);
        System.out.println("If you want to move, enter 1. If you want to swap, enter 2");
        System.out.println(in.next());
        if (in.hasNext()) {
            System.out.println("Check 1");
            String input = in.next();

            switch (input) {
                case "MOVE":
                    for (int i = 0; i < 6; i++) {
                        if (in.hasNext()) {
                            String tile = in.next();
                            char colorChar = tile.charAt(0);
                            char shapeChar = tile.charAt(1);
                            Tile tileMove = new Tile(colorCharToColor(colorChar), shapeCharToShape(shapeChar));
                            System.out.println(tileMove);
                            if (in.hasNext()) {
                                int row = Integer.parseInt(in.next());
                                if (in.hasNext()) {
                                    int column = Integer.parseInt(in.next());

                                }
                            }
                        }
                    }
                    break;
                case "SWAP":

                    break;


            }
        }

        return ans;
    }

    //Move wordt doorgegeven als: "MOVE [Tile Row Column]"
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
