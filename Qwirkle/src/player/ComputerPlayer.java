package player;

import game.Board;
import game.Game;
import tile.Tile;

/**
 * Created by Rens on 13-1-2016.
 */
public class ComputerPlayer extends LocalPlayer {

    public ComputerPlayer(String playerName) {
        hand = new Tile[Game.MAX_HAND_SIZE];
        name = playerName;
    }

    @Override
    public int[] determineMove(Board board) {
        return new int[0];
    }

    @Override
    public boolean isHandEmpty() {
        return super.isHandEmpty();
    }
}
