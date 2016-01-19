package player.local;

import TUI.TUI;
import game.Board;
import game.Game;
import game.move.Choice;
import game.move.Move;
import game.move.Swap;
import player.Player;
import tile.Color;
import tile.Shape;
import tile.Tile;

import java.util.Set;

/**
 * Created by Rens on 13-1-2016.
 */
public class HumanPlayer extends LocalPlayer {

    TUI tui;
    String name;

    public HumanPlayer(String playerName) {
        hand = new Tile[Game.MAX_HAND_SIZE];
        name = playerName;
        TUI tui = new TUI();
    }

    @Override
    public Choice chooseMove(Board board, Set<Tile> hand) {
        return tui.chooseMove(board, hand);
    }

    public Move makeMove(Board board, Set<Tile> hand) {
        return tui.makeMove(board, hand);
    }

    public Swap makeSwap(Set<Tile> hand) {
        return tui.makeSwap(hand);
    }

    public String getName() {
        return name;
    }
}
