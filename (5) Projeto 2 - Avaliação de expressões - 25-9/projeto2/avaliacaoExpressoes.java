package projeto2;

import projeto2.Pilha;

public class avaliacaoExpressoes {

	public Pilha infixaParaNpr(String expressao){
		Pilha pilha = new Pilha();
		expressao = expressao.trim();

		for(int i = 0; i < expressao.length(); i++){
			switch(expressao.charAt(i)){
				case ' ': 
				continue;
				
				case '(':
					pilha.push(expressao.charAt(i));
				break;

				case '+':
				case '-':
				case '*':
				case '/':
					if(!pilha.vazia() && (getPrioridadeOperador((char) pilha.top()) >= getPrioridadeOperador(expressao.charAt(i))))
						System.out.println(pilha.pop());
					pilha.push(expressao.charAt(i));
				break;

				case ')':
					while(!pilha.vazia() && expressao.charAt(i) != '(') System.out.println(pilha.pop());
				break;

				default:
				System.out.println(expressao.charAt(i));
			}
		}

		while(!pilha.vazia())
			System.out.println(pilha.pop());

		return pilha;
	}

	public static int getPrioridadeOperador(char operando){
		int prioridade = 0;

		switch(operando) {
			case '(': 
				prioridade = 1; 
				break;

			case '+':
			case '-':
				prioridade = 2;
				break;

			case '*':
			case '/':
				prioridade = 3;
				break;
		}

		return prioridade;
	}
}