package trabalhografo;

public class intvetor {
	
	int custo;
	int[] caminho;	
	
	public intvetor(int tamanho){
		caminho = new int[tamanho];
	}
	
	public intvetor (intvetor c){
		int i;
		this.custo = c.custo;
		this.caminho = new int[c.caminho.length];
		for (i = 0; i< this.caminho.length; i++){
			this.caminho[i] = this.caminho[i];
		}
	}
}
