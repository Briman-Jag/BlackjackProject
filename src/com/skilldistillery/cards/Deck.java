package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.skilldistilery.blackjack.Hand;

public class Deck {

	private List<Card> cards;

	public Deck() {
		this.cards = createDeck();
	}

	private List<Card> createDeck() {
		List<Card> deck = new ArrayList<>(52);
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add( new Card(r,s));				
			}
		}
		return deck;
	}

	public int checkDeckSize() {
		return cards.size();
	}

	public Card dealCard() {
		return cards.remove(0);
	}

	
	// Takes card away from deck and then puts it into hand of dealer or player
	public void dealCard(Hand hand) {
		dealCard(hand);
	}

	public void shuffle() {
		Collections.shuffle(cards);

	}

}
