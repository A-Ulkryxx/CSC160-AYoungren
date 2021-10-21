

import java.util.Random;
import java.util.Scanner;

public class methodsCS
{

	public static void main( String[ ] args )
	{
		Scanner input;
		input = new Scanner(System.in);
		
		int tabValue;
		
		System.out.println("How many values would you like in the table?");
		tabValue = input.nextInt();
		makeRandomTable( tabValue );
		
		input.close ( );
		
	}
	public static void makeRandomTable(int tabValue)
	{
		Random randGen;
		randGen = new Random();
		
		int randNum;
		int numCycle = 0;
		String title = "Random Numbers";
		
		System.out.printf ( "%35s\n", title );
		while (numCycle < tabValue)
		{
			randNum = randGen.nextInt(1003 - 9 + 1) + 9;
			
			System.out.printf ( "%5d", randNum);
		
			numCycle++;
			if (numCycle % 7 == 0)
			{
				System.out.println ( );
			}
			else {;}
			
		}	// end of loop
		
	}//end of makeRandomTable
	
}// end of class
