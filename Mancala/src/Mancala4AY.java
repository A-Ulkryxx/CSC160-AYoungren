/* Austin Youngren
 * Mancala 4
 * 10/26/21
 * The game of Mancala, a game played by two people by moving beads around a board.
 *  The person with the most beads at the end of the game wins.
 */
public class Mancala4AY
{
	static final int NUM_BINS = 14;

	public static void main( String[ ] args )
	{
		int[ ] beadArray; //number of beads in each bin

		beadArray = new int[ NUM_BINS ];

		startingTestArray ( beadArray );
		//startingArray ( beadArray );
		printArray ( beadArray );
		//showBoard ( );
	} // end of main

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
		} // end of loop
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
			} // end of nested lineCount loop

		} // end of starCount loop
		System.out.println ( "*" );
	}// end of makeDottedLine

	/*
	 * Description: produces the outline of the board
	 * @param: None
	 * @return: None
	 */
	public static void showBoard( )
	{
		int dottedLine = 0;//LCV

		makeSolidLine ( 57 );
		System.out.println ( );
		makeDottedLine ( );
		showTopRowNumbers ( );

		while ( dottedLine < 3 )
		{
			makeDottedLine ( );
			dottedLine++;
		}

		System.out.printf ( "*%4d  ", 13 );
		makeSolidLine ( 43 );
		System.out.printf ( "%4d  *\n", 6 );
		makeDottedLine ( );
		makeDottedLine ( );
		showBottomeRowNumbers ( );
		dottedLine = 0;

		while ( dottedLine < 3 )
		{
			makeDottedLine ( );
			dottedLine++;
		}

		makeSolidLine ( 57 );
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
	 * Description: initializes elements for testing/debugging purposes
	 * @param: beadArray
	 * @return: none
	 */
	public static void startingTestArray( int[ ] beadArray )
	{
		beadArray[ 0 ] = 10;
		beadArray[ 1 ] = 5;
		beadArray[ 2 ] = 1;
		beadArray[ 3 ] = 7;
		beadArray[ 4 ] = 10;
		beadArray[ 5 ] = 5;
		beadArray[ 6 ] = 1;
		beadArray[ 7 ] = 7;
		beadArray[ 8 ] = 48;
		beadArray[ 9 ] = 5;
		beadArray[ 10 ] = 9;
		beadArray[ 11 ] = 4;
		beadArray[ 12 ] = 10;
		beadArray[ 13 ] = 5;
	}

	/*
	 * Description: prints the bead array in a line
	 * @param: beadArray
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
	 * @param: beadArray
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