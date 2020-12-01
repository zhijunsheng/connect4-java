package com.goldenthumb.java.connectfour;

import java.util.HashSet;
import java.util.Set;

public class ConnectFourModel {
	
	private Set<ConnectFourPiece> piecesBox = new HashSet<ConnectFourPiece>();
	
	void dropPieceAt(int col) {
		ConnectFourPiece newPiece = new ConnectFourPiece(col, 0, Player.YELLOW);
		piecesBox.add(newPiece);
	}
	
	private ConnectFourPiece pieceAt(int col, int row) {
		for (ConnectFourPiece piece : piecesBox) {
			if (piece.col == col && piece.row == row) {
				return piece;
			}
		}
		return null;
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
//					if (piece.player == Player.RED) {
//						desc += " r";
//					} else {
//						desc += " y";
//					}
					desc += piece.player == Player.RED ? " r" : " y";
				}
			}
			desc += "\n";
		}
		desc += "  0 1 2 3 4 5 6";
		
		return desc;
	}

}
