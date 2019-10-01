package projeto2;

import projeto2.avaliacaoExpressoes;

public class testaAvaliacaoExpressoes {

    public static void main(String[] args) {
		avaliacaoExpressoes ae = new avaliacaoExpressoes();
		//ae.infixaParaNpr("(A + B) / (C - D)");
		ae.infixaParaNpr("(7 + 3)/(6 - 4) * 9");
	}
}