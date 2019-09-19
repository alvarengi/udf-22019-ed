package pilhalista;

import pilhalista.Pilha;

public class testaPilha {

    public static void main(String[] args) {
        Pilha P1 = new Pilha();

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
