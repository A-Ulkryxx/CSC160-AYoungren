

import java.util.Random;
import java.util.Scanner;

public class methodsCSAY
{
	static Scanner input;
	public static void main( String[ ] args )
	{
		input = new Scanner(System.in);
		
		int tabValue;
		
		tabValue = validEntry();	
		makeRandomTable( tabValue );
		
		input.close ( );
		
	}
	
	public static int validEntry()
	{
		int tabValue;
		do 
		{
			System.out.println("How many values would you like in the table?");
			tabValue = input.nextInt();
			if ((tabValue < 10) || (tabValue > 500))
			{
				System.out.println("Your Table Value is not in range, please choose between 10 and 500.");
			}
			else
			{;}
		
		}while ( (tabValue < 10) || (tabValue > 500));
		
		return tabValue;
	}// end of validEntry
	
	public static void makeRandomTable(int tabValue)
	{
		int randNum;
		int numCycle = 0;
		String title = "Random Numbers";
		
		System.out.printf ( "%35s\n", title );
		while (numCycle < tabValue)
		{
			randNum = randomRange();
			
			System.out.printf ( "%5d", randNum);
		
			numCycle++;
			if (numCycle % 7 == 0)
			{
				System.out.println ( );
			}
			else {;}
			
		}	// end of loop
		
	}//end of makeRandomTable
	
	public static int randomRange()
	{
		
		
		int randNum;
		int lowRange;
		int highRange;
		
		Random randGen;
		randGen = new Random();
		do
		{
			System.out.println("What would you like the random low range to be?");
			lowRange = input.nextInt();
			System.out.println("What would you like the random high range to be?");
			highRange = input.nextInt();
			if (lowRange > highRange)
			{
				System.out.println("Low range cannot be larger than high range.");
			}
			else
			{;}
		}while (lowRange > highRange);
		
		randNum = randGen.nextInt(highRange - lowRange + 1) + lowRange;
		
		return randNum;
	}
	
}// end of class
