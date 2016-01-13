package player;

import game.Board;
import tile.Tile;

/**
 * Created by Rens on 13-1-2016.
 */
public abstract class LocalPlayer extends Player {

    protected Tile[] hand;

    public abstract int[] determineMove(Board board);

    public boolean isHandEmpty() {
        return hand.length==0;
    }
}
