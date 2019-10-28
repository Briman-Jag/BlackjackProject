package com.skilldistilery.blackjack;

import com.skilldistillery.cards.Card;

public class BlackjackHand extends Hand {

	public BlackjackHand() {

	}
	
	// Adds the cards in hand to get complete value of Hand.
	@Override
	public int getHandValue() {
		int value = 0;
		for (Card card : cards) {
			value += card.getValue();
		}
		return value;
	}

	// If hand value = 21
	public boolean isBlackjack() {
		boolean blackj = false;
		if (getHandValue() == 21) {
			blackj = true;
		}
		return blackj;
	}

	// if hand value > 21
	public boolean isBust() {
		boolean bust = false;
		if (getHandValue() > 21) {
			bust = true;
			System.out.println("Busted!");
		}
		return bust;
	}



}
