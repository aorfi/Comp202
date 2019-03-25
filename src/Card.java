
public class Card {
	private int value;
	private String suit;
	
	public Card(int value, String suit) {
		if(value < 0 || value > 13) {
			throw new IllegalArgumentException("Card value is invalid");
		}
		if((suit.equals("spades") || suit.equals("hearts") || suit.equals("diamonds") || suit.equals("clubs"))== false) {
			throw new IllegalArgumentException("Card suit is invalid");
		}
	}
	

}
