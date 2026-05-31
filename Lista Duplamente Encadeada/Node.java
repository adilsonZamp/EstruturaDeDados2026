public class Node {
    private int numero;
    private Node proximo;
    private Node anterior;

    public Node(int numero, Node proximo, Node anterior) {
        this.numero = numero;
        this.proximo = proximo;
        this.anterior = anterior;
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
    public Node getAnterior() {
        return anterior;
    }
    public void setAnterior(Node anterior) {
        this.anterior = anterior;
    }
}