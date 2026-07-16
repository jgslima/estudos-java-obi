import java.util.Scanner;

public class lampadas {

    /**
     * <pre>
     * Você está de volta em seu hotel na Tailândia depois de um dia de mergulhos. O seu quarto tem duas
     * lâmpadas. Vamos chamá-las de A e B. No hotel há dois interruptores, que chamaremos de I
     * 1
     * e I
     * 2
     * . Ao apertar I
     * 1
     * , a lâmpada A troca de estado, ou seja, acende se estiver apagada e apaga se estiver acesa. Se
     * apertar I
     * 2
     * , ambas as lâmpadas A e B trocam de estado. As lâmpadas inicialmente estão ambas apagadas. Seu
     * amigo resolveu bolar um desafio para você. Ele irá apertar os interruptores em uma certa sequência,
     * e gostaria que você respondesse o estado final das lâmpadas A e B.
     *
     * Entrada:
     * A primeira linha contém um número N que representa quantas vezes seu amigo irá apertar algum
     * interruptor. Na linha seguinte seguirão N números, que pode ser 1, se o interruptor I
     * 1
     * foi apertado, ou 2, se o interruptor I
     * 2
     * foi apertado.
     *
     * Saída:
     * Seu programa deve imprimir dois valores, em linhas separadas. Na primeira linha, imprima 1 se a
     * lâmpada A estiver acesa no final das operações e 0 caso contrário. Na segunda linha, imprima 1 se a
     * lâmpada B estiver acesa no final das operações e 0 caso contrário.
     *
     * Restrições:
     *  1 ≤ N ≤ 105
     * Informações sobre a pontuação
     *
     *  Em um conjunto de casos de teste equivalente a 20 pontos, N = 3.
     * </pre>
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = 0;
        int b = 0;

        for (int i = 0; i < n; i++) {
            int interruptor = scanner.nextInt();

            if (interruptor == 1) {
                a = 1 - a;
            } else {
                a = 1 - a;
                b = 1 - b;
            }
        }

        System.out.println(a);
        System.out.println(b);
    }
}
