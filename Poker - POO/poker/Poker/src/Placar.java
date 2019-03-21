public class Placar {
	private int creditos;
	private Carta mao;
	private int aposta;
	private int aux = 0;
	
	
	private int vet_cont[];					//vetor q conta veze qq retirou os numeros
	private int cont_naipe[];				//vetor que contabilida o naipe
	
	public Placar (){
		this.mao = new Carta;
		this.creditos = 200;
		this.aposta = 0;
		this.vet_cont = new int[14];
	}
	
	public void setAposta(){
		int aux = 0;
		this.aposta = 0;
		
		while(this.aposta == 0){
			System.out.printf("Quantos créditos apostará?");	
			aux = EntradaTeclado.leInt();
			if(aux < creditos && aux > 0){					//verifica se a aposta n ultrapassa os creditos e nem seja negativo
				this.aposta = aux;
				this.creditos -= this.aposta;				//retira a aposta do credito
			}
		}
				
	}
	
	public int getCreditos(){
		return this.creditos;
	}
	
	
	
	
	//funcao q calcula a pontuacao do jogador com base nas cartas q retirou
	public void Pontuacao(){
		boolean flag1 = false;
		boolean flagtripla = false;
		boolean flagpar = false;
		boolean flagpar2 = false;
		
		//aciona o contador dos numeros
		for(int i = 2 ; i<= 14 ; ++i){
			for(int j = 0; j<5 ; ++j){
				if(vet_cont[i] == mao[j].GetNumero)			//compara se a posicao do contador for igual ao numero da carta
					++vet_cont[i];
			}
		}
		
		//aciona o contador dos naipes
		for(int i = 0 ; i<4  ; ++i){
			for(int j = 0; j<5 ; ++j){
				if(cont_naipe[i] == mao[j].GetNumero)		//compara se o naipe do contador for igual ao naipe da carta
					++cont_naipe[i];
			}
		}
		
		//Royal Straight Flush e Stright Flush (5 cartas seguidas do mesmo naipe de 10 até o AS)
		for(int i=0; i<5; ++i){				//verifica se todas as cartas estao no mesmo naipe
			aux = cont_naipe[i];
			if(aux == 5)
				flag1 = true;
		}
			//verifica se há Royal Straight Flush
			if(vet_cont[10] == 1 && vet_cont[11] == 1 && vet_cont[12] == 1 && vet_cont[13] == 1 && vet_cont[14] == 1){  //verifica se houve sequenia de 10 ao As 
				System.out.printf("ROYAL STRAIGHT FLUSH !!!!!");
				this.creditos += this.aposta*200;
				return;
			}
			
			//verifica se há straight flush
			else(){
			
			}
			
			
			//Quadra, Trinca e Pares
			for (int i =0; int <15; ++i){			//verifica se há quadra
				aux = vet_cont[i];
				if(aux == 4){
					System.out.printf("Quadra!!");
					this.creditos += this.aposta *50;
					return;
				}
				
				//verifica se há 3 do mesmo numero
				else if (aux == 3){
					flag1= true;
				}
				
				//verifica se há um par
				else if (aux == 2){
					if(flagpar == true )		//verifica se há dois pares
						flagpar2 = true;
					else 
						flagpar = true;			//verifica se ha um par
				}
		
				//DOIS PARES
				if(flagpar == true && flagpar2 == true){
					System.out.printf("Dois pares!!");
					this.creditos += this.aposta;
					return;
				}
				
				//TRINA
				if (flagtripla = true && flagpar == true){
					System.out.printf("Trina!!");
					this.creditos += this.aposta * 2;
					return;
				}
					
				
		
	}
}
