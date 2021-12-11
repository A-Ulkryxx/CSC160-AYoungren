import java.util.Arrays;

public class PlayerAY
{
	private DeckAY hand; // holds dealt cards to player each game
	private long STARTING_CASH = 2000; // Starting cash amount for a player
	private long money;// The amount of money the play has at any given time.
	private boolean betAble; // if the player is allowed to bet
	private boolean playing; // If the player is still in the game
	private long betAmount; // The amount bet in a round
	private long subBet; // The amount bet in a sub round
	private String name; //The players input name
	
	/*Description: Sets number of players, implements the necessary items that each player will need. 
	 * an Array for their hand, and their allocated starting cash for the game
	 * @param: None
	 * @return: None
	 */
	public PlayerAY()
	{
			betAble = true;
			hand = new DeckAY(2, 2);
			money = STARTING_CASH;
			playing = true;
			betAmount = 0;
			subBet = 0;
			name = "player";
	}

	/*Description: Removes player's placed bet from player's allocated money pool 
	 * @param: long playerBet - The player's chosen bet
	 * @return: long playerBet - The player's chosen bet
	 */
	public void placeBet(long playerBet)
	{
		subBet = playerBet;
		money = money - playerBet;  //FIXME - rework once bet pool is decided.
		betAmount = betAmount + playerBet;
	}
	
	/*Description: Removes previous player's placed bet from current player's allocated money pool 
	 * @param: long previousPlayerBet - The previous player's chosen bet
	 * @return: long callMatch - The previous player's chosen bet
	 */
	public void playerCall( long previousPlayerBet)
	{	
		subBet = previousPlayerBet;
		betAmount = betAmount + previousPlayerBet;
		money = money - previousPlayerBet; 
	}

	/*Description: Ensures all players have placed their bets if still in the round
	 * @param: long bigBet - The highest bet placed for sub-round
	 * @return: long betShort - Players who have not bet (-1 return value if all players have matched the bet)
	 */
	public int checkBets(long bigBet)
	{
		int betShort = -1;
		
			if ((betAmount != bigBet) && (playing == true))
			{
				betShort = 1;
			}
			else {;}
		
		return betShort;
	}
	
	
	/*Description: Sends player's card to the discard pile and pulls them out for the remainder of the round
	 * @param: DeckAY discard - the discard pile
	 * @return: None
	 */
	public void fold(DeckAY discard)
	{
		int i;
		
		for (i = 0; i < hand.getCards().length ; i++)
		{
			discard.addCard(hand.getCards()[i]);
		}
		playing = false;
	}
	
	/*Description: Deals hands to each player still playing
	 * @param: PlayerAY[] player - all players in the game
	 * @param: DeckAY deck - The Deck of playing cards
	 * @return: None
	 */
	public void dealCards(DeckAY deck)
	{
		int i;//LCV, index reference variable
		
		for (i = 0; i < 2; i++)
		{
			if (playing == true)
			{
				hand.getCards()[i] = deck.popCard ( );
			}
			else {;}
		}
	}
	

	/*Description: Returns player hands to the deck of cards then shuffles
	 * @param: PlayerAY[] player - all players in the game
	 * @param: DeckAY discard - The discard pile
	 * @return: None
	 */
	public void roundEnd(DeckAY discard, PlayerAY[] player)
	{
		int i;//LCV
		int j;//LCV
		
		for (j = 0; j < player.length; j++)
		{
			for (i = 0; i < 2; i++ )
			{
				if (player[j].playing == true)
				{
					discard.addCard ( player[j].hand.getCards ( )[i]);
				}
				else {;}
			}
		}
		
	}
	
	/*
	 * Getters and Setters
	 */
	public DeckAY getHand()
	{
		return hand;
	}
	
	public long getMoney( )
	{
		return money;
	}

	public void setMoney( long money )
	{
		this.money = money;
	}

	public boolean isBetAble( )
	{
		return betAble;
	}

	public void setBetAble( boolean betAble )
	{
		this.betAble = betAble;
	}
	
	public boolean isPlaying( )
	{
		return playing;
	}

	public void setPlaying( boolean playing )
	{
		this.playing = playing;
	}

	public long getBetAmount( )
	{
		return betAmount;
	}

	public void setBetAmount( long betAmount )
	{
		this.betAmount = betAmount;
	}
	
	public long getSubBet( )
	{
		return subBet;
	}

	public void setSubBet( long subBet )
	{
		this.subBet = subBet;
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
		return "PlayerAY [hand=" + hand + ", STARTING_CASH=" + STARTING_CASH + ", money=" + money + ", betAble=" + betAble
				+ ", playing=" + playing + ", betAmount=" + betAmount + ", subBet=" + subBet + ", name=" + name + "]";
	}
}
