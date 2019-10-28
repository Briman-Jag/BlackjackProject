package com.skilldistillery.casino;

import java.util.Scanner;

import com.skilldistilery.blackjack.Dealer;

public class CasinoApp {

	private Scanner kb = new Scanner(System.in);
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

		System.out.println("Let's play Blackjack! Feeling Lucky???");
		System.out.println();
		dealer.firstDeal(); // Initiates games first deal
		dealer.playerCheck(); // Checks if player has Blackjack from start
		dealer.dealerCheck(); // Checks if dealer has blackjack or has busted
		decisionMenu(); // Brings up players option menu to Hit, Stay, or Quit
		userDecision(); // User chooses to HIT, STAY, or quit
		dealer.playerCheck(); // Checks if player has black jack or has busted

		// After player decides to stay and has not gone over 21
		dealer.dealerHitOrStay(); // Logic for dealer to decide to Hit or Stay
		dealer.dealerCheck();
		dealer.compareHands();

		kb.close();
		System.exit(0);

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
		boolean valid = false;
		// Do/while loop to ensure input is valid integer and not string
		do {
			if (kb.hasNextInt()) {
				choice = kb.nextInt();
				valid = true;
			} else {
				kb.nextLine();
				System.out.println("Please enter valid number choice.");
			}
		} while (!valid);
		switch (choice) {

		case 1:
			System.out.println("You HIT");
			dealer.nextDealPlayer();
			dealer.playerCheck();
			decisionMenu();
			userDecision();
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
			decisionMenu();
			choice = kb.nextInt();
		}

	}
}
