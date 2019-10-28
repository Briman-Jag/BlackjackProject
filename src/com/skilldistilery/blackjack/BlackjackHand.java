package com.skilldistilery.blackjack;

import com.skilldistillery.cards.Card;

public class BlackjackHand extends Hand {

	public BlackjackHand() {

	}
	
	// Need to add the cards in hand to get complete value of Hand.
	@Override
	public int getHandValue() {
		int value = 0;
		for (Card card : cards) {
			value += card.getValue();
		}
		return value;
	}

	// If hand value = 21
	public boolean isBlackjack(BlackjackHand hand) {
		boolean blackj = false;
		if (hand.getHandValue() == 21) {
			blackj = true;
		}
		return blackj;
	}

	// if hand value > 21
	public boolean isBust(BlackjackHand hand) {
		boolean bust = false;
		if (hand.getHandValue() > 21) {
			bust = true;
			System.out.println("Busted!");
		}
		return bust;
	}



}
