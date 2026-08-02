import java.util.Scanner;

public class sequenciaespelho {

    /**
     * <pre>
     * Uma sequência de números é chamada de espelho quando ela pode ser lida da esquerda para a
     * direita e da direita para a esquerda produzindo exatamente a mesma sequência.
     *
     * Dada uma sequência com N inteiros, determine se ela é uma sequência espelho.
     *
     * Entrada:
     * A primeira linha contém um inteiro N, indicando o tamanho da sequência.
     * A segunda linha contém N inteiros A1, A2, ..., AN.
     *
     * Saída:
     * Seu programa deve imprimir uma única linha contendo "S" se a sequência for espelho, ou "N"
     * caso contrário.
     *
     * Restrições:
     * 1 ≤ N ≤ 100000
     * 0 ≤ Ai ≤ 1000000
     * </pre>
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numeros = new int[n];

        for (int i = 0; i < n; i++) {
            numeros[i] = scanner.nextInt();
        }

        boolean espelho = true;

        for (int i = 0; i < n / 2; i++) {
            if (numeros[i] != numeros[n - 1 - i]) {
                espelho = false;
                break;
            }
        }

        System.out.println(espelho ? "S" : "N");
    }
}
