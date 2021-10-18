//Austin Youngren

import java.util.Scanner;

public class test2AY {
	
	public static void main(String[] args) {
		
		Scanner input;
		input = new Scanner (System.in);
		int number;
		int asterisk;
		char playAgain = 'y';
		
		while(playAgain == 'y')
		{
			asterisk = 0;
			System.out.println("What number would you like?");
		
			number = input.nextInt();
		
			while ((number > 100) || (number <= 0))
			{	
				System.out.println("Your number is out of range, please choose bewtween 1 and 100");
				number = input.nextInt(); 
			}
		
		
			while (asterisk < number)
			{
				System.out.print("*");
				asterisk++;
			}
			System.out.println(" ");
			System.out.println("Do you want to choose another number? Yes or no?");
			playAgain = input.next().charAt(0);
		}
	}

}
