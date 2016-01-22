package player.local;

import game.Board;
import move.Choice;
import move.Move;
import move.Swap;
import player.Player;
import tile.Tile;

import java.util.List;

/**
 * Created by Rens on 13-1-2016.
 */
public abstract class LocalPlayer extends Player {

    protected List<Tile> hand;

    public abstract Choice chooseMove(Board board, List<Tile> hand);

    public abstract Swap makeSwap(List<Tile> hand);

    public abstract Move makeMove(Board board, List<Tile> hand);

    public boolean isHandEmpty() {
        return hand.size()==0;
    }
}
