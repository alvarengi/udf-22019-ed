package projeto2;

import projeto2.avaliacaoExpressoes;

public class testaAvaliacaoExpressoes {

    public static void main(String[] args) {
		avaliacaoExpressoes ae = new avaliacaoExpressoes();
		ae.infixaParaNpr("(A + B) / (C - D)");
		//ae.infixaParaNpr("(A + B)/(C - D) * E");

		/* Existe um problema no algoritmo apresentado na página 2:
		   No caso do último passo do algoritmo ainda tem um operando 
		   dentro da pilha, logo tenho de limpar toda a pilha ao fechar
		   o parênteses.
		*/
	}
}