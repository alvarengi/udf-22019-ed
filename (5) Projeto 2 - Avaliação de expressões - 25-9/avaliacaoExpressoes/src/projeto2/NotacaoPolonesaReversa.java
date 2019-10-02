package projeto2;

public class NotacaoPolonesaReversa {

    public Pilha infixaParaNpr(String expressao) {
        Pilha pilha = new Pilha();
        Pilha saida = new Pilha();
        expressao = expressao.trim();

        for (int i = 0; i < expressao.length(); i++) {
            switch (expressao.charAt(i)) {
                case ' ':
                    continue;

                case '(':
                    pilha.push(expressao.charAt(i));
                    break;

                case '+':
                case '-':
                case '*':
                case '/':
                    if (!pilha.vazia() && (getPrioridadeOperador(expressao.charAt(i)) >= getPrioridadeOperador((char) pilha.top()) && (char) pilha.top() != '(')) {
                        saida.push(pilha.pop());
                    }
                    pilha.push(expressao.charAt(i));
                    break;

                case ')':
                    while (!pilha.vazia()) {
                        char atual = (char) pilha.pop();
                        if (atual != '(') {
                            saida.push(atual);
                        } else {
                            break;
                        }
                    }
                    break;

                default:
                    saida.push(expressao.charAt(i));
            }
        }

        while (!pilha.vazia()) {
            saida.push(pilha.pop());
        }

        return saida;
    }

    public static int getPrioridadeOperador(char operando) {
        int prioridade = 0;

        switch (operando) {
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

    public void calcularNpr(Pilha nprAResolver) {
        nprAResolver = Pilha.inverterPilha(nprAResolver);
        
        Pilha operandos = new Pilha();
        
        while (!nprAResolver.vazia()) {
            int operando1,
                operando2,
                resultado;

            char atual = (char) nprAResolver.pop();
            
            switch (atual) {
                case '+':
                    operando2 = (int) operandos.pop();
                    operando1 = (int) operandos.pop();
                    resultado = operando1 + operando2;
                    operandos.push(resultado);
                    break;

                case '-':
                    operando2 = (int) operandos.pop();
                    operando1 = (int) operandos.pop();
                    resultado = operando1 - operando2;
                    operandos.push(resultado);
                    break;

                case '*':
                    operando2 = (int) operandos.pop();
                    operando1 = (int) operandos.pop();
                    resultado = operando1 * operando2;
                    operandos.push(resultado);
                    break;

                case '/':
                    operando2 = (int) operandos.pop();
                    operando1 = (int) operandos.pop();
                    resultado = operando1 / operando2;
                    operandos.push(resultado);
                    break;

                default:
                    operandos.push((int) Character.getNumericValue(atual));
            }
        }

        System.out.println(operandos.top());
    }
}
