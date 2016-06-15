package trabalhografo;

import java.util.Random;

public class geradorgrafo {
	int[][] grafo;
	int[] valores;
	int m, n;

	public geradorgrafo(int m, int n) {
		int i, j;
		Random gerador = new Random();
		valores = new int[((m - 1) * m / 2)];
		grafo = new int[m][m];
		this.m = m;
		this.n = n;
		for (i = 0; i < m; i++)
			grafo[i][i] = -1;
		for (i = 0; i < ((m - 1) * m / 2); i++) {
			valores[i] = gerador.nextInt();
		}
		for (i = 0; i < m; i++) {
			for (j = 0; j < i; j++) {
				if (checar(i, j)) {
					grafo[i][j] = grafo[j][i] = gerador.nextInt(11);
				} else {
					grafo[i][j] = grafo[j][i] = -1;
				}
			}
		}
		for (i = 0; i < m; i++) {
			for (j = 0; j < m; j++)
				System.out.print(grafo[i][j] + " ");
			System.out.print('\n');
		}

	}

	public boolean checar(int i, int j) {
		int val, i2, j2;
		val = ((i - 1) * i / 2) + j;
		for (i2 = 0, j2 = 0; (i2 < valores.length) && (j2 < n); i2++) {
			if (valores[val] < valores[i2])
				j2++;
		}
		if (j2 == n)
			return false;
		else
			return true;
	}
}