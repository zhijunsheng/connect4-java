package com.goldenthumb.java.connectfour;

import java.util.HashSet;
import java.util.Set;

public class ConnectFourModel {
	
	private Set<ConnectFourPiece> piecesBox = new HashSet<ConnectFourPiece>();
	private Player playerInTurn = Player.RED;
	
	void dropPieceAt(int col) {
		int row = numPiecesAt(col);
		ConnectFourPiece newPiece = new ConnectFourPiece(col, row, playerInTurn);
		piecesBox.add(newPiece);
		
		playerInTurn = playerInTurn == Player.RED ? Player.YELLOW : Player.RED;
	}
	
	private int numPiecesAt(int col) {
		int cnt = 0;
		for (ConnectFourPiece piece : piecesBox) {
			if (piece.col == col) {
				cnt += 1;
			}
		}
		return cnt;
	}
	
	ConnectFourPiece pieceAt(int col, int row) {
		for (ConnectFourPiece piece : piecesBox) {
			if (piece.col == col && piece.row == row) {
				return piece;
			}
		}
		return null;
	}
	
	void reset() {
		piecesBox.removeAll(piecesBox);
		playerInTurn = Player.RED;
	}
	
	@Override
	public String toString() {
		
		String desc = "";
		
		for (int i = 0; i < 6; i++) {
			desc += (5 - i) + "";
			for (int col = 0; col < 7; col++) {
				ConnectFourPiece piece = pieceAt(col, 5 - i);
				if (piece == null) {
					desc += " .";
				} else {
					desc += piece.player == Player.RED ? " r" : " y";
				}
			}
			desc += "\n";
		}
		desc += "  0 1 2 3 4 5 6";
		
		return desc;
	}

}
