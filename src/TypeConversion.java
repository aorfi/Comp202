
public class TypeConversion {
	public static void main(String[] args) {
		String s = "3";
		double x;
		int y;
		
		x = Double.parseDouble(s);
		y = (int) x;
		
		System.out.print( s + " " + x + " " + y);
	}

}
