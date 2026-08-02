import java.util.Scanner;

public class somadosvizinhos {

    /**
     * <pre>
     * Em uma rua há N casas enfileiradas, numeradas de 1 até N. Em cada casa há um número inteiro
     * anotado na fachada. Para cada casa, queremos calcular a soma formada pelo número da própria
     * casa com os números das casas vizinhas imediatas. A primeira casa possui apenas a vizinha da
     * direita, e a última casa possui apenas a vizinha da esquerda.
     *
     * Sua tarefa é ler a sequência de números das casas e imprimir, na mesma ordem, a soma dos
     * vizinhos de cada posição.
     *
     * Entrada:
     * A primeira linha contém um inteiro N, indicando a quantidade de casas.
     * A segunda linha contém N inteiros A1, A2, ..., AN, indicando os números anotados nas fachadas.
     *
     * Saída:
     * Seu programa deve imprimir uma única linha com N inteiros separados por espaço. O i-ésimo
     * inteiro deve ser a soma do valor da casa i com os valores de suas casas vizinhas imediatas
     * existentes.
     *
     * Restrições:
     * 1 ≤ N ≤ 1000
     * -1000 ≤ Ai ≤ 1000
     * </pre>
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] valores = new int[n];

        for (int i = 0; i < n; i++) {
            valores[i] = scanner.nextInt();
        }

        StringBuilder saida = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int soma = valores[i];

            if (i > 0) {
                soma += valores[i - 1];
            }

            if (i + 1 < n) {
                soma += valores[i + 1];
            }

            if (i > 0) {
                saida.append(' ');
            }

            saida.append(soma);
        }

        System.out.println(saida);
    }
}
