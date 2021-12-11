/*Austin Youngren
 * War 5
 * 11/18/21
 * CardG3, DeckG3, WarG3
 * Description: Represents a playing card in a standard deck of playing cards.
 * Can be used for a variety of games that don't need the use of Joker card.
 */
public class CardG3
{
	public final String[] CARD_RANK = 
		{null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" }; //All possible card ranks
	public final String[] CARD_SUIT =
		{ "Clubs", "Diamonds", "Hearts","Spades"};  // All possible card suits
	
	private int rank; // a card's rank
	private int suit; // a card's suit
	
		/*Description: Applies values for rank and suit within a card.
		 * 
		 * CardG3()
		 * @param: None
		 * @return: None
		 * 
		 * CardG3(int rank, int suit)
		 * @param: rank - the specified rank to be assigned to a card
		 * @param: suit - the specified suit to be assigned to a card
		 * @return: None
		 */
	public CardG3() 
	{
		rank = 4;
		suit = 2;
	}
	
	public CardG3(int rank, int suit)
	{
		this.rank = rank;
		this.suit = suit;
	}
	
		/*
		 * Description: This method compares two cards to see which card has the higher valued rank. The only card that beats Ace(14) is a 2.
		 * @param: CardG3 - A single card of the deck.
		 * @return: compareResult - returns 1 if card rank is greater returns -1 if otherCard rank is greater returns 0 if
		 * both cards' ranks are equal
		 * @Author: Austin Youngren
		 */
	public int compareTo(CardG3 otherCard)
	{
		int compareResult; // the value result of the comparison of two cards 
		
		if ((rank == 2) && (otherCard.rank == 14))
		{
			compareResult = 1;
		}
		else if ((rank == 14) && (otherCard.rank == 2))
		{
			compareResult = -1;
		}
		else if (rank > otherCard.rank)
		{
			compareResult = 1;
		}
		
		else if (rank < otherCard.rank)
		{
			compareResult = -1;
		}
		else
		{
			compareResult = 0;
		}
		return compareResult;
	}
	
	/*
	 * Description: This method compares two cards to see which card has the higher valued rank and suit.
	 * @param: CardG3 - A single card of the deck.
	 * @return: comparison - returns 1 if card rank is greater, returns -1 if cardTwo rank is greater, returns 0 if
	 * both cards' ranks are equal
	 * @Author: Austin Youngren
	 */
	public int compareCard(CardG3 cardTwo)
	{
		int comparison;//the result of two cards being compared
		
		if (suit > cardTwo.suit)
		{
			comparison = 1;
		}
		else if (suit == cardTwo.suit)
		{
			if (rank > cardTwo.rank)
			{
				comparison = 1;
			}
			else if (rank == cardTwo.rank)
			{
				comparison = 0;
			}
			else
			{
				comparison = -1;
			}
		}
		else
		{
			comparison = -1;
		}
		return comparison;
	}
	
		/*Getters and setters below
	   */ 
	public void setSuit(int suit)
	{
		this.suit = suit;
	}
	
	public int getSuit()
	{
		return suit;
	}
	
	public void setRank(int rank)
	{
		this.rank = rank;
	}
	
	public int getRank()
	{
		return rank;
	}

		/*Description: outputs the rank and suit of a card
		 * @param: None
		 * @return: None
		 */
	@Override
	public String toString( )
	{
		return CARD_RANK[rank] + " of " + CARD_SUIT[suit] + ", ";
			//return "Card(rank: " + rank + ", suit: " + suit + ")";
	}	
}

//Problems: None