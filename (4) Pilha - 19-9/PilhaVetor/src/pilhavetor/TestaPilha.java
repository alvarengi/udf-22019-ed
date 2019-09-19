package pilhavetor;

import pilhavetor.Pilha;

public class TestaPilha {

    public static void main(String[] args) {
        Pilha P1 = new Pilha(20);

        P1.push("A");
        System.out.println(P1.top());
        
        P1.push("B");
        System.out.println(P1.top());
        
        System.out.println(P1.pop());
        
        System.out.println(P1.top());
        
        System.out.println(P1.pop());
        
        System.out.println(P1.top());
    }

}
