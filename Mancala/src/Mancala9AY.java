
/* Austin Youngren
 * Mancala 9
 * 11/4/21
 * The game of Mancala, a game played by two people by moving beads around a board.
 *  The person with the most beads at the end of the game wins.
 */
import java.util.Scanner;

public class Mancala9AY
{
	static final int NUM_BINS = 14;// number of bins in the game
	static Scanner input;

	public static void main( String[ ] args )
	{
		//Scanner input;
		input = new Scanner ( System.in );
		int[ ] beadArray; //number of beads in each bin
		int player; //which player, decides turn
		int winner; //game decision
		char newGame = 'y';
		
		while (newGame == 'y') 
		{
			player = 1;
			beadArray = new int[ NUM_BINS ];
			startingTestArray ( beadArray );
			//startingArray ( beadArray );
			printArray ( beadArray );
			do
			{
				showBoard ( beadArray );
				winner = dropBeads( beadArray, player );
				player = ( player % 2 ) + 1; // alternates player: 1 % 2 + 1 = 2 or 2 % 2 + 1 = 1
			} while ( winner == -1 );
			showBoard ( beadArray ); //Shows empty board
			System.out.println("Would you like to play again? (y/n)");
			newGame = input.next().charAt(0);
		}
		input.close ( );
	} // end of main

	/*
	 * Description: Players select bin to start their turn
	 * @param: beadArray - number of beads in each bin
	 * @param: player - which bins can be chosen
	 * @return: bin - the selected bin to start turn
	 */
	public static int getStartingBin( int[ ] beadArray, int player )
	{
		int bin; // LCV and bin decision
		int highBin = 5; // condition variable - high range
		int lowBin = 0; // condition variable - low range
		if ( player == 2 )
		{
			highBin = 12;
			lowBin = 7;
		}
		else
		{
			;
		}
		do
		{
			System.out.println ( "Player " + player + ", which bin would you like to start in? (" + lowBin + " - " + highBin + ")" );
			bin = input.nextInt ( );
			if ( ( bin > highBin ) || ( bin < lowBin ) || ( beadArray[ bin ] < 1 ) )
			{
				System.out.println ( "Invalid selection, please choose again." );
			}
			else
			{
				;
			}
		} while ( ( bin > highBin ) || ( bin < lowBin ) || ( beadArray[ bin ] < 1 ) );
		return bin;
	}
	
	/*
	 * Description: Player bead drops for turn, one is dropped in every following bin from selected.
	 * @param: beadArray - number of beads in each bin
	 * @param: player - who's turn it is 
	 * @return: winner - game decision
	 */
	public static int dropBeads(int[] beadArray, int player)
	{
		int opponentEndBin; //opponent's, side bin:non-playable
		int playerEndBin; // current player's side bin
		int hand; //amount of beads in hand after pick up
		int winner; // game decision 
		int bin; //selected bin & index variable
		
		opponentEndBin = 13; 
		playerEndBin = 6;
		if (player == 2)
		{
			opponentEndBin =  6;
			playerEndBin = 13;
		}
		
		do
		{
			bin = getStartingBin(beadArray, player);
			do 
			{
				hand = beadArray[bin];
				beadArray[bin] = 0;
				while(hand > 0)
				{
					bin++;
					if (bin == opponentEndBin)
					{
						bin++;
					}
					if (bin > 13)
					{
						bin = 0;
					}
					beadArray[bin]++;
					hand--;
				}
				
			}while ((beadArray[bin] > 1) && (bin != playerEndBin));
			winner = gameOverCheck ( beadArray );
		}while ((bin == playerEndBin) && (winner == -1));
		return winner;
	}
	
	/*
	 * Description: Checks the remaining beads in top and bottom bins to decide if the game ends
	 * @param: beadArray - number of beads in each bin
	 * @return: winner: game ending outcome (player win(1 or 2), tie(0), or keep playing(-1)
	 */
	public static int gameOverCheck( int[ ] beadArray )
	{
		int winner = -1;// game decision
		int playerOne = 0; //beads on player one's side
		int playerTwo = 0; //beads on player two's side
		int tempPlayVal = 0; // holds a player bead value for possible swap
		int i; //LCV

		//for loops check respective player bins
		for ( i = 0; i < 6; i++ )
		{
			playerOne = playerOne + beadArray[ i ];
		}
		for ( i = 12; i > 6; i-- )
		{
			playerTwo = playerTwo + beadArray[ i ];
		}

		//checks  bins for winner
		if ( ( playerOne == 0 ) || ( playerTwo == 0 ) )
		{
			tempPlayVal = playerTwo;
			playerTwo = beadArray[ 13 ] + playerOne;
			playerOne = beadArray[ 6 ] + tempPlayVal;
			
			for ( i = 0; i < 14; i++ )
			{
				beadArray[ i ] = 0;
			}
			
			beadArray[6] = playerOne;
			beadArray[13] = playerTwo;
			
			if ( playerOne == playerTwo )
			{
				System.out
						.println ( "Player 1 has " + playerOne + " score\nPlayer 2 has " + playerTwo + " score\nTie" );
				winner = 0;
			}
			else if ( playerOne > playerTwo )
			{
				System.out.println ( "Player 1 has " + playerOne + " score\nPlayer 2 has " + playerTwo + " score\nPlayer 1 Wins" );
				winner = 1;
			}
			else if ( playerTwo > playerOne )
			{
				System.out.println ( "Player 1 has " + playerOne + " score\nPlayer 2 has " + playerTwo + " score\nPlayer 2 Wins" );
				winner = 2;
			}
			else
			{
				;
			}
		}
		else
		{
			;
		}
		return winner;
	}//end of gameOverCheck

	/*
	 * Description: Print out line of stars
	 * @param numStars - Amount of stars for line output
	 * @return: void
	 */
	public static void makeSolidLine( int numStars )
	{
		int starCount; // LCV
		starCount = 0;

		while ( starCount < numStars )
		{
			System.out.print ( "*" );
			starCount++;
		}
	} // end of makeSolidLine

	/*
	 * Description: Print out dotted line of stars
	 * @param: None
	 * @return: None
	 */
	public static void makeDottedLine( )
	{
		int spaceCount; // LCV
		int starCount; // LCV
		spaceCount = 0;
		starCount = 0;

		while ( starCount < 8 )
		{
			System.out.print ( "*" );
			starCount++;
			spaceCount = 0;

			while ( ( spaceCount < 6 ) )
			{
				System.out.print ( " " );
				spaceCount++;
			}
		} // end of starCount loop
		System.out.println ( "*" );
	}// end of makeDottedLine

	/*
	 * Description: produces the outline of the board
	 * @param: beadArray - number of beads in each bin)
	 * @return: void
	 */
	public static void showBoard( int[ ] beadArray )
	{
		makeSolidLine ( 57 );
		System.out.println ( );
		makeDottedLine ( );
		showTopRowNumbers ( );
		makeDottedLine ( );
		showTopBins ( beadArray );
		makeDottedLine ( );

		System.out.printf ( "*%4d  ", 13 );
		makeSolidLine ( 43 );
		System.out.printf ( "%4d  *\n", 6 );

		makeDottedLine ( );
		showBottomeRowNumbers ( );
		makeDottedLine ( );
		showBottomBins ( beadArray );
		makeDottedLine ( );
		makeSolidLine ( 57 );
		System.out.println ( );
	}// end of showBoard

	/*
	 * Description: prints out top row of numbers
	 * @param:None
	 * @return: none
	 */
	public static void showTopRowNumbers( )
	{
		int topNums = 0; // number within columns of top row
		System.out.print ( "*      " );
		while ( topNums < 6 )
		{
			System.out.printf ( "*%4d  ", topNums );
			topNums++;
		}
		System.out.println ( "*      *" );
	}// end of showTopRowNumbers

	/*
	 * Description: prints out bottom row of numbers
	 * @param:None
	 * @return: void
	 */
	public static void showBottomeRowNumbers( )
	{
		int bottomNums = 12;//number within columns of bottom row
		System.out.print ( "*      " );
		while ( bottomNums > 6 )
		{
			System.out.printf ( "*%4d  ", bottomNums );
			bottomNums--;
		}
		System.out.println ( "*      *" );
	}// end of showBottomNumbers	

	/*
	 * Description: prints out array numbers for bins zero through five
	 * @param: beadArray - number of beads in each bin
	 * @return: void
	 */
	public static void showTopBins( int[ ] beadArray )
	{
		int i; //LCV
		System.out.print ( "*      " );
		for ( i = 0; i < 6; i++ )
		{
			System.out.printf ( "*%4d  ", beadArray[ i ] );

		}
		System.out.println ( "*      *" );
	}// end of showTopBins

	/*
	 * Description: prints out array numbers for bins six through thirteen
	 * @param: beadArray - number of beads in each bin
	 * @return: void
	 */
	public static void showBottomBins( int[ ] beadArray )
	{
		int i; // LCV
		for ( i = 13; i > 5; i-- )
		{
			System.out.printf ( "*%4d  ", beadArray[ i ] );
		}
		System.out.println ( "*" );
	}// end of showBottomBins

	/*
	 * Description: initializes elements for testing/debugging purposes
	 * @param: beadArray - number of beads in each bin)
	 * @return: void
	 */
	public static void startingTestArray( int[ ] beadArray )
	{
		beadArray[ 0 ] = 0;
		beadArray[ 1 ] = 0;
		beadArray[ 2 ] = 0;
		beadArray[ 3 ] = 0;
		beadArray[ 4 ] = 1;
		beadArray[ 5 ] = 1;
		beadArray[ 6 ] = 14;
		beadArray[ 7 ] = 0;
		beadArray[ 8 ] = 0;
		beadArray[ 9 ] = 0;
		beadArray[ 10 ] = 0;
		beadArray[ 11 ] = 0;
		beadArray[ 12 ] = 1;
		beadArray[ 13 ] = 14;
	}

	/*
	 * Description: prints the bead array in a line
	 * @param: beadArray - number of beads in each bin
	 * @return: void
	 */
	public static void printArray( int[ ] beadArray )
	{
		int i; //LCV
		for ( i = 0; i < NUM_BINS; i++ )
		{
			System.out.printf ( "%3d", beadArray[ i ] );
			if ( i == 6 )
			{
				System.out.printf ( "   | " );
			}
		}
		System.out.println ( );
		System.out.println ( );
	}

	/*
	 * Description: initializes elements in beadArray
	 * @param: beadArray - number of beads in each bin)
	 * @return: void
	 */
	public static void startingArray( int[ ] beadArray )
	{
		int i; //LCV

		for ( i = 0; i < NUM_BINS; i++ )
		{
			beadArray[ i ] = 4;
		}
		beadArray[ 6 ] = 0;
		beadArray[ 13 ] = 0;
	}
}

// Problems: None 