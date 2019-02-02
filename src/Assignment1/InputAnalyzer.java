//Alev Orfi 260722166

public class InputAnalyzer {
	public static void main(String[] args) {
		double a = Double.parseDouble(args[0]); //inputs a
		double b = Double.parseDouble(args[1]); //inputs b
		double c = Double.parseDouble(args[2]); //inputs b
		
		boolean allPositive = (a >= 0 && b >= 0 && c >= 0); //checks to see if they are all positive
		System.out.println ("The numbers " + a + ", " + b + " and " + c + " are all non-negative: " + allPositive);
		
		boolean oneEven = (a%2 == 0 || b%2 == 0 ||c%2 == 0);//checks if at least one is even 
		System.out.println ("At least one between " + a + ", " + b + " and " + c + " is even: " + oneEven);
			
		boolean decreasing = (a > b && b > c);//checks if they are in decreasing order
		System.out.println ("The numbers " + a + ", " + b + " and " + c + " are in a strictly decreasing order: " + decreasing);
		
		boolean positiveDecreasing = (allPositive == true || decreasing == true);//checks if they are all positive or in decreasing order
		System.out.println ("The numbers " + a + ", " + b + " and " + c + " are either all non-negative or in a strictly decreasing order: " + positiveDecreasing);

		boolean positiveAndNoneEven = (allPositive == true && oneEven == false);//checks if they are all positive and non are even
		System.out.println ("The numbers " + a + ", " + b + " and " + c + " are all non-negative numbers and none of them is even: " + positiveAndNoneEven);
		}

}
