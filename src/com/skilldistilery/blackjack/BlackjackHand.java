package com.skilldistilery.blackjack;

import com.skilldistillery.cards.Card;

public class BlackjackHand extends Hand {

	public BlackjackHand() {

	}
	
	// Need to add the cards in hand to get complete value of Hand.
	@Override
	public int getHandValue() {
		
		return ((Card) cards).getValue();
	}

	// If hand value = 21
	public boolean isBlackjack() {
		boolean blackj = false;
		if (((Card) cards).getValue() == 21) {
			blackj = true;
		}
		return blackj;
	}

	// if hand value > 21
	public boolean isBust() {
		boolean bust = false;
		if (((Card) cards).getValue() > 21) {
			bust = true;
			System.out.println("Busted!");
		}
		return bust;
	}



}
