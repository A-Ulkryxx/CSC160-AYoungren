/*
 * Austin Youngren
 * Guessing Game #4
 * Due: 10/07/2021
 * This code is intended for users to play a guessing game. 
 * The guess will compare to a randomly generated number.
 * User repeats guessing until they have guessed correctly.
 * User will lose a point after every false guess.
 */

import java.util.Random;
import java.util.Scanner;

public class GuessingGameAY4 {
	static Scanner input;
	public static void main(String[] args) {
		
		Scanner input;
		input = new Scanner(System.in);
		int guess;       // User's guess   
		int answer;      // randomly generated number
		int score = 5;   // User's score
		Random randGen;		// Sets up random number generator
		
		randGen = new Random(); // starts random number generator
		answer = randGen.nextInt(20 - 10 + 1) + 10;  // Formula is (high - low + 1) + low
		
		System.out.println("The number is " + answer); // Placed before guess and loop for testing
		
		System.out.println("What number would you like to guess?");
		guess = input.nextInt(); //Initializer
		System.out.println("Your guess is " + guess);
		
		//Loop to repeat guessing until guess matches answer
		while (guess != answer) //Loop starts if guess is not equal to answer (condition)
		{
			//If the score is greater than zero and if guess is wrong, User loses a point in score
			if ((score > 0) && (guess != answer)) //Score cannot drop below zero
			{
				score = score - 1;
				System.out.println("Your score is: " + score);   
			}
			else
			{;}
			
			if (guess > answer) // Guess hint options based
			{
				System.out.println("Your guess is to high"); 
			}
			else    
			{
				System.out.println("Your guess is to low"); 
			}
			
			System.out.println("Guess again.");
			guess = input.nextInt();    //Changer
			
		}                            //Loop end
		
		System.out.println("Your guess was correct!");
		System.out.println("Your score final score is " + score); //intended score output
	}

}
// Problems: No Problems