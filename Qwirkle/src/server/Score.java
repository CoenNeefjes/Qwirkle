package server;

import game.Board;

public class Score {
	
	private Board board;
	
	//checkt of er een rij van 6 wordt gemaakt. Zo ja, dan wordt dat getal vervangen door 12
	public int[] checkSix(int row, int col) {
		for (int i=0; i<=4; i++) {
			if (board.getLengths(row, col)[i] == 6) {
				board.getLengths(row, col)[i] = 12;
			} 
		}
		return board.getLengths(row, col);
	}
	
	//telt alle getallen in de array op
	public int sum(int row, int col) {
		int result = 0;
		for (int i=0; i<=4; i++) {
			result = result + checkSix(row, col)[i];
		}
		return result;
	}
	
}
