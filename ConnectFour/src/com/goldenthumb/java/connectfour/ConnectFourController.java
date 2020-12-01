package com.goldenthumb.java.connectfour;

import javax.swing.JFrame;

/*
 * MVC: Model View Controller
 * 
 */
public class ConnectFourController implements ConnectFourDelegate {
	
	private ConnectFourModel game;
	private ConnectFourView panel;
	
	ConnectFourController() {		
		game = new ConnectFourModel();
		
		JFrame frame = new JFrame("Connect Four");
		frame.setSize(700, 600);
		frame.setLocation(200, 1200);
		
		panel = new ConnectFourView();
		panel.delegate = this;
		frame.add(panel);
		
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new ConnectFourController();
	}

	@Override
	public ConnectFourPiece pieceAt(int col, int row) {
		return game.pieceAt(col, row);
	}

	@Override
	public void dropPieceAt(int col) {
		game.dropPieceAt(col);
		panel.repaint();
	}

}
