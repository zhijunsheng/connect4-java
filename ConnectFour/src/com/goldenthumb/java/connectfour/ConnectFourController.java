package com.goldenthumb.java.connectfour;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(700, 600);
		frame.setLocation(200, 1200);
		
		panel = new ConnectFourView();
		panel.delegate = this;
		frame.add(panel, BorderLayout.CENTER);
		
		JButton resetBtn = new JButton("Reset");
		resetBtn.setPreferredSize(new Dimension(-1, 40));
		frame.add(resetBtn, BorderLayout.SOUTH);
		
		frame.setVisible(true);
		
		resetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.reset();
				panel.repaint();
			}
		});
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
