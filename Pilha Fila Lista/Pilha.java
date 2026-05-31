import java.util.Random;

public class Pilha {
    private Node top; //primeiro
    private final Random random;

    public Pilha () {
        this.top = null;
        this.random = new Random();
    }

    public boolean verificaOrdem(String ordem) {
        Node node = top;

        if (ordem.equals("crescente")) {
            while (node.getProximo() != null) {
                if (node.getNumero() > node.getProximo().getNumero()) {
                    return false;
                }
                node = node.getProximo();
            }
        } else if (ordem.equals("decrescente")) {
            while (node.getProximo() != null) {
                if (node.getNumero() < node.getProximo().getNumero()) {
                    return false;
                }
                node = node.getProximo();
            }
        }
        
        return true;
    }

    public void ordenaCrescente() {
        boolean troca;

        System.out.println("Ordenando...");

        do {
            troca = false;

            Node prev = null;
            Node atual = top;

            while (atual.getProximo() != null) { 
                Node prox = atual.getProximo();

                //maior no topo
                if (atual.getNumero() > prox.getNumero()) {
                    atual.setProximo(prox.getProximo());
                    prox.setProximo(atual);

                    if (prev == null) {
                        top = prox;
                    } else {
                        prev.setProximo(prox);
                    }
 
                    troca = true;

                    prev = prox;
                } else {
                    prev = atual;
                    atual = atual.getProximo();
                }
            }
        } while (troca);
    }

    public void ordenaDecrescente() {
        boolean troca;

        System.out.println("Ordenando...");

        do {
            troca = false;

            Node prev = null;
            Node atual = top;

            while (atual.getProximo() != null) { 
                Node prox = atual.getProximo();

                //maior no topo
                if (atual.getNumero() < prox.getNumero()) {
                    atual.setProximo(prox.getProximo());
                    prox.setProximo(atual);

                    if (prev == null) {
                        top = prox;
                    } else {
                        prev.setProximo(prox);
                    }
 
                    troca = true;

                    prev = prox;
                } else {
                    prev = atual;
                    atual = atual.getProximo();
                }
            }
        } while (troca);
    }

    public Node pegaUltimoNode() {
        for (Node node = top; node != null; node = node.getProximo()) {
            if (node.getProximo() == null) {
                return node;
            }
        }
        return null;
    }

    public void push(int valor) {
        Node novoNode = new Node();

        novoNode.setNumero(valor);
        novoNode.setProximo(top);
        top = novoNode;
    }

    public boolean pop() {
        if (top == null) {
            System.out.println("Não existem mais itens");
            return false;
        } else {
            System.out.println("Item "+top.getNumero()+" removido.");
            top = top.getProximo();
            return true;
        }
    }

    public void pushAleatorio() {
        int valor = random.nextInt(100);
        // System.out.println(valor);

        push(valor);
    }

    public void printRecursico(Node node) {
        System.out.println(node.getNumero());
        if (node.getProximo() != null) {
            printRecursico(node.getProximo());
        }
    }

    public void printRecursicoReverso(Node node) {
        if (node.getProximo() != null) {
            printRecursicoReverso(node.getProximo());
        }
        System.out.print(node.getNumero() + " ");
    }

    public Node getTop() {
        return top;
    }

    public void setTop(Node prim) {
        this.top = prim;
    }  
}