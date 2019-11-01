package filacircular;

public class Fila {

    private int inicio;
    private int total;
    private int tamanho;
    private Nodo[] fila;

    public Fila(int tamanho) {
        this.inicio = 0;
        this.total = 0;
        this.tamanho = tamanho;
        this.fila = new Nodo[tamanho];
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public boolean isVazia() {
        return this.total == 0;
    }

    public boolean isCheia() {
        return this.total == this.tamanho;
    }

    public Nodo desempilharNodo() {
        Nodo nodoQueSaiu = this.fila[this.inicio];
        this.fila[this.inicio] = null;
        this.inicio += 1;
        
        if (this.inicio == this.tamanho) {
            this.inicio = 0;
        }
        
        total--;

        return nodoQueSaiu;
    }

    public void empilharNodo(Nodo nodoAEmpilhar) {
        int posicaoAtual = 0;

        if (!this.isCheia()) {
            while (fila[posicaoAtual] != null) {
                posicaoAtual++;
            }
            
            this.fila[posicaoAtual] = nodoAEmpilhar;
            this.total++;
        } else {
            System.out.println("\nFila cheia!");
        }

    }

    public void imprimirFila() {
        if (this.isVazia()) {
            System.out.println("\nFila vazia!");
        } else {
            System.out.print("\nFila = [ ");

            boolean jaPassouPelo0 = false;
            int vaiPararOnde = this.tamanho;
            
            for (int i = this.inicio; i < vaiPararOnde; i++) {
                if (this.fila[i] != null) {
                    System.out.print(fila[i].getDado().toString() + " ");
                } else {
                    break;
                }

                if (jaPassouPelo0 == false) {
                    if (i != 0) {
                        if (i == this.tamanho - 1) {
                            vaiPararOnde -= this.inicio;
                            i = -1;
                        }
                    } else {
                        jaPassouPelo0 = true;
                    }
                }
            }

            System.out.print("]");
        }
    }
}
