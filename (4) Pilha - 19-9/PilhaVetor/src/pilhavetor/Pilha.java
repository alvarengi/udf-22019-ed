package pilhavetor;

public class Pilha {
    private final int CAPACIDADEDEFAULT = 30;
    private int topo;
    private Object areaPilha[];

    public Pilha() {
        areaPilha = new Object[CAPACIDADEDEFAULT];
        topo = -1;
    }    
    
    public Pilha(int capacidade) {
        areaPilha = new Object[capacidade];
        topo = -1;
    }
    
    public boolean vazia() {
        return(topo < 0);
    }
    
    public int tamanho() {
        return topo + 1;
    }
    
    public Object top(){
        if(this.vazia())
            return null;
        else
            return this.areaPilha[this.topo];
    }
    
    public void push(Object elemento){
        if (this.topo < this.areaPilha.length - 1){
            this.areaPilha[++topo] = elemento;
        }
    }
    
    public Object pop() {
        if(this.vazia())
            return null;
        else
            return this.areaPilha[this.topo--];
    }      
}
