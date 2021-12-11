
public class countdown
{

	public static void main( String[ ] args )
	{
		countDown(5);
		

	}

	public static void countDown(int num)
	{
		System.out.println ( num );
		if (num == 0)
		{
			System.out.println("BLAST OFF!!!!!");
		}
		else
		{
			countDown(num - 1);
		}
		
		
	}
}
