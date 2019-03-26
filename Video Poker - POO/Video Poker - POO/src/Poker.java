/**Video Poker- Trabalho de POO
 * 
 * @author Breno Pejon & Lucas Ebling
 * N  USP  10801152    & 10692183
 *
 */
public class Poker {
	public static void main( String args[]) throws Exception{
		Placar placar = new Placar();
		Cartas carts = new Cartas();	
	
	
	
	
		//jogo de poker		
		while(placar.getCreditos() != 0 ){
			placar.setAposta();				//pega qual sera a aposta
		
			
			//calcula a pontuacao da rodada
			placar.Pontuacao(carta);
			placar.getCreditos(true);
		}
	}
	

	
	}
}
