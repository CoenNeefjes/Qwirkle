package player.local;

import TUI.TUI;
import game.Board;
import move.Choice;
import move.Move;
import move.Swap;
import tile.Color;
import tile.Shape;
import tile.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rens on 13-1-2016.
 */
public class HumanPlayer extends LocalPlayer {

    TUI tui;
    String name;

    public HumanPlayer(String playerName) {
        hand = new ArrayList<Tile>();
        name = playerName;
        tui = new TUI();
    }

    @Override
    public Choice chooseMove(Board board, List<Tile> hand) {
        return tui.chooseMove(board, hand);
    }

    public Move makeMove(Board board, List<Tile> hand) {
        try {
            return tui.makeMove(board, hand);
        } catch (Color.ColorNotFoundException e) {
            e.printStackTrace();
        } catch (Shape.ShapeNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Swap makeSwap(List<Tile> hand) {
        return tui.makeSwap(hand);
    }

    public String getName() {
        return name;
    }
}
