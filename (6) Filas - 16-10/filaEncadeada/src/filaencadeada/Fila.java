package filaencadeada;

public class Fila {
    private Nodo comeco;
    private Nodo fim;
    private int total;
    
    public Fila() {
        comeco = null;
        fim = null;
        total = 0;
    }
    
    public boolean isEmpty() {
        return (total == 0);
    }
    
    public void enqueue(Object x) {
        Nodo novo = new Nodo();
        novo.setDado(x);
        novo.setProximo(null);
        if(isEmpty()){
            comeco = null;
            fim = comeco;
        } else {
            fim.setProximo(novo);
            fim = novo;
        }
        total++;
    }
    
    public Object dequeue() {
        Object resp = null;
        if(!isEmpty()){
            resp = comeco.getDado();
            comeco = comeco.getProximo();
            total--;
        }
        return resp;
    }
    
    public void print() {
        if (isEmpty()) {
            System.out.println("Fila vazia!");
        } else {
            Nodo aux;
            String saida = "";
            aux = comeco;
            while (aux != null) {
                saida += aux.getDado().toString() + ", ";
                aux = aux.getProximo();
            }
            System.out.println("F: [ " + saida + "]");
        }
    }
}
