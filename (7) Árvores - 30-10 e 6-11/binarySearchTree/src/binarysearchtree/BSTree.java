package binarysearchtree;

public class BSTree {

    private BTreeNode raiz;

    public BSTree() {
        raiz = null;
    }

    public BTreeNode getRaiz() {
        return raiz;
    }

    public void inserir(int valor) {
        BTreeNode novo = new BTreeNode(); // cria um novo Nó
        novo.setDado(valor); // atribui o valor recebido ao item de dados do Nó

        if (raiz == null) // árvore vazia, novo será a raiz
        {
            raiz = novo;
        } else {
            BTreeNode atual = raiz;
            BTreeNode anterior;
            while (true) {
                anterior = atual;
                if (valor <= atual.getDado()) { // ir a esquerda
                    atual = atual.getEsq();
                    if (atual == null) {
                        anterior.setEsq(novo);
                        return;
                    }
                } // fim da condição ir a esquerda
                else { // ir a direita
                    atual = atual.getDir();
                    if (atual == null) {
                        anterior.setDir(null);
                        return;
                    }
                } // fim da condição ir a direita
            } // fim do laço while
        } // fim do else árvore não vazia
    }

    public int altura(BTreeNode atual) {
        if (atual == null) {
            return 0;
        } else {
            if (altura(atual.getEsq()) > altura(atual.getDir())) {
                return (1 + altura(atual.getEsq()));
            } else {
                return (1 + altura(atual.getDir()));
            }
        }
    }

    public void inOrder(BTreeNode atual) {
        if (atual != null) {
            inOrder(atual.getEsq());
            System.out.print(atual.getDado() + " ");
            inOrder(atual.getDir());
        }
    }

    public void preOrder(BTreeNode atual) {
        if (atual != null) {
            System.out.print(atual.getDado() + " ");
            inOrder(atual.getEsq());
            inOrder(atual.getDir());
        }
    }

    public void posOrder(BTreeNode atual) {
        if (atual != null) {
            inOrder(atual.getEsq());
            inOrder(atual.getDir());
            System.out.print(atual.getDado() + " ");
        }
    }
    
    public BTreeNode buscar(int chave) {
        if (raiz == null) return null; // se arvore vazia
        
        BTreeNode atual = raiz;
        while((atual.getDado() != chave) & (atual != null)) { // enquanto não encontrou
            if(chave < atual.getDado() )
                atual = atual.getEsq(); // caminha pra esquerda
            else
                atual = atual.getDir(); // caminha pra direita
        } // fim laço while
        
        return atual; // se atual é null, chave não encontrada, 
                      // caso contrário retorna a referência para o nó
    }
}
