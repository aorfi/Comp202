//Alev Orfi 260722166
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class BullsAndCows {
	
	public static void main(String[] args) {
		playBullsAndCows((int) Math.random()*10);//plays with random generator
	}

	public static boolean contains(int[] a, int b) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == b) {
				return true;
			}
		}
		return false;
	}
	
	public static int[] generateSecretDigits(int seed) {
		int[] Digits = new int[4];
		Random random = new Random(seed); 
		for (int i = 0; i < Digits.length; i++) {
			boolean different = true;
			int randomDigit = random.nextInt(10);
			for (int j = 0; j < i; j++) {
				if(randomDigit == Digits[j]) {
					different = false;	
					}
			}
			if(different == true) {
				Digits[i] = randomDigit;
			}
		}
		return Digits;
	}
	
	public static int[] extractDigits(int digits) {
		int length = (int) (Math.log10(Math.abs(digits)) + 1);//gets the length of digits
		if(length < 4 && length > 0) { //if the length is less than 
			int[] digitArray = new int[4];//makes an array of size 4
			for(int i = 0; i < 4; i++ ) {
				if(i < (4-length)) {//fills in zeros for missing numbers
					digitArray[i] = 0;
				}
				else {//fills in rest of digits
					digitArray[i] = (int) (Math.abs(digits)/(Math.pow(10,(5-length-i))))%10;
				}
			}
		return digitArray;	
		}
		if(digits < 0) {//if there is a negative then add a zero in digitArray[0]
			int[] digitArray = new int[length];
			digitArray[0] = 0;
			for(int i = 1; i < length; i++) {
				digitArray[i] = (int) (Math.abs(digits)/(Math.pow(10,(length-1-i))))%10;
			}
		return digitArray;	
		}
		else {//fills in digits
			int[] digitArray = new int[length];
			for(int i = 0; i < length; i++) {
				digitArray[i] = (int) (Math.abs(digits)/(Math.pow(10,(length-1-i))))%10;
			}
		return digitArray;	
		}
	}
	
	public static int getNumOfBulls(int[] digitsSecret, int[] digitsGuess) {
		if(digitsSecret.length != digitsGuess.length) {//throws when array lengths are different
			throw new IllegalArgumentException("Guess is wrong length");
		}
		int bulls = 0;
		for(int i = 0; i < digitsSecret.length; i++) {//checks if the value of each array is the same (at same position)
			if(digitsSecret[i] == digitsGuess[i]) {
				bulls++;
			}
		}
		return bulls;
	}
	
	public static int getNumOfCows(int[] digitsSecret, int[] digitsGuess) {
		if(digitsSecret.length != digitsGuess.length) {//throws when array lengths are different
			throw new IllegalArgumentException("Guess is wrong length");
		}
		int cows = 0;
		int[] secret = digitsSecret; //change the secret if there are the same values in the same position
		for(int i = 0; i < digitsSecret.length; i ++) {
			if(digitsSecret[i] == digitsGuess[i]) {
				secret[i] = 10+i; //make this large so it wont be the same as any other value
			}
		}
		
		for(int i = 0; i < digitsSecret.length; i++) {//checks if any value of each array is the same
			for(int m = 0; m < digitsSecret.length; m++) {
				if(secret[i] == digitsGuess[m] && m!=i) {//adds to cows if they are the same in a different position
					cows++;
				}
			}
		}
		return cows;
	}
	
	public static void playBullsAndCows(int a) {
		Scanner s = new Scanner(System.in);
		int[] secret = generateSecretDigits(a);
		System.out.println(Arrays.toString(secret));
		System.out.println("Welcome to Bulls and Cows!");
		for(int guessNumber = 1; guessNumber < 50; guessNumber ++) {
			secret = generateSecretDigits(a);
			
			if(guessNumber > 5) {//ask is you want to quit after 5 guesses
				System.out.println("Do you want to quit the game? (y/n)");
				String reponse = s.next();
				if(reponse.equals("y")) {//exits if response is y
					System.out.println("I guess you had enough after " + (guessNumber-1) + " tries");
					return;
				}
				if(reponse.equals("n")) {
					System.out.println("\nGuess #" + guessNumber + " Enter a 4 digit code: ");
					int guess = s.nextInt();
					if(guess < 0 || guess > 9999) {
						System.out.println("Make sure your guess is a positive and at most 4 digit; you wasted a guess");
						continue;
					}
					int[] guessArray = extractDigits(guess); 
					
					
					
					int count = 0;
					for(int i = 0; i < secret.length; i++) {//checks if the guess is correct
						if(guessArray[i] == secret[i]) {
							count++;
						}
						if(count == secret.length) {//exits when correct
							System.out.println("Congrats! You guessed the code in " + guessNumber + " tries");
							return;
						}
					}
					
					
					System.out.println(Arrays.toString(secret));
					System.out.println(Arrays.toString(guessArray));
					int bulls = getNumOfBulls(secret, guessArray);
					int cows = getNumOfCows(secret, guessArray);
					System.out.println("The number of bulls is: " + bulls);
					System.out.println("The number of cows is: " + cows);
				}
			}
			
			
			else {
				System.out.println("\nGuess #" + guessNumber + " Enter a 4 digit code: ");
				int guess = s.nextInt();
				if(guess < 0 || guess > 9999) {
					System.out.println("Make sure your guess is a positive and at most 4 digit; you wasted a guess");
					continue;
				}
				int[] guessArray = extractDigits(guess); 
				
				
				
				int count = 0;
				for(int i = 0; i < secret.length; i++) {//checks if the guess is correct
					if(guessArray[i] == secret[i]) {
						count++;
					}
					if(count == secret.length) {//exits when correct
						System.out.println("Congrats! You guessed the code");
						return;
					}
				}
				
				
				System.out.println(Arrays.toString(secret));
				System.out.println(Arrays.toString(guessArray));
				int bulls = getNumOfBulls(secret, guessArray);
				int cows = getNumOfCows(secret, guessArray);
				System.out.println("The number of bulls is: " + bulls);
				System.out.println("The number of cows is: " + cows);
			}
		}
			
				
			
		}
		
		
	
	
	
}
