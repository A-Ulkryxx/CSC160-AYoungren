import java.util.Scanner;

//Austin Youngren
public class DieGameAY
{
	static Scanner input;
	
	public static void main( String[ ] args )
	{
		input = new Scanner(System.in);
		Die testDie = new Die ( );  	//Part 3
		System.out.println ( "Die Test: " + testDie.toString ( ) );  //Part 3
		int value;
		int numDieSides = getDieSideInput ( );  //part 4
	
		Player[ ] players = new Player[ 3 ];	//part 6

		for ( int i = 0; i < players.length; i++ )	//part 6
		{
			players[ i ] = new Player ( );	//part 6
			Die die = new Die ( numDieSides );	//Part 3
			
			
			players[ i ].setDie ( die );	//part 6
			die.setValue( die.roll());
			System.out.println ( "Die Test: " + die.toString ( ) );	//Part 3
			//call the method that will roll the die and set the value, you also write the method	//part 5	
		
		}  //end loop to create players


		for ( int i = 0; i < players.length; i++ ) //part 7
		{
			printRollResult(players[i].getDie ( ));
		}

		findWinner(players);
// Call method to declare winner  // part 9

		input.close ( );
	}  //end main

    // Using this method stub.  Write a method to get the number of sides on the die
	public static int getDieSideInput( )					//part 4 whole method
	{
		int numSides;
		System.out.println("How many sides would you like your dice to have?");
		numSides = input.nextInt ( );
		
		return numSides;
	}
		
	public static void printRollResult( Die oneDie )  //part 3  whole method
	{
		System.out.println ( "You rolled a " + oneDie.getValue ( ) + " on a " + oneDie.getNumSides ( ) + " sided die" );
	}
	
		// Write a method to find the player with the highest roll and output the number of the winner and their die value.
	public static void findWinner(Player[] players)
	{
		int i;
		Die die;
		int value;
		int highestValue = 0;
		int winner = -1;
		
		for (i = 0; i < players.length; i++)
		{
			die = players[i].getDie();
			value = die.getValue ( );
			if (value > highestValue)
			{
				highestValue = value;
				winner = i;
			}
			else if (value == highestValue)
			{
				System.out.println("The winner is " + players[i].getName() + "with value of: " + die.getValue());
			}
			else {;}
		}
		
		die = players[winner].getDie();
		value = die.getValue ( );
		System.out.println("The winner is " + players[winner].getName()+ "with value of: " + value);
	}
	
	public static void getPlayerName(Player[] players)
	{
		int i;
		String name;
		
		for (i = 0; i < players.length; i++)
		{
			System.out.println( "Player " + (i+1) + "What would you like your name to be");
			name = input.nextLine();
			
			players[i].setName(name);
		}
	}
	
}//end of class


//AY