/**Video Poker- Trabalho de POO

 * Classe que chega numeros aleatorios
 * @author Breno Pejon & Lucas Ebling
 * N  USP  10801152    & 10692183
 *
 */
import java.util.Calendar;

public class Rand {
	
	private long p = 2147483648L;
	private long m = 843314861;
	private long a = 453816693;
	
	private long xi = Calendar.getInstance().getTimeInMillis();
	
	/**
	 * 
	 * @return retorna um double raleatorio
	 */
	public double getRand(){
		xi = (a + (m * xi))%p;
		double d = xi;
	
		
		return d/p;
	}
	
	/**
	 *  retorna um inteiro baseado em um alcance determinado
	 * @param max range maximo
	 * @param min range minimo
	 * @return retorna um int aleatorio com range de max e min
	 */
	public int getRange(int max, int min){
		int y = (int)(getRand() * max - min  +1) + min;
		
		
		return y;
	}
	
	
	
	
}
