package com.goldenthumb.java.connectfour;

import javax.swing.JFrame;

/*
 * MVC: Model View Controller
 * 
 */
public class ConnectFourController implements ConnectFourDelegate {
	
	private ConnectFourModel game;
	
	ConnectFourController() {		
		game = new ConnectFourModel();
		System.out.println(game);
		game.dropPieceAt(5);
		game.dropPieceAt(5);
		game.dropPieceAt(4);
		game.dropPieceAt(1);
		
		JFrame frame = new JFrame("Connect Four");
		frame.setSize(700, 600);
		frame.setLocation(200, 1200);
		
		ConnectFourView panel = new ConnectFourView();
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

}
