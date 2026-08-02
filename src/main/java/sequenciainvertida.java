import java.util.Scanner;

public class sequenciainvertida {

    /**
     * <pre>
     * Dada uma sequência com N números inteiros, sua tarefa é imprimir essa mesma sequência na ordem
     * inversa.
     *
     * Entrada:
     * A primeira linha contém um inteiro N, indicando o tamanho da sequência.
     * A segunda linha contém N inteiros A1, A2, ..., AN.
     *
     * Saída:
     * Seu programa deve imprimir uma única linha contendo os N inteiros da sequência em ordem
     * inversa, separados por espaço.
     *
     * Restrições:
     * 1 ≤ N ≤ 1000
     * -1000 ≤ Ai ≤ 1000
     * </pre>
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numeros = new int[n];

        for (int i = 0; i < n; i++) {
            numeros[i] = scanner.nextInt();
        }

        StringBuilder saida = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            if (!saida.isEmpty()) {
                saida.append(' ');
            }

            saida.append(numeros[i]);
        }

        System.out.println(saida);
    }
}
