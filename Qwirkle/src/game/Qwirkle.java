package game;

import exceptions.TMPEXCEPTION;
import player.Player;
import player.local.HumanPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rens on 18-1-2016.
 */
public class Qwirkle {
    public static void main(String[] args) {
        Player p1 = new HumanPlayer("Rinus");
        Player p2 = new HumanPlayer("Henk");
        List<Player> playerList = new ArrayList<Player>();
        playerList.add(p1);
        playerList.add(p2);
        Game game = null;
        try {
            game = new Game(playerList);
        } catch (TMPEXCEPTION tmpexception) {
            tmpexception.printStackTrace();
        }
        game.start();
    }
}
