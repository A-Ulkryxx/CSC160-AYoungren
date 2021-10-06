/*
 * Austin Youngren
 * Guessing Game #3
 * Due: 10/06/2021
 * This code is intended for users to play a guessing game. 
 * The guess will compare to a randomly generated number.
 * User repeats guessing until they have guessed correctly
 */

import java.util.Random;
import java.util.Scanner;

public class GuessingGameAY3 {
	static Scanner input;
	public static void main(String[] args) {
		
		Scanner input;
		input = new Scanner(System.in);
		int guess;          
		int answer;         
		Random randGen;		// Sets up and starts random number generator
		
		randGen = new Random();
		answer = randGen.nextInt(20 - 10 + 1) + 10;  // Formula is (high - low + 1) + low
		
		System.out.println("The number is " + answer); // Placed before guess and loop for testing
		
		System.out.println("What number would you like to guess? (10 - 20)");
		guess = input.nextInt();
		System.out.println("Your guess is " + guess);
		
		//Added loop to repeat guessing until guess matches answer
		while (guess != answer) //Loop starts if guess is not equal to answer
		{
			if (guess > answer) 
			{
				System.out.println("Your guess is to high"); 
			}
			else    
			{
				System.out.println("Your guess is to low"); 
			}
			
			System.out.println("Guess again.");
			guess = input.nextInt();    //Changer, restarts or ends loop
			
		}                            //Loop end
		
		System.out.println("Your guess was correct!");
	}

}
// Problems: No Problems