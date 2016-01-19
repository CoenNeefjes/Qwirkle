package server;

import tile.Color;
import tile.Shape;
import tile.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rens on 18-1-2016.
 */
public class TileBag {

    public static final int SAMETILECOUNT = 3; //How many of a tile there are in the bag
    public static final int MAXBAGSIZE = Color.values().length* Shape.values().length*SAMETILECOUNT;
    public static final int HAND_SIZE = 6;
    private ArrayList<Tile> tiles;

    public TileBag() {
        this.tiles = new ArrayList<>(MAXBAGSIZE);
        for (Color c : Color.values()) {
            for (Shape s : Shape.values()) {
                for (int i = 0; i < SAMETILECOUNT; i++) {
                    this.tiles.add(new Tile(c, s));
                }
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.tiles);
    }


    public int remaining() {
        return this.tiles.size();
    }

    public Tile drawTile() {
        Tile tile = this.tiles.get(0);
        this.tiles.remove(0);
        return tile;

    }


    public Set<Tile> drawHand() {
        Set<Tile> hand = new HashSet<>();
        for (int i = 0; i < HAND_SIZE; i++) {
            hand.add(this.drawTile());
        }
        return hand;
    }

}
