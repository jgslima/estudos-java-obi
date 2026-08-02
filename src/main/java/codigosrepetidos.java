import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class codigosrepetidos {

    /**
     * <pre>
     * Um sistema registra N códigos inteiros correspondentes a acessos realizados ao longo do dia.
     * Os códigos podem ser grandes e a quantidade de códigos distintos não é conhecida de antemão.
     *
     * Sua tarefa é determinar quantos códigos distintos apareceram e qual foi o código com maior
     * número de ocorrências. Em caso de empate no número de ocorrências, deve ser escolhido o menor
     * código.
     *
     * Entrada:
     * A primeira linha contém um inteiro N, indicando a quantidade de acessos registrados.
     * A segunda linha contém N inteiros C1, C2, ..., CN, correspondentes aos códigos lidos.
     *
     * Saída:
     * Seu programa deve imprimir duas linhas.
     * Na primeira linha, imprima a quantidade de códigos distintos.
     * Na segunda linha, imprima dois inteiros separados por espaço: o código mais frequente e sua
     * quantidade de ocorrências.
     *
     * Restrições:
     * 1 ≤ N ≤ 200000
     * 0 ≤ Ci ≤ 1000000000
     * </pre>
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Integer> frequencias = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int codigo = scanner.nextInt();
            frequencias.put(codigo, frequencias.getOrDefault(codigo, 0) + 1);
        }

        int melhorCodigo = -1;
        int maiorFrequencia = -1;

        for (Map.Entry<Integer, Integer> entrada : frequencias.entrySet()) {
            int codigo = entrada.getKey();
            int frequencia = entrada.getValue();

            if (frequencia > maiorFrequencia
                    || (frequencia == maiorFrequencia && codigo < melhorCodigo)) {
                melhorCodigo = codigo;
                maiorFrequencia = frequencia;
            }
        }

        System.out.println(frequencias.size());
        System.out.println(melhorCodigo + " " + maiorFrequencia);
    }
}
