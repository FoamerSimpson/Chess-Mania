package chess;

import java.awt.Color;

import javax.swing.JButton;

public class recursive {
	
	

	public static void omniMove(int space, int amount, String[] ray, JButton[] buttons) {
		boolean notInvalidLeftWall = !(space%8==0 && (amount==-9||amount==-1||amount==7));
		boolean notInvalidRightWall = !((space-7)%8==0 && (amount==-7||amount==1||amount==9));
		
		if((space+amount)>=0 && (space+amount)<=63&& notInvalidLeftWall && notInvalidRightWall&&buttons[space+amount].getText().equals("")) {
			buttons[space+amount].setBackground(new Color(229, 130, 245));
			
			space = space+ amount;
			if((space%8!=0 && amount ==-9||amount!=-9)) {
				omniMove(space, amount, ray, buttons);}
		
		}else {
			for(String element : ray) {
				if((space+amount)>=0 && (space+amount)<=63 && notInvalidLeftWall && notInvalidRightWall && buttons[space+amount].getText().equals(element)) {
					buttons[space+amount].setBackground(new Color(229, 130, 245));
					break;
					
				}
				
			}
			
			
			
		}
	}
	public static void knightHop(int space, int amount, String[] ray, JButton[] buttons) {
		boolean notInvalidLeftWall = !(space%8==0 && (amount==-17||amount==-10||amount==6||amount==15));
		boolean notInvalidRightWall = !((space-7)%8==0 && (amount==17||amount==10||amount==-6||amount==-15));
		boolean notInvalidNearLeft = !((space-1)%8==0 && (amount==-10||amount==6));
		boolean notInvalidNearRight = !((space-6)%8==0 && (amount==10||amount==-6));
		
		if((space+amount)>=0 && (space+amount)<=63&&notInvalidLeftWall&&notInvalidRightWall&&notInvalidNearLeft&&notInvalidNearRight&&buttons[space+amount].getText().equals("")) {
			buttons[space+amount].setBackground(new Color(229, 130, 245));
		}else {
			for(String element : ray) {
				if((space+amount)>=0 && (space+amount)<=63 && notInvalidLeftWall && notInvalidRightWall && notInvalidNearLeft&&notInvalidNearRight&& buttons[space+amount].getText().equals(element)) {
					buttons[space+amount].setBackground(new Color(229, 130, 245));
					break;
					
				}
				
			}	
		}
		
		
	}
	public static void kingStep(int space, int amount, String[] ray, JButton[] buttons) {
		boolean notInvalidLeftWall = !(space%8==0 && (amount==-1||amount==-9||amount==7));
		boolean notInvalidRightWall = !((space-7)%8==0 && (amount==1||amount==9||amount==-7));
		
		if((space+amount)>=0 && (space+amount)<=63&& notInvalidLeftWall && notInvalidRightWall&&buttons[space+amount].getText().equals("")) {
			buttons[space+amount].setBackground(new Color(229, 130, 245));
		}else {
			for(String element : ray) {
				if((space+amount)>=0 && (space+amount)<=63 && notInvalidLeftWall && notInvalidRightWall && buttons[space+amount].getText().equals(element)) {
					buttons[space+amount].setBackground(new Color(229, 130, 245));
					break;
					
				}
				}
		}
		
	}
	
	
	
}
