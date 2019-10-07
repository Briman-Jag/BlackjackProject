## Blackjack Project

### Week 4 Homework Project for Skill Distillery

### Overview
This program is a Blackjack game between two participants, which are the user and a programed dealer. The program creates a deck of cards with text, keeps track of scores based on the cards values, and simulates turns to follow the rules of a basic version of Blackjack.

The program is built up of 11 classes total. The classes Card, Deck, Rank, and Suit were created to build the virtual deck of cards to be played with by methods in other classes. They deck class using the other three classes to create a standard 52 card deck with proper ranks and suits. It also includes the methods to check the deck size, deal the cards, and shuffle the cards.

The classes BlackjackHand, Hand, and Dealing are involved in the manipulation of the deck of cards and running the methods that play the game according to its logic. BlackjackHand has methods following rules on whether a hand wins or is loses or busts because the card values are over 21. The Dealing class does most the work of running the games turns. It has a variety of methods to deal each hand with specific messages depending on which game participant is playing, check the participants hands values, display cards that are face up, determine whether the dealer should hit or stay, and compare the participants hands against each other to see who wins the game.

The last four classes to mention are the Dealer, Player, Table, and CasinoApp classes, which represent the participants, the table they play on, and the application that runs the program. The CasinoApp has the menu for whether a user would like to hit, stay, or quit as well as a switch to initiate the appropriate methods in the Dealing class depending on their choice. The blackJack method within the CasinoApp puts the methods in a particular method to simulate the game of Blackjack.

The grading requirements for this project are:
-  Your program must NOT be contained in one procedural main(). You MUST design a OO class structure.
- When the game begins both the player and dealer are dealt two cards.
- If a player or dealer is dealt 21 the game is over. Otherwise the player can choose to hit as many times as they wish until they choose to stay.
- Once the player has completed their turn the dealer will begin their turn, automatically hitting or staying according to the Blackjack rules.
- The game is immediately over if either player gets above 21.
- The winner is displayed.

### How to run
When the program is launched it will print dialogue about the game starting, deck being shuffled, and the first two cards dealt to the user and dealer. The users two cards are dealt first up, while the dealers first card is face down and second card is dealt face up. If neither user has scored 21 which is done with an Ace card worth 11 points and another card with a value of 10 points, then the user is prompt to either hit, stay or quit. After a hit it will allow the user to hit again unless they have reached or busted the 21 point score capacity. If they choose to stay then the dealer will decide to hit or stay itself with its relation to a 17 point value meaning it will hit until it is equal to or above 17. If neither of the participants at this point have Blackjack or have busted then the game will compare the two hands to see who wins the game by having the higher point value without going over 21 or determine the game is a tie or push if their scores are the same.


### Technologies/Topics Applied
Technologies and topics used in this project were: Enumerated types, lists, ArrayLists, arrays, getters & setters, method calling, while loops, switch, toString, booleans, menu interface, Collection sorting, Do/while loops, ASCII unicode, and game logic.
