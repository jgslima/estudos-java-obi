import java.util.Scanner;

public class gangorra {

    /**
     * <pre>
     * Joãozinho acaba de mudar de escola e a primeira coisa que percebeu na nova escola é que a
     * gangorra do parquinho não é simétrica, uma das extremidades é mais longa que a outra. Após
     * brincar algumas vezes com um amigo de mesmo peso, ele percebeu que quando está em uma
     * extremidade, a gangorra se desequilibra para o lado dele (ou seja, ele fica na parte de baixo, e o
     * amigo na parte de cima), mas quando eles trocam de lado, a gangorra se desequilibra para o lado do
     * amigo. Sem entender a situação, Joãozinho pediu ajuda a outro amigo de outra série, que explicou
     * que o comprimento do lado interfere no equilíbrio da gangorra, pois a gangorra estará equilibrada
     * quando
     * P1*C1=P2*C2
     * onde P
     * 1
     * e P
     * 2
     * são os pesos da criança no lado esquerdo e direito, respectivamente, e C
     * 1
     * e C
     * 2
     * são os comprimentos da gangorra do lado esquerdo e direito, respectivamente.
     * Com a equação, Joãozinho já consegue dizer se a gangorra está equilibrada ou não mas, além
     * disso, ele quer saber para qual lado a gangorra descerá caso esteja desequilibrada.
     *
     * Entrada:
     * A primeira e única linha da entrada contém 4 inteiros, P
     * 1
     * , C
     * 1
     * , P
     * 2
     * e C
     * 2
     *
     * , nesta ordem.
     *
     * Saída:
     * Seu programa deve produzir uma única linha, contendo um único inteiro. Se a gangorra estiver
     * equilibrada, imprima "0". Se ela estiver desequilibrada de modo que a criança esquerda esteja na
     * parte de baixo, imprima "-1", senão, imprima "1".
     *
     * Restrições:
     *  10 ≤ P1 ≤ 100 e 10 ≤ C1 ≤ 100
     *  10 ≤ P2 ≤ 100 e 10 ≤ C2 ≤ 100
     * </pre>
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p1 = scanner.nextInt();
        int c1 = scanner.nextInt();
        int p2 = scanner.nextInt();
        int c2 = scanner.nextInt();
        int esquerda = p1 * c1;
        int direita = p2 * c2;

        if (esquerda == direita) {
            System.out.println(0);
        } else if (esquerda > direita) {
            System.out.println(-1);
        } else {
            System.out.println(1);
        }
    }
}
