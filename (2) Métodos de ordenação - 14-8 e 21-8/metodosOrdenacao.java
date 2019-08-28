import java.util.Scanner;

public class metodosOrdenacao {

    public static void main(String[] args) {
        //Declaração de variável para armazenar o inteiro representando o tamanho do array
        int n = 0;

        //Declaração do Scanner para leitura dos dados digitados pelo usuário no console
        Scanner leia = new Scanner(System.in);

        System.out.print("Insira o tamanho (inteiro) do array desejado: ");
        n = leia.nextInt();

        //Declaração do array utilizando o valor inserido (ou não, logo sendo 0)
        int[] v = new int[n];

        //Loop para popular o array de acordo com inputs do usuário
        for (int i = 0; i < v.length; i++) {
            System.out.print("Insira um inteiro para o vetor de posição " + i + ": ");
            v[i] = leia.nextInt();
        }

        //Começo da apresentação dos dados inseridos no array no output
        System.out.print("\n\n\t\t\t\t\t[ ");

        //Loop para apresentar os dados populados no array pelo output
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }

        //Fim da apresentação dos dados inseridos no array no output
        System.out.print("]");

		//Descomente aqui o método de ordenação desejado
        //bubbleSort(v);
        //selectionSort(v);
        //insertionSort(v);
        //quickSort(v);
        //Começo da apresentação dos dados inseridos no array no output
        System.out.print("\n\n\t\t\t\t\t[ ");

        //Loop para apresentar os dados populados no array pelo output
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }

        //Fim da apresentação dos dados inseridos no array no output
        System.out.print("]");
    }

    //Implementação do Bubble Sort de acordo com os slides
    public static void bubbleSort(int vetor[]) {
        int aux;
        int tam = vetor.length;
        for (int i = 0; i < tam - 1; i++) {
            for (int j = 0; j < tam - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }
        }
    }

    //Implementação do Selection Sort de acordo com os slides
    public static void selectionSort(int vetor[]) {
        int aux;
        int tam = vetor.length;

        for (int i = 0; i < tam - 1; i++) {
            for (int j = i + 1; j < tam; j++) {
                if (vetor[j] < vetor[i]) {
                    aux = vetor[j];
                    vetor[j] = vetor[i];
                    vetor[i] = aux;
                }
            }
        }
    }

    //Implementação do Insertion Sort de acordo com os slides
    public static void insertionSort(int vetor[]) {
        int aux;
        int tam = vetor.length;
        int j;

        for (int i = 1; i < tam; i++) {
            aux = vetor[i];
            j = i - 1;
            while (j >= 0 && aux < vetor[j]) {
                vetor[j + 1] = vetor[j];
                j--;
            }

            vetor[j + 1] = aux;
        }
    }

    //Implementação do Quick Sort de acordo com os slides
    public static void quickSort(int vetor[]) {
        quickSort(vetor, 0, vetor.length - 1);
    }

    public static void quickSort(int vetor[], int i, int s) {
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
}
