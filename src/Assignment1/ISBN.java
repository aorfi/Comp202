// Alev Orfi 260722166


public class ISBN {
	public static void main(String[] args) {
		int fourDigit = Integer.parseInt(args[0]); //inputs the four digit value  
		
		int d5 = fourDigit/1000;//finds values of each digit
		int d4 = (fourDigit%1000)/100;
		int d3 = ((fourDigit%1000)%100)/10;
		int d2 = ((fourDigit%1000)%100)%10;
		
		int sumDigits = 5*d5 + 4*d4 + 3*d3 + 2*d2;//calculate the sum of the digits times its position
		int d1 = 11 - sumDigits%11;//calculates d1
		
		if (d1 == 10) {	
			System.out.println ("The last digit must be X."); //prints X if d1 is 10
		} 
		else if(d1 == 11) {	
			System.out.println ("The last digit must be 0.");//prints 0 if d1 id 11
		} 
		
		else {
			System.out.println ("The last digit must be: " + d1);//prints d1
		}		
	}
}

