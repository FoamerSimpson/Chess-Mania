package chess;

import java.awt.Color;

import javax.swing.*;

public class piecemanager {

	static String[] BLACKPIECES= {"B_P", "B_B","B_K","B_R","B_Q","BKing"};
	static String[] WHITEPIECES= {"W_P", "W_B","W_K","W_R","W_Q","WKing"};
	
	
	
	
	public static boolean moveclick(JButton[] buttons, JButton currentclick, JButton previousclick, boolean whitesTurn) {
		if(currentclick.getBackground().equals(new Color(229, 130, 245))) {
			currentclick.setText(previousclick.getText());
			setboard.setTiles(buttons);
			for(int i=0; i<64; i++) {
	            if (buttons[i].equals(previousclick) ) {
	               buttons[i].setText("");
	               if(whitesTurn) {
	       				return false;
	       			}else {
	       				return true;
	       			}
	            	}
			}
			
		}
		return whitesTurn;
		
		}
	
	public static void boardclick(int space, String piece, JButton[] buttons, boolean whitesTurn) {
		System.out.println("Button "+space+ " was clicked, and it has "+ piece +" on it");
		if(piece.equals("W_P")&& whitesTurn) {
			piecemanager.whitePawn(space, piece, buttons, whitesTurn);
		}else if(piece.equals("B_P")&& !whitesTurn) {
			piecemanager.blackPawn(space, piece, buttons, whitesTurn);
		}else if(piece.equals("W_B") && whitesTurn) {
			piecemanager.whiteBishop(space, piece, buttons, whitesTurn);
		}else if(piece.equals("B_B") && !whitesTurn) {
			piecemanager.blackBishop(space, piece, buttons, whitesTurn);
		}else if(piece.equals("W_R") && whitesTurn) {
			piecemanager.whiteRook(space, piece, buttons, whitesTurn);
		}else if(piece.equals("B_R") && !whitesTurn) {
			piecemanager.blackRook(space, piece, buttons, !whitesTurn);
		}else if(piece.equals("W_Q") && whitesTurn) {
			piecemanager.whiteQueen(space, piece, buttons, whitesTurn);
		}else if(piece.equals("B_Q") && !whitesTurn) {
			piecemanager.blackQueen(space, piece, buttons, !whitesTurn);
		}else if(piece.equals("W_K") && whitesTurn) {
			piecemanager.whiteKnight(space, piece, buttons);
		}else if(piece.equals("B_K") && !whitesTurn) {
			piecemanager.blackKnight(space, piece, buttons);
		}else if(piece.equals("WKing") && whitesTurn) {
			piecemanager.whiteKing(space, piece, buttons);
		}else if(piece.equals("BKing") && !whitesTurn) {
			piecemanager.blackKing(space, piece, buttons);
		}
	}
	
	
	
	
	public static void whitePawn(int space, String piece, JButton[] buttons, boolean whitesTurn){
		if(space>=48 && space<=55 && whitesTurn) {	
			if(buttons[space-8].getText().equals("")) {
			buttons[space-8].setBackground(new Color(229, 130, 245));
			}
			if(buttons[space-16].getText().equals("") && buttons[space-8].getText().equals("")) {
			buttons[space-16].setBackground(new Color(229, 130, 245));
			}
			//checking for black pieces to capture
			for (String element : BLACKPIECES) {
					if((space-9)>=0 && element.equals(buttons[space-9].getText()) && space%8!=0) {
						buttons[space-9].setBackground(new Color(229, 130, 245));
					}
					if(space-7>0 && element.equals(buttons[space-7].getText()) && (space-7) % 8 != 0) {
						buttons[space-7].setBackground(new Color(229, 130, 245));
					}
			}
		}

		else if(whitesTurn && space-8>=0) {
			if(buttons[space-8].getText().equals("")) {
			buttons[space-8].setBackground(new Color(229, 130, 245));
			}
			//checking for black pieces to capture
			for (String element : BLACKPIECES) {
					if((space-9)>=0 && element.equals(buttons[space-9].getText()) && space %8 !=0 && space!=8) {
						buttons[space-9].setBackground(new Color(229, 130, 245));
					}
					if((space-7)>0 && element.equals(buttons[space-7].getText()) && (space-7) %8 !=0) {
						buttons[space-7].setBackground(new Color(229, 130, 245));
					}
			}		
		}
	}
	
	public static void blackPawn(int space, String piece, JButton[] buttons, boolean whitesTurn){
		if(space>=8 && space<=15 && !whitesTurn ) {
			
			if(buttons[space+8].getText().equals("")) {
			buttons[space+8].setBackground(new Color(229, 130, 245));
			}
			if(buttons[space+16].getText().equals("") && buttons[space+8].getText().equals("")) {
			buttons[space+16].setBackground(new Color(229, 130, 245));
			}
			// checking for white pieces to capture
			for (String element : WHITEPIECES) {
				if(space+9<63 && element.equals(buttons[space+9].getText()) && (space+9) % 8 != 0) {
					buttons[space+9].setBackground(new Color(229, 130, 245));
				}
				if(space+7<63 && element.equals(buttons[space+7].getText()) && space%8!=0) {
					buttons[space+7].setBackground(new Color(229, 130, 245));
				}
			}
							
		}else if(!whitesTurn && space+8<=63){
			if(buttons[space+8].getText().equals("")) {
				buttons[space+8].setBackground(new Color(229, 130, 245));
			}
			// checking for white pieces to capture
			for (String element : WHITEPIECES) {
				if(space+9<=63 && element.equals(buttons[space+9].getText()) && (space+9) % 8 != 0) {
					buttons[space+9].setBackground(new Color(229, 130, 245));
				}
				if(space+7<63 && element.equals(buttons[space+7].getText()) && space%8!=0) {
					buttons[space+7].setBackground(new Color(229, 130, 245));
				}
			}
		}
	}
	
	
	public static void whiteBishop(int space, String piece, JButton[] buttons, boolean whitesTurn){
		
		recursive.omniMove(space, -7, BLACKPIECES, buttons);
		recursive.omniMove(space, -9, BLACKPIECES, buttons);
		recursive.omniMove(space, 7, BLACKPIECES, buttons);
		recursive.omniMove(space, 9, BLACKPIECES, buttons);
		
	}
	
	public static void blackBishop(int space, String piece, JButton[] buttons, boolean whitesTurn){
			
			recursive.omniMove(space, -7, WHITEPIECES, buttons);
			recursive.omniMove(space, -9, WHITEPIECES, buttons);
			recursive.omniMove(space, 7, WHITEPIECES, buttons);
			recursive.omniMove(space, 9, WHITEPIECES, buttons);
			
		}
	
	public static void whiteRook(int space, String piece, JButton[] buttons, boolean whitesTurn){
		
		recursive.omniMove(space, 8, BLACKPIECES, buttons);
		recursive.omniMove(space, -8, BLACKPIECES, buttons);
		recursive.omniMove(space, 1, BLACKPIECES, buttons);
		recursive.omniMove(space, -1, BLACKPIECES, buttons);
		
	}
	public static void blackRook(int space, String piece, JButton[] buttons, boolean whitesTurn){
		
		recursive.omniMove(space, 8, WHITEPIECES, buttons);
		recursive.omniMove(space, -8, WHITEPIECES, buttons);
		recursive.omniMove(space, 1, WHITEPIECES, buttons);
		recursive.omniMove(space, -1, WHITEPIECES, buttons);
		
	}
	
	public static void whiteQueen(int space, String piece, JButton[] buttons, boolean whitesTurn){
		
		recursive.omniMove(space, 8, BLACKPIECES, buttons);
		recursive.omniMove(space, -8, BLACKPIECES, buttons);
		recursive.omniMove(space, 1, BLACKPIECES, buttons);
		recursive.omniMove(space, -1, BLACKPIECES, buttons);
		recursive.omniMove(space, -7, BLACKPIECES, buttons);
		recursive.omniMove(space, -9, BLACKPIECES, buttons);
		recursive.omniMove(space, 7, BLACKPIECES, buttons);
		recursive.omniMove(space, 9, BLACKPIECES, buttons);
		
	}
	
	public static void blackQueen(int space, String piece, JButton[] buttons, boolean whitesTurn){
		
		recursive.omniMove(space, 8, WHITEPIECES, buttons);
		recursive.omniMove(space, -8, WHITEPIECES, buttons);
		recursive.omniMove(space, 1, WHITEPIECES, buttons);
		recursive.omniMove(space, -1, WHITEPIECES, buttons);
		recursive.omniMove(space, -7, WHITEPIECES, buttons);
		recursive.omniMove(space, -9, WHITEPIECES, buttons);
		recursive.omniMove(space, 7, WHITEPIECES, buttons);
		recursive.omniMove(space, 9, WHITEPIECES, buttons);
	}
	
	public static void whiteKnight(int space, String piece, JButton[] buttons) {
		recursive.knightHop(space, 15, BLACKPIECES, buttons);
		recursive.knightHop(space, -15, BLACKPIECES, buttons);
		recursive.knightHop(space, 10, BLACKPIECES, buttons);
		recursive.knightHop(space, -10, BLACKPIECES, buttons);
		recursive.knightHop(space, 6, BLACKPIECES, buttons);
		recursive.knightHop(space, -6, BLACKPIECES, buttons);
		recursive.knightHop(space, 17, BLACKPIECES, buttons);
		recursive.knightHop(space, -17, BLACKPIECES, buttons);
	}
	public static void blackKnight(int space, String piece, JButton[] buttons) {
		recursive.knightHop(space, 15, WHITEPIECES, buttons);
		recursive.knightHop(space, -15, WHITEPIECES, buttons);
		recursive.knightHop(space, 10, WHITEPIECES, buttons);
		recursive.knightHop(space, -10, WHITEPIECES, buttons);
		recursive.knightHop(space, 6, WHITEPIECES, buttons);
		recursive.knightHop(space, -6, WHITEPIECES, buttons);
		recursive.knightHop(space, 17, WHITEPIECES, buttons);
		recursive.knightHop(space, -17, WHITEPIECES, buttons);
	}
	public static void whiteKing(int space, String piece, JButton[] buttons) {
		recursive.kingStep(space, -1, BLACKPIECES, buttons);
		recursive.kingStep(space, 1, BLACKPIECES, buttons);
		recursive.kingStep(space, 8, BLACKPIECES, buttons);
		recursive.kingStep(space, -8, BLACKPIECES, buttons);
		recursive.kingStep(space, 9, BLACKPIECES, buttons);
		recursive.kingStep(space, -9, BLACKPIECES, buttons);
		recursive.kingStep(space, 7, BLACKPIECES, buttons);
		recursive.kingStep(space, -7, BLACKPIECES, buttons);
	}public static void blackKing(int space, String piece, JButton[] buttons) {
		recursive.kingStep(space, -1, WHITEPIECES, buttons);
		recursive.kingStep(space, 1, WHITEPIECES, buttons);
		recursive.kingStep(space, 8, WHITEPIECES, buttons);
		recursive.kingStep(space, -8, WHITEPIECES, buttons);
		recursive.kingStep(space, 9, WHITEPIECES, buttons);
		recursive.kingStep(space, -9, WHITEPIECES, buttons);
		recursive.kingStep(space, 7, WHITEPIECES, buttons);
		recursive.kingStep(space, -7, WHITEPIECES, buttons);
	}
	
	
}