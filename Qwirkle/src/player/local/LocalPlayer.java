package player.local;

import game.Board;
import game.move.Choice;
import game.move.Move;
import game.move.Swap;
import player.Player;
import tile.Tile;

import java.util.Set;

/**
 * Created by Rens on 13-1-2016.
 */
public abstract class LocalPlayer extends Player {

    protected Tile[] hand;

    public abstract Choice chooseMove(Board board, Set<Tile> hand);

    public abstract Swap makeSwap(Set<Tile> hand);

    public abstract Move makeMove(Board board, Set<Tile> hand);

    public boolean isHandEmpty() {
        return hand.length==0;
    }
}
