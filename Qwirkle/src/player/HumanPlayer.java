package player;

import game.Board;

import java.util.Scanner;

/**
 * Created by Rens on 13-1-2016.
 */
public class HumanPlayer extends Player {


    public HumanPlayer(String name, int playerNumber) {
        super(name, playerNumber);
    }

//    @Override
    public int[] determineMove(Board board) {

        int[] ans = new int[2];
        Scanner in = new Scanner(System.in);
        System.out.println("Enter move:");
        if (in.hasNext()) {
            String input = in.next();
            switch (input) {
                case "MOVE":
                    if (in.hasNext()) {

                    }
                    break;
                case "SWAP":

                    break;


            }
        }

        return ans;
    }

    public static void main(String[] args) {
        HumanPlayer player = new HumanPlayer("Rens", 1);
        Board board = new Board();
        player.determineMove(board);
    }
}
