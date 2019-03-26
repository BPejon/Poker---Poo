
public class Carta {
	
	private int[] naipe = {0,0,0,0,0}; //1 = ouros 2 = espadas 3 = copas 4 = paus
	private int[] mao = {0,0,0,0,0}; // 11 = J 12 = Q 13 = R 14 = A
	
	public Carta(int[] n, int[] m)
	{
		naipe = n;
		mao  = m;
	}
	
	//Unicode -> valores para os simbolos:
	//9824
	//9827
	//9830
	//9829
	//Usar Character.toString(char c);
	void displayHand()
	{
		String top = " +-----+ ";
		String side = " | ";
		
		String r_1 = "";
		String r_2 = "";
		String r_3 = "";
		String r_4 = "";
		String r_5 = "";
		
		
		for(int i = 0; i < 5; i++)
		{
			r_1 = r_1 + top;
			r_2 = r_2 + side + "   " + side;
			r_4 = r_4 + side + "   " + side;
			r_5 = r_5 + top;
			if(mao[i] < 10)
			{
				switch(naipe[i])
				{
				case 1: //ouros
					r_3 = r_3 + side + " " + mao[i] + "♦" + side;
					break;
				case 2: //espadas
					r_3 = r_3 + side + " " + mao[i] + "♠" + side;
					break;
				case 3: //copas
					r_3 = r_3 + side +" " + mao[i] + "♥" + side;
					break;
				case 4: //paus
					r_3 = r_3 + side + " " + mao[i] + "♣" + side;
					break;
				default:
					break;
				}
			}
			
			if(mao[i] == 10)
			{
				switch(naipe[i])
				{
				case 1: //ouros
					r_3 = r_3 + side + "10" + "♦" + side;
					break;
				case 2: //espadas
					r_3 = r_3 + side + "10" + "♠" + side;
					break;
				case 3: //copas
					r_3 = r_3 + side + "10" + "♥" + side;
					break;
				case 4: //paus
					r_3 = r_3 + side + "10" + "♣" + side;
					break;
				default:
					break;
				}
			}
			
			if(mao[i] == 11)
			{
				switch(naipe[i])
				{
				case 1: //ouros
					r_3 = r_3 + side + " J" + "♦" + side;
					break;
				case 2: //espadas
					r_3 = r_3 + side + " J" + "♠" + side;
					break;
				case 3: //copas
					r_3 = r_3 + side + " J" + "♥" + side;
					break;
				case 4: //paus
					r_3 = r_3 + side + " J" + "♣" + side;
					break;
				default:
					break;
				}
			}
			if(mao[i] == 12)
			{
				switch(naipe[i])
				{
				case 1: //ouros
					r_3 = r_3 + side + " Q" + "♦" + side;
					break;
				case 2: //espadas
					r_3 = r_3 + side + " Q" + "♠" + side;
					break;
				case 3: //copas
					r_3 = r_3 + side + " Q" + "♥" + side;
					break;
				case 4: //paus
					r_3 = r_3 + side + " Q" + "♣" + side;
					break;
				default:
					break;
				}
			}
			if(mao[i] == 13)
			{
				switch(naipe[i])
				{
				case 1: //ouros
					r_3 = r_3 + side + " K" + "♦" + side;
					break;
				case 2: //espadas
					r_3 = r_3 + side + " K" + "♠" + side;
					break;
				case 3: //copas
					r_3 = r_3 + side + " K" + "♥" + side;
					break;
				case 4: //paus
					r_3 = r_3 + side + " K" + "♣" + side;
					break;
				default:
					break;
				}
			}
			if(mao[i] == 14)
			{
				switch(naipe[i])
				{
				case 1: //ouros
					r_3 = r_3 + side + " A" + "♦" + side;
					break;
				case 2: //espadas
					r_3 = r_3 + side + " A" + "♠" + side;
					break;
				case 3: //copas
					r_3 = r_3 + side + " A" + "♥" + side;
					break;
				case 4: //paus
					r_3 = r_3 + side + " A" + "♣" + side;
					break;
				default:
					break;
				}
			}
			
		}
			
			System.out.printf("\n%s\n%s\n%s\n%s\n%s\n", r_1,r_2,r_3,r_4,r_5);
		
		
		
		}
	
	void randDraw()
	{
		Rand r = new Rand();
		for(int i = 0; i < 5; i++)
		{
			int card_value = r.getRange(14, 2); 
			int card_naipe = r.getRange(4, 1);
			
			for(int j = 0; j < i; j++)
				{
					if(card_value == mao[j] && card_naipe == naipe[j])
					{
						 card_value = r.getRange(14, 2); 
						 card_naipe = r.getRange(4, 1);	
						 
						 if(card_value == mao[j] && card_naipe == naipe[j])
						 {
							 j--;
						 }
							 
					}
				}
			mao[i] = card_value;
			naipe[i] = card_naipe;
		
		}
		
		
		
	}
		
}
