package com.goldenthumb.java.connectfour;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConnectFourModelTest {
	
	@Test
	void testDropPieceAt() {
		ConnectFourModel game = new ConnectFourModel();
		
		assertNull(game.pieceAt(0, 3));
		
		game.dropPieceAt(0);
		game.dropPieceAt(0);
		game.dropPieceAt(0);
		game.dropPieceAt(0);
		
		System.out.println(game);
		assertEquals(Player.YELLOW, game.pieceAt(0, 3).player);
	}
	
	@Test
	void testGameBoardWithPieces() {
		ConnectFourModel game = new ConnectFourModel();
		game.dropPieceAt(0);
		game.dropPieceAt(3);
		game.dropPieceAt(6);
		assertTrue(game.toString().contains("0 r . . y . . r"));
	}

	@Test
	void testToString() {
		ConnectFourModel game = new ConnectFourModel();
		assertTrue(game.toString().contains("1 . . . . . . ."));
	}

}
