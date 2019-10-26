package com.skilldistilery.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class Dealer {
	// DELETE as code related to fields are replaced
//	private int playerValue;
//	private int dealerValue;
//	private Card c = new Card(null, null);
//	private List<Card> phand = new ArrayList<>();
//	private List<Card> dhand = new ArrayList<>();
	private Deck deck = new Deck();
	private Hand dHand = new BlackjackHand(); // Dealers Hand
	private Hand pHand = new BlackjackHand();	// Players Hand
	
	public Dealer() {

	}

	public void firstDeal() {
		System.out.println("*Dealer shuffles deck*");
		// Player being dealt first card
		deck.dealCard(pHand);

//		playerValue += c.getValue();
//		phand.add(c);
		System.out.println("*The dealer deals your first card face up*");
		displayCard(pHand);

		// Dealer deals their card facedown
		deck.dealCard(dHand);
		System.out.println("*Dealer deals their first card facedown*");

		// Player being dealt second card
		System.out.println("*The dealer deals your second card faceup*");
		c = deck.dealCard();
		System.out.println("Hand is now: [" + pHand.get + "]");
//		phand.getHandValue() += c.getValue();
        deck.dealCard(pHand);
		System.out.println();
		System.out.println("Your hand is:");
		displayCardsAndPlayerValue(pHand, pHand.getHandValue());
		System.out.println();

		// Dealer deals their second card face up
		System.out.println("*The dealer deals their second card faceup*");
		c = deck.dealCard();
//		dhand.getHandValue() += c.getValue();
		dHand.add(c);
		System.out.println(c.toString());

	}

	public void nextDealPlayer() {
		System.out.println("*Dealer deals next card*");
		deck.dealCard(pHand);
		System.out.println(c.toString());
//		phand.getHandValue() += c.getValue();
//		pHand.add(c);
		System.out.println("Your hand is now:");
		displayCardsAndPlayerValue(pHand, pHand.getHandValue());
		System.out.println();

	}

	public void nextDealDealer() {
		System.out.println("*The dealer deals their next card faceup*");
		c = deck.dealCard();
		dhand.getHandValue() += c.getValue();
		dHand.add(c);
		System.out.println(c.toString());
		System.out.println();
	}

	public void playerCheck() {

		if (pHand.isBlackjack(pHand.getHandValue()) == true) {
			System.out.println("You got 21! Winner winner!!!");
			System.out.println("*****Winning hand*****");
			displayCardsAndPlayerValue(pHand, pHand.getHandValue());
			System.out.println("You got lucky! Good game!");
			System.exit(0);
		} else if (pHand.isBust(pHand.getHandValue()) == true) {
			System.out.println("You Lose!");
			System.out.println("Too bad! Thanks for playing!");
			System.exit(0);
		} else {

		}

	}

	public void dealerCheck() {
		if (dHand.isBlackjack(dHand.getHandValue()) == true) {
			System.out.println("Dealer has won! Game over!");
			System.out.println("Dealers winning hand:");
			displayCardsAndDealerValue(dHand, dHand.getHandValue());
			System.out.println();
			System.out.println("Your losing hand:");
			displayCardsAndDealerValue(pHand, pHand.getHandValue());
			System.out.println("Too bad! Thanks for playing!");
			System.exit(0);

		} else if (dHand.isBust(dHand.getHandValue()) == true) {
			System.out.println("...Dealers losing hand...");
			displayCardsAndDealerValue(dHand, dHand.getHandValue());
			System.out.println("Dealer busts! You win!");
			System.out.println();
			System.out.println("*****Winning hand*****");
			displayCardsAndPlayerValue(pHand, pHand.getHandValue());
			System.out.println("You got lucky! Good game!");
			System.exit(0);

		}

	}

	public void dealerHitOrStay() {
		while (dHand.getHandValue() < 18) {
			System.out.println("*Dealer Hits*");
			nextDealDealer(); // Dealer deals their next card
			dealerCheck(); // Checks if dealer has blackjack or has busted
		}
		System.out.println("*Dealer STAYS and flips their facedown card*");

	}

	public void displayCard(Hand hand) {

		System.out.println(hand);
	}

	
	public void displayCardsAndPlayerValue() {
		
		System.out.println("Total value = " + pHand.getHandValue());
	}
	
	public void displayCardsAndDealerValue() {
		
		System.out.println("Total value = " + pHand.getHandValue());
	}
	

	public void compareHands() {
		if (pHand.getHandValue() > dHand.getHandValue()) {
			System.out.println("You win!");
			System.out.println("Dealers losing hand");
			System.out.println();
			displayCardsAndDealerValue(dHand, dHand.getHandValue());
			System.out.println();
			System.out.println("*****Winning hand*****");
			displayCardsAndPlayerValue(pHand, pHand.getHandValue());
			System.out.println("You got lucky! Good game!");
			System.exit(0);

		} else if (pHand.getHandValue() < dHand.getHandValue()) {
			System.out.println("You lose!");
			System.out.println("Dealers winning hand:");
			displayCardsAndDealerValue(dHand, dHand.getHandValue());
			System.out.println();
			System.out.println("Your losing hand:");
			displayCardsAndPlayerValue(pHand, pHand.getHandValue());
			System.out.println("Too bad! Thanks for playing!");
			System.exit(0);

		} else {
			System.out.println("PUSH!");
			System.out.println("Card values are tied");
			System.out.println("No winner!");
			System.out.println();
			System.out.println("Dealers Hand:");
			displayCardsAndDealerValue(dHand, dHand.getHandValue());
			System.out.println();
			System.out.println("Players Hand:");
			displayCardsAndPlayerValue(pHand, pHand.getHandValue());
			System.exit(0);

		}
	}

}
