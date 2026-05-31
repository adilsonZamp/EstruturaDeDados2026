import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Lista mLista = new Lista();

        // mLista.addInicio(0);
        for (int i = 0; i < 10; i++) {
            mLista.addAleatorio();
        }

        System.out.println("\nPrint recursivo:");
        mLista.printRecursico(mLista.getPrim());

        System.out.print("\nEstá ordenado? ");
        System.out.print(mLista.verificaOrdem() ? "Sim" : "Não");

        System.out.println();

        mLista.ordenaCrescente();
        System.out.print("\nEstá ordenado? ");
        System.out.print(mLista.verificaOrdem() ? "Sim" : "Não");
        
        System.out.println("\nLista ordem crescente:");
        mLista.printRecursico(mLista.getPrim());
        System.out.println("\nLista ordem decrescente:");
        mLista.printRecursicoReverso(mLista.getPrim());

        //inserir em ordem
        mLista.inserirEmOrdem(35);
        mLista.inserirEmOrdem(0);
        mLista.inserirEmOrdem(9999);
        System.out.println("\nLista após inserir em ordem:");
        System.out.println("Está em ordem? "+(mLista.verificaOrdem() ? "Sim" : "Não"));
        mLista.printRecursico(mLista.getPrim());

        //teste buscar valor removido e printar tudo
        System.out.print("Procurar valor: ");
        System.out.println(mLista.buscaValor(scanner.nextInt()).mensagem);
        System.out.println("Lista: ");
        mLista.printRecursico(mLista.getPrim());

        //remover
        System.out.print("Remova o primeiro valor: ");
        System.out.println(mLista.removerEspecifico(scanner.nextInt()));

        System.out.print("Remova qualquer valor: ");
        System.out.println(mLista.removerEspecifico(scanner.nextInt()));
        
        System.out.print("Remova o último valor: ");
        System.out.println(mLista.removerEspecifico(scanner.nextInt()));
        
        System.out.println("Lista depois de remover: ");
        mLista.printRecursico(mLista.getPrim());

        //Pilha LIFO

        // Pilha pilha = new Pilha();
        // String ordem[] = {"crescente", "decrescente"};

        // for (int i = 0; i < 10; i++) {
        //     pilha.pushAleatorio();
        // }

        // System.out.println("Pilha: ");
        // pilha.printRecursico(pilha.getTop());

        // pilha.ordenaCrescente();
        // System.out.println("Ordem "+ordem[0]+"? "+pilha.verificaOrdem(ordem[0]));
        // pilha.printRecursico(pilha.getTop());
        // next();

        // pilha.ordenaDecrescente();
        // System.out.println("Ordem "+ordem[1]+"? "+pilha.verificaOrdem(ordem[1]));
        // pilha.printRecursico(pilha.getTop());
        // next();

        // System.out.println("Removendo todos os itens...");
        // for (int i = 0; i < 15; i++) {
        //     if (!pilha.pop()) {
        //         break;
        //     }
        // }

        //Fila FIFO

        // Fila fila = new Fila();

        // // System.out.println("Números gerados: ");
        // for (int i = 0; i < 10; i++) {
        //     fila.addAleatorio();
        // }
        // // next();

        // System.out.println("Imprimindo recursivamente a fila");
        // fila.printRecursico(fila.getPrim());
        // next();

        // //fazer ordenação
        // System.out.println("Ordem crescente");
        // fila.ordenaCrescente();
        // fila.printRecursico(fila.getPrim());
        // next();

        // System.out.println("Imprimindo recursivamente a fila inversa");
        // fila.printRecursicoReverso(fila.getPrim());
        // next();

        // System.out.println("Removendo alguns itens");
        // for (int i = 0; i < 5; i++) {
        //     fila.printRecursico(fila.getPrim());
        //     System.out.println("\n");
        //     if (!fila.remove()) {
        //         break;
        //     }
        // }
        // fila.printRecursico(fila.getPrim());
        // next();

        // System.out.println("Removendo mais itens do que tem");
        // for (int i = 0; i < 20; i++) {
        //     if (!fila.remove()) {
        //         break;
        //     }
        // }
        // if (fila.estaVazia()) {
        //     System.out.println("Fila vazia");
        // } else {
        //     fila.printRecursico(fila.getPrim());
        // }

    }

    private static void next() {
        System.out.println("\nAperte Enter para continuar");
        scanner.nextLine();
    }
}
