/* Austin Youngren
 * Mancala 3
 * 10/22/21
 * The game of Mancala, a game played by two people by moving beads around a board.
 *  The person with the most beads at the end of the game wins.
 */
public class Mancala3AY
{

	public static void main( String[ ] args )
	{
	/*	int numStars; // Amount of stars to output in a line
		numStars = 3;
		makeSolidLine ( numStars );
		System.out.println ( "" );
		makeSolidLine ( 57 );
		System.out.println ( "" );
		makeDottedLine ( );
	*/ 
		showBoard();
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
		
		makeSolidLine(57);
		System.out.println ( );
		
		while (dottedLine < 5)
		{
			makeDottedLine();
			dottedLine++;
		}
		
		makeSolidLine(57); //FIXME: needs open spaces in first and last column
		System.out.println();
		dottedLine = 0;
		
		while (dottedLine < 5)
		{
			makeDottedLine();
			dottedLine++;
		}
	
		makeSolidLine(57);
	}
	
}
// Problems: None