import java.util.Scanner;

/* Austin Youngren
 * Mancala 7
 * 10/29/21
 * The game of Mancala, a game played by two people by moving beads around a board.
 *  The person with the most beads at the end of the game wins.
 */
public class Mancala6AY
{
	static final int NUM_BINS = 14;// number of bins in the game

	public static void main( String[ ] args )
	{
		int[ ] beadArray; //number of beads in each bin
		int turnCount = 0;
		//int binChoice;
		beadArray = new int[ NUM_BINS ];
		//do {
			//startingTestArray ( beadArray );
			startingArray ( beadArray );
			printArray ( beadArray );
			showBoard ( beadArray );
			getStartingBin ( beadArray, turnCount );
			//binChoice = getStartingBin ( beadArray, turnCount );
			//System.out.println ( binChoice);//tester
			System.out.println ( gameOverCheck ( beadArray ) );
		/*	if (gameOverCheck ( beadArray ) == -1)
			{
				turnCount++;
			}
			else if (gameOverCheck ( beadArray ) == 0)
			{
				System.out.print ( "The game is a tie." );
			}
			else if (gameOverCheck ( beadArray ) == 1)
			{
				System.out.print ( "Player 1 wins" );
			}
			else if (gameOverCheck ( beadArray ) == 2)
			{
				System.out.print ( "Player 2 wins." );
			}
			else {;}
		*/
		//}while (gameOverCheck ( beadArray ) == -1);
	} // end of main

		
	public static int getStartingBin( int[ ] beadArray, int turnCount )
	{
		Scanner input;
		input = new Scanner ( System.in );
		int i; // LCV
		if ((turnCount % 2) == 0)
		{
			do
				{
					System.out.println ( "Player 1, which bin would you like to start in? (0 - 5)" );
					i = input.nextInt ( );
					if (( i > 5 ) || ( i < 0 ) )
					{
						System.out.println ( "Invalid selection, please choose again." );
					}
					else
					{
						;
					}
					if ( beadArray[ i ] < 1 )
					{
						System.out.println ( "There are no beads in that bin, please choose another bin." );
					}
					else
					{
						;
					}
			} while ( ( i > 5 ) || ( i < 0 ) || ( beadArray[ i ] < 1 ) );
		}
		else
		{
				do
					{
						System.out.println ( "Player 2, which bin would you like to start in? (7 - 12)" );
						i = input.nextInt ( );
						if ( ( i > 12 ) || ( i < 7 ) )
						{
							System.out.println ( "Invalid selection, please choose again." );
						}
						else
						{
							;
						}
						if ( beadArray[ i ] < 1 )
						{
							System.out.println ( "There are no beads in that bin, please choose another bin." );
						}
						else
						{
							;
						}
					} while ( ( i > 12 ) || ( i < 7 ) || ( beadArray[ i ] < 1 ) );
		}
		input.close ( );
		return i;
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
		int i; //LCV
		int j;//LCV

		//for loops check respective player bins
		for ( i = 0; i < 6; i++ )
		{
			playerOne = playerOne + beadArray[ i ];
		}
		for ( j = 12; j > 6; j-- )
		{
			playerTwo = playerTwo + beadArray[ j ];
		}

		//checks  bins for winner
		if ( ( playerOne == 0 ) || ( playerTwo == 0 ) )
		{
			beadArray[ 13 ] = beadArray[ 13 ] + playerOne;
			beadArray[ 6 ] = beadArray[ 6 ] + playerTwo;

			if ( beadArray[ 6 ] == beadArray[ 13 ] )
			{
				winner = 0;
			}
			else if ( beadArray[ 6 ] > beadArray[ 13 ] )
			{
				winner = 1;
			}
			else if ( beadArray[ 13 ] > beadArray[ 6 ] )
			{
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
	 * @param numStars - Amount of stars to output in a line return type void
	 * @return: None
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
	 * @param: beadArray (passes number of beads in each bin to various methods)
	 * @return: None
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
	 * @return: none
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
	 * @param: beadArray(number of beads in each top bin)
	 * @return: none
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
	 * @param: beadArray (number of beads in each bottom and side bin)
	 * @return: none
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
	 * @param: beadArray (tests number of beads in each bin)
	 * @return: none
	 */
	public static void startingTestArray( int[ ] beadArray )
	{
		beadArray[ 0 ] = 0;
		beadArray[ 1 ] = 0;
		beadArray[ 2 ] = 0;
		beadArray[ 3 ] = 5;
		beadArray[ 4 ] = 0;
		beadArray[ 5 ] = 0;
		beadArray[ 6 ] = 25;
		beadArray[ 7 ] = 0;
		beadArray[ 8 ] = 5;
		beadArray[ 9 ] = 0;
		beadArray[ 10 ] = 0;
		beadArray[ 11 ] = 0;
		beadArray[ 12 ] = 0;
		beadArray[ 13 ] = 14;
	}

	/*
	 * Description: prints the bead array in a line
	 * @param: beadArray (number of beads in each bin)
	 * @return: none
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
	 * @param: beadArray(number of starting beads in each bin)
	 * @return: none
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