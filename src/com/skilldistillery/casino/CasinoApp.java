package com.skilldistillery.casino;

import java.util.List;
import java.util.Scanner;

import com.skilldistilery.blackjack.Dealing;
import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class CasinoApp {

	Scanner kb = new Scanner(System.in);
	private Deck deck = new Deck();
	private Dealing deal = new Dealing();
	private Dealer dealer = new Dealer();
	private Player player = new Player();

	public static void main(String[] args) {
		CasinoApp cApp = new CasinoApp();

		cApp.launch();

	}

	private void launch() {

		blackJack();
	}

	public void blackJack() {
		boolean keepGoing = true;
		String yesNo = "";
		System.out.println("Let's play Blackjack! Feeling Lucky???");
		dealer.playGame();
		player.playGame();

		while (keepGoing) {
			System.out.println("*Dealer shuffles deck*");
			deck.shuffle();
			System.out.println();
			deal.firstDeal(); // Initiates games first deal
			deal.playerCheck(); // Checks if player has Blackjack from start
			decisionMenu(); // Brings up players option menu to Hit, Stay, or Quit
			userDecision();
			deal.playerCheck(); // Checks if player has black jack or has busted
			// If not dealers turn
			deal.nextDealDealer();
			deal.dealerCheck(); // Checks if dealer has blackjack or has busted
			deal.dealerHitOrStay(); // Logic for dealer to decide to Hit or Stay
			deal.dealerCheck(); // Checks if dealer has blackjack or has busted
			deal.compareHands();
			
			System.out.println("Another Game?");
			System.out.println("Press Enter for yes or quit to stop: ");
			yesNo = kb.next();
			if (yesNo.equalsIgnoreCase("quit")) {
				System.out.println("Thanks for playing!");
				kb.close();
				System.exit(0);
			}

		}

	}

	private void decisionMenu() {
		System.out.println("_______________________________________________");
		System.out.println("Would you like to HIT for another card or STAY");
		System.out.println("1. HIT");
		System.out.println("2. STAY");
		System.out.println("3. Quit");
	}

	private void userDecision() {

		int choice = 0;
		while (choice != 2) {
			choice = kb.nextInt();
			switch (choice) {
			// Uses nextDeal() to get next card and add it to playerValue
			case 1:
				System.out.println("You HIT");
				deal.nextDealPlayer();
				decisionMenu();
				break;
			case 2:
				System.out.println("You STAY");
				break;
			case 3:
				System.out.println("Thanks for playing! Goodbye!");
				kb.close();
				System.exit(0);
				break;
			default:
				System.out.println("Not a valid option!");
			}
		}
	}

	// Use comparator to compare hand values of dealer and player if neither busts
	public void compareHands() {

	}

}
