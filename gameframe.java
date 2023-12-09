package chess;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class gameframe extends JFrame implements ActionListener  {
	
	static JButton[] buttons = new JButton[64];
	JLabel textField = new JLabel();
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JFrame frame = new JFrame();
	boolean whitesTurn=true;
	
	
	gameframe()
	{
		frame.setTitle("Chess");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setSize(600, 600);
		frame.getContentPane().setBackground(new Color(183, 177, 189));
		frame.setLayout(new BorderLayout());
		
		
		textField.setBackground(new Color(55, 174, 204));
		textField.setForeground(new Color(51, 212, 158));
		textField.setFont(new Font("ink free", Font.BOLD, 75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Chess-Mania");
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0,0,800,100);
		
		buttonPanel.setLayout(new GridLayout(8,8));
		buttonPanel.setBackground(new Color(161, 138, 84));
		
		 for (int i = 0; i < 64; i++) {
             buttons[i] = new JButton();
             buttons[i].addActionListener(this);
             buttonPanel.add(buttons[i]); 
         }
		 
		 setboard.setTiles(buttons);
		 setboard.setPieces(buttons);
		
		
		titlePanel.add(textField);
		frame.add(titlePanel, BorderLayout.NORTH);
		frame.add(buttonPanel);
	}
	
	JButton clickedButton = new JButton();
	JButton previousPress= new JButton();
	@Override
	public void actionPerformed(ActionEvent e) {	

		previousPress = clickedButton;
    		  
        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {	            	
                clickedButton = buttons[i];	                
                break;
            }
    	}
            
        System.out.println(previousPress.getText()+"ln75");
        if(clickedButton.getBackground().equals(new Color(229, 130, 245))) {
        	this.whitesTurn=piecemanager.moveclick(buttons, clickedButton, previousPress, whitesTurn);        	
    	}else {setboard.setTiles(buttons);}
	     
	        
        for(int i=0; i<64; i++) {
            if (clickedButton == buttons[i]) {
                int space=i;	                	                
                piecemanager.boardclick(space, buttons[i].getText(), buttons, whitesTurn);  
        	}        
    	}
    }

	

	    
	
}
