package filacircular;

public class main {

    public static void main(String[] args) {
        Fila fila = new Fila(5);
        
        Nodo nodo1 = new Nodo();
        nodo1.setDado("João");
        Nodo nodo2 = new Nodo();
        nodo2.setDado("Maria");
        Nodo nodo3 = new Nodo();
        nodo3.setDado("José");
        Nodo nodo4 = new Nodo();
        nodo4.setDado("Fulano");
        Nodo nodo5 = new Nodo();
        nodo5.setDado("Ciclano");
        
        fila.empilharNodo(nodo1);
        fila.empilharNodo(nodo2);
        fila.empilharNodo(nodo3);
        fila.empilharNodo(nodo4);
        fila.empilharNodo(nodo5);
        
        fila.imprimirFila();
        
        Nodo shit = fila.desempilharNodo();
        System.out.println(shit.getDado());
        System.out.println(fila.desempilharNodo().getDado());
        System.out.println(fila.desempilharNodo().getDado());
        
        fila.imprimirFila();
        
        fila.empilharNodo(nodo1);
        fila.empilharNodo(nodo2);
        fila.empilharNodo(nodo3);
        fila.empilharNodo(nodo4);
        
        fila.imprimirFila();
    }
    
}
