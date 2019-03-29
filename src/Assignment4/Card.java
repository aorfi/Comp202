
public class Card {
	private int value;
	private String suit;
	
	public Card(int value, String suit) {
		if(value < 1 || value > 13) {
			throw new IllegalArgumentException("Card value is invalid");
		}
		if((suit.equalsIgnoreCase("spades") || suit.equalsIgnoreCase("hearts") || suit.equalsIgnoreCase("diamonds") || suit.equalsIgnoreCase("clubs"))== false) {
			throw new IllegalArgumentException("Card suit is invalid");
		}
		this.value = value;
		this.suit = suit.toLowerCase();
	}
	
	public int getValue() {
			
			return this.value;
			
		}
	
	public String getSuit() {
		
		return this.suit;
		
	}
	

}
