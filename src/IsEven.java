
public class IsEven {
	public static void main(String[] args){
		String x = args[0];
		int y = Integer.parseInt(x);
		boolean isEven = y%2 == 0;
		if (isEven) {
			if (y%3 == 0) {
				System.out.println(y + " is even");
				System.out.println(y + " is a multiple of 3");
				}
			else {
				System.out.println(y + " is even");
				System.out.println(y + " is not a multiple of 3");
				}
		}else {
			if (y%3 == 0) {
				System.out.println(y + " is odd");
				System.out.println(y + " is a multiple of 3");
				}
			else {
				System.out.println(y + " is odd");
				System.out.println(y + " is not a multiple of 3");
			}
		}
		
	}

}
