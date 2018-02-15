package Game;

public class TicTacToe {
	
	public String currentChar; 
	public String [][] grid = {{"", "", ""},{"", "", ""},{"", "", ""}}; //col1, col2, col3
	public boolean isTie; 
	
	public TicTacToe() {
		isTie = false;
		currentChar = "X"; 
	}
	
	public boolean nextMove(int btn) {
		
		System.out.println("Next move being made");
		
		if(currentChar == "X") {
			currentChar = "O";
		}
		else if(currentChar == "O") {
			currentChar = "X";
		}

		switch(btn) {
			case 1: grid[0][0] = currentChar;
					break;
			case 2: grid[0][1] = currentChar;
					break;
			case 3: grid[0][2] = currentChar;
					break;
			case 4: grid[1][0] = currentChar;
					break;
			case 5: grid[1][1] = currentChar;
					break;
			case 6: grid[1][2] = currentChar;
					break;
			case 7: grid[2][0] = currentChar;
					break;
			case 8: grid[2][1] = currentChar;
					break;
			case 9: grid[2][2] = currentChar;
					break;
			default: break;
		}
		
	    if(gameIsOver()) {
	    
	    		//Reset board and game state
	    		System.out.println("The game board is now full");
	    		System.out.println("**************************");
	    		System.out.println("The winner is... " + currentChar);
	    		System.out.println("**************************");
	    		
	    		for(int i = 0; i < 3; i++) { // reset grid state
	    			for(int j = 0; j < 3; j++) { 
	    				grid[i][j] = "";	
	    			}
	    		}	
	    		currentChar = "X"; 
	    		return false;	
	    }   
	    return true;
	}
	
	public boolean gameIsOver() {
		
		// check rows and cols
		
		for(int i = 0; i < 3; i++) { 
			
			if(grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != "") {
				return true;
			}
			if(grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] != "") {
				return true;				
			}		
		}
	
		//check diagonals 
		if(grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != "") {
			return true;
		}
		if(grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != "") {
			return true;				
		}	
		for(int i = 0; i < 3; i++) { // col
			for(int j = 0; j < 3; j++) { // row
				if(grid[i][j] == "") {
					return false;
				}		
			}
		}		
		
		isTie = true;
		System.out.println("No winner :(");
		return true; 	
	}
}

