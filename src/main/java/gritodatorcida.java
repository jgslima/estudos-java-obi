import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class gritodatorcida {

    /**
     * <pre>
     * Durante uma final, cada torcedor grita o nome de um time. Os nomes dos times são palavras em
     * letras maiúsculas e a quantidade de times diferentes não é informada antecipadamente.
     *
     * Sua tarefa é descobrir qual time foi gritado mais vezes. Em caso de empate na quantidade de
     * gritos, vence o time cujo nome vem primeiro em ordem lexicográfica.
     *
     * Entrada:
     * A primeira linha contém um inteiro N, indicando a quantidade de gritos registrados.
     * Cada uma das N linhas seguintes contém uma string Ti, o nome de um time.
     *
     * Saída:
     * Seu programa deve imprimir duas linhas.
     * Na primeira linha, imprima o nome do time vencedor.
     * Na segunda linha, imprima a quantidade de gritos desse time.
     *
     * Restrições:
     * 1 ≤ N ≤ 100000
     * 1 ≤ |Ti| ≤ 30
     * </pre>
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<String, Integer> frequencias = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String time = scanner.next();
            frequencias.put(time, frequencias.getOrDefault(time, 0) + 1);
        }

        String melhorTime = null;
        int maiorFrequencia = -1;

        for (Map.Entry<String, Integer> entrada : frequencias.entrySet()) {
            String time = entrada.getKey();
            int frequencia = entrada.getValue();

            if (frequencia > maiorFrequencia
                    || (frequencia == maiorFrequencia && time.compareTo(melhorTime) < 0)) {
                melhorTime = time;
                maiorFrequencia = frequencia;
            }
        }

        System.out.println(melhorTime);
        System.out.println(maiorFrequencia);
    }
}
