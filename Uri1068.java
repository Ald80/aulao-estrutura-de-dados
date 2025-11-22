import java.util.Scanner;

public class Uri1068 {
	public static void main(String[]args) {

	Scanner teclado = new Scanner(System.in);
	String expressao;
	boolean correct;

	while ( teclado.hasNext()) {
		correct = true;
		Pilha pilha = new Pilha();
		expressao = teclado.nextLine();
		for (int posicao=0; posicao < expressao.length() && correct; posicao ++) {
			if (expressao.charAt(posicao) == '(') {
				pilha.push(expressao.charAt(posicao));
			}
			else if (expressao.charAt(posicao) == ')') {
				if (pilha.isEmpty()) {
					correct = false;
				} else {
					pilha.pop();
				}
			}
		}
		if (pilha.isEmpty() && correct) {
			System.out.println("correct");
		} else {
			System.out.println("incorrect");
		}
	}
	
	}

	private static class Pilha {
		private int topo;
		private char elementos[];

		public Pilha() {
			this.topo = -1;
			elementos = new char[1000];
		}

		public boolean isEmpty() {
			return (topo == -1);
		}

		public void push(char e) {
			topo++;
			elementos[topo] = e;
		}

		public char pop() {
			char ele = elementos[topo];
			topo--;
			return ele;
		}
	}
}

// https://www.youtube.com/watch?v=YderH4_1zFY
// 31:21