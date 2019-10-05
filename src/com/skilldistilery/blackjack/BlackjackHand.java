package com.skilldistilery.blackjack;

public class BlackjackHand extends Hand {
	
	public BlackjackHand() {
		
	}

	@Override
	public int getHandValue() {
		
		return 0;
	}
	// If hand value = 21
	public boolean isBlackjack() {
		
		return true;
	}
	// if hand value > 21
	public boolean isBust() {
		
		return true;
	}
	

}
