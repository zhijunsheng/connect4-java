package com.goldenthumb.java.connectfour;

import javax.swing.JFrame;

/*
 * MVC: Model View Controller
 * 
 */
public class ConnectFourController {

	public static void main(String[] args) {
		ConnectFourModel game = new ConnectFourModel();
		System.out.println(game);
		
		
		JFrame frame = new JFrame("Connect Four");
		frame.setSize(700, 600);
		frame.setLocation(200, 1200);
		
		ConnectFourView panel = new ConnectFourView();
		frame.add(panel);
		
		frame.setVisible(true);
	}

}
