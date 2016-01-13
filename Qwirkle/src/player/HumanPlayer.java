package player;

import game.Board;

/**
 * Created by Rens on 13-1-2016.
 */
public class HumanPlayer extends Player {


    public HumanPlayer(String name, int playerNumber) {
        super(name, playerNumber);
    }

    @Override
    public int determineMove(Board board) {
        return 0;
    }
}
