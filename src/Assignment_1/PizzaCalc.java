package Assignment_1;
//Alev Orfi 260722166
public class PizzaCalc {
	public static void main(String[] args) {
		int mode = Integer.parseInt(args[0]); //looks for mode
		if(mode == 1) {
			int diamLarge = Integer.parseInt(args[1]); //looks for large diameter
			int diamSmall = Integer.parseInt(args[2]);//looks for small diameter
			
			System.out.println ("You selected \"Quantity mode\".");//prints mode and inputed values
			System.out.println ("The diameter of the large pizza is " + diamLarge + " inches.");
			System.out.println ("The diameter of the small pizza is " + diamSmall + " inches.");
			
			double areaLarge = Math.PI*Math.pow((diamLarge/2),2);//calculate the area
			double areaSmall = Math.PI*Math.pow((diamSmall/2),2);
			double ratio = (areaLarge/areaSmall);//gets ratio of the area
			
			System.out.println ("\nYou should order " + ratio + " small pizzas.");	//prints number of small pizzas to order
		}
		else if(mode == 2) {
			int diamLarge = Integer.parseInt(args[1]);//looks for large diameter
			double priceLarge = Double.parseDouble(args[2]);//looks for price of large pizza
			int diamSmall = Integer.parseInt(args[3]);//looks for small diameter
			int numSmall = Integer.parseInt(args[4]);//looks for number of small pizzas
			
			System.out.println ("You selected \"Price mode\".");//prints mode and inputed values
			System.out.println ("The diameter of the large pizza is " + diamLarge + " inches.");
			System.out.println ("The price of one large pizza is " + priceLarge + " dollars.");
			System.out.println ("The diameter of the small pizza is " + diamSmall + " inches.");
			System.out.println ("You want to buy " + numSmall + " pizzas.");
			
			double areaLarge = Math.PI*Math.pow((diamLarge/2),2);//calculates the area
			double areaSmall = Math.PI*Math.pow((diamSmall/2),2);
			double fairPrice = ((areaSmall/areaLarge)*priceLarge*numSmall);//calculates the fair price
			
			System.out.println ("\nThe fair price to pay for " + numSmall + " small pizzas is " + fairPrice + " dollars");
		}
		else {
			System.out.println("This mode is not supported.");//prints when a wrong choice is made
		}
		
	}

}
