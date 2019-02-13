//Alev Orfi 260722166
// simulates a game of Bunco with two players
public class Bunco {
	public static void main(String[] args) {
	String name1 = args[0];
	String name2 = args[1];
	playBunco(name1, name2);	

	}
	
	public static int diceRoll() {//gets a random number between 1 and 6
		int dice =  (int) (Math.random()*7);	
		return dice;
	}
	
	public static int getScore(int d1, int d2, int d3, int round){
		int rollScore = 0;
		if (d1 == round) {
			rollScore++;
		}
		if (d2 == round) {
			rollScore++;
		}
		if (d3 == round) {
			rollScore++;
		}
		if (d1 == d2 && d2 == d3 && d3 == round) {
			rollScore = 21;
		}
		else if (d1 == d2 && d2 == d3) {
			rollScore = 5;
		}
		return rollScore;
		
	}
	
	public static int playOneRound(String name, int round) {
		if(round >= 1 && round <=6) {
			int d1 = diceRoll();
			int d2 = diceRoll();
			int d3 = diceRoll();
			int score = getScore(d1,d2,d3,round);
			System.out.println(name + " rolled " + d1 + " " + d2 + " " + d3 + " and scored " + score + " points");
			return score;
		}
		else {
			System.out.print("The round input is not valid");
			return -1;
		}
	}
	
	public static void playBunco(String name1, String name2) {//runs the entire game of Bunco
		int score1 = 0;//initialize player 1's score
		int score2 = 0;//initialize player 2's score
		for(int i=1; i<=6; i++) {//runs through 6 rounds
			System.out.println("Round #: " + i);
			System.out.println();
			score1= score1 + playOneRound(name1,i);
			score2= score2 + playOneRound(name2,i);	
			System.out.println();
			System.out.println(name1 + "'s score after round " + i +" is " + score1);
			System.out.println(name2 + "'s score after round " + i +" is " + score2);
			System.out.println("--------------------");
		}
		if (score1 > score2) {
			System.out.println(name1 + " wins!");
		}
		else if (score2 > score1) {
			System.out.println(name2 + " wins!");
		}
		else if (score2 == score1) {
			System.out.println("tie!");
		}
	}

}
