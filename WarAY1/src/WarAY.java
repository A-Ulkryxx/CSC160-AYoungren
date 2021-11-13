/*Austin Youngren
 * War 1
 * 11/15/21
 * CardAY
 * The game of War. This is a game where players evenly split a deck of cards between each player. 
 * Players then each play a card from the top of the deck to middle playing field(middle pile).
 * When each player plays one card, the winner is determined my the higher card. 
 * The winner then takes both cards and adds it to the bottom of their respective pile.
 * If the played cards in the playing field are of same value, 
 * each player plays another card until a player has a higher value. 
 * The player with all of the cards from all piles wins.
 */
public class WarAY
{
	public static void main( String[ ] args )
	{
		CardAY card1 = new CardAY ( );  //The first card of the deck
		CardAY card2 = new CardAY ( "Ace", "Spades" );  // The second card of the deck

		System.out.println ( "Card one: " + card1.getRank ( ) + " of " + card1.getSuit ( ) );
		System.out.println ( "Card two: " + card2.getRank ( ) + " of " + card2.getSuit ( ) );

		card1.setRank ( "King" );
		card1.setSuit ( "Hearts" );

		System.out.println ( "Card one change: " + card1.getRank ( ) + " of " + card1.getSuit ( ) );
	}
}
//Problems: None