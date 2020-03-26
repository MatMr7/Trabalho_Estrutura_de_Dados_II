/*
 * Uri1166
 * Este problema consiste em encontrar a quantidade dmáxima de bolas que podem ser colocadas satisfazendo 
 * as regras descritas no problema.
 * 
 * Matheus Morais.
 */

import java.util.Scanner;

public class uri1166 {
	
	
	static boolean isRaiz( int n) { //Este método verifica se um certo valor n é raiz quadrada
		
		int raiz = (int)(Math.sqrt(n) + 0.5); //O cast é realizado pois o retorno do método Math.sqrt() não é int
		
		return (raiz*raiz ) == n ? true : false;// Caso seja raiz é retornado true, caso contrário false
	}
	static int [] calculaMaxBolas() {//Este método calcula todos os resultados possiveis para a quantidade possível de Pags que é entre 1 e 50
		
		int [] maxBolas = new int[53]; // O problema diz queo maximo de bolas é 50, então coloquei 53 pra ter uma sobra
				
		int ultimaBola[] = new int[53];// Aqui são guardadas as ultimas bolas 
		
		int p = 0; //referencia as pags citadas no problema
		
		int prox = 1;
		
		
		while(true) {
			
			boolean useNextP = true; 
			
			for(int k = 1; k<= p;k++) {//Neste for, caso a condição de raiz seja satisfeita, o valor prox + ultimaBola[k] é colocado no array 
				if(isRaiz(ultimaBola[k] + prox)) {
					useNextP = false;
					ultimaBola[k] = prox;
				}
				
			}
			
			if(useNextP == true) { //Caso a condição de raiz não seja satisfeita entra nesse if,que vai colocar no indice p o valor do prox -1 e a ultima bola com valor de prox
				maxBolas[p] = prox -1;
				p = p+1;
				ultimaBola[p] = prox;
				if(p == 51) break;//caso o p chegue a 51, o que significa que ele checou o valor para todas as 50 Pags
			}
			prox ++;
			
		}
		return maxBolas;
	}
	public static void main(String []  args) {
		
		Scanner sc = new Scanner(System.in);
		
		int [] max = calculaMaxBolas(); //Aqui o valor maximo de bolas que pode ser colocado para cada quantidade de Pags
		
		int in = Integer.parseInt(sc.nextLine()); // Aqui é lida a quantidade de entradas
		
		int [] entradas = new int[in]; // aqui as entradas ficararão armazenadas
		
		int cont = 0; // um contador para auxiliar no input das entradas
		
		for( int k : entradas) {//neste for as entradas são de fato lidas
			entradas[cont] = Integer.parseInt(sc.nextLine());
			++cont;
		}
		for ( int k : entradas) {//aqui os resultados são printados
			System.out.println(max[k]);
		}
		
	}

}