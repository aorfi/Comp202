
public class PracticeLoops {
	public static void main(String[] args) {
//		printMultiples(3,5);
		printMultTable(2,3);
		
	}
	
	public static void printMultiples(int n, int m ) {
		for (int i = 1 ; i <= m; i++) {
			System.out.print((n*i) + " ");
		}	
		System.out.println();
	}
	
	public static void printMultTable(int n, int m) {
		for (int i = 1 ; i <= n; i++) {
			printMultiples(i,m);
		}
		
	}
	
	

}
