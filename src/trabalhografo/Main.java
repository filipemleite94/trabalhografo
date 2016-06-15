package trabalhografo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m,n;
		geradorgrafo g;
		heldkarp h;
		bruto b;
		System.out.println("Digite o numero de vertices: ");
		m = s.nextInt();
		System.out.println("Digite o numero de arestas: ");
		n = s.nextInt();
		g = new geradorgrafo(m,n);
		h = new heldkarp(g.grafo);
		b = new bruto(g.grafo);
	}

}
