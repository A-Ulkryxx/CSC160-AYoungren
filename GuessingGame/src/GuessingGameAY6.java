/*
 * Austin Youngren
 * Guessing Game #6
 * Due: 10/11/2021
 * This code is intended for users to play a guessing game. 
 * The guess will compare to a randomly generated number.
 * User can set up their own guessing range.
 * User repeats guessing until they have guessed correctly.
 * User will lose a point after every false guess.
 * User can play games until they decide to quit.
 * Program tracks games played, game score, score of all games, 
 * Outputs average score per game of all games when user quits.
 * 
 */

import java.util.Random;
import java.util.Scanner;

public class GuessingGameAY6 {
	static Scanner input;
	public static void main(String[] args) 
	{
		Scanner input;
		input = new Scanner(System.in);
		int guess;              // User's guess   
		int answer;             // randomly generated number
		int score;          // User's score in a single game
		double totalScore = 0;  // User's score of all games
		char playAgain;         // Holds the choice to play again
		int game = 0;           // keeps track of which game user is playing
		double averageScore;    //average points user scored per game
		int lowRange;        //User's input for the low range of random number
		int highRange;       // User's input for the high range of random number
		
		System.out.println("Would you like to play a game?");
		playAgain = input.next().charAt(0); 
		
			//Do-while loop to ensure the range is valid
		do  
		{
		System.out.println("What range would you like to play in?");
		
		System.out.print("Bottom Range: "); 
		lowRange = input.nextInt();        // Allows user to enter in the bottom of the range they want to guess
		System.out.println("High Range: ");
		highRange = input.nextInt();       // Allows user to enter in the top of the range they want to guess
		
		if (lowRange > highRange)
		{
			System.out.println("invalid entry");
		}
		else {;}
		
		}while (lowRange > highRange);
		
		while (playAgain == 'y') 	
		{
			Random randGen;		// Sets up random number generator
			randGen = new Random(); 	// starts random number generator
			answer = randGen.nextInt(highRange - lowRange + 1) + lowRange; 	// Formula is (high - low + 1) + low
			
			score = 5;
			game++;
			System.out.println("Game: " + game);
			
			System.out.println("What number would you like to guess?");
			guess = input.nextInt(); 	
			System.out.println("Your guess is " + guess);
		
				//Loop to repeat guessing until guess matches answer
			while (guess != answer) 
			{
				if (score >= 0) 
				{
					score = score - 1;
					System.out.println("Your score is: " + score);   
				}
				else
				{;}
			
				if (guess > answer)
				{
					System.out.println("Your guess is to high"); 
				}
				else    
				{
				System.out.println("Your guess is to low"); 
				}
			
				System.out.println("Guess again.");
				guess = input.nextInt();    
			
			}                           
		
			System.out.println("Your guess was correct!");
			System.out.println("Your score game end score is " + score); 
			
			totalScore = totalScore + score; 
			
			System.out.println("Would you like to play another?");
			playAgain = input.next().charAt(0); 
			
		}  
		
		System.out.println("You played " + game + " games.");  
		System.out.println("Your total score of all games was " + totalScore + "."); 
		
		averageScore = totalScore / game; 
		
		System.out.println("With an average score of " + averageScore + " per game.");
	}

}
// Problems: No Problems