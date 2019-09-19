package pilhalista;

public class Nodo {

    private Object dado;
    private Nodo prox;

    public Nodo(Object dado) {
        this.dado = dado;
        this.prox = null;
    }

    public Object getDado() {
        return dado;
    }

    public Nodo getProx() {
        return prox;
    }

    public void setProx(Nodo prox) {
        this.prox = prox;
    }
}
