package com.goldenthumb.java.connectfour;


enum Player {
	RED,
	YELLOW,
}

public class ConnectFourPiece {
	int col;
	int row;
	Player player;

	ConnectFourPiece(int col, int row, Player player) {
		this.col = col;
		this.row = row;
		this.player = player;
	}
}
