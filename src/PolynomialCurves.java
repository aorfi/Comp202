//Alev Orfi 260722166
public class PolynomialCurves {
	
	public static void main(String args[]) {
		double [] coef = {2};
		drawCurve(coef,1,'o');
	}
	
	public static boolean onCurve(int[] coord, double[] coef, double t) {
		boolean onCurve = false;
		int x = coord[0];//relable variables
		int y = coord[1];
		double poly = 0;
		for(int i = 0; i < coef.length; i++) {//create polynomial
			poly += coef[i]*Math.pow(x, (coef.length -1 - i));
		}		
		if (((y-t) < poly) && ((y+t) > poly)) {//check conditions
			onCurve = true;
		}
		return onCurve;

	}

	public static void verifyInput(double[] coef, double t) {//check to see if iputs will work
		if(coef.length == 0) {
			throw new IllegalArgumentException("Coeffient array needs values");
		}
		if(t < 0) {
			throw new IllegalArgumentException("Thickness needs to be a positive value");
		}
		
	}
	
	public static void drawCurve(double[] coef, double t, char sym) {
		verifyInput(coef,t);
		for(int i = 0; i < 21; i++) {
			for(int m = 0; m < 21; m ++) {
				
				int[] coord = {m,i};
				if(onCurve(coord, coef,t) == true) {//print function
					System.out.print(sym);
				}
				
				
				else if(m==10) {
					if(i == 0) {
						System.out.print("^");
					}
					else {
					System.out.print("|");
					}
				}
				if(i == 10 && m ==20) {
					System.out.print('>');
				}
				else if(i == 10) {
					System.out.print("-");
				}
				
				if(m == 20) {
					System.out.println(" ");
				}
				else if(i != 10 && onCurve(coord, coef,t) == false){
					System.out.print(" ");
				}
				
				
				
				
				
			}
		}
	}
	

}
