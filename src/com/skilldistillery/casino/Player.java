package com.skilldistillery.casino;

import com.skilldistilery.blackjack.BlackjackHand;


public class Player extends BlackjackHand implements Table{

	@Override
	public int getHandValue() {
		
		return 0;
	}

	@Override
	public void playGame() {
		System.out.println("[You sit down at the Blackjack table]");
	}
	
	

}
