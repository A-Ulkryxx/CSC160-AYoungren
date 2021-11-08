//Austin Youngren

package test3AY;

import java.util.Scanner;

public class test3AY
{
	static Scanner input;
	static final int NUM_ENTRY = 30;
	public static void main( String[ ] args )
	{
		input = new Scanner(System.in);
		int [] numberArray;
		numberArray = new int[NUM_ENTRY];
		
		//getNumbers(numberArray);
		testingNumbers(numberArray);
		printNumbers(numberArray);
		findAverage(numberArray);
		highLowValues(numberArray);
	}

	public static void getNumbers(int[] numberArray)
	{
		int i;
		
		for (i = 0; i < numberArray.length; i++)
		{
			System.out.println("Please enter in the next number. Entry: " + (i+1));
			numberArray[i] = input.nextInt();
		}
	}
	
	public static void printNumbers(int [ ] numberArray)
	{
		int i;
		
		for (i = 0; i < numberArray.length; i++)
		{
				System.out.println(numberArray[i]);		
		}
	}
	
	public static void findAverage(int [ ] numberArray)
	{
		double average = 0;
		int i;
		
		for (i = 0; i < numberArray.length; i++)
		{
			average = average + numberArray[i];		
		}
		
		average = average / NUM_ENTRY;
		System.out.println("The average of your numbers is: " + average);
	}
	
	public static void highLowValues(int [ ] numberArray)
	{
		int i;
		int lowValue;
		int highValue;
		
		highValue = numberArray[0];
		lowValue = numberArray[0];
		
		for (i = 0; i < numberArray.length; i++)
		{
			if (numberArray[i] > highValue)
			{
				highValue = numberArray[i];
			}
			else if(numberArray[i] < lowValue)
			{
				lowValue = numberArray[i];
			}
			else {;}
		}
		System.out.println("The lowest value is " + lowValue + " and the highest value is " + highValue + ".");
	}
	public static void testingNumbers(int [ ] numberArray)
	{
		int i;
		
		for (i = 0; i < numberArray.length; i++)
		{
			numberArray[i] = i + 1;
			System.out.println(numberArray[i]);
		}
		
	}
}
