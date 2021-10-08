/*
 * Austin Youngren
 */

import java.util.Scanner;

public class checkSheetLoopAY {

	public static void main(String[] args) {
		
		Scanner input;
		input = new Scanner(System.in);
		int bactAmount; // amount of bacteria
		int enteredSamples; // number of samples
		int numSample; // counts samples entered
		int bactTotal; // Total bacteria
		
		numSample = 0;
		bactTotal = 0;
		System.out.println("How many samples are there?");
		enteredSamples = input.nextInt();
		
		while (numSample != enteredSamples )
		{	
			numSample++;
			
			System.out.println("What was the amount of bacteria in sample " + numSample + "?");
			bactAmount = input.nextInt();
			
			System.out.println("There was " + bactAmount + " bacteria in the " + numSample + " sample.");
			
			bactTotal = bactTotal + bactAmount;
						
		}
		
		System.out.println("The total bacteria count is " + bactTotal);
		
	}

}
