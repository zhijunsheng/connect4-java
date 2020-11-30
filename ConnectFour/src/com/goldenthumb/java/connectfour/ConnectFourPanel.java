package com.goldenthumb.java.connectfour;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class ConnectFourPanel extends JPanel {

	private static final long serialVersionUID = 2064075504759682385L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.MAGENTA);
		g2.setStroke(new BasicStroke(7));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.drawOval(100, 70, 150, 150);
	}
}
