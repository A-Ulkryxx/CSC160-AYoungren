import java.util.Scanner;

/*Austin Youngren, Emily Lederman
 * War 5
 * 11/18/21
 * CardG3, DeckG3, WarG3
 * The game of War. This is a game where players evenly split a deck of cards between each player. 
 * Players then each play a card from the top of the deck to middle playing field(middle pile).
 * When each player plays one card, the winner is determined my the higher card. 
 * The winner then takes both cards and adds it to the bottom of their respective pile.
 * If the played cards in the playing field are of same value, 
 * each player plays another card until a player has a higher value. 
 * The player with all of the cards from all piles wins.
 */
public class War8G3
{
	static Scanner input;

	public static void main( String[ ] args )
	{
		input = new Scanner ( System.in );
		
		char play; // initiates game by user prompt
		int i; //LCV, 
		boolean done = false;
		CardG3 card1 = new CardG3 ( );  //The first card of the deck
		CardG3 card2 = new CardG3 ( );  // The second card of the deck
		DeckG3 cards = new DeckG3 ( ); // A standard deck of 52 cards
		DeckG3 p1Deck = new DeckG3 ( 0 ); // player one's pile of cards
		DeckG3 p2Deck = new DeckG3 ( 0 );// player two's pile of cards
		DeckG3 middlePile = new DeckG3 ( 0 );// the playing field

//		changeFace(card1, 2, 2);
		cards.shuffle ( );
		p1Deck = cards.getSubDeck ( 0, 25 );
		p2Deck = cards.getSubDeck ( 26, 51 );
		
//		p1Deck.popCard();
//		card1.setRank ( 14 );
//		p1Deck.addCard ( card1 );
//		p1Deck.popCard();
//		p1Deck.addCard ( card1 );
//		p1Deck.popCard();
//		p1Deck.addCard ( card1 );
//		p1Deck.popCard();
//		p1Deck.addCard ( card1 );
//		p1Deck.popCard();
//		p1Deck.addCard ( card1 );
		do
		{
			card1 = p1Deck.popCard (  );
			card2 = p2Deck.popCard (  );

			System.out.println ( "Player 1: " + card1 + ", Player 2: " + card2 );

			middlePile.addCard ( card1 );
			middlePile.addCard ( card2 );

			
			if ( card1.compareTo ( card2 ) == 0 )
			{
				
				while ( (card1.compareTo ( card2 ) == 0) && (done == false))
				{
					
					System.out.println ( "Tie, press 'y' when ready to continue. " );
					play = input.next ( ).charAt ( 0 );
					if ( play == 'y' )
					{
						if ((p1Deck.getSizeOfQueue ( ) < 4) )
						{
							done = true;
							p2Deck.addDeck ( p1Deck );
							p2Deck.addDeck(middlePile);
						}
						else if((p2Deck.getSizeOfQueue ( ) < 4))
						{
							done = true;
							p1Deck.addDeck ( p2Deck );
							p1Deck.addDeck(middlePile);
						}	
						else
						{
							for (i = 0; i < 3; i++)
							{
								card1 = p1Deck.popCard (  );
								card2 = p2Deck.popCard (  );
								middlePile.addCard ( card1 );
								middlePile.addCard ( card2 );
							}
							card1 = p1Deck.popCard (  );
							card2 = p2Deck.popCard (  );
							System.out.println ( "Player 1: " + card1 + " Player 2: " + card2 );
							middlePile.addCard ( card1 );
							middlePile.addCard ( card2 );
						}
					}
				}
				System.out.println(p1Deck.toString());
				System.out.println(p2Deck.toString());
			}
			if ( card1.compareTo ( card2 ) == 1 )
			{
				p1Deck.addDeck ( middlePile );
				System.out.println ( "Player 1 wins\n" );
				
			}
			else
			{
				p2Deck.addDeck ( middlePile );
				System.out.println ( "Player 2 wins\n" );
			}
			middlePile.nullTheDeck ( );

		}while (  ( p1Deck.isEmpty ( ) == false ) && ( p2Deck.isEmpty ( ) == false ) );
		
		if ( p1Deck.isEmpty ( ) == true )
		{
			System.out.println ( "Game Finished: Player 2 Wins " );
			System.out.println("P1: " + p1Deck.toString());
			System.out.println("P2: " + p2Deck.toString());
		}
		else if ( p2Deck.isEmpty ( ) == true )
		{
			System.out.println ( "Game Finished: Player 1 Wins" );
			System.out.println("P1: " + p1Deck.toString());
			System.out.println("P2: " + p2Deck.toString());
		}
		
		p1Deck.nullTheDeck ( );
		p2Deck.nullTheDeck();
		cards.organizer ( );
	}
	
	/*
	 * Description: Changes the Rank and suit of a card
	 * @param: CardG3 card - the card to be changed
	 * @param: int newRank - the rank that card will be changed to
	 * @param: int newSuit - the suit that card will be changed to
	 * @return: None
	 */
	public static void changeFace(CardG3 card, int newRank, int newSuit)
	{
		card.setRank(newRank);
		card.setSuit ( newSuit );
		showCard(card);
	}
	
	/*
	 * Description:Organizes a deck of cards by suit then organizes by suit's rank
	 * @param: None
	 * @return: None
	 */
	public static void showCard(CardG3 card)
	{
		System.out.println( card.CARD_RANK[card.getRank ( )] + " of " + card.CARD_SUIT[card.getSuit ( )]);
	}
}
//Problems: None