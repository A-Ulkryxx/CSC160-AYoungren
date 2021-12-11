import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIOAY
{
	static File inFile;
	static Scanner fin;
	static java.io.File outFile;
	static PrintWriter fout;
	
	public static void main( String[ ] args ) throws IOException
	{
		
		inFile = new File ("Balance.txt");
		String accName;
		double accBalance;
		String accNum;
		
		if( !inFile.exists())
		{
			System.out.println("File not found");
			System.exit ( -1 );
		}
		
		fin = new Scanner( inFile);
	
		accBalance = fin.nextDouble();
		fin.nextLine();
		accNum = fin.nextLine ( );
		accName = fin.nextLine();
		
		outFile = new File("DaFile.txt");
		fout = new PrintWriter(outFile);
		
		while (fin.hasNext())
		{
			System.out.println( accBalance + " " + accName + " " + accNum);
			fout.printf(" %2s %2s %2s \n",accBalance, accName, accNum);
			
			accBalance = fin.nextDouble();
			fin.nextLine();
			accNum = fin.nextLine();
			accName = fin.nextLine ( );
		}
		
		System.out.println(accBalance + " " + accName + " " + accNum);
		fout.printf ( "IT WORKED");
		fout.close();
		System.out.println("Done");
		
		fin.close ( );
	}

}
