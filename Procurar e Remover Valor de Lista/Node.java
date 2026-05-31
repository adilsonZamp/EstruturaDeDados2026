public class Node {
    private int numero;
    private Node proximo;

    public Node(int numero, Node proximo) {
        this.numero = numero;
        this.proximo = proximo;
    }

    public Node() {}

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public Node getProximo() {
        return proximo;
    }
    public void setProximo(Node node) {
        this.proximo = node;
    }
}