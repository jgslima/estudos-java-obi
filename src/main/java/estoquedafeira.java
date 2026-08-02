import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class estoquedafeira {

    /**
     * <pre>
     * Uma feira controla o estoque de seus produtos por meio de três tipos de operação:
     * - ENTRA nome quantidade: acrescenta a quantidade informada ao produto.
     * - SAI nome quantidade: retira a quantidade informada do produto.
     * - CONSULTA nome: pede o estoque atual do produto.
     *
     * Os nomes dos produtos são strings sem espaços, e a quantidade de produtos diferentes não é
     * conhecida de antemão. É garantido que nenhuma operação SAI tentará retirar mais itens do que o
     * estoque disponível.
     *
     * Sua tarefa é processar todas as operações e responder às consultas.
     *
     * Entrada:
     * A primeira linha contém um inteiro N, indicando a quantidade de operações.
     * Cada uma das N linhas seguintes contém uma operação em um dos formatos descritos acima.
     *
     * Saída:
     * Para cada operação CONSULTA, seu programa deve imprimir uma linha contendo o estoque atual do
     * produto consultado. Caso o produto ainda não tenha aparecido, o estoque considerado é 0.
     *
     * Restrições:
     * 1 ≤ N ≤ 200000
     * 1 ≤ quantidade ≤ 1000000
     * 1 ≤ |nome| ≤ 30
     * </pre>
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<String, Integer> estoque = new HashMap<>();
        StringBuilder saida = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String operacao = scanner.next();
            String nome = scanner.next();

            if (operacao.equals("CONSULTA")) {
                saida.append(estoque.getOrDefault(nome, 0)).append('\n');
            } else {
                int quantidade = scanner.nextInt();
                int atual = estoque.getOrDefault(nome, 0);

                if (operacao.equals("ENTRA")) {
                    estoque.put(nome, atual + quantidade);
                } else {
                    estoque.put(nome, atual - quantidade);
                }
            }
        }

        System.out.print(saida);
    }
}
