package com.goldenthumb.java.connectfour;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

public class ConnectFourView extends JPanel {

	private static final long serialVersionUID = 2064075504759682385L;
	
	Set<ConnectFourPiece> shadowPiecesBox = new HashSet<ConnectFourPiece>();
	
	private int originX = 90;
	private int originY = 70;
	private int cellSize = 80;
	private int diameter = 50;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		drawPieces(g2);
		drawBoard(g2);
	}
	
	private void drawPieces(Graphics2D g2) {
		// tmp code
		
		shadowPiecesBox.add(new ConnectFourPiece(6, 0, Player.RED));
		shadowPiecesBox.add(new ConnectFourPiece(6, 1, Player.YELLOW));
		shadowPiecesBox.add(new ConnectFourPiece(6, 2, Player.RED));
		shadowPiecesBox.add(new ConnectFourPiece(6, 3, Player.YELLOW));
		
		for (ConnectFourPiece piece : shadowPiecesBox) {
			drawCircle(g2, piece.col, piece.row, piece.player == Player.RED);
		}
	}
	
	private void drawBoard(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) {
				g2.drawOval(originX + col * cellSize, originY + row * cellSize, diameter, diameter);
			}
		}
	}
	
	private void drawCircle(Graphics2D g2, int col, int row, boolean isRed) {
		g2.setColor(isRed ? Color.RED : Color.YELLOW);
		g2.fillOval(originX + col * cellSize, originY + (5 - row) * cellSize, diameter, diameter);
	}
}
