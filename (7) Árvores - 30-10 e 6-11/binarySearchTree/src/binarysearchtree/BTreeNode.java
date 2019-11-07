package binarysearchtree;

public class BTreeNode {
    // dado do nó
    private int dado;

    // filhos esquerdo e direito
    private BTreeNode esq, dir;

    public BTreeNode() {

    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public BTreeNode getEsq() {
        return esq;
    }

    public void setEsq(BTreeNode esq) {
        this.esq = esq;
    }

    public BTreeNode getDir() {
        return dir;
    }

    public void setDir(BTreeNode dir) {
        this.dir = dir;
    }
}
