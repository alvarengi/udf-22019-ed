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
        for(int i=0; i<v.length; i++){
            System.out.print("Insira um inteiro para o vetor de posição " + i + ": ");
            v[i] = leia.nextInt();
        }

        //Começo da apresentação dos dados inseridos no array no output
        System.out.print("\n\n\t\t\t\t\t[ ");

        //Loop para apresentar os dados populados no array pelo output
        for(int i=0; i<v.length; i++){
            System.out.print(v[i] + " ");
        }

        //Fim da apresentação dos dados inseridos no array no output
        System.out.print("]");
		
		//Descomente aqui o método de ordenação desejado
		//bubbleSort(v);
		//selectionSort(v);
		
		//Começo da apresentação dos dados inseridos no array no output
        System.out.print("\n\n\t\t\t\t\t[ ");

        //Loop para apresentar os dados populados no array pelo output
        for(int i=0; i<v.length; i++){
            System.out.print(v[i] + " ");
        }

        //Fim da apresentação dos dados inseridos no array no output
        System.out.print("]");
    }


	//A implementação do Bubble Sort aqui foi realizada parte com meu
	//entendimento do funcionamento deste, parte com o conteúdo do slide
	public static void bubbleSort(int v[]){
        int t = 0;

        for(int i=0; i<v.length; i++){
            for(int j=0; j<v.length-1-i; j++){
                if(v[j] > v[j+1]){
                    t = v[j];
                    v[j] = v[j+1];
                    v[j+1] = t;
                }
            }
        }
	}
	
	//Implementação do Selection Sort de acordo com os slides
	public static void selectionSort(int vetor[]){
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

}