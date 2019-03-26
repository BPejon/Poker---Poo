
public class Test {
	
	public static void main(String[] args)
	{
		int[] n = {1,2,3,4,1};
		int[] cart = {10,11,12,13,14};
		

		Carta c = new Carta(n,cart);
		c.displayHand();
		
		c.randDraw();
		
		c.displayHand();
		
	}
}
