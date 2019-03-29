
public class testCard {
	public static void main(String args[]) {
		//Card m = new Card(11,"spaDes");
		Deck d = new Deck();
		d.showCards();
		d.shuffle();
		System.out.println();
		d.showCards();
		System.out.println();
		d.deal();
		d.showCards();
		System.out.println();
		d.pickACard(11);
		System.out.println(d.getNumOfCards());
		d.showCards();
		
		d.shuffle();
		System.out.println();
		d.showCards();
		d.restockDeck();
		System.out.println();
		d.showCards();
//		
	}

}
