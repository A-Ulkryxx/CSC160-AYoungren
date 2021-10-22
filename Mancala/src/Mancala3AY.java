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
		
		while (dottedLine < 5)
		{
			
			makeDottedLine();
			dottedLine++;
		
		}
		System.out.print ( "*      " ); //left side bar numbers will go here
		makeSolidLine(43); 
		System.out.println( "      *" );//right side bar numbers will go here
		dottedLine = 0;
		
		while (dottedLine < 5)
		{
			
			makeDottedLine();
			dottedLine++;
				
		
		}
	
		makeSolidLine(57);
	}// end of showBoard
	
	/*
	 * Description: prints out top row of numbers
	 * @param:None(yet)
	 * @return: none
	 */
	public static void showTopRowNumbers()
	{
		int topNums = 0;
		
		
	}// end of showTopRowNumbers
	
	/*
	 * Description: prints out bottom row of numbers
	 * @param:None(yet)
	 * @return: none
	 */
	public static void showBottomeRowNumbers()
	{
		int bottomNums = 0;
		
		
	}// end of showBottomNumbers
		
}
// Problems: None