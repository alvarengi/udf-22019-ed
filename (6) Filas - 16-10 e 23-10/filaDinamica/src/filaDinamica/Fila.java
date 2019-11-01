package filaDinamica;

public class Fila {

    private Nodo inicio;
    private Nodo fim;

    public Nodo getFim() {
        return fim;
    }

    public void setFim(Nodo fim) {
        this.fim = fim;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public boolean isVazia() {
        return this.inicio == null;
    }

    public void enfileirarDado(Nodo dado) {
        if (this.isVazia()) {
            this.inicio = dado;
            this.fim = dado;
        } else {
            this.fim.setProximo(dado);
            this.fim = dado;
        }
    }
    
    public Object desenfilerarDado(){
        if(this.isVazia()){
            return null;
        } else {
            Object dado = this.inicio.getDado();
            this.inicio = inicio.getProximo(); 
            return dado;
        }
    }
    
    public void imprimirFila(){
        if(this.isVazia()){
            System.out.println("Fila vazia!");
        } else {
            System.out.print("\nFila = [ ");
            Nodo nodoAtual = this.inicio;
            while(nodoAtual != null){
                System.out.print(nodoAtual.getDado().toString() + " ");
                nodoAtual = nodoAtual.getProximo();
            }
            System.out.print("]");
        }
    }
}
