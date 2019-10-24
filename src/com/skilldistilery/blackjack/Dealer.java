package com.skilldistilery.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class Dealer{

	private int playerValue;
	private int dealerValue;
	private Card c = new Card(null, null);
	private List<Card> phand = new ArrayList<>();
	private List<Card> dhand = new ArrayList<>();
	private Deck deck = new Deck();
	private BlackjackHand bHand = new BlackjackHand();
	
	public Dealer() {

	}


	public void firstDeal() {
		System.out.println("*Dealer shuffles deck*");
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
		System.out.println();
		System.out.println("Your hand is:");
		displayCardsAndValue(phand, playerValue);
		System.out.println();

		// Dealer deals their second card face up
		System.out.println("*The dealer deals their second card faceup*");
		c = deck.dealCard();
		dealerValue += c.getValue();
		dhand.add(c);
		System.out.println(c.toString());

	}

	public void nextDealPlayer() {
		System.out.println("*Dealer deals next card*");
		c = deck.dealCard();
		System.out.println(c.toString());
		playerValue += c.getValue();
		phand.add(c);
		System.out.println("Your hand is now:");
		displayCardsAndValue(phand, playerValue);
		System.out.println();

	}

	public void nextDealDealer() {
		System.out.println("*The dealer deals their next card faceup*");
		c = deck.dealCard();
		dealerValue += c.getValue();
		dhand.add(c);
		System.out.println(c.toString());
		System.out.println();
	}

	public void playerCheck() {

		if (bHand.isBlackjack(playerValue) == true) {
			System.out.println("You got 21! Winner winner!!!");
			System.out.println("*****Winning hand*****");
			displayCardsAndValue(phand, playerValue);
			System.out.println("You got lucky! Good game!");
			System.exit(0);
		} else if (bHand.isBust(playerValue) == true) {
			System.out.println("You Lose!");
			System.out.println("Too bad! Thanks for playing!");
			System.exit(0);
		} else {

		}

	}

	public void dealerCheck() {
		if (bHand.isBlackjack(dealerValue) == true) {
			System.out.println("Dealer has won! Game over!");
			System.out.println("Dealers winning hand:");
			displayCardsAndValue(dhand, dealerValue);
			System.out.println();
			System.out.println("Your losing hand:");
			displayCardsAndValue(phand, playerValue);
			System.out.println("Too bad! Thanks for playing!");
			System.exit(0);

		} else if (bHand.isBust(dealerValue) == true) {
			System.out.println("...Dealers losing hand...");
			displayCardsAndValue(dhand, dealerValue);
			System.out.println("Dealer busts! You win!");
			System.out.println();
			System.out.println("*****Winning hand*****");
			displayCardsAndValue(phand, playerValue);
			System.out.println("You got lucky! Good game!");
			System.exit(0);

		}

	}

	public void dealerHitOrStay() {
		while (dealerValue < 18) {
			System.out.println("*Dealer Hits*");
			nextDealDealer(); // Dealer deals their next card
			dealerCheck(); // Checks if dealer has blackjack or has busted
		}
		System.out.println("*Dealer STAYS and flips their facedown card*");

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
			System.out.println();
			System.out.println("*****Winning hand*****");
			displayCardsAndValue(phand, playerValue);
			System.out.println("You got lucky! Good game!");
			System.exit(0);

		} else if (playerValue < dealerValue) {
			System.out.println("You lose!");
			System.out.println("Dealers winning hand:");
			displayCardsAndValue(dhand, dealerValue);
			System.out.println();
			System.out.println("Your losing hand:");
			displayCardsAndValue(phand, playerValue);
			System.out.println("Too bad! Thanks for playing!");
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
