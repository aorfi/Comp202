import java.util.Arrays;

public class GameOfLife {
	
	public static void main(String args[]) {
		int[][] tub =  {{0,0,0,0,0}, {0,0,1,0,0}, {0,1,0,1,0}, {0,0,1,0,0}, {0,0,0,0,0}};
		displayUniverse(tub);
		int[][] newtub = getnextGenUnverse(tub);
		displayUniverse(newtub);
		System.out.println(Arrays.deepToString(newtub));
	}

	public static boolean isValidUniverse(int[][] uni) {//checks if the universe is valid
		for(int i = 0; i < uni.length-1; i++) {
			if(uni[i].length != uni[i+1].length ) { //returns false if the dimension of the inner arrays are different than the outer
				return false;	
			}
		}
		for(int j = 0; j < uni.length; j++) {
			for(int m =0; m < uni[j].length; m++) {
				if(uni[j][m] > 1) {//checks that no values are not 1 or 0
					return false;
				}
			}
		}
		return true;//if it passes first two tests
	}
	
	public static void displayUniverse(int[][] uni) {//displays the universe
		for(int i = 0; i <= uni.length +1 ; i++) {
			for( int m = 0; m <= uni[0].length +1 ; m++) {
				if(i == 0 && m == 0 || i == uni.length +1 && m == 0 ){//prints + in top and bottom left most position
					System.out.print("+");
				}
				else if(i == uni.length +1 && m == uni[0].length +1 || i == 0 && m == uni[0].length +1 ) {//prints + and goes to next line for right most top and bottom
					System.out.println("+");
				}
				else if(m == 0) {//prints | for left hand side
					System.out.print("|");
				}
				else if(m == uni[0].length +1) {//prints | and go to next line for right hand side
					System.out.println("|");
				}
				else if(i == 0 || i == uni.length +1){ // prints - on top and bottom
					System.out.print("-");
				}
				for(int a=0; a < uni.length; a++) {
					for(int b=0; b<uni[0].length; b++) {
						if(uni[a][b] == 1 && (i-1)==a && (m-1)==b) {//print * where there's a 1
							System.out.print("*");
						}
						else if(uni[a][b] == 0 && (i-1)==a && (m-1)==b) {//print space when theres a zero
							System.out.print(" ");
						}
					}
				}
			}
		}
	}
	
	
	public static int getNextGenCell(int[][] uni, int x, int y) {
		int neighbor=0;
		for(int i = 0; i < uni.length ; i++) {//calculates the number of neightbours that are alive
			for( int m = 0; m <uni[0].length; m++) {
				if(i-x==1 || m-y==1) {
					neighbor += uni[i][m];
				}
			}
		}		
		if(uni[x][y] == 1) {//determines if it lives or not depending on the neighbour number
			if(neighbor < 2 || neighbor > 3) {
				return 0;
			}
			else {
				return 1;
			}
		}
		else{
			if(neighbor == 3) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}
	
	
	public static int[][] getnextGenUnverse(int[][] uni){
		int[][] newUni = new int[uni.length][uni[0].length];
		for(int i = 0; i < uni.length ; i++) {
			for( int m = 0; m <uni[0].length; m++) {
				newUni[i][m] = getNextGenCell(uni,i,m);
			}
		}
		return newUni;
		
	}
}
