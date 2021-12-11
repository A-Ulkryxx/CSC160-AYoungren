/*Austin Youngren
 * Texas Hold'Em
 * 12/13/21
 * Description: Creates and manages a deck of cards. Can take in specified Card numbers 
 * for deck creation, Can create a standard deck of 52 cards,
 * shuffles the deck, organize the deck, and can shuffle a specific amount of cards for deck
 */

import java.util.Random;

public class DeckAY
{
	private CardAY[ ] cards;
	
	private int bottomQueue;//the bottom card of a deck queue
	private int topQueue; //the top card of a deck queue
	private int sizeOfQueue;// the size of the deck's queue

		/* 
		 * Description: Makes an array of cards for the creation of a Deck. Default constructor assigns each card with rank
		 * and suit values
		 * 
		 * DeckAY(int numberOfCards)
		 * @param: numberOfCards - the specified number(array) of cards in a deck
		 * @return: None 
		 * 
		 * DeckAY(int numberOfCards, int num)
		 * @param: numberOfCards - the specified number(array) of cards in a deck
		 * @param; num - the limit of array slots in a deck
		 * @return: None 
		 * 
		 * DeckAY()
		 * @param: None
		 * @return: None
		 */
	public DeckAY( )
	{
		int i; // LCV
		int j; //LCV
		int h = 0; // array index reference
		CardAY card; // temporary card for rank and suit assignment
		cards = new CardAY[ 52 ];// an array of 52 cards to create a full deck
		
		bottomQueue = 52;
		topQueue = 0;
		sizeOfQueue = 52;

		for ( i = 0; i < 4; i++ )
		{
			for ( j = 2; j < 15; j++ )
			{
				card = new CardAY ( j, i );
				cards[ h ] = card;
				h++;
			}
		}
	}
	
	public DeckAY( int numberOfCards, int num ) 
	{
		int i; // LCV
		CardAY card; // temporary card for rank and suit assignment
		cards = new CardAY[ num ];// an array of cards. Number of cards equates to sizeOfQueue
		bottomQueue = numberOfCards;
		topQueue = 0;
		sizeOfQueue = numberOfCards;

		for ( i = 0; i < numberOfCards; i++ )
		{
			card = new CardAY ( );
			cards[ i ] = card;
		}
	}
	
	public DeckAY( int numberOfCards ) 
	{
		int i; // LCV
		bottomQueue = numberOfCards;
		topQueue = 0;
		sizeOfQueue = numberOfCards;
		
		CardAY card; // temporary card for rank and suit assignment
		cards = new CardAY[ 52 ];// an array of cards. Number of cards equates to sizeOfQueue

		for ( i = 0; i < numberOfCards; i++ )
		{
			card = new CardAY ( );
			cards[ i ] = card;
		}
	}

		/*
		 * Description:Organizes a deck of cards by suit then organizes by suit's rank
		 * @param: None
		 * @return: None
		 */
	public void organizer( ) 
	{
		int i; // LCV
		int j;//index reference variable

		CardAY tempCard = new CardAY ( 0, 0 );//temporary card for data member swap
		for ( i = 0; i < cards.length; i++ )// loops for all cards in a deck
		{
			for ( j = 1; j < ( cards.length - i ); j++ ) // array traversal for swap
			{
				if ( cards[ j - 1 ].compareCard(cards[ j ]) == 1 )
				{
					tempCard = cards[ j - 1 ];
					cards[ j - 1 ] = cards[ j ];
					cards[ j ] = tempCard;
				}
			}
		}
	}

		/*
		 * Description:Shuffles a deck of cards by randomly choosing an array index (j) and swaps the data members with
		 * looped index(i).
		 * @param: None
		 * @return: None
		 */
	public void shuffle( ) 
	{
		int j;//index reference variable
		CardAY tempCard = new CardAY ( 0, 0 );//a temporary card for swapping
		Random randGen = new Random ( );//random int generator
		for ( int i = 0; i < cards.length; i++ )
		{
				//ordered element assigns data members to temporary placeholder for a swap
			tempCard = cards[ i ];
				//assigns random integer to index reference variable for swap 
			j = randGen.nextInt ( cards.length );
				//random element's data members are assigned to ordered element
			cards[ i ] = cards[ j ];
				//temporary place holder assigns held data members to random element
			cards[ j ] = tempCard;
		}
	}//end of shuffle method

		/*
		 * Description: Shuffles a deck of cards, provided as an argument, by randomly choosing an array index (j) and swaps
		 * the data members with ordered index (i).
		 * This is a second shuffle method made because the directions asked for two 
		 * kinds of shuffle methods. The one above and this one
		 * @param: DeckG3 deck - an array (deck) of cards
		 * @return: None
		 */
	public static void shuffleAny( DeckAY deck )
	{
		int j;//index reference variable
		CardAY tempCard = new CardAY ( 0, 0 );// temporary card to swap with
		Random randGen = new Random ( );//random generator set up
		for ( int i = 0; i < deck.cards.length; i++ )
		{
				//ordered element assigns data members to temporary placeholder for a swap
			tempCard = deck.cards[ i ];
				//assigns random integer to index reference variable for swap 
			j = randGen.nextInt ( deck.cards.length );
				//random element's data members are assigned to ordered element
			deck.cards[ i ] = deck.cards[ j ];
			deck.cards[ j ] = tempCard;
		}
	}
	/*
	 * Description: Creates a subdeck from a specified range within a larger deck
	 * @param: int start - the specified starting range of cards in a deck for subdeck creation
	 * @param: int end - the specified end range of cards in a deck for subdeck creation
	 * @return: subDeck - a new deck created from the wanted range of a larger deck
	 */
	public DeckAY getSubDeck( int start, int end )
	{
		int i; //LCV, index reverence variable
		int j = 0; // index reference variable
		int numCards; //index reference variable, a range of cards in a deck to create subdeck

		numCards = end - ( start );
		DeckAY subDeck = new DeckAY ( numCards );
		for ( i = start; i < end; i++ )
		{
			subDeck.cards[ j ] = cards[ i ];
			j++;
		}
		return subDeck;
	}

		/*
		 * we could take the number of players and use MOD to then divy the subdecks into piles based on that. the remainder
		 * cards if there are any could be a bonus winning pile for the first round if (playercount == 3) { start = end = }
		 * else if (playercount == 4) start and end will then be in subdeck, and all we have to pass in is the amount of
		 * players an array of decks for each players to give them each a deck
		 */

		/*
		 * Description: Searches for a specified card in an array of cards
		 * @param: int rank - the specified rank of the card being searched for
		 * @param: int suit - the specified suit of the card being searched for
		 * @return: cardLocation - returns the array location of the specified card in the deck of cards
		 */
	public int cardSearch( int rank, int suit )
	{
		int i;//LCV and array index location
		int cardLocation = -1; // returns index of specified card

		for ( i = 0; i < cards.length; i++ )
		{
			if ( cards[ i ].getRank ( ) == rank )
			{
				if ( cards[ i ].getSuit ( ) == suit )
				{
					cardLocation = i;
				}
				else
				{
					;
				}
			}
			else
			{
				;
			}
		}
		return cardLocation;
	}

	/*
	 * Description: Takes a deck and inserts the values of the pile array at the bottom/end of deck array
	 * @param: DeckG3 pile - an array (deck/pile) of cards
	 * @return: None
	 * @Author: Austin Youngren
	 */
	public void addDeck( DeckAY pile )
	{
		int i; //LCV, index reference variable

		for ( i = pile.topQueue ; i < pile.sizeOfQueue; i++ )
		{
			this.addCard(pile.cards[ i ]);
			pile.cards[ i ] = null;
		}
		pile.sizeOfQueue = 0;
		pile.bottomQueue = 0;
		pile.topQueue = 0;
		
	}//end of addDeck
	
		/*
		 * Description: Takes a deck and inserts the values of the pile array at the bottom/end of deck array
		 * @param: DeckG3 pile - an array (deck/pile) of cards
		 * @return: None
		 */
//	public void addDeck( DeckG3 pile )
//	{
//		int i; //LCV, index reference variable
//		int j = 0;// index reference variable
//		int addingCards;// length new array
//
//		addingCards = cards.length + pile.cards.length;
//		CardG3[ ] newCards = new CardG3[ addingCards ];
//		for ( i = 0; i < cards.length; i++ )
//		{
//			newCards[ i ] = cards[ i ];
//		}
//		for ( ; i < newCards.length; i++ )
//		{
//			newCards[ i ] = pile.cards[ j ];
//			j++;
//		}
//		cards = newCards;
//	}//end of addDeck

	/*
	 * Description: Selects the card on top of the deck, setting that element to null. Then returns that card.
	 * @param: DeckG3 pile - an array (deck/pile) of cards
	 * @return: topCard - the top card on a pile or deck
	 * @Author: Austin Youngren
	 */
	public CardAY popCard(  )
	{
		CardAY topCard;// the top card on a pile or deck
		
		topCard = cards[topQueue];
		cards[topQueue] = null;
		topQueue++;
		sizeOfQueue--;
		if (topQueue == cards.length)
		{
			topQueue = 0;
		}
		
		return topCard;
	}
	
		/*
		 * Description: Selects the card on top of the deck, setting that element to null. Then returns that card.
		 * @param: DeckG3 pile - an array (deck/pile) of cards
		 * @return: topCard - the top card on a pile or deck
		 */
//	public CardG3 popCard( DeckG3 pile )
//	{
//		CardG3 topCard;// the top card on a pile or deck
//		int i = 0;// LCV, index reference variable
//
//		while ( ( cards[ i ] == null ) && ( i < cards.length ) )
//		{
//			i++;
//		}
//		if ( i == cards.length )
//		{
//			topCard = null;
//		}
//		else
//		{
//			topCard = pile.cards[ i ];
//			pile.cards[ i ] = null;
//		}
//		return topCard;
//	}//end of popCard

	/*
	 * Description: Takes card as argument then places that card on the bottom of specified deck
	 * @param: CardG3 card - A single card of the deck.
	 * @return: None
	 */
	public void addCard(CardAY card)
	{
		cards[bottomQueue] = card;
		bottomQueue++;
		if (bottomQueue == cards.length)
		{
			bottomQueue = 0;
		}
		sizeOfQueue++;
	}
		/*
		 * Description: Takes card as argument then places that card on the bottom of specified deck
		 * @param: CardG3 card - A single card of the deck.
		 * @return: None
		 */
//	public void addCard( CardG3 card ) 
//	{
//		int i; //LCV
//		int addingCards; //the new array length
//
//		addingCards = cards.length + 1;
//		CardG3[ ] newCards = new CardG3[ addingCards ];
//		newCards[ addingCards - 1 ] = card;
//		for ( i = 0; i < cards.length; i++ )
//		{
//			newCards[ i ] = cards[ i ];
//		}
//		cards = newCards;
//	}//end of addCard
	
		/*
		 * Description: Sets all cards to null for testing purposes
		 * @param: None
		 * @return: None
		 */
	public void nullTheDeck() 
	{
		int i;//LCV, index reference variable
		
		for (i = 0; i < (cards.length - 1); i++)
		{
			cards[i] = null;
		}
	}
		/*
		 * Description: Looks through a deck array to check if it is empty.
		 * @param: None
		 * @return: True - if the deck array is empty( All cards used ) OR False - if the deck array is not empty( Not all
		 * cards used )
		 */
	public boolean isEmpty( ) 
	{
		boolean retValue;// returns true is deck is empty, 
								//returns false if there are cards still in the deck
		if ( sizeOfQueue == 0 )
		{
			retValue = true;
		}
		else
		{
			retValue = false;
		}
		return retValue;
	}//end of isEmpty

	/*
	 * Getters and Setters
	 */

	public CardAY[ ] getCards( )
	{
		return cards;
	}

	public void setCards( CardAY[ ] cards )
	{
		this.cards = cards;
	}

	public int getBottomQueue( )
	{
		return bottomQueue;
	}

	public void setBottomQueue( int bottomQueue )
	{
		this.bottomQueue = bottomQueue;
	}

	public int getTopQueue( )
	{
		return topQueue;
	}

	public void setTopQueue( int topQueue )
	{
		this.topQueue = topQueue;
	}

	public int getSizeOfQueue( )
	{
		return sizeOfQueue;
	}

	public void setSizeOfQueue( int sizeOfQueue )
	{
		this.sizeOfQueue = sizeOfQueue;
	}


	/*
	 * Description: outputs the rank and suit of each card of a deck.
	 * @param: None
	 * @return: Output list of cards, with rank and suit, of a deck
	 */
	
	@Override
	public String toString( ) 
	{
		int i; //LCV
		String print;// returned text
		print = "DeckAY: \n";
		for ( i = 0; i < cards.length; )
		{
			if (cards[i] == null)
			{
				print = print + " " + "null, ";
			}
			else
			{
				print = print + " " + cards[ i ].toString ( );
			}
			i++;
			if ( ( i % 4 ) == 0 )
			{
				print = print + "\n";
			}
		}
		return print;
	}
}
/*
 * Problems:
 */
