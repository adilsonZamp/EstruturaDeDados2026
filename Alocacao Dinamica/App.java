public class App {
    public static void main(String[] args) throws Exception {
        Lista mLista = new Lista();

        // mLista.addInicio(0);
        for (int i = 0; i < 10000; i++) {
            mLista.addAleatorio();
        }
        
        System.out.println("\nPrint recursivo:");
        // mLista.printRecursico(mLista.getPrim());
        
        System.out.print("\nEstá ordenado? ");
        System.out.print(mLista.verificaOrdem() ? "Sim" : "Não");
        
        System.out.println();
        // ordenação
        long inicio = System.currentTimeMillis();
        mLista.ordenaCrescente();
        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        
        System.out.println("\nLista ordem crescente:");
        // mLista.printRecursico(mLista.getPrim());

        System.out.println("\nLista ordem decrescente:");
        // mLista.printRecursicoReverso(mLista.getPrim());
        
        System.out.println("Tempo decorrido: " + tempo + " ms");
        System.out.print("\nEstá ordenado? ");
        System.out.print(mLista.verificaOrdem() ? "Sim" : "Não");
    }
}
