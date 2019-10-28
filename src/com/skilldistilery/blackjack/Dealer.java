package com.skilldistilery.blackjack;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class Dealer {
	private Deck deck = new Deck();
	private BlackjackHand dHand = new BlackjackHand(); // Dealers Hand
	private BlackjackHand pHand = new BlackjackHand(); // Players Hand

	public Dealer() {

	}

	public void firstDeal() {
		System.out.println("*Dealer shuffles deck*");
		// Player being dealt first card
		deck.dealCard(pHand);
		System.out.println("*The dealer deals your first card face up*");
		displayCard(pHand);

		// Dealer deals their card facedown
		deck.dealCard(dHand);
		System.out.println("*Dealer deals their first card facedown*");

		// Player being dealt second card
		System.out.println("*The dealer deals your second card faceup*");
		deck.dealCard(pHand);
		displayCardsAndPlayerValue(pHand, pHand.getHandValue());
		System.out.println();

		// Dealer deals their second card face up
		System.out.println("*The dealer deals their second card faceup*");
		deck.dealCard(dHand);
		dealerFaceUpCard(dHand);
		System.out.println();

	}

	public void nextDealPlayer() {
		System.out.println("*Dealer deals next card*");
		deck.dealCard(pHand);
		System.out.println(pHand);
		displayCardsAndPlayerValue(pHand, pHand.getHandValue());
		System.out.println();
	}

	public void nextDealDealer() {
		System.out.println("*The dealer deals their next card faceup*");
		deck.dealCard(dHand);
		dealerFaceUpCard(dHand);
		System.out.println();
	}

	public void playerCheck() {

		if (pHand.isBlackjack(pHand)) {
			System.out.println("You got 21! Winner winner!!!");
			System.out.println("*****Winning hand*****");
			displayCardsAndPlayerValue(pHand, pHand.getHandValue());
			System.out.println("You got lucky! Good game!");
			System.exit(0);
		} else if (pHand.isBust(pHand)) {
			System.out.println("You Lose!");
			System.out.println("Too bad! Thanks for playing!");
			System.exit(0);
		} 
	}

	public void dealerCheck() {
		if (dHand.isBlackjack(dHand)) {
			System.out.println("Dealer has won! Game over!");
			System.out.println("Dealers winning hand:");
			displayCardsAndDealerValue(dHand, dHand.getHandValue());
			System.out.println();
			System.out.println("Your losing hand:");
			displayCardsAndDealerValue(pHand, pHand.getHandValue());
			System.out.println("Too bad! Thanks for playing!");
			System.exit(0);

		} else if (dHand.isBust(dHand)) {
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

	public void dealerFaceUpCard(Hand hand) {
		Card card = hand.getCards().get(hand.getCards().size() - 1);
		System.out.println(card);

	}

	public void displayCardsAndPlayerValue(Hand pHand, int handValue) {
		System.out.println("Players hand is: " + pHand);
		System.out.println("Total value = " + handValue);
	}

	public void displayCardsAndDealerValue(Hand dHand, int handValue) {
		System.out.println("Dealerss hand is: " + dHand);
		System.out.println("Total value = " + handValue);
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
