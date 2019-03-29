//Alev Orfi 260722166
import java.util.Random;

public class Deck {
	private Card[] cards; //card attribute
	private int cardsLeft; //number of cards left
	private Random numberGenerator = new Random(123); //random attribute with seed 123
	
	public Deck() {
		int n = 0;
		Card[] cardValues = new Card[52]; //deck has 52 cards
		String[] suit= {"spades", "hearts", "diamonds", "clubs"};
		for(int m=0; m<4; m++) {
			for(int i = 13; i>0; i--) {
				Card cardAtn = new Card(i, suit[m]); //assigns card number and suits
				cardValues[n] = cardAtn;
				n++;
			}
		}
		this.cardsLeft = cardValues.length;//assigns length of deck to cardsLeft
		this.cards = cardValues; //gives card values to cards
	}
	
	public int getNumOfCards() {//returns value of cardsLeft
		return cardsLeft;
	}
	
	public Card[] getCards() { 
		Card[] cardsLeft = new Card[getNumOfCards()];//creates new array cardsLeft
		for( int i=0; i < cardsLeft.length; i++) {
			cardsLeft[i] = cards[i];
		}
		return cardsLeft;//returns this array to not alter cards
				
	}
	
	public void showCards() {//prints cards number and suit
		String s = "";
		
		for(int i =(cards.length -1) ; i >= 0; i--) {
			s += cards[i].getValue() + " of " + cards[i].getSuit() + ", ";
	
		}
		System.out.print(s);
		
	}
	
	public void shuffle() {
		Card[] shuffledDeck = getCards();//created new shuffled deck
		for(int i=0; i < 1000; i++) {
			int r1 = numberGenerator.nextInt(cardsLeft);//gets random number
			int r2 = numberGenerator.nextInt(cardsLeft);		
			Card temp = shuffledDeck[r1];//switches values at 2 random positions
			shuffledDeck[r1] = shuffledDeck[r2];
			shuffledDeck[r2] = temp;	
		}
		cards=shuffledDeck;//sets card to this shuffled deck
	}
	
	public Card deal() {
		if(cards.length == 0) {//if deck is empty
			return null;
		}
		else {
			Card topCard = cards[cards.length-1];//gets top card
			Card[] tempCards = new Card[cards.length-1];
			for(int i=0; i<tempCards.length; i++) {//removes top card from deck
				tempCards[i] = cards[i];
			}
			cards = tempCards;
			cardsLeft--;//subtract 1 from cardsLeft
			return topCard;
		}
	}
	
	public Card pickACard(int position) {
		Card picked = cards[cards.length-position-1]; //gets index of position
		Card[] updatedCards = new Card[cards.length-1];
		for(int i=0; i<cards.length-position-1; i++){ //before the position just copy cards
			   updatedCards[i] = cards[i]; 
			    
			  }
		for(int i=cards.length-position-1; i< updatedCards.length; i++){//shifts one over
			   updatedCards[i] = cards[i+1]; 
			    
			  }
	
		cardsLeft--;//subtract 1
		cards = updatedCards;
		return picked;
	}
	
	public void restockDeck() {
		int n = 0;
		Card[] cardValues = new Card[52];//creates new deck
		String[] suit= {"spades", "hearts", "diamonds", "clubs"};
		for(int m=0; m<4; m++) {
			for(int i = 13; i>0; i--) {
				Card cardAtn = new Card(i, suit[m]);//assign card values 
				cardValues[n] = cardAtn;
				n++;
			}
		}
		this.cards = cardValues;
	}
		

}
