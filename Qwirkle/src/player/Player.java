package player;

import game.Board;
import game.move.Choice;
import game.move.Move;
import game.move.Swap;
import tile.Tile;

import java.util.Set;

public abstract class Player {
	
	protected String name;
	private int playerNumber;
    protected Set<Tile> hand;

    public abstract Choice chooseMove(Board board, Set<Tile> hand);

    public abstract Swap makeSwap(Set<Tile> hand);
	
    public abstract Move makeMove(Board board, Set<Tile> hand);

    public Set<Tile> getHand() {
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
