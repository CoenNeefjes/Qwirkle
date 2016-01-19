package player.local;

import game.Board;
import game.Game;
import game.move.Choice;
import game.move.Move;
import game.move.Swap;
import tile.Tile;

import java.util.Set;

/**
 * Created by Rens on 13-1-2016.
 */
public class ComputerPlayer extends LocalPlayer {

    public ComputerPlayer(String playerName) {
        hand = new Tile[Game.MAX_HAND_SIZE];
        name = playerName;
    }

    @Override
    public Choice chooseMove(Board board, Set<Tile> hand) {
        return null;
    }

    @Override
    public Swap makeSwap(Set<Tile> hand) {
        return null;
    }

    @Override
    public Move makeMove(Board board, Set<Tile> hand) {
        return null;
    }

    @Override
    public boolean isHandEmpty() {
        return super.isHandEmpty();
    }
}
