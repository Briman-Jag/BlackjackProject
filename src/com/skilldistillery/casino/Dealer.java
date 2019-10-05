package com.skilldistillery.casino;

import com.skilldistilery.blackjack.BlackjackHand;


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
