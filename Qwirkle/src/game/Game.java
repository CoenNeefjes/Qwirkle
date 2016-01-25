package game;

import exceptions.TooManyPlayersException;
import move.Choice;
import player.Player;
import server.TileBag;
import tile.Tile;

import java.util.List;
import java.util.Scanner;

/**
 * <h1>Game</h1>
 * Game is the class which creates the game (aka, creates a new board,
 * playerList and tileBag).
 * 
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

    /** <h2>Game</h2>
     * Constructor, takes the playerList as parameter and creates a new Board, Tilebag and starts the game.
     * 
     * @param players PlayerList, basically list of players
     * @throws TooManyPlayersException if players.size() <= MAXPLAYERS, throw exception
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
     * Method start. This first resets the board, then calls the method play() which plays the game
     * and then asks whether you want to play again.
     */
    public void start() {
        boolean doorgaan = true;
        while (doorgaan) {
            reset();
            play();
            doorgaan = readBoolean("\n Play another time? (y/n)?", "y", "n");
        }
    }

    /**
     * Simple method to check the answer of a yes/no question
     * 
     * @param prompt String, text message - the question
     * @param yes String, yes
     * @param no String, no
     * @return boolean, yes or no.
     */
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
	/**
	 * Method to reset the board (calls board.reset() and set the current player to 0;
	 */
    public void reset() {
        currentPlayer = 0;
        board.reset();
    }

    /**
     * Play method. This first calls the method update to give an overview of the game status and then
     * gets the move of the current player. After that it calls nextPlayer() to change the currentPlayer.
     */
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
    
    /**
     * Checks whether the game has ended
     * @return boolean, true if game has ended, false if not
     */
    public boolean gameEnded() {
    	return tileBag.remaining() == 0;
    }
    
    /**
     * Changes the current player to the next player
     */
    public void nextPlayer() {
        this.currentPlayer = (this.currentPlayer + 1) % (players.size());
    }

    /**
     * Gives an update of the game by outputting the current player and the board
     */
    public void update() {
        System.out.println("Current player is now number " + this.currentPlayer);
        System.out.println("\ncurrent game situation: \n\n" + board.toString()
                + "\n");
    }
    
    /**
     * Gets the current player
     * @return Player, current player
     */
    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    /**
     * Gets the hand of a player
     * @param Player you want to get the hand from
     * @return a List of Tiles - the hand of the player
     */
    public List<Tile> getHand(Player player) {
        return player.getHand();
    }



}
