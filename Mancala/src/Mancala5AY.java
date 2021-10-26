/* Austin Youngren
 * Mancala 5
 * 10/26/21
 * The game of Mancala, a game played by two people by moving beads around a board.
 *  The person with the most beads at the end of the game wins.
 */
public class Mancala5AY
{
	static final int NUM_BINS = 14;

	public static void main( String[ ] args )
	{
		int[ ] beadArray; //number of beads in each bin

		beadArray = new int[ NUM_BINS ];

		startingTestArray ( beadArray );
		//startingArray ( beadArray );
		printArray ( beadArray );
		showBoard ( beadArray );
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
		beadArray[ 0 ] = 25;
		beadArray[ 1 ] = 10;
		beadArray[ 2 ] = 6;
		beadArray[ 3 ] = 3;
		beadArray[ 4 ] = 41;
		beadArray[ 5 ] = 55;
		beadArray[ 6 ] = 66;
		beadArray[ 7 ] = 7;
		beadArray[ 8 ] = 87;
		beadArray[ 9 ] = 98;
		beadArray[ 10 ] = 10;
		beadArray[ 11 ] = 11;
		beadArray[ 12 ] = 12;
		beadArray[ 13 ] = 13;
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