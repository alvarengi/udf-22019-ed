import java.util.Scanner;
import java.util.Random;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class metodosOrdenacao {

    static int execucoesDesejadas = 11; 
    static String formato = ".txt";
    static String arquivo = "sortingBenchmark_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm")) + formato;

    static long[][] totalTempoExecucaoBubbleSort = new long[execucoesDesejadas][18];
    static long[][] totalComparacoesBubbleSort = new long[execucoesDesejadas][18];
    static long[][] totalTrocasBubbleSort = new long[execucoesDesejadas][18]; 

    static long[][] totalTempoExecucaoSelectionSort = new long[execucoesDesejadas][18]; 
    static long[][] totalComparacoesSelectionSort = new long[execucoesDesejadas][18]; 
    static long[][] totalTrocasSelectionSort = new long[execucoesDesejadas][18]; 

    static long[][] totalTempoExecucaoInsertionSort = new long[execucoesDesejadas][18]; 
    static long[][] totalComparacoesInsertionSort = new long[execucoesDesejadas][18]; 
    static long[][] totalTrocasInsertionSort = new long[execucoesDesejadas][18]; 

    static long[][] totalTempoExecucaoQuickSort = new long[execucoesDesejadas][18]; 
    static long[][] totalComparacoesQuickSort = new long[execucoesDesejadas][18]; 
    static long[][] totalTrocasQuickSort = new long[execucoesDesejadas][18]; 

    static long comparacoesQuickSort = 0;
    static long trocasQuickSort = 0;

    static int contador = 0;
    static int executadas = 0;

    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        for(executadas = 0; executadas < execucoesDesejadas; executadas++){
            comparacoesQuickSort = 0;
            trocasQuickSort = 0;
            contador = 0;

            for(int j = 2; j <= 262144; j *= 2){
                try{
                    escreveEmArquivo("\nsortingBenchmark_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm")) + "\n");                
                }catch(IOException e){
                    e.printStackTrace();
                }

                System.out.println("======================================================= v[" + j + "] ======================================================");
                System.out.println("Ordenação de v[" + j + "] iniciada.");
                sortingBenchmark(j);
                System.out.println("========================================================= FIM! =========================================================\n");
                contador++;
            }
        }

        for(int i = 0; i < execucoesDesejadas; i++){
            try{
                escreveEmArquivo("\n===================================================== EXECUÇÃO " + i + " ====================================================\n");  
            } catch(IOException e){
                e.printStackTrace();
            }

            int tamanhoVetor = 2;

            for(int j = 0; j < 18; j++){
                try{
                    escreveEmArquivo("----------------------------------------------------- v[" + tamanhoVetor + "] --------------------------------------------------------\n");  
                    escreveEmArquivo("\nBUBBLE SORT"); 
                    escreveEmArquivo("\nTempo de execução: " + totalTempoExecucaoBubbleSort[i][j]);  
                    escreveEmArquivo("\nComparações: " + totalComparacoesBubbleSort[i][j]);         
                    escreveEmArquivo("\nTrocas: " + totalTrocasBubbleSort[i][j]);
                    
                    escreveEmArquivo("\n\nSELECTION SORT");
                    escreveEmArquivo("\nTempo de execução: " + totalTempoExecucaoSelectionSort[i][j]);  
                    escreveEmArquivo("\nComparações: " + totalComparacoesSelectionSort[i][j]);         
                    escreveEmArquivo("\nTrocas: " + totalTrocasSelectionSort[i][j]);
                    
                    escreveEmArquivo("\n\nINSERTION SORT");
                    escreveEmArquivo("\nTempo de execução: " + totalTempoExecucaoInsertionSort[i][j]);  
                    escreveEmArquivo("\nComparações: " + totalComparacoesInsertionSort[i][j]);         
                    escreveEmArquivo("\nTrocas: " + totalTrocasInsertionSort[i][j]);
                    
                    escreveEmArquivo("\n\nQUICK SORT");
                    escreveEmArquivo("\nTempo de execução: " + totalTempoExecucaoQuickSort[i][j]);  
                    escreveEmArquivo("\nComparações: " + totalComparacoesQuickSort[i][j]);         
                    escreveEmArquivo("\nTrocas: " + totalTrocasQuickSort[i][j]);
                    escreveEmArquivo("\n");
                }catch(IOException e){
                    e.printStackTrace();
                }

                tamanhoVetor *= 2;
            }
        }

        System.out.println("Vetores e métodos utilizados e estatísticas disponíveis em " + arquivo);
    }

    public static void sortingBenchmark(int tamanhoVetor){
        System.out.println("Alocando...");

        int[][] v = new int[4][tamanhoVetor];

        System.out.println("Vetor alocado!");

        System.out.println("Preenchendo...");
        preencheVetor(v);
        System.out.println("Vetor preenchido!");

        try{
            escreveEmArquivo("\nv[" + v[0].length + "] = { ");
            for (int valor : v[0] )
                escreveEmArquivo(valor + " ");
            escreveEmArquivo("}");
        }catch(IOException e){
            e.printStackTrace();
        }
        
        bubbleSort(v[0]);
        System.out.println("Bubble Sort concluído!");
        selectionSort(v[1]);
        System.out.println("Selection Sort concluído!");
        insertionSort(v[2]);
        System.out.println("Insertion Sort concluído!");
        quickSort(v[3]);
        System.out.println("Quick Sort concluído!");

        try{
            escreveEmArquivo("\n\nv[" + v[0].length + "] = { ");
            for (int valor : v[0] )
                escreveEmArquivo(valor + " ");
            escreveEmArquivo("}");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void bubbleSort(int vetor[]) {
        long duracao = System.nanoTime(),
			comparacoes = 0,
            trocas = 0;
		int aux = 0,
            tam = vetor.length;
        for (int i = 0; i < tam - 1; i++) {
            for (int j = 0; j < tam - 1 - i; j++) {
                comparacoes++;
                if (vetor[j] > vetor[j + 1]) {
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                    trocas++;
                }
            }
        }
        duracao = System.nanoTime() - duracao;

        try{
            totalTempoExecucaoBubbleSort[executadas][contador] = duracao;
            totalComparacoesBubbleSort[executadas][contador] = comparacoes;
            totalTrocasBubbleSort[executadas][contador] = trocas;

            escreveEmArquivo("\n\nDuração Bubble Sort: " + duracao + "ns");
            escreveEmArquivo("\nComparações Bubble Sort: " + comparacoes);
            escreveEmArquivo("\nTrocas Bubble Sort: " + trocas);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void selectionSort(int vetor[]) {
        long duracao = System.nanoTime(),   
			comparacoes = 0,
            trocas = 0;
        int aux = 0,
			tam = vetor.length;

        for (int i = 0; i < tam - 1; i++) {
            for (int j = i + 1; j < tam; j++) {
                comparacoes++;
                if (vetor[j] < vetor[i]) {
                    aux = vetor[j];
                    vetor[j] = vetor[i];
                    vetor[i] = aux;
                    trocas++;
                }
            }
        }		

        duracao = System.nanoTime() - duracao;

        try{
            totalTempoExecucaoSelectionSort[executadas][contador] = duracao;
            totalComparacoesSelectionSort[executadas][contador] = comparacoes;
            totalTrocasSelectionSort[executadas][contador] = trocas;

            escreveEmArquivo("\n\nDuração Selection Sort: " + duracao + "ns");
            escreveEmArquivo("\nComparações Selection Sort: " + comparacoes);
            escreveEmArquivo("\nTrocas Selection Sort: " + trocas);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void insertionSort(int vetor[]) {
        long duracao = System.nanoTime(),
            comparacoes = 0,
            trocas = 0;
        int aux = 0,
            tam = vetor.length,
            j = 0;

        for (int i = 1; i < tam; i++) {
            comparacoes++;
            aux = vetor[i];
            j = i - 1;
            while (j >= 0 && aux < vetor[j]) {
                vetor[j + 1] = vetor[j];
                j--;
                trocas++;
            }

            vetor[j + 1] = aux;
        }		
        
        duracao = System.nanoTime() - duracao;

        try{
            totalTempoExecucaoInsertionSort[executadas][contador] = duracao;
            totalComparacoesInsertionSort[executadas][contador] = comparacoes;
            totalTrocasInsertionSort[executadas][contador] = trocas;
            escreveEmArquivo("\n\nDuração Insertion Sort: " + duracao + "ns");
            escreveEmArquivo("\nComparações Insertion Sort: " + comparacoes);
            escreveEmArquivo("\nTrocas Insertion Sort: " + trocas);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void quickSort(int vetor[]) {
        long duracao = System.nanoTime();
        quickSort(vetor, 0, vetor.length - 1);
        duracao = System.nanoTime() - duracao;

        try{
            totalTempoExecucaoQuickSort[executadas][contador] = duracao;
            totalComparacoesQuickSort[executadas][contador] = comparacoesQuickSort;
            totalTrocasQuickSort[executadas][contador] = trocasQuickSort;
            escreveEmArquivo("\n\nDuração Quick Sort: " + duracao + "ns");
            escreveEmArquivo("\nComparações Quick Sort: " + comparacoesQuickSort);
            escreveEmArquivo("\nTrocas Quick Sort: " + trocasQuickSort);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void quickSort(int vetor[], int i, int s) {
        int e = i, d = s;
        int item = vetor[((e + d) / 2)];
        while (e <= d) {
            comparacoesQuickSort++;
            while (vetor[e] < item) {
                e++;
            }
            while (vetor[d] > item) {
                d--;
            }
            if (e <= d) {
                int aux; //Variável auxiliar para as trocas
                aux = vetor[e];
                vetor[e] = vetor[d];
                vetor[d] = aux;
                d--;
                e++;
                trocasQuickSort++;
            }
        }

        if (d - i > 0) {
            comparacoesQuickSort++;
            quickSort(vetor, i, d);
        }
        if (s - e > 0) {
            comparacoesQuickSort++;
            quickSort(vetor, e, s);
        }
    }

    public static void preencheVetor(int vetor[]){
        List<Integer> randomArray = new ArrayList<Integer>();

        for(int i=0; i < vetor.length; i++){
            randomArray.add(i + 1);
        }

        Collections.shuffle(randomArray);

        for(int i=0; i < randomArray.size(); i++){
            vetor[i] = randomArray.get(i);
        }
    }

    public static void preencheVetor(int vetor[][]){
        List<Integer> randomArray = new ArrayList<Integer>();

        for(int i=0; i < vetor[0].length; i++){
            randomArray.add(i + 1);
        }

        Collections.shuffle(randomArray);

        for(int i=0; i < vetor.length; i++){
            for(int j=0; j < randomArray.size(); j++){
                    vetor[i][j] = randomArray.get(j);
                }
        }
    }

    public static void escreveEmArquivo(String texto) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(arquivo, true));
        printWriter.print(texto);
        printWriter.close();
    }
}