package player;

import game.Board;
import move.Choice;
import move.Move;
import move.Swap;
import tile.Tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class Player {
	
	protected String name;
	private int playerNumber;
    protected List<Tile> hand = new ArrayList<Tile>();

    public abstract Choice chooseMove(Board board, List<Tile> hand);

    public abstract Swap makeSwap(List<Tile> hand);
	
    public abstract Move makeMove(Board board, List<Tile> hand);

    public List<Tile> getHand() {
        return this.hand;
    }

    public String getName() {
        return name;
    }

    public void addTile(Tile tile) {
        this.hand.add(tile);
    }

    public void addTile(Set<Tile> tileSet) {
        for (Tile t : tileSet) {
            addTile(t);
        }
    }

    public void removeTile(Tile tile) {
        boolean removed = false;
        for (Tile t : this.hand) {
            while (!removed) {
                if (t.equals(tile)) {
                    this.hand.remove(t);
                    removed = true;
                }
            }
        }
    }
}
