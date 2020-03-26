
/*
 * Uri1286
 * O problema consiste em definir o tempo que Roberto irá levar para entregar as suas pizzas 
 * de acordo com os critérios apresentados no problema
 * 
 * Foi utilizada a estratégia da mochila para resolver o problema
 * 
 * Matheus Morais.
 */



import java.util.Scanner;

class Pedido { //Como não podemos usar outros arquivos no uri, criei um objeto pedido neste arquivo mesmo para facilitar
	
	public int tempo;
	public int qnt;
	
	Pedido(){
		this.tempo = 0;
		this.qnt = 0;
		
	}
}


public class uri1286 {
	
	public static int max( int a , int b) {//uma função simples para descobrir o valor max entre dois valores
		
		return  a > b ? a : b;
	}
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Pedido []  pedidos = new Pedido[999];//aqui é declarado um array de pedidos
		
		int [][] mtrz = new int[999][999]; // aqui é declarada uma matriz para auxiliar no problema da mochila
		
		
		for (int j = 0; j < pedidos.length; j++) {//aqui os objetos do array de pedidos são instanciados
			pedidos[j] = new Pedido();
		}
		
		
		
		
		while(true) {
			
			int n = Integer.parseInt(sc.nextLine());//aqui são declaradas a quantidade de entradas
			if(n == 0) break;// caso a entrda seja 0, que é a condição de parada, o programa é encerrado
			
			int p = Integer.parseInt(sc.nextLine());// indica o numero maximo de pizzas
			
			for(int i = 1; i <= n ; i++) {// aqui é feita a entrada dos dados e os dados são colocados nas variáveis dos objetos
				String [] temp = sc.nextLine().split(" ");
				pedidos[i].tempo = Integer.parseInt(temp[0]);
				pedidos[i].qnt = Integer.parseInt(temp[1]);
			}
			/*
			 * O código abaixo resolve o problema da mochila para os pedidos
			 */
			for(int k = 0;k <= n;k++) {
				for(int j = 0;j<=p;j++) {
					if(k == 0 || j == 0) {
						mtrz[k][j] = 0;
					}else {
						if(pedidos[k].qnt > j) {
							mtrz[k][j] = mtrz[k-1][j];
						}else {
							mtrz[k][j] = max(mtrz[k-1][j - pedidos[k].qnt] + pedidos[k].tempo,mtrz[k-1][j]);              
						}
					}
				}
			}
			/*
			 * Aqui são printados os resultados
			 */
			System.out.println(mtrz[n][p] + " min.");
			
		}
		
	}
}
