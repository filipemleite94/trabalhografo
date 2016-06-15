package trabalhografo;

import java.util.ArrayList;

public class heldkarp {
	
	int[][] grafo;
	int tamanho;
	intvetor melhor;
	
	public heldkarp(int[][] grafo){
		int i;
		this.grafo = grafo;
		tamanho = grafo.length;
		ArrayList<Integer> P = new ArrayList<Integer>();
		for(i=1; i<tamanho; i++){
			P.add(i);
		}
		intvetor c = new intvetor(tamanho);
		melhor = customin(0, P, c);
		System.out.println("Held-Karp: ");
		System.out.println(melhor.custo);
		System.out.println("Melhor caminho: ");
		for(i=0; i<tamanho; i++)
			System.out.print(melhor.caminho[i]+" ");
	}
	
	private intvetor customin(int i, ArrayList<Integer> P, intvetor c){
		if (P.size()==0){
			if (grafo[0][i]>=0){
				c.custo=grafo[0][i];
				c.caminho[0]=i;
			}
			else {
				c.custo=-1;
				c.caminho[0]=-1;
			}
			return c;
		}
		else{
			return minimo(i,P, c);
		}
	}
	
	private intvetor minimo(int i, ArrayList<Integer> P, intvetor c){
		int cont, aux;
		intvetor minimo, mediador;
		minimo = new intvetor(tamanho);
		minimo.custo = -1;
		minimo.caminho[0]=-1;
		mediador = new intvetor(c);
		for (cont = 0; cont < P.size(); cont++) {
			aux = P.get(0);
			P.remove(0);
			mediador = customin(aux, P, mediador);
			if ((mediador.custo >= 0) && (grafo[i][aux] >= 0)) {
				mediador.custo += grafo[i][aux];
				mediador.caminho[P.size()] = aux;
				if ((mediador.custo < minimo.custo)||(minimo.custo<0))
					minimo = mediador;
			}
			P.add(P.size(), aux);
		}
		return minimo;
	}
}
