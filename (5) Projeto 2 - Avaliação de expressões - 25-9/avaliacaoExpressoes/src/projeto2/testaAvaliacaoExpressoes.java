package projeto2;

public class testaAvaliacaoExpressoes {

    public static void main(String[] args) {
        NotacaoPolonesaReversa npr = new NotacaoPolonesaReversa();
	//npr.infixaParaNpr("(A + B) / (C - D)");
	//npr.infixaParaNpr("((A+(B*C))-D)");
	//npr.infixaParaNpr("(A + B)/(C - D) * E");
	npr.calcularNpr(npr.infixaParaNpr("(7 + 3)/(6 - 4) * 9"));
    }
    
}
