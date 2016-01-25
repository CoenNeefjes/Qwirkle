package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.Board;
import tile.Color;
import tile.Shape;
import tile.Tile;

public class ValidMoveTest {
	
	private Board board;
	private Tile tile1;
	private Tile tile2;
	private Tile tile3;
	private Tile tile4;
	private Tile tile5;
	private Tile tile6;
	private Tile tile7;
	private Tile tile8;
	private Tile tile9;
	private Tile tile10;
	private Tile empty;
	
	@Before
	public void setUp() {
		board = new Board();
		tile1 = new Tile(Color.BLUE, Shape.CIRCLE);
		tile2 = new Tile(Color.BLUE, Shape.DIAMOND);
		tile3 = new Tile(Color.GREEN, Shape.CIRCLE);
		tile4 = new Tile(Color.GREEN, Shape.CIRCLE);
		tile5 = new Tile(Color.BLUE, Shape.SQUARE);
		tile6 = new Tile(Color.RED, Shape.CIRCLE);
		tile7 = new Tile(Color.YELLOW, Shape.CIRCLE);
		tile8 = new Tile(Color.ORANGE, Shape.CIRCLE);
		tile9 = new Tile(Color.PURPLE, Shape.CIRCLE);
		tile10 = new Tile(Color.BLUE, Shape.CIRCLE);
		empty = new Tile(Color.EMPTY, Shape.EMPTY);
	}
	
	@Test
	public void testValidMoveStart() {
		//Plaats een <blue, circle> niet op 91,91
		board.setTile(92, 91, tile1);
		assertEquals(board.getTile(92,91), empty);
		//Plaats een <blue, circle> op 91,91
		board.setTile(91, 91, tile1);
		assertEquals(board.getTile(91,91), tile1);
	}
	
	@Test
	public void testValidMoveNotStart() {
		//Plaats een <blue, circle> op 91,91
		board.setTile(91, 91, tile1);
		assertEquals(board.getTile(91,91), tile1);
		//Plaats een <blue, diamond> op 91,91
		board.setTile(92, 91, tile2);
		assertEquals(board.getTile(92,91), tile2);
		//Plaas een <blue, square> waar al een <blue, diamond> staat
		board.setTile(92, 91, tile5);
		assertEquals(board.getTile(92,91), tile2);
	}

	@Test
	public void TestValidSurroundings() {
		//Plaats een <blue, circle> op 91,91
		board.setTile(91, 91, tile1);
		assertEquals(board.getTile(91,91), tile1);
		//Plaats een <green, circle> op 91,92
		board.setTile(91, 92, tile3);
		assertEquals(board.getTile(91,92), tile3);
		//Plaats een <green, circle> op 90,92 terwijl er al een <green, circle> in deze rij staat
		board.setTile(91, 90, tile4);
		assertEquals(board.getTile(91,90), empty);
		
		//Verleng de rij naar rechts vanaf de startTile tot 6 lang
		board.setTile(91, 93, tile6); 
		assertEquals(board.getTile(91,93), tile6);
		board.setTile(91, 94, tile7); 
		assertEquals(board.getTile(91,94), tile7);
		board.setTile(91, 95, tile8);
		assertEquals(board.getTile(91,95), tile8);
		board.setTile(91, 96, tile9);
		assertEquals(board.getTile(91,96), tile9);
		//verleng rij naar rechts tot die 7 lang is
		board.setTile(91, 97, tile10); 
		assertEquals(board.getTile(91,97), empty);
	}
	

}