package com.skilldistilery.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class Dealing {
	private int playerValue;
	private int dealerValue;
	private Card c = new Card(null, null);
	private List<Card> phand = new ArrayList<>();
	private List<Card> dhand = new ArrayList<>();
	private Deck deck = new Deck();
	private BlackjackHand bHand = new BlackjackHand();

	public Dealing() {

	}

	public void firstDeal() {

		deck.shuffle();

		// Player being dealt first card
		c = deck.dealCard();
		playerValue += c.getValue();
		phand.add(c);
		System.out.println("*The dealer deals your first card face up*");
		displayCard(phand);

		// Dealer deals their card facedown
		c = deck.dealCard();
		dealerValue += c.getValue();
		dhand.add(c);
		System.out.println("*Dealer deals their first card facedown*");

		// Player being dealt second card
		System.out.println("*The dealer deals your second card faceup*");
		c = deck.dealCard();
		playerValue += c.getValue();
		phand.add(c);
		System.out.println("Your hand is:");
		displayCardsAndValue(phand, playerValue);

		// Dealer deals their second card face up
		System.out.println("*The dealer deals their second card faceup*");
		c = deck.dealCard();
		dealerValue += c.getValue();
		dhand.add(c);
		System.out.println(c.toString());
//		System.out.println(deck.checkDeckSize() + " cards left in deck.");
	}

	public void nextDealPlayer() {
		System.out.println("*Dealer deals next card*");
		c = deck.dealCard();
		playerValue += c.getValue();
		phand.add(c);
		System.out.println("Your hand is:");
		displayCardsAndValue(phand, playerValue);

	}

	public void nextDealDealer() {
		System.out.println("*The dealer deals their third card faceup*");
		c = deck.dealCard();
		dealerValue += c.getValue();
		dhand.add(c);
		System.out.println(c.toString());
	}
	
	public void checkDealerHand(List<Card> hand) {
		
		
		
	}

	public void displayCard(List<Card> hand) {

		System.out.println(hand);
	}

	public void displayCardsAndValue(List<Card> hand, int value) {

		for (Card c : hand) {
			System.out.println(c);
		}
		System.out.println("Total card value= " + value);
	}

}
