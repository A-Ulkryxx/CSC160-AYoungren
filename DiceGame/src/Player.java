//Austin Youngren
public class Player
{
	private Die die;
	private String name;
	
	public Player()
	{
		die = new Die();
		name = "John Smith";
	}

	
	
//	public Player( String name )
//	{
//		
//	}
	
	public Die getDie( )
	{
		return die;
	}

	public void setDie( Die die )
	{
		this.die = die;
	}

	public String getName( )
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}



	@Override
	public String toString( )
	{
		return "Player [die=" + die + ", name=" + name + "]";
	}
	
	
	
}
