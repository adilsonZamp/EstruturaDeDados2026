import java.util.ArrayList;
import java.util.Random;

public class Lista {
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

    public Resposta buscaValor(int valor) {
        ArrayList<Node> achados = new ArrayList<>();
        Node atual = prim;
        
        do {
            if (valor == atual.getNumero()) {
                achados.add(atual);
            }
            atual = atual.getProximo();
        }while(atual != null);

        if (achados.isEmpty()) {
            return new Resposta("Não encontrou "+valor+" em nenhum objeto da lista", false);
        } else {
            // for (Node node : achados) {
            //     System.out.println("debug Node/valor");
            //     System.out.println("Node: "+node);
            //     System.out.println("Numero: "+node.getNumero());
            // }
            return new Resposta("Valor "+valor+" encontrado nos objetos "+achados.toString(), true);
        }
    }

    public String removerEspecifico(int valor) {
        Node atual = prim;
        Node ultimo = pegaUltimoNode();
        int nodeValor;
        boolean removeu = false;
        
        while (atual != null) {
            if (atual.getProximo() == null) {
                break;
            }
            nodeValor = atual.getProximo().getNumero();
            
            if (atual == prim && valor == prim.getNumero()) {
                prim = prim.getProximo();
                removeu = true;
            } else if (atual.getProximo() == ultimo && valor == ultimo.getNumero()) {
                atual.setProximo(null);
                removeu = true;
            } else {
                if (valor == nodeValor) {
                    atual.setProximo(
                        atual.getProximo().getProximo() == null ? null : atual.getProximo().getProximo()
                    );
                    removeu = true;
                }
            }
            atual = atual.getProximo();
        }

        if (buscaValor(valor).sucesso) {
            removerEspecifico(valor);
        } else {
            return "";
        }

        if (!removeu) {
            return "Não encontrou "+valor+" em nenhum objeto da lista";
        } else {
            return "Valor "+valor+" removido da Lista";
        }
    }

    public void inserirEmOrdem(int valor) {
        Node atual = prim;
        Node aux;
        Node ultimoNode = pegaUltimoNode();
        boolean inserido = false;
        
        if (verificaOrdem()) {
            // System.out.println("add esta em ordem");
            if (valor <= prim.getNumero()) {
                // System.out.println("add prim");
                aux = prim;
                prim = new Node(valor, aux);
                return;
            } else if (valor >= ultimoNode.getNumero()) {
                // System.out.println("add ultimo");
                ultimoNode.setProximo(new Node(valor, null));
                return;
            }

            while(!inserido) {
                if (valor >= atual.getNumero() && valor <= atual.getProximo().getNumero()) {
                    aux = atual.getProximo();
                    atual.setProximo(new Node(valor, aux));
                    // System.out.println("add em ordem");
                    inserido = true;
                } else {
                    atual = atual.getProximo();
                }
            }
        } else {
            System.out.println("Não é possível inserir, lista desordenada.");
        }
    }


    public void printRecursico(Node node) {
        System.out.print(node.getNumero() + " ");
        if (node.getProximo() != null) {
            printRecursico(node.getProximo());
        } else {
            System.out.println();
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