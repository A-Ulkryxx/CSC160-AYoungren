import java.util.Scanner;

public class TexasHoldEm
{
	static Scanner input;
	static char betsOpen;

	public static void main( String[ ] args )
	{
		input = new Scanner ( System.in );
		Boolean inGame;// evaluates if the player is still playing
		int i;//LCV, index reference variable
		long betPool = 0;//the betting pools, only one is in use unless someone goes all in
								//others will be used for players who continue to bet after the all in.
		DeckAY deck = new DeckAY ( );//The deck of playing cards
		DeckAY discard = new DeckAY ( 0 );// the discard pile
		DeckAY tableCards = new DeckAY (5, 5);
		DeckAY evaluation = new DeckAY(7, 7);
		PlayerAY[ ] players;// the players in game
		

		players = getPlayers (  );

		//while there are more than one players
		betsOpen = 'y';

		
		deck.shuffle ( );
		

		for ( i = 0; i < players.length; i++ )
		{
			System.out.println ( "evaluating player: " + i );
			inGame = players[ i ].isPlaying ( );
			if ( inGame == true )
			{
				players[ i ].dealCards ( deck );
				System.out.println ( players[ i ].getName ( ) + " cards :" + players[ i ].getHand ( )+ "\n" );
			}
			else
			{
				;
			}
		}
		betRound ( players, discard, betPool );
		getFlop(deck, discard, tableCards);
		betRound ( players, discard, betPool );
		getTurn(deck, discard, tableCards);
		betRound ( players, discard, betPool );
		getRiver(deck, discard, tableCards);
		betRound ( players, discard, betPool );

		//hand evaluation

		//round winner
		newRound ( players );//round ends 
		//end of Round while

		//congratulate winner

	}

	/*
	 * Description: Sets the amount of players who will play in the game.
	 * @param: PlayerAY[] player - all players in the game
	 * @return: None
	 */
	public static PlayerAY[] getPlayers( )
	{
		int numPlayers;// the number of players to play
		int i;//LCV, index reference variable
		String name; // a player's name

		System.out.println ( "How many players are playing?" );
		numPlayers = input.nextInt ( );
		PlayerAY[ ] players;
		players = new PlayerAY[ numPlayers ];
		for ( i = 0; i < players.length; i++ )
		{
			players[ i ] = new PlayerAY ( );
			System.out.println ( "Player " + ( i + 1 ) + ", what name would you like to use?" );
			name = input.next ( );
			players[ i ].setName ( name );
		}
		return players;
	}

	/*
	 * Description: Handles the bets of all players for the sub-round (before flop, after flop, after river 1, after
	 * river 2)
	 * @param: PlayerAY[] player - all players in the game
	 * @param: DeckAY deck - The Deck of playing cards
	 * @param: long[] betPool - the betting pools, only one is in use unless someone goes all in others will be used for
	 * players who continue to bet after the all in.
	 * @return: None
	 */
	public static void betRound( PlayerAY[ ] players, DeckAY discard, long betPool )
	{
		char decision;// betting decision.
		char allIn; // all in decision
		long bet = 0;//player's chosen bet amount
		long minBet = 0;// The highest bet in the sub-round, call decision match, 
		long playerCap = 0;// max amount of money a player can bet
		int betsIn = 0;// if the player has bet enough
		int i;// //LCV, index reference variable
		int c;
		int j;

		//		for ( c = 0; c < players.length; c++)
		//		{
		//			
		//		}
		while ( betsOpen == 'y' )
		{
			for ( i = 0; i < players.length; i++ )
			{
				playerCap = players[i].getMoney();
				if ( players[ i ].isPlaying ( ) == false )
				{
					i++;
				}
				System.out.println ( players[ i ].getName ( ) + " cards: " + players[ i ].getHand ( ) );
				System.out
						.println ( players[ i ].getName ( ) + ", would you like to check(h), call(c), bet(b), or fold(f)?" );
				decision = input.next ( ).charAt ( 0 );

				while ( ( decision == 'h' ) && ( minBet != 0 ) )
				{
					System.out.println ( "You cannot check because bets have been placed." );
					System.out.println ( "Would you like to call(c), bet(b), or fold(f)?" );
					decision = input.next ( ).charAt ( 0 );
				}

				if ( decision == 'b' )//start of bet
				{
					System.out.println ( "How much would you like to bet?" );
					bet = input.nextInt ( );
					//ensures the player can bet the amount
					while ( ( bet <= minBet )  ) //|| ( bet >= playerCap )
					{
						if ( bet <= minBet )
						{
							System.out.println ( "Current bet is $" + minBet + ". Your bet of $" + bet
									+ " must be large than the current bet." );
							System.out.println ( "How much would you like to bet?" );
							bet = input.nextInt ( );
						}
//						else if ( bet >= playerCap )
//						{
//							System.out.println ( "You cannot bet $" + bet + ". You only have $" + playerCap + " to bet." );
//							System.out.println ( "Would you like to go all in?(y/n)" );
//							allIn = input.next ( ).charAt ( 0 );
//							if ( allIn == 'y' )
//							{
//								bet = playerCap;
//								players[ i ].placeBet ( bet );
//								betPool = betPool + bet;
//								minBet = bet;
//								System.out.println ( players[ i ].getName ( ) + " bet" + minBet );
//								for ( j = 0; j < players.length; j++ )
//								{
//									if ( ( j != i ) && ( players[ j ].isPlaying ( ) == true )
//											&& ( players[ j ].getSubBet ( ) != minBet ) )
//									{
//										System.out.println (
//												players[ i ].getName ( ) + " has gone all in with" + minBet + ". Would you, "
//														+ players[ j ].getName ( ) + ", like to match the bet(b) or fold(f)?" );
//										allIn = input.next ( ).charAt ( 0 );
//										if ( allIn == 'b' )
//										{
//											if ( players[ j ].getMoney ( ) < minBet )
//											{
//												System.out.println ( players[ j ].getName ( )
//														+ " doesn't have enough money to compete. Player folds." );
//												players[ j ].fold ( discard );
//											}
//											else
//											{
//												players[ j ].playerCall ( minBet );
//												betPool = betPool + minBet;
//												players[ j ].setSubBet ( minBet );
//											}
//										}
//										else
//										{
//											players[ j ].fold ( discard );
//										}
//									}
//								}
//								betsOpen = 'n';
//							}
//							else
//							{
//								;
//							}
//						}
						else
						{
							minBet = bet;
							betPool = betPool + bet;
							System.out.println ( players[ i ].getName ( ) + " bet" + minBet );
						}
					}
				}//end of bet

				else if ( decision == 'c' )//start of call
				{
					if ( minBet >= playerCap )
					{
						System.out.println ( "You cannot bet $" + minBet + ". You only have $" + playerCap + " to bet." );
						System.out.println ( "Would you like to go all in?(y/n)" );
						allIn = input.next ( ).charAt ( 0 );
//						if ( allIn == 'y' )
//						{
//							bet = playerCap;
//							players[ i ].placeBet ( bet );
//							betPool = betPool + bet;
//							minBet = bet;
//							System.out.println ( players[ i ].getName ( ) + " bet" + minBet );
//							for ( j = 0; j < players.length; j++ )
//							{
//								if ( ( j != i ) && ( players[ j ].isPlaying ( ) == true ) )
//								{
//									System.out.println (
//											players[ i ].getName ( ) + " has gone all in with" + minBet + ". Would you, "
//													+ players[ j ].getName ( ) + ", like to match the bet(b) or fold(f)?" );
//									allIn = input.next ( ).charAt ( 0 );
//									if ( allIn == 'b' )
//									{
//										if ( players[ j ].getMoney ( ) < minBet )
//										{
//											System.out.println ( players[ j ].getName ( )
//													+ " doesn't have enough money to comepete. Player folds." );
//											players[ j ].fold ( discard );
//										}
//										else
//										{
//											players[ j ].playerCall ( minBet );
//											betPool = betPool + minBet;
//											players[ j ].setSubBet ( minBet );
//										}
//									}
//								}
//
//							}
//							betsOpen = 'n';
//						}
//						else
//						{
//							players[ i ].fold ( discard );
//						}
					}// end of call
					else
					{
						players[ i ].playerCall ( minBet );
						betPool = betPool + minBet;
					}
				}

				else if ( decision == 'f' )
				{
					players[ i ].fold ( discard );
				}

				else
				{
					;
				}
			}
		}
		
	}

	public static void newRound( PlayerAY[ ] players )
	{
		int i;
		for ( i = 0; i < players.length; i++ )
		{
			if ( players[ i ].getMoney ( ) != 0 )
			{
				players[ i ].setPlaying ( true );
			}
			betsOpen = 'y';
		}
	}
	
	public static void getFlop(DeckAY deck, DeckAY discard, DeckAY tableCards)
	{
		CardAY card = new CardAY();
		
		card = deck.popCard ( );
		discard.addCard ( card );
		
		card = deck.popCard ( );
		tableCards.addCard ( card );
		
		card = deck.popCard ( );
		tableCards.addCard ( card );
		
		card = deck.popCard ( );
		tableCards.addCard ( card );
		
		System.out.println("Cards on the flop: " + tableCards.getCards ( ));
	}
	
	public static void getTurn(DeckAY deck, DeckAY discard, DeckAY tableCards)
	{
		CardAY card = new CardAY();
		
		card = deck.popCard ( );
		discard.addCard ( card );
		card = deck.popCard ( );
		tableCards.addCard ( card );
		
		System.out.println("Table cards with the turn: " + tableCards.getCards ( ));
	}
	
	public static void getRiver(DeckAY deck, DeckAY discard, DeckAY tableCards)
	{
		CardAY card = new CardAY();
		
		card = deck.popCard ( );
		discard.addCard ( card );
		card = deck.popCard ( );
		tableCards.addCard ( card );
		
		System.out.println("Table cards with the river: " + tableCards.getCards ( ));
	}
	
	
}
