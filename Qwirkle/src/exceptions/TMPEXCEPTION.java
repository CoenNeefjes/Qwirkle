package exceptions;

/**
 * Created by Rens on 18-1-2016.
 */
public class TMPEXCEPTION extends Throwable {

    private int players;

    public TMPEXCEPTION(int players) {
        this.players = players;
    }

    public int getPlayers() {
        return this.players;
    }

}
