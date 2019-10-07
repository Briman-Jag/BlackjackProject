package com.skilldistillery.casino;

import java.util.InputMismatchException;
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

		System.out.println("Let's play Blackjack! Feeling Lucky???");
		dealer.playGame();
		player.playGame();

		System.out.println();
		deal.firstDeal(); // Initiates games first deal
		deal.playerCheck(); // Checks if player has Blackjack from start
		deal.dealerCheck(); // Checks if dealer has blackjack or has busted
		decisionMenu(); // Brings up players option menu to Hit, Stay, or Quit
		userDecision(); // User chooses to HIT, STAY, or quit
		deal.playerCheck(); // Checks if player has black jack or has busted

		// After player decides to stay and has not gone over 21
		deal.dealerHitOrStay(); // Logic for dealer to decide to Hit or Stay
		deal.dealerCheck();
		deal.compareHands();

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

		try {
			int choice = 0;
			choice = kb.nextInt();

			while (choice != 2) {
				switch (choice) {
				// Uses nextDeal() to get next card and add it to playerValue
				case 1:
					System.out.println("You HIT");
					deal.nextDealPlayer();
					deal.playerCheck();
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
					decisionMenu();
					choice = kb.nextInt();
				}

			}
		} catch (InputMismatchException e) {

			System.out.println("java.util.InputMismatchException");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
