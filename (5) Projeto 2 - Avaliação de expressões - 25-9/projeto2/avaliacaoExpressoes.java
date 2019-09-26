package projeto2;

import projeto2.Pilha;

public class avaliacaoExpressoes {

	public Pilha infixaParaNpr(String expressao){
		Pilha pilha = new Pilha();
		expressao = expressao.trim();

		for(int i = 0; i < expressao.length(); i++){
			switch(expressao.charAt(i)){
				case ' ':
				case '(': 
				continue;

				case '+':
				case '-':
				case '*':
				case '/':
				pilha.push(expressao.charAt(i));
				break;

				case ')':
				while(!pilha.vazia()) System.out.println(pilha.pop());
				break;

				default:
				System.out.println(expressao.charAt(i));
			}
		}

		while(!pilha.vazia())
			System.out.println(pilha.pop());

		return pilha;
	}
}