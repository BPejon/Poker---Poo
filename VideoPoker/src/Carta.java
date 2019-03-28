/**Video Poker- Trabalho de POO
 * Classe que administra as cartas do jogo e a mao do jogador
 * 
 * @author Breno Pejon & Lucas Ebling
 * N  USP  10801152    & 10692183
 *
 */
public class Carta {
	/* NAIPES
	 * 1 = OUROS 
	 * 2 = ESPADAS
	 * 3 = COPAS
	 * 4 = PAUS
	 */
	
	/*CARTAS
	 * 2 - 10 = Valores do baralho
	 * 11 = Valete
	 * 12 = Dama
	 * 13 = Rei
	 * 14 = As
	 */
	
	private int[] naipe = {0,0,0,0,0}; 
	private int[] mao = {0,0,0,0,0}; 
	
	/**
	 * Inicializa a classe carta
	 */
	public Carta(){
	}
	
	
	
	/**
	 * 
	 * @return retorna o vetor de cartas que ha na mao
	 */
	public int[] getMao(){
		return mao;
	}
	
	/**
	 * 
	 * @return retorna o vetor de naipes
	 */
	public int[] getNaipe(){
		return naipe;
	}
	

	/**
	 * Mostra a mao do jogador em formato de carta, ascArt
	 */
	void displayHand(){
		String top = " +-----+ ";
		String side = " | ";
		
		String r_1 = "";
		String r_2 = "";
		String r_3 = "";
		String r_4 = "";
		String r_5 = "";
		
		
		for(int i = 0; i < 5; i++){
			r_1 = r_1 + top;
			r_2 = r_2 + side + "   " + side;
			r_4 = r_4 + side + "   " + side;
			r_5 = r_5 + top;
			
			//condicionais para de printar as cartas que nao correspondem com seu numero
			//como por exemplo valete, dessa forma printará "J" ao inves de "10"
			//tambem printa o 10, pois ele n precisa do espaco adicional
			
			//se for menor q o valete printa seu numero correspondente
			if(mao[i] < 10){
				switch(naipe[i]){
				case 1: //ouros
					r_3 = r_3 + side + " " + mao[i] + "\u2666" + side;
					break;
				case 2: //espadas
					r_3 = r_3 + side + " " + mao[i] + "\u2660" + side;
					break;
				case 3: //copas
					r_3 = r_3 + side +" " + mao[i] + "\u2665" + side;
					break;
				case 4: //paus
					r_3 = r_3 + side + " " + mao[i] + "\u2663" + side;
					break;
				default:
					break;
				}
			}
			
			//printa o 10
			if(mao[i] == 10) {
				switch(naipe[i]){
				case 1: //ouros
					r_3 = r_3 + side + "10" + "\u2666" + side;
					break;
				case 2: //espadas
					r_3 = r_3 + side + "10" + "\u2660" + side;
					break;
				case 3: //copas
					r_3 = r_3 + side + "10" + "\u2665" + side;
					break;
				case 4: //paus
					r_3 = r_3 + side + "10" + "\u2663" + side;
					break;
				default:
					break;
				}
			}
			
			
			//printa o valete
			if(mao[i] == 11){
				switch(naipe[i])
				{
				case 1: //ouros
					r_3 = r_3 + side + " J" + "\u2666" + side;
					break;
				case 2: //espadas
					r_3 = r_3 + side + " J" + "\u2660" + side;
					break;
				case 3: //copas
					r_3 = r_3 + side + " J" + "\u2665" + side;
					break;
				case 4: //paus
					r_3 = r_3 + side + " J" + "\u2663" + side;
					break;
				default:
					break;
				}
			}
			
			//printa a dama
			if(mao[i] == 12){
				switch(naipe[i])
				{
				case 1: //ouros
					r_3 = r_3 + side + " Q" + "\u2666" + side;
					break;
				case 2: //espadas
					r_3 = r_3 + side + " Q" + "\u2660" + side;
					break;
				case 3: //copas
					r_3 = r_3 + side + " Q" + "\u2665" + side;
					break;
				case 4: //paus
					r_3 = r_3 + side + " Q" + "\u2663" + side;
					break;
				default:
					break;
				}
			}
			
			//printa o rei
			if(mao[i] == 13) {
				switch(naipe[i])
				{
				case 1: //ouros
					r_3 = r_3 + side + " K" + "\u2666" + side;
					break;
					
				case 2: //espadas
					r_3 = r_3 + side + " K" + "\u2660" + side;
					break;
					
				case 3: //copas
					r_3 = r_3 + side + " K" + "\u2665" + side;
					break;
					
				case 4: //paus
					r_3 = r_3 + side + " K" + "\u2663" + side;
					break;
					
				default:
					break;
				}
			}
			
			//printa o As
			if(mao[i] == 14){
				switch(naipe[i]){
				case 1: //ouros
					r_3 = r_3 + side + " A" + "\u2666" + side;
					break;
					
				case 2: //espadas
					r_3 = r_3 + side + " A" + "\u2660" + side;
					break;
					
				case 3: //copas
					r_3 = r_3 + side + " A" + "\u2665" + side;
					break;
					
				case 4: //paus
					r_3 = r_3 + side + " A" + "\u2663" + side;
					break;
				default:
					break;
				}
			}
			
		}
			
			System.out.printf("\n%s\n%s\n%s\n%s\n%s\n", r_1,r_2,r_3,r_4,r_5);
						
		}
	
	/**
	 * Pega as cartas aleatoriamente do baralho
	 */
	void randDraw(){
		Rand r = new Rand();
		for(int i = 0; i < 5; i++){
			int card_value = r.getRange(14, 2); 
			int card_naipe = r.getRange(4, 1);
			
			for(int j = 0; j < i; j++){
					if(card_value == mao[j] && card_naipe == naipe[j]){
						 card_value = r.getRange(14, 2); 
						 card_naipe = r.getRange(4, 1);	
						 
						 if(card_value == mao[j] && card_naipe == naipe[j]) {
							 j--;
						 }
					}
				}
			mao[i] = card_value;
			naipe[i] = card_naipe;
		
		}				
	}
	
	/**
	 * Pega novas cartas do baralho caso o usuario deseje substutuir de sua mao
	 * @param cartas que deseja substituir
	 */
	void partialDraw(String s)
	{	Rand r = new Rand();
		String[] sel = s.split(" ");
		
		for(int i = 0; i < sel.length; i++)
		{
			mao[Integer.parseInt(sel[i])] = 0;
			naipe[Integer.parseInt(sel[i])] = 0;
			
			
			
			int card_value = r.getRange(14, 2); 
			int card_naipe = r.getRange(4, 1);
			
			for(int j = 0; j < i; j++){
					if(card_value == mao[j] && card_naipe == naipe[j]){
						 card_value = r.getRange(14, 2); 
						 card_naipe = r.getRange(4, 1);	
						 
						 if(card_value == mao[j] && card_naipe == naipe[j]) {
							 j--;
						 }
					}
				}
			mao[Integer.parseInt(sel[i])] = card_value;
			naipe[Integer.parseInt(sel[i])] = card_naipe;
		}		
	}	
}
