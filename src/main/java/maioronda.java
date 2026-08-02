import java.util.Scanner;

public class maioronda {

    /**
     * <pre>
     * Dizemos que um trecho contínuo de medições forma uma onda quando, ao percorrê-lo da esquerda
     * para a direita, os valores primeiro crescem estritamente e depois decrescem estritamente. Tanto a
     * parte crescente quanto a parte decrescente devem existir.
     *
     * Dadas N medições de altura de uma pista, sua tarefa é determinar o comprimento da maior onda
     * presente na sequência. Se não existir nenhuma onda válida, o resultado deve ser 0.
     *
     * Entrada:
     * A primeira linha contém um inteiro N, indicando a quantidade de medições.
     * A segunda linha contém N inteiros H1, H2, ..., HN, correspondentes às medições.
     *
     * Saída:
     * Seu programa deve imprimir uma única linha contendo o comprimento da maior onda da sequência.
     * Se não houver onda válida, imprima 0.
     *
     * Restrições:
     * 1 ≤ N ≤ 200000
     * 0 ≤ Hi ≤ 1000000
     * </pre>
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] alturas = new int[n];

        for (int i = 0; i < n; i++) {
            alturas[i] = scanner.nextInt();
        }

        if (n < 3) {
            System.out.println(0);
            return;
        }

        int[] cresce = new int[n];
        int[] decresce = new int[n];

        for (int i = 1; i < n; i++) {
            if (alturas[i] > alturas[i - 1]) {
                cresce[i] = cresce[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (alturas[i] > alturas[i + 1]) {
                decresce[i] = decresce[i + 1] + 1;
            }
        }

        int resposta = 0;

        for (int i = 0; i < n; i++) {
            if (cresce[i] > 0 && decresce[i] > 0) {
                resposta = Math.max(resposta, cresce[i] + decresce[i] + 1);
            }
        }

        System.out.println(resposta);
    }
}
