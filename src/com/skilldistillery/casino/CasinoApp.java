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
		System.out.println("Let's play Blackjack! Feeling Lucky???");
		dealer.playGame();
		player.playGame();
		System.out.println("*Dealer shuffles deck*");
		deck.shuffle();
		System.out.println();
		deal.firstDeal();
		// Need method to check if player or dealer has blackjack already
		
		decisionMenu();
		userDecision();
		// Need to put methods to check if player has black jack or has busted
		deal.playerCheck();
		// If not dealers turn
		deal.nextDealDealer();
		// Check if dealer has blackjack or has busted
		deal.dealerCheck();
		deal.dealerHitOrStay();
		deal.dealerCheck();
		// Otherwise decisionMenu and User Decision again
		

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
		choice = kb.nextInt();
		switch (choice) {
		// Uses nextDeal() to get next card and add it to playerValue
		case 1:
			System.out.println("You HIT");
			deal.nextDealPlayer();
			break;
		case 2:
			System.out.println("You STAY");
			break;
		case 3:
			System.out.println("Thanks for playing! Goodbye!");
			kb.close();
			System.exit(0);
		}
	}

	// Use comparator to compare hand values of dealer and player if neither busts
	public void compareHands() {

	}

}
