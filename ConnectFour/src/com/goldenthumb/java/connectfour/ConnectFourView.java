package com.goldenthumb.java.connectfour;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

public class ConnectFourView extends JPanel implements MouseListener {

	private static final long serialVersionUID = 2064075504759682385L;
	
	ConnectFourDelegate delegate = null;
	
	Set<ConnectFourPiece> shadowPiecesBox = new HashSet<ConnectFourPiece>();
	
	private int originX = 90;
	private int originY = 70;
	private int cellSize = 80;
	private int diameter = 50;
	
	ConnectFourView() {
		super();
		
		addMouseListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		drawPieces(g2);
		drawBoard(g2);
	}
	
	private void drawPieces(Graphics2D g2) {
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) {
				ConnectFourPiece piece = delegate.pieceAt(col, 5 - row);
				if (piece != null) {
					drawPiece(g2, piece.col, piece.row, piece.player == Player.RED);
				}
			}
		}
		
		
		// tmp code
		
//		shadowPiecesBox.add(new ConnectFourPiece(6, 0, Player.RED));
//		shadowPiecesBox.add(new ConnectFourPiece(6, 1, Player.YELLOW));
//		shadowPiecesBox.add(new ConnectFourPiece(6, 2, Player.RED));
//		shadowPiecesBox.add(new ConnectFourPiece(6, 3, Player.YELLOW));
//		
//		for (ConnectFourPiece piece : shadowPiecesBox) {
//			drawPiece(g2, piece.col, piece.row, piece.player == Player.RED);
//		}
	}
	
	private void drawBoard(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) {
				Rectangle square = squareFor(col, row);
				g2.drawOval(square.x, square.y, square.width, square.height);
				
				// TODO tmp code
				Rectangle cell = new Rectangle(originX + col * cellSize, originY + (5 - row) * cellSize, cellSize, cellSize);
				g2.drawRect(cell.x, cell.y, cell.width, cell.height);
				
			}
		}
	}
	
	private void drawPiece(Graphics2D g2, int col, int row, boolean isRed) {
		g2.setColor(isRed ? Color.RED : Color.YELLOW);
		Rectangle square = squareFor(col, row);
		g2.fillOval(square.x, square.y, square.width, square.height);
	}
	
	private Rectangle squareFor(int col, int row) {
		int x = originX + col * cellSize + (cellSize - diameter)/2;
		int y = originY + (5- row) * cellSize + (cellSize - diameter)/2;
		return new Rectangle(x, y, diameter, diameter);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Point mouseTip = e.getPoint();
		System.out.println(mouseTip);
		
		int col = (mouseTip.x - originX) / cellSize;
		System.out.println("col = " + col);
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
