package com.skilldistilery.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;

public abstract class Hand {

	protected List<Card> cards = new ArrayList<>();

	public Hand() {

	}

	public abstract int addCard();

	public abstract int getHandValue();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cards: ");
		builder.append(cards);
		builder.append("");
		return builder.toString();
	}

}
