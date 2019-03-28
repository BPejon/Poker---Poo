/**Video Poker- Trabalho de POO
 * Classe que administra os creditos e apostas do jogador
 * além de contabilizar sua pontuacao
 * 
 * @author Breno Pejon & Lucas Ebling
 * N  USP  10801152    & 10692183
 *
 */
public class Placar {
	private int creditos;
	private int aposta;
	
	private int aux = 0;
 
	private int vet_cont[];					//vetor q conta veze qq retirou os numeros
	private int cont_naipe[];				//vetor que contabilida o naipe
	
	
	/**
	 * Construtor da placa
	 * seta os creditos inicais como 200
	 */
	public Placar (){
		//this.mao = new Carta;
		this.creditos = 200;
		this.aposta = 0;
		this.vet_cont = new int[15];
		this.cont_naipe = new int [5];
	}
	
	/**
	 * Funcao que pega o valor da aposta desejada
	 * 
	 */
	public void setAposta() throws Exception{
		int aux = 0;
		this.aposta = 0;
		
		while(this.aposta == 0){
			System.out.printf("Quantos creditos apostar?\n");	
			aux = EntradaTeclado.leInt();
			if(aux <= creditos && aux > 0){					//verifica se a aposta n ultrapassa os creditos e nem seja negativo
				this.aposta = aux;
				this.creditos -= this.aposta;				//retira a aposta do credito
			}
			else
				System.out.printf("Nao ha creditos suficientes\n");
		}				
	}
	
	
	/**
	 * 
	 * @return retorna  quantidade total de creditos
	 */
	public int getCreditos(){
		return this.creditos;
	}
	
	
	/**
	 * Funcao que printa quantidade total de creditos e retorna-os
	 * @param boolean true
	 * @return quantidade total de creditos
	 */
	public int getCreditos(boolean print){
		System.out.printf("Voce possue " +this.creditos + " creditos\n");
		return this.creditos;
	}
	
	/**
	 * Retorna a aposta
	 * @return retorna o valor apostado
	 */
	public int getAposta(){
		return this.aposta;
	}
	
	/**
	 * Retorna a aposta e printa-a
	 * @param boolean true
	 * @return retorna a aposta
	 */
	public int getAposta(boolean print)
	{
		System.out.printf("Sua aposta e de: %d\n", aposta);
		return this.aposta;
	}
	
	
	
	/**
	 * Funcao q calcula a pontuacao do jogador com base nas cartas q retirou
	 * @param vetor de cartas na mao  
	 * @param vetor de naipe das cartas
	 */
	public void Pontuacao(int[] mao, int[] naipe){
		boolean flag1 = false;
		boolean flagtripla = false;
		boolean flagpar = false;
		boolean flagpar2 = false;
		
		
		for(int i = 2; i < 15; i++){
			vet_cont[i] = 0;
		} //zera o contador das cartas
		
		for(int i = 0; i < 5; i++){
			cont_naipe[i] = 0;
		} //zera o contador de naipes
		
		
		//aciona o contador dos numeros
		for(int i = 2 ; i< 15 ; ++i){
			for(int j = 0; j<5 ; ++j){
				if(i == mao[j])			//compara se a posicao do contador for igual ao numero da carta
					++vet_cont[i];
			}
		}
		
		//aciona o contador dos naipes
		for(int i = 0 ; i<5  ; ++i){
			for(int j = 0; j<5 ; ++j){
				if(i == naipe[j])		//compara se o naipe do contador for igual ao naipe da carta
					++cont_naipe[i];
			}
		}
		
		//----------PONTUACAO---------//
		
		
		//Royal Straight Flush, Stright Flush e Flush  // (5 cartas seguidas do mesmo naipe de 10 ate o AS)
		for(int i=0; i<5; ++i){				//verifica se todas as cartas estao no mesmo naipe
			aux = cont_naipe[i];
			if(aux == 5)
				flag1 = true;
		}
		
		//se houver todos os naipes
		if(flag1== true) {
			
		//verifica se ha Royal Straight Flush
			if((vet_cont[10] == 1) && (vet_cont[11] == 1)  && (vet_cont[12] == 1)  && (vet_cont[13] == 1) && (vet_cont[14] == 1)) {  //verifica se houve sequencia de 10 ao As 
				System.out.printf("ROYAL STRAIGHT FLUSH !!!!!\n");
				this.creditos += this.aposta*200;
				return;
			}
		
			//verifica se ha cartas seguidas
			else{
				//nessa implementacao se sair 14, 2, 3, 4 ,5 n vale
				for (int i =2; i <10; ++i){			
					//verifica straight flush
					if(vet_cont[i] == 1 && vet_cont[i+1] == 1 && vet_cont[i+2] == 1 && vet_cont[i+3] == 1 && vet_cont[i+4] == 1){		//verifica cartas em ordem
						System.out.printf("Straight Flush!!\n");
						this.creditos += this.aposta* 100;
						return;
					}
				}
			}		
			
			//se todas forem do mesmo naipe porem n satisfaz as condicoes acima, então é flush
				System.out.printf("Flush!!\n");
				this.creditos += this.aposta *10;
				return;
		}		
			
		
		//caso nao houver 5 naipes iguais
		
		//Quadra, Trinca, Pares Full Hand e Straight
		for (int i =2; i<15; ++i){			
			aux = vet_cont[i];
			
			//verifica se ha quadra
			if(aux == 4){
				System.out.printf("Quadra!!\n");
				this.creditos += this.aposta *50;
				return;
				}
				
				//verifica se ha 3 do mesmo numero
				else if (aux == 3){
					flagtripla= true;
				}
				
				//verifica se ha um par
				else if (aux == 2){
					if(flagpar == true )		//verifica se ha dois pares
						flagpar2 = true;
					else 
						flagpar = true;			//verifica se ha um par
				}
		
				//DOIS PARES
				else if(flagpar == true && flagpar2 == true){
					System.out.printf("Dois pares!!\n");
					this.creditos += this.aposta;
					return;
				}
				
				//TRINCA
				else if(flagtripla == true && flagpar == false) {
					System.out.printf("Trinca!!\n");
					this.creditos += this.aposta*2;
					return;
				}
				
				//Full Hand
				else if (flagtripla == true && flagpar == true){
					System.out.printf("Full Hand!!\n");
					this.creditos += this.aposta * 20;
					return;
				}
				
				//verifica Straight
				else if(vet_cont[i] == 1 && vet_cont[i+1] == 1 && vet_cont[i+2] == 1 && vet_cont[i+3] == 1 && vet_cont[i+4] == 1){		//verifica cartas em ordem
					System.out.printf("Straight!!\n");
					this.creditos += this.aposta * 5;
					return;
				}					
		}
		
		//Se nao alcançou nenhum dos casos
		System.out.printf("Nenhuma combinacao feita :( \n");
		return;
		
	}
	

	/**
	 * 	Main para teste do placar
	 */
/*	public static void main( String args[]) throws Exception{
		Placar placar = new Placar();
		
		while(placar.getCreditos() != 0 ){
			placar.setAposta();				//pega qual sera a aposta
			for(int i =0; i<5 ; ++i) {
				mao[i] = EntradaTeclado.leInt();
				naipe[i] = EntradaTeclado.leInt();
			}
			
			//calcula a pontuacao da rodada
			placar.Pontuacao();
			placar.getCreditos(true);
		}
	}
	
*/
}
	

	
