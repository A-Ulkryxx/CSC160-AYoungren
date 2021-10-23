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
		makeDottedLine();
		showTopRowNumbers();
	
		while (dottedLine < 3)
		{
			makeDottedLine();
			dottedLine++;
		}
		
		System.out.printf ( "*  13  "); 
		makeSolidLine(43); 
		System.out.println( "  6   *");
		makeDottedLine();
		makeDottedLine();
		showBottomeRowNumbers();
		dottedLine = 0;
		
		while (dottedLine < 3)
		{
			makeDottedLine();
			dottedLine++;
		}
	
		makeSolidLine(57);
	}// end of showBoard
	
	/*
	 * Description: prints out top row of numbers
	 * @param:None
	 * @return: none
	 */
	public static void showTopRowNumbers()
	{
		int topNums = 0; // number within columns of top row
		System.out.print( "*      ");
		while (topNums< 6)
		{
			System.out.printf ( "*%4d  ", topNums );
			topNums++;
		}
		System.out.println ("*      *" );
		
	}// end of showTopRowNumbers
	
	/*
	 * Description: prints out bottom row of numbers
	 * @param:None
	 * @return: none
	 */
	public static void showBottomeRowNumbers()
	{
		int bottomNums = 12;//number within columns of bottom row
		System.out.print( "*      ");
		while (bottomNums > 6)
		{
			System.out.printf ( "*%4d  ", bottomNums );
			bottomNums--;
		}
		System.out.println ("*      *" );
		
	}// end of showBottomNumbers		
}
// Problems: making spaces after variables in print f statements without using spaces