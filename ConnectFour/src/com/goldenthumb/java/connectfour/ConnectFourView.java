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

import javax.swing.JPanel;

public class ConnectFourView extends JPanel implements MouseListener {

	private static final long serialVersionUID = 2064075504759682385L;
	
	ConnectFourDelegate delegate = null;
	
	private double boardScaleFactor = 0.9; 
	private double circleScaleFactor = 0.8; 
	
	private int originX = -10000;
	private int originY = -10000;
	private int cellSize = -10000;
	private int diameter = -10000;
	
	ConnectFourView() {
		super();
		
		addMouseListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int w = (int)((double)(getSize().width) * boardScaleFactor);
		int h = (int)((double)(getSize().height) * boardScaleFactor);
		if (w * 6 > h * 7) {
			cellSize = h / 6;
		} else {
			cellSize = w / 7;
		}
		diameter = (int)(circleScaleFactor * ((double)cellSize));
		
		originX = (getSize().width - 7 * cellSize) / 2;
		originY = (getSize().height - 6 * cellSize) / 2;
		
		
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
//				Rectangle cell = new Rectangle(originX + col * cellSize, originY + (5 - row) * cellSize, cellSize, cellSize);
//				g2.drawRect(cell.x, cell.y, cell.width, cell.height);
				
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
		int col = (e.getPoint().x - originX) / cellSize;
		delegate.dropPieceAt(col);
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
