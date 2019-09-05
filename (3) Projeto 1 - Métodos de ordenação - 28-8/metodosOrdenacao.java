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

public class metodosOrdenacao {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        char escolha = '\0';
        String arquivo = "teste.txt";

        //Declaração de variável para armazenar o inteiro representando o tamanho do array
        int n = 0;

        //Declaração do Scanner para leitura dos dados digitados pelo usuário no console
        Scanner leia = new Scanner(System.in);

        System.out.print("Insira o tamanho (inteiro) do array desejado: ");
        n = leia.nextInt();

        //Declaração de um array multidimensional para armazenar o vetor e suas cópias
        int[][] v = new int[4][n];

        preencheVetor(v);

        try{
            escreveEmArquivo("v[" + v.length + "] = { ", arquivo);
            for (int valor : v[0] )
                escreveEmArquivo(valor + " ", arquivo);
            escreveEmArquivo("}", arquivo);
        }catch(IOException e){
            e.printStackTrace();
        }

        System.out.print("Deseja submeter o vetor à ordenação? (S/N) ");
        escolha = leia.next().charAt(0);
        escolha = Character.toLowerCase(escolha);
        
        if(escolha == 'n'){
            System.exit(0);
        }

        System.out.println("==== MÉTODOS DE ORDENAÇÃO ====");
        System.out.println("\t(b)ubble Sort");
        System.out.println("\t(s)election Sort");
        System.out.println("\t(i)nsertion Sort");
        System.out.println("\t(q)uick Sort");
        System.out.println("\t(t)odos os métodos");
        System.out.println("================================");
        System.out.print("Selecione o método de ordenação [b, s, i, q, t]: ");
        escolha = leia.next().charAt(0);
        escolha = Character.toLowerCase(escolha);
        leia.close();

        switch(escolha){
            case 'b':
            bubbleSort(v[0], arquivo);
            break;
            
            case 's':
            selectionSort(v[0], arquivo);
            break;
            
            case 'i':
            insertionSort(v[0], arquivo);
            break;
            
            case 'q': 
            quickSort(v[0]);
            break;

            case 't':
            bubbleSort(v[0], arquivo);
            selectionSort(v[1], arquivo);
            insertionSort(v[2], arquivo);
            quickSort(v[3]);
            break;
            
            default:
            System.exit(0);
        }

        try{
            escreveEmArquivo("\n\nv[" + v.length + "] = { ", arquivo);
            for (int valor : v[0] )
                escreveEmArquivo(valor + " ", arquivo);
            escreveEmArquivo("}", arquivo);
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    //Implementação do Bubble Sort de acordo com os slides
    public static void bubbleSort(int vetor[], String arquivo) {
        long duracao = System.nanoTime();
        int comparacoes = 0,
            trocas = 0,
            aux = 0,
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
            escreveEmArquivo("\n\nDuração Bubble Sort: " + duracao + "ns", arquivo);
            escreveEmArquivo("\nComparações Bubble Sort: " + comparacoes, arquivo);
            escreveEmArquivo("\nTrocas Bubble Sort: " + trocas, arquivo);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //Implementação do Selection Sort de acordo com os slides
    public static void selectionSort(int vetor[], String arquivo) {
        long duracao = System.nanoTime();   
        int aux = 0,
            comparacoes = 0,
            trocas = 0,
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
            escreveEmArquivo("\n\nDuração Selection Sort: " + duracao + "ns", arquivo);
            escreveEmArquivo("\nComparações Selection Sort: " + comparacoes, arquivo);
            escreveEmArquivo("\nTrocas Selection Sort: " + trocas, arquivo);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //Implementação do Insertion Sort de acordo com os slides
    public static void insertionSort(int vetor[], String arquivo) {
        long duracao = System.nanoTime();
        int comparacoes = 0,
            trocas = 0,
            aux = 0,
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
            escreveEmArquivo("\n\nDuração Insertion Sort: " + duracao + "ns", arquivo);
            escreveEmArquivo("\nComparações Insertion Sort: " + comparacoes, arquivo);
            escreveEmArquivo("\nTrocas Insertion Sort: " + trocas, arquivo);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //Implementação do Quick Sort de acordo com os slides
    public static void quickSort(int vetor[]) {
        quickSort(vetor, 0, vetor.length - 1);
    }

    public static void quickSort(int vetor[], int i, int s) {
        long duracao = System.nanoTime();
        int e = i, d = s;
        int item = vetor[((e + d) / 2)];
        while (e <= d) {
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
            }
        }

        if (d - i > 0) {
            quickSort(vetor, i, d);
        }
        if (s - e > 0) {
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

    public static void escreveEmArquivo(String texto, String arquivo) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(arquivo, true));
        printWriter.print(texto);
        printWriter.close();
    }
}