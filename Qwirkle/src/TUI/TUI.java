package TUI;

import game.Board;
import move.Choice;
import move.Move;
import move.Swap;
import tile.Color;
import tile.Shape;
import tile.Tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Rens on 13-1-2016.
 */
public class TUI {

    public Choice chooseMove(Board board, List<Tile> hand) {
        Scanner in = new Scanner(System.in);
        boolean chosen = false;

        while (!chosen) {
            System.out.println("If you want to move, enter \"MOVE\". If you want to swap, enter \"SWAP\"");
            if (in.hasNext()) {
                String choice = in.nextLine();
                    switch (choice) {
                        case ("MOVE"):
                            return Choice.move;
                        case ("SWAP"):
                            return Choice.swap;
                        case ("BOARD"):
                            System.out.println(board.toString());
                            break;
                    }

            } else {
                System.out.println("Invalid command");
            }
        }
//        in.close();
        return null;
    }


    public Move makeMove(Board board, List<Tile> hand) throws Color.ColorNotFoundException, Shape.ShapeNotFoundException {
        Move move;
        List<Tile> tileList = new ArrayList<Tile>();
        List<Integer> rowList = new ArrayList<Integer>();
        List<Integer> colList = new ArrayList<Integer>();
        System.out.println("Enter your move, in the following manner:" +
                "\"COLORCHARshapechar row col\"");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            if (in.hasNext()) {
                String tileName = in.next();
                switch (tileName) {
                    case ("END"):
                        move = new Move(tileList, colList, rowList);
                        System.out.println(move);
                        board.setTiles(move.getRows(), move.getCols(), move.getTiles());
                        return move;
                    case ("BOARD"):
                        board.toString();
                        break;
                }
                char colorChar = tileName.charAt(0);
                char shapeChar = tileName.charAt(1);
                tileList.add(i, new Tile(Color.colorCharToColor(colorChar), Shape.shapeCharToShape(shapeChar)));
                System.out.println("Tile is " + tileList.get(i));
                if (in.hasNext()) {
                    rowList.add(i, Integer.parseInt(in.next()));
                    if (in.hasNext()) {
                        colList.add(i, Integer.parseInt(in.next()));
                    }
                }
            }
        }
        move = new Move(tileList, colList, rowList);
        board.setTiles(move.getRows(), move.getCols(), move.getTiles());
        System.out.println(move);
        return move;
    }

    public Swap makeSwap(List<Tile> hand) {
        return null;
    }

}
