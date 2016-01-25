package game;

import exceptions.TooManyPlayersException;
import player.Player;
import player.local.ComputerPlayer;
import player.local.HumanPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Rens on 18-1-2016.
 */
public class Qwirkle {
    public static void main(String[] args) {

        List<Player> playerList = new ArrayList<Player>();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter amount of human players");
        if (in.hasNext()) {
            int humanPlayers = in.nextInt();
            System.out.println("Enter amount of computer players");
            int computerPlayers = in.nextInt();
            for (int i = 0; i < humanPlayers; i++) {
                System.out.println("Enter name of human player number " + (i+1));
                Player player = new HumanPlayer(in.next());
                playerList.add(i, player);
            }
            for (int i = 0; i < computerPlayers; i++) {
                System.out.println("Enter name of computer player number " + (i+1) +
                        ", in total player number " + (humanPlayers+i+1));
                Player player = new ComputerPlayer(in.next());
                playerList.add((humanPlayers+i), player);
            }
        }
//        in.close();
        Game game = null;
        try {
            game = new Game(playerList);
        } catch (TooManyPlayersException tooManyPlayersException) {
            tooManyPlayersException.printStackTrace();
        }
        if (game != null) game.start();

        //TO DO:    Read Qwirkle rules for scoring points;
        //          Implement server
        //          Add JML
        //          Add Javadoc
        //          Add comments
        //
    }
}
