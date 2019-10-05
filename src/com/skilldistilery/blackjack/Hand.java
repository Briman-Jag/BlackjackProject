package com.skilldistilery.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;

public abstract class Hand {
	
	List<Card> cards = new ArrayList<>();
	
	
	public Hand() {
		
	}
	
	public void addCard(Card card) {
		
	}
	
	public void clear() {
		
	}
	
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