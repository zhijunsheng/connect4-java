package com.goldenthumb.java.connectfour;

import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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
	
	private void playSound() {
		InputStream is = getClass().getClassLoader().getResourceAsStream("drop.wav");
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(is);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		playSound();
	}

}
