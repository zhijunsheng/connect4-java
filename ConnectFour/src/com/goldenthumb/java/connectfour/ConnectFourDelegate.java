package com.goldenthumb.java.connectfour;

public interface ConnectFourDelegate {
	/**
	 * Returns a piece at (col, row).
	 * 
	 * @param col
	 * @param row
	 * @return
	 */
	ConnectFourPiece pieceAt(int col, int row);
	
	/**
	 * Drops a piece at col.
	 * 
	 * @param col
	 */
	void dropPieceAt(int col);
}
