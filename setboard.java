package chess;

import java.awt.Color;

import javax.swing.*;

public class setboard {

	public static void setTiles(JButton[] buttons) {
		
		for (int i = 0; i < 64; i++) {
             if (i / 8 % 2 == 0) {
                buttons[i].setBackground(i % 2 == 0 ? new Color(255, 206, 163) : new Color(102, 59, 21));
            } else {
                buttons[i].setBackground(i % 2 == 0 ? new Color(102, 59, 21) : new Color(255, 206, 163));
            }
        }
		
		
	}
	
	
	public static void setPieces(JButton[] buttons) {
		for (int i = 0; i < 64; i++) {
            if(i>=8 && i <=15) {buttons[i].setText("B_P");}
            if(i>=48 && i <=55) {buttons[i].setText("W_P");}
            if(i==63 || i ==56) {buttons[i].setText("W_R");}
            if(i==0 || i ==7) {buttons[i].setText("B_R");}
            if(i==62 || i ==57) {buttons[i].setText("W_K");}
            if(i==1 || i ==6) {buttons[i].setText("B_K");}
            if(i==61 || i ==58) {buttons[i].setText("W_B");}
            if(i==2 || i ==5) {buttons[i].setText("B_B");}
            if(i==3) {buttons[i].setText("B_Q");}
            if(i==4) {buttons[i].setText("BKing");}
            if(i==59) {buttons[i].setText("W_Q");}
            if(i==60) {buttons[i].setText("WKing");}


        }
		
	}
	
	
}
