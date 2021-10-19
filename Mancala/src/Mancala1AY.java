/* Austin Youngren
 * Mancala 1
 * 10/19/21
 * The game of Mancala, a game played by two people by moving beads around a board.
 *  The person with the most beads at the end of the game wins.
 */
public class Mancala1AY {

	public static void main(String[] args) 
	{
		
		int numStars; //Amount of stars to output in a line
		numStars = 3;
		makeSolidLine(numStars);
		System.out.println("");
		makeSolidLine(10);
		

	}   // end of main
	
	/*Description: Print out line of stars
	 * @param numStars - Amount of stars to output in a line
	 * return type void
	 */
	public static void makeSolidLine(int numStars)
	{
		int starCount; // LCV
		starCount = 0;
		
		while (starCount < numStars)
		{
			System.out.print("*");
			starCount++;
		}  //end of loop
		
	} //end of makeSolidLine
		
}
// Problems: None