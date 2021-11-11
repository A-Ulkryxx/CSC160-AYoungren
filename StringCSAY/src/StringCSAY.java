// Austin Youngren

import java.util.Scanner;

public class StringCSAY
{
	static Scanner input;
	
	public static void main( String[ ] args )
	{
		input = new Scanner(System.in);
		int wordOne ;
		String wordTwo = new String();
		String sentence = new String();
		String bigSentence = new String();
		int comparison;
		int conversion;
		
		System.out.println("Input a word.");
		wordOne = Integer.parseInt("101");
		wordOne = wordOne + 1;
		System.out.println(wordOne);
		
//		System.out.println("Input a sentence.");
//		sentence = input.nextLine ( );
//		System.out.println(wordOne.length());
//		bigSentence = sentence.concat(wordOne) + wordOne;
//		System.out.println(bigSentence);
//		System.out.println(bigSentence.indexOf ( "cat" ));
//		System.out.println("Input another word.");
//		wordTwo = input.nextLine ( );
		wordTwo = "Hello";
		System.out.println(wordTwo);
		conversion = Integer.valueOf(wordTwo);
		System.out.println(conversion);
//		System.out.println("Are the words equal?: " + wordOne.equals ( wordTwo ));
//		System.out.println(wordOne.compareTo ( wordTwo ));
//		comparison = wordOne.compareTo ( wordTwo );
//		if (comparison == 0)
//		{
//			System.out.println("The words are equal");
//		}
//		else if (comparison == -1)
//		{
//			System.out.println("The first word is less than the second word");
//		}
//		else
//		{
//			System.out.println("The second word is less than the first word");
//		}
	}

	//Big cat Small cat middle cat 
}
