package projeto2;

import java.util.Scanner;

public class testaAvaliacaoExpressoes {

    public static void main(String[] args) {
        int opcao = 1;
        String expressao;

        Scanner leia = new Scanner(System.in);
        NotacaoPolonesaReversa npr = new NotacaoPolonesaReversa();

        //npr.infixaParaNpr("(A + B) / (C - D)");
        //npr.infixaParaNpr("((A+(B*C))-D)");
        //npr.infixaParaNpr("(A + B)/(C - D) * E");
        //npr.calcularNpr(npr.infixaParaNpr("(7 + 3)/(6 - 4) * 9"));
        
        while (opcao != 0) {
            System.out.println("1. Expressão infixa para notação polonesa reversa");
            System.out.println("\tEx.: ((A + (B * C)) - D)");
            System.out.println("\n2. Resolução de expressão infixa com valores");
            System.out.println("\tEx.: (7 + 3)/(6 - 4) * 9");
            System.out.println("\n0. Sair");
            System.out.print("Escolha a opção desejada: ");
            opcao = leia.nextInt();
            leia.nextLine();

            if (opcao == 1) {
                System.out.print("Informe a expressão infixa: ");
                expressao = leia.nextLine();
                Pilha expressaoEmNpr = npr.infixaParaNpr(expressao);
                expressaoEmNpr = Pilha.inverterPilha(expressaoEmNpr);

                System.out.print("Expressão na notação polonesa reversa: ");

                while (!expressaoEmNpr.vazia()) {
                    System.out.print(expressaoEmNpr.pop());
                }
            } else if (opcao == 2) {
                System.out.print("Informe a expressão infixa: ");

                expressao = leia.nextLine();
                int resultado = npr.calcularNpr(npr.infixaParaNpr(expressao));

                System.out.println("Resultado: " + resultado);
            }
            
            System.out.println("\n");
        }
    }

}
