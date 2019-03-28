/**Video Poker- Trabalho de POO
 * Jogo do Video Poker (main)
 *   
 * @author Breno Pejon & Lucas Ebling
 * N  USP  10801152    & 10692183
 *
 */
public class Poker {
	public static void main(String[] args) throws Exception{
		
	Carta cart = new Carta();
	Placar p = new Placar();
	boolean exit = false;
	
	
		while(p.getCreditos() > 0 && exit == false){
		//pega a aposta
		p.setAposta();
		
		//gera "aleatoriamente" as cartas
		cart.randDraw();
		
		//printa as cartas
		cart.displayHand();
		
		System.out.printf("   (0)      (1)      (2)      (3)      (4)   \n");
		System.out.printf("Quais sao as cartas que deseja substituir, digite seu numero e de um espaco para a proxima.\n Caso nao queira mudar, apenas digite 'n' seguida de enter:\n"); 
		String s = EntradaTeclado.leString();
		
		//se nao for n, pegara novas cartas
		if(s.compareTo("n") != 0){
			cart.partialDraw(s);
			cart.displayHand();
			
			//pergunta novamente se gostaria de trocar
			System.out.printf("   (0)      (1)      (2)      (3)      (4)   \n");
			System.out.printf("Quais sao as cartas que deseja substituir, digite seu numero e de um espaco para a proxima.\n Caso nao queira mudar, apenas 'n' seguido de enter\n");
			s = EntradaTeclado.leString();
			
			//compara a resposta
			if(s.compareTo("n") != 0) {
				cart.partialDraw(s);
				cart.displayHand();
			}
		}
		//verifica qual é a pontuacao
		p.Pontuacao(cart.getMao(), cart.getNaipe());
		
		//printa quantos creditos possue
		p.getCreditos(true);
		
		if(p.getCreditos() != 0){
			System.out.printf("Deseja Continuar? S/N\n");
			s = EntradaTeclado.leString();
			
			//compara de a resposta for nao
			if(s.compareTo("N") == 0 || s.compareTo("n") == 0)
				exit = true;
		}
	
	}
		
		System.out.printf("Saindo...");
	
	}
}
