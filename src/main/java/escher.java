import java.util.Scanner;

public class escher {

    /**
     * <pre>
     * M. C. Escher foi um artista gráfico holandês que fazia incríveis ilustrações onde preenchia a tela com
     * objetos auto-similares, cujos contornos encaixam neles próprios, criando simetrias geométricas muito
     * impressionantes. Veja um exemplo dessa ideia na figura, que mostra um objeto que é um perfil
     * ortogonal definido por uma sequência de números naturais representando a sequência de alturas.
     * Podemos pegar uma cópia do objeto, rotacionar 180 graus e encaixar perfeitamente no objeto
     * original, formando um retângulo.
     *
     * Em termos mais gerais, se uma sequência de N números naturais representando a sequência de
     * alturas for A1, A2, A3,…,AN-2,AN-1, AN, o perfil definido será chamado de perfil Escher se tivermos
     * A1+AN igual a A2+AN-1 igual a A3+AN-2, e assim por diante. Neste problema, será dada a sequência
     * de alturas que definem o perfil e seu programa deve decidir se o perfil é Escher, ou não.
     *
     * Entrada:
     * A primeira linha da entrada contém um número N, indicando quantos números tem a sequência. A
     * segunda linha da entrada contém N números naturais, Ai, para 1 ≤ i ≤ N, definindo a sequência de
     * alturas do perfil.
     *
     * Saída:
     * Seu programa deve imprimir uma linha contendo o caractere S, se o perfil for Escher; ou N, senão.
     *
     * Restrições:
     *  3 ≤ N ≤ 10000.
     *  1 ≤ Ai ≤ 1000, para todo 1 ≤ i ≤ N.
     * Informações sobre a pontuação
     *  Em um conjunto de casos de teste somando 20 pontos, N = 3.
     *  Em um conjunto de casos de teste somando 80 pontos, nenhuma restrição adicional.
     * </pre>
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] alturas = new int[n];

        for (int i = 0; i < n; i++) {
            alturas[i] = scanner.nextInt();
        }

        int soma = alturas[0] + alturas[n - 1];

        for (int i = 1; i < n; i++) {
            if (alturas[i] + alturas[n - 1 - i] != soma) {
                System.out.println("N");
                return;
            }
        }

        System.out.println("S");
    }
}
