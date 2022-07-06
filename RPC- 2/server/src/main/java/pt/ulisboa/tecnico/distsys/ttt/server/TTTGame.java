package pt.ulisboa.tecnico.distsys.ttt.server;

import pt.ulisboa.tecnico.distsys.ttt.PlayResult;

public class TTTGame {
	private char board[][];
	private int numPlays = 0;
	private int nextPlayer = 0;
	
	public TTTGame() {
		board = new char[][] {
			{'1', '2', '3'},
			{'4', '5', '6'},
			{'7', '8', '9'}
		};
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
	        /* outside board */
	        return PlayResult.OUT_OF_BOUNDS;
	    }
	    synchronized (this) {
		    if (board[row][column] > '9') {
		        /* square has been taken */
		        return PlayResult.SQUARE_TAKEN;
		    }
		    if (player != nextPlayer)  {
		        /* not players turn */
		        return PlayResult.WRONG_TURN;
		    }
		    if (numPlays == 9) {
		        /* no more plays left */
                return PlayResult.GAME_FINISHED;
		    }
	
		    board[row][column] = (player == 1) ? 'X' : 'O';  /* Insert player symbol   */
		    nextPlayer = (nextPlayer + 1) % 2;
		    numPlays ++;
		    return PlayResult.SUCCESS;
	    }
	}

	public int info(int player){
		char played = (player == 1) ? 'X' : 'O';
		int number = 0;
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(board[i][j] == played)
					number++;
			}
		}
		return number;
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
			if (board[1][1]=='X')
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
	                if (board[line][0]=='X')
						result = 1;
					else
						result = 0;
					break;
	            }

	            if ((board[0][line] == board[1][line] && board[0][line] == board[2][line]))
	            {
	                if (board[0][line]=='X')
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
}
