package com.skilldistillery.casino;

import java.util.List;

import com.skilldistilery.blackjack.BlackjackHand;
import com.skilldistilery.blackjack.Dealing;
import com.skilldistillery.cards.Card;


public class Dealer extends BlackjackHand implements Table{
	@Override
	public int getHandValue() {
		
		return 0;
	}
	// Could maybe use this to initiate game and deal cards onto table
	// And/or indicate whose turn it is
	@Override
	public void playGame() {
		System.out.println("[Dealer wait's patiently for their next challenger at the Blackjack Table]");
		
	}
	

	

	
}
