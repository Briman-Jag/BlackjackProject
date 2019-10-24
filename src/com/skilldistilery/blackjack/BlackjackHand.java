package com.skilldistilery.blackjack;

public class BlackjackHand extends Hand {
	private int value;

	public BlackjackHand() {

	}

	@Override
	public int getHandValue() {

		return 0;
	}

	// If hand value = 21
	public boolean isBlackjack(int value) {
		boolean blackj = false;
		if (value == 21) {
			blackj = true;
		}
		return blackj;
	}

	// if hand value > 21
	public boolean isBust(int value) {
		boolean bust = false;
		if (value > 21) {
			bust = true;
			System.out.println("Busted!");
		}
		return bust;
	}

	@Override
	public int addCard() {
		// TODO Auto-generated method stub
		return 0;
	}

}
