package filaDinamica;

public class main {

    public static void main(String[] args) {
        Nodo n1 = new Nodo();
        n1.setDado("A");
        
        Nodo n2 = new Nodo();
        n2.setDado("B");
        
        Nodo n3 = new Nodo();
        n3.setDado("C");
        
        Nodo n4 = new Nodo();
        n4.setDado("D");
        
        Nodo n5 = new Nodo();
        n5.setDado("E");
        
        Nodo n6 = new Nodo();
        n6.setDado("F");
        
        Fila alfabeto = new Fila();
        alfabeto.enfileirarDado(n1);
        alfabeto.enfileirarDado(n2);
        alfabeto.enfileirarDado(n3);
        alfabeto.enfileirarDado(n4);
        alfabeto.enfileirarDado(n5);
        alfabeto.enfileirarDado(n6);

        while(!alfabeto.isVazia()){
            Object saiu = alfabeto.desenfilerarDado();
            System.out.println("\nDado que saiu: " + saiu.toString());
            alfabeto.imprimirFila();
        }
    }
}
