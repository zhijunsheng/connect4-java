package com.goldenthumb.java.connectfour;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class ConnectFourView extends JPanel {

	private static final long serialVersionUID = 2064075504759682385L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		int cellSize = 80;
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) {
				g2.drawOval(90 + col * cellSize, 70 + row * cellSize, 50, 50);
			}
		}
	}
}