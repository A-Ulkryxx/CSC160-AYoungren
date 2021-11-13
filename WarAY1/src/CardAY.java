/*
 * Austin Youngren
 * War 1
 * 11/15/21
 * WarAY1
 * Description: Represents a playing card in a standard deck of playing cards.
 * Can be used for a variety of games that don't need use of Joker card.
 */
public class CardAY
{
	private static final String[] CARD_RANK = 
		{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" }; //All possible card ranks
	private static final String[] CARD_SUIT =
		{"Hearts", "Clubs", "Diamonds", "Spades"};  // All possible card suits
	private String rank;// a card's rank
	private String suit;// a card's suit
	
	/* Description: Default Constructor - sets default rank and suit to a card
	 * @param: None
	 * @return: None
	 */
	public CardAY() 
	{
		this.rank = CARD_RANK[0];
		this.suit = CARD_SUIT[0];
	}
	
	/* Description: Constructor - sets the rank and suit to a card
	 * @param: rank - the rank that will be assigned to a card
	 * @param: suit - the suit that will be assigned to a card
	 * @return: None
	 */
	public CardAY(String rank, String suit)
	{
		this.rank = rank;
		this.suit = suit;
	}
	
	/* Description: Setter Accessor - assigns a suit to  a card
	 * @param: suit -  the suit to be assigned to a card
	 * @return: None
	 */
	public void setSuit(String suit)
	{
		this.suit = suit;
	}
	
	/* Description: Getter Accessor - returns the suit of a card
	 * @param: None
	 * @return: suit - the suit of a card
	 */
	public String getSuit()
	{
		return suit;
	}
	
	/* Description: Setter Accessor - assigns a rank to a card
	 * @param: rank - the rank to be assigned to a card
	 * @return: None
	 */
	public void setRank(String rank)
	{
		this.rank = rank;
	}
	
	/* Description: Getter Accessor - returns the rank of a card
	 * @param: None
	 * @return: rank - the rank of a card
	 */
	public String getRank()
	{
		return rank;
	}
}

//Problems: None