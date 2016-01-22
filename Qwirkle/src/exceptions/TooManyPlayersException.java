package exceptions;

/**
 * Created by Rens on 18-1-2016.
 */
public class TooManyPlayersException extends Exception {

    private int players;

    public TooManyPlayersException(int players) {
        this.players = players;
    }

    public int getPlayers() {
        return this.players;
    }

}
