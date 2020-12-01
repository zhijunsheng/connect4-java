package com.goldenthumb.java.connectfour;

public class ConnectFourModel {
	
	@Override
	public String toString() {
		
		String desc = "";
		
		for (int i = 0; i < 6; i++) {
			desc += (5 - i) + "";
			for (int col = 0; col < 7; col++) {
				desc += " .";
			}
			desc += "\n";
		}
		desc += "  0 1 2 3 4 5 6";
		
		return desc;
	}

}
