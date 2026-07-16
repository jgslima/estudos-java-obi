import java.util.Scanner;

public class mobile {

    /**
     * <pre>
     * O móbile na sala da Maria é composto de três hastes exatamente como na figura abaixo. Para que
     * ele esteja completamente equilibrado, com todas as hastes na horizontal, os pesos das quatro bolas
     * A, B, C e D têm que satisfazer todas as seguintes três condições:
     * 1. A = B + C + D; e
     * 2. B + C = D; e
     * 3. B = C
     *
     * Nesta tarefa, dados os pesos das quatro bolas, seu programa deve decidir se o móbile está ou não
     * completamente equilibrado.
     *
     * Entrada:
     * A entrada consiste de quatro linhas contendo, cada uma, um número inteiro, indicando os pesos das
     * bolas. Os números são dados na ordem: A, B, C e D.
     *
     * Saída:
     * Seu programa deve escrever uma única linha na saída, contendo o caractere "
     * S
     * " se o móbile estiver equilibrado, ou o caractere "
     * N
     * " se não estiver equilibrado.
     *
     * Restrições:
     *  1 ≤ A,B,C,D ≤ 1000
     * </pre>
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        boolean equilibrado = a == b + c + d && b + c == d && b == c;
        System.out.println(equilibrado ? "S" : "N");
    }
}
