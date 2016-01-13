package player;

import game.Board;
import game.Game;
import tile.Tile;

import java.util.Scanner;

/**
 * Created by Rens on 13-1-2016.
 */
public class HumanPlayer extends LocalPlayer {

    public HumanPlayer(String playerName) {
        hand = new Tile[Game.MAX_HAND_SIZE];
        name = playerName;
    }

    @Override
    public int[] determineMove(Board board) {
        return new int[0];
    }
}
