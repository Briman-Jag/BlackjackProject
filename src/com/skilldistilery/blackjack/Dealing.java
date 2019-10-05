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
		System.out.println("[" + c.toString() + "]");
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
		System.out.println("Your hand is now:");
		displayCardsAndValue(phand, playerValue);

	}

	public void nextDealDealer() {
		System.out.println("*The dealer deals their third card faceup*");
		c = deck.dealCard();
		dealerValue += c.getValue();
		dhand.add(c);
		System.out.println(c.toString());
		System.out.println();
	}

	public void playerCheck() {

		if (bHand.isBlackjack(playerValue) == true) {
			System.out.println("Player has Blackjack and wins!!!");
			System.exit(0);
		} else if (bHand.isBust(playerValue) == true) {
			System.out.println("You Lose!");
			System.exit(0);
		} else {
			System.out.println();
			System.out.println("________Next turn_________");
		}

	}

	public void dealerCheck() {
		if (bHand.isBlackjack(dealerValue) == true) {
			System.out.println("Dealer has Blackjack and wins! Game over!");
			System.out.println("Dealers winning hand:");
			displayCardsAndValue(dhand, dealerValue);
			System.out.println();
			System.out.println("Your losing hand:");
			displayCardsAndValue(phand, playerValue);
			System.exit(0);
		} else if (bHand.isBust(dealerValue) == true) {
			displayCardsAndValue(dhand, dealerValue);
			System.out.println("Dealer busts! You win!");
			System.out.println();
			System.out.println("*****Winning hand*****");
			displayCardsAndValue(phand, playerValue);
			System.exit(0);
		} else {
			System.out.println();
		}

	}

	public void dealerHitOrStay() {
		while (dealerValue < 18) {
			System.out.println("*Dealer Hits*");
			nextDealDealer();
		}
		System.out.println("*Dealer Stays*");

	}

	public void displayCard(List<Card> hand) {

		System.out.println(hand);
	}

	public void displayCardsAndValue(List<Card> hand, int value) {

		for (Card c : hand) {
			System.out.println(c);
		}
		System.out.println("Total value = " + value);
	}

	public void compareHands() {
		if (playerValue > dealerValue) {
			System.out.println("You win!");
			System.out.println("Dealers losing hand");
			displayCardsAndValue(dhand, dealerValue);
			System.out.println("*****Winning hand*****");
			displayCardsAndValue(phand, playerValue);
			System.exit(0);
		} else if (playerValue < dealerValue) {
			System.out.println("You lose!");
			System.out.println("Dealers winning hand:");
			displayCardsAndValue(dhand, dealerValue);
			System.out.println();
			System.out.println("You're losing hand:");
			displayCardsAndValue(phand, playerValue);
			System.out.println("!!!!!GAME OVER!!!!!");
			System.exit(0);
		} else {
			System.out.println("PUSH!");
			System.out.println("Card values are tied");
			System.out.println("No winner!");
			System.out.println();
			System.out.println("Dealers Hand:");
			displayCardsAndValue(dhand, dealerValue);
			System.out.println();
			System.out.println("Players Hand:");
			displayCardsAndValue(phand, playerValue);
			System.exit(0);
		}
	}

}
