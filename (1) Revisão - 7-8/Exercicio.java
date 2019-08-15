import java.util.Scanner;

public class Exercicio {

    public static void main(String[] args) {
        int[] v = new int[15];
        int i;

        Scanner leia = new Scanner(System.in);

        for (i = 0; i < 15; i++) {
            System.out.print("Insira um inteiro para o vetor de posição " + i + ": ");
            v[i] = leia.nextInt();
        }

        for (i = 0; i < 15; i++) {
            System.out.print("v[" + i + "] = " + v[i]);
        }

        leia.close();
    }
}