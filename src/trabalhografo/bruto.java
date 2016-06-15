package trabalhografo;

public class bruto {

	int[][] grafo;
	int tamanho, minimo;
	int[] caminho;

	public bruto(int[][] grafo) {
		int i;
		int[] caminhomed;
		this.grafo = grafo;
		tamanho = grafo.length;
		minimo = -1;
		caminhomed = new int[tamanho + 1];
		for (i = 0; i < tamanho + 1; i++)
			caminhomed[i] = 0;
		caminho = new int[tamanho+1];
		for (i = 0; i < tamanho + 1; i++)
			caminho[i] = 0;
		min(0, caminhomed, 0);
		System.out.println("\nBruto: ");
		System.out.println(minimo);
		System.out.println("Melhor caminho: ");
		for (i = 0; i < tamanho + 1; i++)
			System.out.print(caminho[i] + " ");
	}

	public void min(int valor, int[] caminhomed, int profundidade) {
		int i, j, k;
		i = caminhomed[profundidade];
		for (j = 1; j < tamanho; j++) {
			if(checar(j, caminhomed, profundidade)||profundidade==tamanho-1){
				if (grafo[i][j] >= 0) {
					if (profundidade < tamanho-1) {
						caminhomed[profundidade+1] = j;
						min(valor + grafo[i][j], caminhomed, profundidade + 1);
						caminhomed[profundidade+1]=0;
					} else if (((valor + grafo[i][0]) < minimo) || (minimo < 0)) {
						if ((grafo[i][0] >= 0)) {
							minimo = valor + grafo[i][0];
							for(k=0; k<tamanho+1; k++){
								caminho[k]=caminhomed[k];
							}
						}
					}
				}
			}
		}
	}

	public boolean checar(int j, int[] cam, int profundidade) {
		int i;
		for(i=0; i<profundidade; i++)
				if(cam[i] == j) return false;
		return true;
	}
}
