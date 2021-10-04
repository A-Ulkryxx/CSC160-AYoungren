package checksheetIf;

import java.util.Scanner;

public class checksheetIf {

	public static void main(String[] args) {
		
		Scanner input;
		input = new Scanner(System.in);
		int numOne;
		int numTwo;
		int numThree;
		
		System.out.println("Please enter first number");
		numOne = input.nextInt();
		System.out.println("Please enter second number");
		numTwo = input.nextInt();
		System.out.println("Please enter third number");
		numThree = input.nextInt();
		
		if (numOne < numTwo)
		{
			System.out.println("Number 2 is greater than number 1.");
		}
		else
		{
			System.out.println("Number 1 is greater than number 2.");
		}
		
		
	
		if ((numTwo < numThree) && (numOne > numTwo))
			{
				System.out.println("Numeric order is " + numOne + ", " + numTwo + ", " + numThree);
			}
		else if ((numThree < numTwo) && (numOne > numThree))
			{
				System.out.println("Number order is " + numOne + ", " + numThree + ", " + numTwo);
			}
		else if ((numThree < numOne) && (numOne > numTwo))
			{
				System.out.println("Number order is " + numThree + ", " + numOne + ", " + numTwo);
			}
		else if ((numOne < numThree) && (numTwo < numOne))
			{
				System.out.println("Numeric order is " + numTwo + ", " + numOne + ", " + numThree);
			}
		else if ((numThree < numOne) && (numTwo > numThree))
			{
				System.out.println("Number order is " + numTwo + ", " + numThree + ", " + numOne);
			}
		else if (numThree < numTwo)
			{
				System.out.println("Number order is " + numThree + ", " + numTwo + ", " + numOne);
			}
	}

}
