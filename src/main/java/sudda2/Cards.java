package sudda2;

import java.util.Arrays;

public class Cards {
	
	final public static int CARD_SIZE = 20;
	
	Card[] cards;
	
	private int cursor;
	
	public Cards() {
		cards = new Card[CARD_SIZE];
		
		for(int i = 0; i < CARD_SIZE; ++i) {
			cards[i] = new Card(i);
		}
		shuffle(100);
	}
	
	public void shuffle(int times) {
		for(int i = 0; i < times; ++i) {
			int x = (int)(Math.random()*CARD_SIZE);
			int y = (int)(Math.random()*CARD_SIZE);
			
			Card temp = cards[x];
			cards[x] = cards[y];
			cards[y] = temp;
		}
	}
	public Card next() {
		if(cursor > CARD_SIZE - 1) {
			shuffle(500);
			cursor = 0;
		}
		return cards[cursor++];
	}
	
	public String toString() {
		return Arrays.toString(cards);
	}
	


}
