package pt.ulisboa.tecnico.distsys.ttt.server;

import pt.ulisboa.tecnico.distsys.ttt.contract.PlayResult;

public class TTTGame {
	private char board[][];
	private int numPlays = 0;
	private int nextPlayer = 0;
	private char symbolP0 = 'O';
	private char symbolP1 = 'X';
	
	public TTTGame() {
		this.resetBoard();
	}
	
	@Override
	public synchronized String toString() {
		return String.format( "\n\n %c | %c | %c\n---+---+---\n %c | %c | %c\n---+---+---\n %c | %c | %c\n ",
		        board[0][0], board[0][1], board[0][2],
		        board[1][0], board[1][1], board[1][2],
		        board[2][0], board[2][1], board[2][2]);
	}
	

	public PlayResult play(int row, int column, int player) {
	    if (!(row >=0 && row <3 && column >= 0 && column < 3)) {
	        /* Outside board */
	        return PlayResult.OUT_OF_BOUNDS;
	    }
	    synchronized (this) {
		    if (board[row][column] > '9') {
		        /* Square has been taken */
		        return PlayResult.SQUARE_TAKEN;
		    }
		    if (player != nextPlayer)  {
		        /* Not players turn */
		        return PlayResult.WRONG_TURN;
		    }
		    if (numPlays == 9) {
		        /* No more plays left */
                return PlayResult.GAME_FINISHED;
		    }
	
		    board[row][column] = (player == 1) ? symbolP1 : symbolP0;  /* Insert player symbol */
		    nextPlayer = (nextPlayer + 1) % 2;
		    numPlays++;
		    return PlayResult.SUCCESS;
	    }
	}
	
	/**
	 *  @return 0 or 1 if there is a winner, 2 if there is a draw, -1 otherwise
	 */
	public synchronized int checkWinner() {
	    int line;
	    int result = -1;

	    /* Check for a winning line - diagonals first */
	    if((board[0][0] == board[1][1] && board[0][0] == board[2][2]) ||
	       (board[0][2] == board[1][1] && board[0][2] == board[2][0]))
	    {
			if (board[1][1]==symbolP1)
				result = 1;
			else
				result = 0;
	    }
	    else
	    {
	        /* Check rows and columns for a winning line */
	        for(line = 0; line <= 2; line ++)
	        {
	            if((board[line][0] == board[line][1] && board[line][0] == board[line][2]))
	            {
	                if (board[line][0]==symbolP1)
						result = 1;
					else
						result = 0;
					break;
	            }

	            if ((board[0][line] == board[1][line] && board[0][line] == board[2][line]))
	            {
	                if (board[0][line]==symbolP1)
						result = 1;
					else
						result = 0;
					break;
	            }
	        }
	    }
	    if (result == -1 && numPlays == 9)
	    {
	        result = 2; /* A draw! */
	    }
	    
	    return result; 

	}
	
	public void resetBoard() {
		board = new char[][] {
			{'1', '2', '3'},
			{'4', '5', '6'},
			{'7', '8', '9'}
		};
	}

	public synchronized void trocaSimbolos(){
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(board[i][j] == 'O')
					board[i][j] = 'X';
				else if(board[i][j] == 'X')
					board[i][j] = 'O';
			}
		}
		char a = symbolP1;
		symbolP1 = symbolP0;
		symbolP0 = a;
	}
}