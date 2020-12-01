package com.goldenthumb.java.connectfour;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConnectFourModelTest {
	
	@Test
	void testGameBoardWithPieces() {
		ConnectFourModel game = new ConnectFourModel();
		game.dropPieceAt(0);
		game.dropPieceAt(3);
		
		System.out.println(game);
	}

	@Test
	void testToString() {
		ConnectFourModel game = new ConnectFourModel();
		assertTrue(game.toString().contains("1 . . . . . . ."));
	}

}
