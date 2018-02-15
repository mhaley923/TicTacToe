package Game;

import java.lang.Object;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameWindow {
	
	public String currentChar; 
	public TicTacToe TicTacToeGame; 
	private JFrame frame;
	
	int playerXWins, playerOWins;
	
	//set class-wide dynamic UI elements
	JButton btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3;
	JButton btnNewButton_4, btnNewButton_5, btnNewButton_6, btnNewButton_7, btnNewButton_8;
	JLabel playerOLabel, playerXLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow window = new GameWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public GameWindow() {
		
		TicTacToeGame = new TicTacToe();
		currentChar = "X"; 
		playerXWins = 0;
		playerOWins = 0;
		initialize();
		
	}
	
	public void switchChar() {
		
		if(currentChar == "X") {
			currentChar = "O";
		}
		else if(currentChar == "O") {
			currentChar = "X";
		}
		
	}	
	
	private void updateWins() {
		
		if(TicTacToeGame.isTie == false) {
			
			if(currentChar == "X") {
				playerXWins = playerXWins + 1;
			}
			else if(currentChar == "O") {
				playerOWins = playerOWins + 1;
			}
	
			String oText = Integer.toString(playerOWins);
			String xText = Integer.toString(playerXWins);
			
			playerOLabel.setText(oText);
			playerXLabel.setText(xText);
		}
		else {
			TicTacToeGame.isTie = false;
		}
	}
	
	public void resetButtons() {
		
		updateWins();
		
		btnNewButton.setText("");
		btnNewButton_1.setText("");
		btnNewButton_2.setText("");
		btnNewButton_3.setText("");
		btnNewButton_4.setText("");
		btnNewButton_5.setText("");
		btnNewButton_6.setText("");
		btnNewButton_7.setText("");
		btnNewButton_8.setText("");
		
		btnNewButton.setEnabled(true);
		btnNewButton_1.setEnabled(true);
		btnNewButton_2.setEnabled(true);
		btnNewButton_3.setEnabled(true);
		btnNewButton_4.setEnabled(true);
		btnNewButton_5.setEnabled(true);
		btnNewButton_6.setEnabled(true);
		btnNewButton_7.setEnabled(true);	
		btnNewButton_8.setEnabled(true);	
		
		currentChar = "X"; 	
	}	
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 5, 2, 2));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnNewButton = new JButton("");
		btnNewButton_1 = new JButton("");
		btnNewButton_2 = new JButton("");
		btnNewButton_3 = new JButton("");
		btnNewButton_4 = new JButton("");
		btnNewButton_5 = new JButton("");
		btnNewButton_6 = new JButton("");
		btnNewButton_7 = new JButton("");
		btnNewButton_8 = new JButton("");		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchChar(); 			
				TicTacToeGame.nextMove(1);		

				System.out.println("Button 1 has been pressed");
				
				String text = currentChar;
				btnNewButton.setFont(new Font("Arial", Font.BOLD, 75));	
				btnNewButton.setText(text);
				btnNewButton.setEnabled(false);

			}
		});
		btnNewButton.setBounds(6, 6, 225, 184);
		panel_1.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		//JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				switchChar();
				//TicTacToeGame.nextMove(4);			
				if(TicTacToeGame.nextMove(4) == false){				
					resetButtons();
					return; 			
				}			
				System.out.println("Button 4 pressed");
				
				String text = currentChar;
				btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 75));
				btnNewButton_2.setText(text);
				btnNewButton_2.setEnabled(false);
			}
		});
		
		btnNewButton_2.setBounds(6, 6, 225, 178);
		panel_4.add(btnNewButton_2);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		//JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				switchChar();
				//TicTacToeGame.nextMove(7);	
				if(TicTacToeGame.nextMove(7) == false){				
					resetButtons();
					return; 			
				}				
				System.out.println("Button 7 pressed");	
				String text = currentChar;
								
				btnNewButton_7.setFont(new Font("Arial", Font.BOLD, 75));
				btnNewButton_7.setText(text);
				btnNewButton_7.setEnabled(false);
			}
		});

		btnNewButton_7.setBounds(6, 6, 225, 178);
		panel_7.add(btnNewButton_7);
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		panel_10.setLayout(null);
		
		JPanel panel_13 = new JPanel();
		panel.add(panel_13);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		//JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				switchChar();
				System.out.println("Button 2 pressed");
				
				//TicTacToeGame.nextMove(2);			
				if(TicTacToeGame.nextMove(2) == false){	
					
					resetButtons();
					return; 
				}
									
				String text = currentChar;
				btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 75));
				btnNewButton_1.setText(text);
				btnNewButton_1.setEnabled(false);
			}
		});
		btnNewButton_1.setBounds(6, 6, 225, 178);
		panel_2.add(btnNewButton_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		//JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchChar();
				System.out.println("Button 5 pressed");
				//TicTacToeGame.nextMove(5);		
				if(TicTacToeGame.nextMove(5) == false){		
								
					resetButtons();
					return; 
				}		
				
				String text = currentChar;
				btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 75));
				btnNewButton_3.setText(text);
				btnNewButton_3.setEnabled(false);
			}
		});
		btnNewButton_3.setBounds(6, 6, 225, 178);
		panel_5.add(btnNewButton_3);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_8);
		panel_8.setLayout(null);
		
		//JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchChar();
				System.out.println("Button 8 pressed");		
				//TicTacToeGame.nextMove(8);	
				if(TicTacToeGame.nextMove(8) == false){		
					
					resetButtons();
					return; 
				}
				
				btnNewButton_6.setFont(new Font("Arial", Font.BOLD, 75));
				String text = currentChar;
				btnNewButton_6.setText(text);
				btnNewButton_6.setEnabled(false);
			}
		});
		btnNewButton_6.setBounds(6, 6, 225, 178);
		panel_8.add(btnNewButton_6);
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblPlayerO = new JLabel("Player O:");
		lblPlayerO.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblPlayerO.setBounds(22, 134, 123, 25);
		panel_11.add(lblPlayerO);
		
		JLabel lblPlayerX_1 = new JLabel("Player X:");
		lblPlayerX_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblPlayerX_1.setBounds(22, 74, 112, 32);
		panel_11.add(lblPlayerX_1);
		
		playerOLabel = new JLabel("0");
		playerOLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		playerOLabel.setBounds(157, 130, 61, 32);
		panel_11.add(playerOLabel);
		
		playerXLabel = new JLabel("0");
		playerXLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		playerXLabel.setBounds(157, 74, 61, 32);
		panel_11.add(playerXLabel);
		
		JLabel lblNewLabel = new JLabel("WINS");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(73, 12, 72, 32);
		panel_11.add(lblNewLabel);
		
		JPanel panel_14 = new JPanel();
		panel.add(panel_14);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		//JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				switchChar();
				System.out.println("Button 3 pressed");		
				//TicTacToeGame.nextMove(3);		
				if(TicTacToeGame.nextMove(3) == false){		
						
					resetButtons();
					return; 
				}
				
				String text = currentChar;
				btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 75));
				btnNewButton_4.setText(text);
				btnNewButton_4.setEnabled(false);
			}
		});
		btnNewButton_4.setBounds(6, 6, 225, 178);
		panel_3.add(btnNewButton_4);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		//JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				switchChar();
				System.out.println("Button 6 pressed");	
				
				//TicTacToeGame.nextMove(6);
				if(TicTacToeGame.nextMove(6) == false){		
					resetButtons();
					return; 
				}
				
				String text = currentChar;
				btnNewButton_5.setFont(new Font("Arial", Font.BOLD, 75));
				btnNewButton_5.setText(text);
				btnNewButton_5.setEnabled(false);
			}
		});
		btnNewButton_5.setBounds(6, 6, 225, 178);
		panel_6.add(btnNewButton_5);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_9);
		panel_9.setLayout(null);
		
		//JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchChar();
				System.out.println("Button 9 pressed");
				
				if(TicTacToeGame.nextMove(9) == false){					
					resetButtons();
					return; 
				}
				
				String text = currentChar;
				btnNewButton_8.setFont(new Font("Arial", Font.BOLD, 75));
				btnNewButton_8.setText(text);
				btnNewButton_8.setEnabled(false);
			}
		});
		btnNewButton_8.setBounds(6, 6, 225, 178);
		panel_9.add(btnNewButton_8);
		
		JPanel panel_12 = new JPanel();
		panel.add(panel_12);
		
		JPanel panel_15 = new JPanel();
		panel.add(panel_15);
		
	}
}


