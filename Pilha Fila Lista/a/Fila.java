import java.util.Random;

public class Fila {
    private final Random random;
    private Node prim;
    private Node ultm;

    public Fila () {
        this.prim = null;
        this.ultm = null;
        this.random = new Random();
    }

    public Resultado verificaOrdem(String ordem) {
        Resultado resultado = new Resultado();
        Node node = prim;

        if (ordem.equals("crescente")) {
            while (node.getProximo() != null) {
                if (node.getNumero() > node.getProximo().getNumero()) {
                    resultado.setNode(node);
                    resultado.setResultado(false);
                    return resultado;
                }
                node = node.getProximo();
            }
        } else if (ordem.equals("decrescente")) {
            while (node.getProximo() != null) {
                if (node.getNumero() < node.getProximo().getNumero()) {
                    resultado.setNode(node);
                    resultado.setResultado(false);
                    return resultado;
                }
                node = node.getProximo();
            }
        }
        
        resultado.setNode(node);
        resultado.setResultado(true);
        return resultado;
    }

    public void ordenaCrescente() {
        Resultado resultado;
        boolean troca;

        System.out.println("Ordenando...");

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

        resultado = verificaOrdem("crescente");
        if (resultado.getResultado()) {
            ultm = resultado.getNode();
        }
    }
    
    public void ordenaDecrescente() {
        Resultado resultado;
        boolean troca;

        System.out.println("Ordenando...");

        do {
            troca = false;

            Node prev = null;
            Node atual = prim;

            while (atual.getProximo() != null) { 
                Node prox = atual.getProximo();

                //maior no topo
                if (atual.getNumero() < prox.getNumero()) {
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

        resultado = verificaOrdem("decrescente");
        if (resultado.getResultado()) {
            ultm = resultado.getNode();
        }
    }

    public Node pegaUltimoNode() {
        return ultm;
    }

    public void add(int valor) {
        Node novoNode = new Node();

        novoNode.setNumero(valor);
        novoNode.setProximo(null);
        // System.out.print(valor+" ");

        if (prim == null && ultm == null) {
            prim = ultm = novoNode;
        } else {
            ultm.setProximo(novoNode);
            ultm = novoNode;
        }
    }

    public boolean remove() {
        if (prim != null || ultm != null) {
            if (prim != ultm) {
                prim = prim.getProximo();
                return true;
            } else {
                prim = ultm = null;
                return true;
            }
        } else {
            System.out.println("Não tem mais itens");
            return false;
        }
    }

    public void addAleatorio() {
        int valor = random.nextInt(100);
        add(valor);
    }

    public void printRecursico(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getNumero() + " ");
        if (node.getProximo() != null) {
            printRecursico(node.getProximo());
        }
    }

    public void printRecursicoReverso(Node node) {
        if (node == null) {
            return;
        }
        if (node.getProximo() != null) {
            printRecursicoReverso(node.getProximo());
        }
        System.out.print(node.getNumero() + " ");
    }

    public boolean estaVazia() {
        return prim == null && ultm == null;
    }

    public Node getPrim() {
        return prim;
    }

    public void setPrim(Node prim) {
        this.prim = prim;
    }  
}