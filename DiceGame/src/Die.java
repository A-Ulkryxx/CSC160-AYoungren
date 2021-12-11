//Austin Youngren
import java.util.Random;



public class Die
{
	private int numSides;
	private int value;
	
	public Die()
	{
		numSides = 6;
		value = 0;
	}
	
	public Die(int sideNum)
	{
		numSides = sideNum;
		value = 0;
	}

	public int roll()
	{
		Random randGen;
		randGen = new Random();
		int rolledValue;
		
		rolledValue = randGen.nextInt(numSides + 1) - 1;
		
		return rolledValue;
	}
	
	public int getNumSides( )
	{
		return numSides;
	}

	public void setNumSides( int numSides )
	{
		this.numSides = numSides;
	}

	public int getValue( )
	{
		return value;
	}

	public void setValue( int value )
	{
		this.value = value;
	}
	
	@Override
	public String toString( )
	{
		return "Die [numSides=" + numSides + ", value=" + value + "]";
	}
}
