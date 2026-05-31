import java.util.Random;
import java.util.Scanner;

public class Lista {
    private Scanner scanner = new Scanner(System.in);

    private Node prim;
    private Random random;

    public Lista () {
        this.prim = null;
        this.random = new Random();
    }

    public boolean verificaOrdem() {
        Node node = prim;

        while (node.getProximo() != null) {
            if (node.getNumero() > node.getProximo().getNumero()) {
                return false;
            }
            node = node.getProximo();
        }

        return true;
    }

    public void ordenaCrescente() {
        boolean troca;

        do {
            troca = false;

            Node prev = null;
            Node atual = prim;

            while (atual.getProximo() != null) { 
                Node prox = atual.getProximo();

                if (atual.getNumero() > prox.getNumero()) {
                    atual.setProximo(prox.getProximo());
                    prox.setProximo(atual);

                    if (prev == null) {
                        prim = prox;
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

    // outdated
    // public void addInicio(int i) {
    //     Node novoNode = new Node();
    //     novoNode.setNumero(i);
    //     novoNode.setProximo(prim);
    //     prim = novoNode;
    // }

    public Node pegaUltimoNode() {
        for (Node node = prim; node != null; node = node.getProximo()) {
            if (node.getProximo() == null) {
                return node;
            }
        }
        return null;
    }

    //add completo
    public void add(int valor) {
        Node novoNode = new Node();
        Node ultimoNode = pegaUltimoNode();

        novoNode.setNumero(valor);
        novoNode.setProximo(null);

        if (ultimoNode != null) {
            ultimoNode.setProximo(novoNode);
        } else {
            prim = novoNode;
        }
    }

    public void addAleatorio() {
        int valor = random.nextInt(100);
        Node novoNode = new Node();
        Node ultimoNode = pegaUltimoNode();

        //System.out.println(valor);
        novoNode.setNumero(valor);
        novoNode.setProximo(null);
        
        if (ultimoNode != null) {
            ultimoNode.setProximo(novoNode);
        } else {
            prim = novoNode;
        }
    }

    // outdated
    // public void print() {
    //     for (Node node = prim; node != null; node = node.getProximo()) {
    //         System.out.print(node.getNumero() + " ");
    //     }
    //     System.out.println();
    // }

    public void printRecursico(Node node) {
        System.out.print(node.getNumero() + " ");
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

    public Node getPrim() {
        return prim;
    }

    public void setPrim(Node prim) {
        this.prim = prim;
    }  
}