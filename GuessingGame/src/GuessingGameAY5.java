/*
 *  Austin Youngren
 * Guessing Game #5
 * Due: 10/08/2021
 * This code is intended for users to play a guessing game. 
 * The guess will compare to a randomly generated number.
 * User repeats guessing until they have guessed correctly.
 * User will lose a point after every false guess.
 * User can play games until they decide to quit.
 * Program tracks games played, game score, score of all games, 
 * outputs average score per game of all games when user quits.
 */

import java.util.Random;
import java.util.Scanner;

public class GuessingGameAY5 {
	static Scanner input;
	public static void main(String[] args) 
	{
		Scanner input;
		input = new Scanner(System.in);
		int guess;              // User's guess   
		int answer;             // randomly generated number
		int score;          // User's score in a single game
		int totalScore = 0;  // User's score of all games
		char playAgain;         // Holds the choice to play again
		int game = 0;           // keeps track of which game user is playing
		int averageScore;    //average points user scored per game
		
		System.out.println("Would you like to play a game?");
		playAgain = input.next().charAt(0); // Initializer for first loop
		
		while (playAgain == 'y') 	//Allows user to play game multiple times. First loop condition
		{
			Random randGen;		// Sets up random number generator
			randGen = new Random(); 	// starts random number generator
			answer = randGen.nextInt(20 - 10 + 1) + 10; 	// Formula is (high - low + 1) + low
			score = 5;
			game++;
			System.out.println("Game: " + game);
			
			System.out.println("What number would you like to guess? Range of 10 - 20");
			guess = input.nextInt(); 	//Initializer
			System.out.println("Your guess is " + guess);
		
				//Loop to repeat guessing until guess matches answer
			while (guess != answer) //second loop condition
			{
				if (score > 0) 
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
				guess = input.nextInt();    // Changer for second loop
			
			}                            //second loop end
		
			System.out.println("Your guess was correct!");
			System.out.println("Your score game end score is " + score); 
			
			totalScore = totalScore + score; //Collective score of all games
			
			System.out.println("Would you like to play another?");
			playAgain = input.next().charAt(0); // changer for first loop
			
		}  //first loop end
		
		System.out.println("You played " + game + " games.");  // outputs total games played
		System.out.println("Your total score of all games was " + totalScore + "."); // outputs collective score of all games
		
		averageScore = totalScore / game; // formula that finds average points per game of all games played
		
		System.out.println("With an average score of " + averageScore + " per game."); // outputs average score per game of all games played
	}

}
// Problems: No Problems