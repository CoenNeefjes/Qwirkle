package game;

import player.Player;
import java.util.Scanner;

public class Game {
    public static final int MAXPLAYERS = 8;
    public static final int MAX_HAND_SIZE = 6;


    private Board board;
    protected Player[] players;

    private int currentPlayer;

    public Game() {

    }

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
        currentPlayer= 0;
        board.reset();
    }

    public void play() {
        update();
        while (!board.gameOver()) {
            update();
            currentPlayer = currentPlayer + 1 % players.length;
        }
    }

    public void update() {
        System.out.println("\ncurrent game situation: \n\n" + board.toString()
                + "\n");
    }



}
