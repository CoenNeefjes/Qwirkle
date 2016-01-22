package game;

import exceptions.TooManyPlayersException;
import move.Choice;
import player.Player;
import server.TileBag;
import tile.Tile;

import java.util.List;
import java.util.Scanner;

/**
 * Game is the class which 
 * @author Rens Oliemans, Coen Neefjes
 *
 */

public class Game {
    public static final int MAXPLAYERS = 4;
    public static final int MAX_HAND_SIZE = 6;


    private Board board;
    protected List<Player> players;
    private TileBag tileBag;

    private int currentPlayer;

    /**
     */
    public Game(List<Player> players) throws TooManyPlayersException {
        if (players.size() <= MAXPLAYERS) {
            this.players = players;
        } else {
            throw new TooManyPlayersException(players.size());
        }
        tileBag = new TileBag();
        for (Player p : players) {
            p.addTile(tileBag.drawHand());
        }
    	currentPlayer = 0;
    	board = new Board();

    	start();
    }

    /**
     * Starts the game. If the game has ended (play() has ended), 
     * you get a message if you want to play again or not.
     */
    public void start() {
        boolean doorgaan = true;
        while (doorgaan) {
            reset();
            play();
            doorgaan = readBoolean("\n Play another time? (y/n)?", "y", "n");
        }
    }

    private boolean readBoolean(String prompt, String yes, String no) {
        String answer;
        do {
            System.out.println(prompt);
            try (Scanner in = new Scanner(System.in)) {
                answer = in.hasNextLine() ? in.nextLine() : null;
            }
        } while (answer == null || (!answer.equals(yes) && !answer.equals(no)));
        return answer.equals(yes);
    }

    public void reset() {
        currentPlayer = 0;
        board.reset();
    }

    public void play() {
    	update();
    	while (!gameEnded()) {
            Choice choice = getCurrentPlayer().chooseMove(board, currentHand(getCurrentPlayer()));
            if (choice == Choice.move) {
                getCurrentPlayer().makeMove(board, currentHand(getCurrentPlayer()));
            } else if (choice == Choice.swap) {
                getCurrentPlayer().makeSwap(currentHand(getCurrentPlayer()));
            }
            nextPlayer();
    	}
    }
    
    public boolean gameEnded() {
    	return false;
    }
    
    public void nextPlayer() {
        this.currentPlayer = (this.currentPlayer + 1) % (players.size());
    }

    public void update() {
        System.out.println("Current player is now number " + this.currentPlayer);
        System.out.println("\ncurrent game situation: \n\n" + board.toString()
                + "\n");
    }
    
    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    public List<Tile> currentHand(Player player) {
        return getCurrentPlayer().getHand();
    }



}
