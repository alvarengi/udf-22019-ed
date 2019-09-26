package pilhalista;

import pilhalista.Nodo;

public class Pilha {
    
    private Nodo topo;
    private int quantElementos;
    
    public Pilha() {
        topo = null;
        quantElementos = 0;
    }
    
    public boolean vazia() {
        return (topo == null);
    }
    
    public int tamanho() {
        return this.quantElementos;
    }
    
    public Object top() {
        if (this.vazia())
            return null;
        else
            return this.topo.getDado();
    }
    
    public void push(Object elemento) {
        Nodo novo = new Nodo(elemento);
        novo.setProx(topo);
        topo = novo;
        quantElementos++;
    }
    
    public Object pop() {
        if (this.vazia())
            return null;
        else {
            Object elemento = topo.getDado();
            topo = topo.getProx();
            quantElementos--;
            return elemento;
        }
    }
}