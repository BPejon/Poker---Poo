import java.util.Calendar;

public class Rand {
	
	private long p = 2147483648L;
	private long m = 843314861;
	private long a = 453816693;
	
	private long xi = Calendar.getInstance().getTimeInMillis();
	
	
	public double getRand()
	{
		xi = (a + (m * xi))%p;
		double d = xi;
	
		
		return d/p;
	}
	
	public int getRange(int max, int min)
	{
		int y = (int)(getRand() * max - min  +1) + min;
		
		
		return y;
	}
	
	
	
	
}
