package player.local;

import game.Board;
import move.Choice;
import move.Move;
import move.Swap;
import tile.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rens on 13-1-2016.
 */
public class ComputerPlayer extends LocalPlayer {

    public ComputerPlayer(String playerName) {
        hand = new ArrayList<Tile>();
        name = playerName;
    }

    @Override
    public Choice chooseMove(Board board, List<Tile> hand) {
        return null;
    }

    @Override
    public Swap makeSwap(List<Tile> hand) {
        return null;
    }

    @Override
    public Move makeMove(Board board, List<Tile> hand) {
        return null;
    }

    @Override
    public boolean isHandEmpty() {
        return super.isHandEmpty();
    }
}
