/*
Austin Youngren
If Statement Check Sheet
Date: 10/5/2021
This program is intended to take 3 user inputs and organize them in numeric order.
Program also tells you which is the higher value of numOne and numTwo.
*/
package checksheetIfAY;

import java.util.Scanner;

public class checksheetIf {

	public static void main(String[] args) {
		
		Scanner input;
		input = new Scanner(System.in);
		int numOne;
		int numTwo;
		int numThree;
		
		System.out.println("Please enter first number");
		numOne = (int) input.nextInt();
		System.out.println("Please enter second number");
		numTwo = (int) input.nextInt();
		System.out.println("Please enter third number");
		numThree = (int) input.nextInt();
		
		if (numOne < numTwo)
		{
			System.out.println("Number 2 is greater than number 1.");
		}
		else
		{
			System.out.println("Number 1 is greater than number 2.");
		}
		
		if ((numOne < numTwo) && (numTwo < numThree))  //Data Values: 1,8,9. Used in every possible order for testing.
			{
				System.out.println("Numeric order is " + numOne + ", " + numTwo + ", " + numThree);
			}
		else if ((numOne < numThree) && (numThree < numTwo))
			{
				System.out.println("Number order is " + numOne + ", " + numThree + ", " + numTwo);
			}
		else if ((numThree < numOne) && (numOne < numTwo))
			{
				System.out.println("Number order is " + numThree + ", " + numOne + ", " + numTwo);
			}
		else if ((numTwo < numOne) && (numOne < numThree))
			{
				System.out.println("Numeric order is " + numTwo + ", " + numOne + ", " + numThree);
			}
		else if ((numTwo < numThree) && (numThree < numOne))
			{
				System.out.println("Number order is " + numTwo + ", " + numThree + ", " + numOne);
			}
		else 
			{
				System.out.println("Number order is " + numThree + ", " + numTwo + ", " + numOne);
			}
	}

}
// Problems: None