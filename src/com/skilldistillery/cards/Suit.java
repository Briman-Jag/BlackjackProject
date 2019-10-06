package com.skilldistillery.cards;

public enum Suit {

	HEARTS("\u2665"),
	SPADES("\u2660"),
	CLUBS("\u2663"),
	DIAMONDS("\u2666");
	
	Suit(String s){
		name = s;
	}
	
	final private String name;
	
	@Override
	public String toString() {
		return name;
	}
	
	public String getName() {
		return name;
	}
	
	
	
}
