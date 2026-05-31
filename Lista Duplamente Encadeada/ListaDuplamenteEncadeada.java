public class ListaDuplamenteEncadeada {
    private Node head;
    private Node tail;

    public void criarListaDupla() {
        head = null;
        tail = null;
    }

    public boolean listaVazia() {
        if (head == null && tail == null) {
            return true;
        } else {
            return false;
        }
    }

    

    public Node getHead() {
        return head;
    }
    public Node getTail() {
        return tail;
    }
    public void setHead(Node head) {
        this.head = head;
    }
    public void setTail(Node tail) {
        this.tail = tail;
    }
}
