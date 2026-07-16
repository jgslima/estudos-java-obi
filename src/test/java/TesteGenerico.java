import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class TesteGenerico {

    @ParameterizedTest(name = "{0}")
    @MethodSource("casosDeTeste")
    void testar(CasoDeTeste casoDeTeste) throws Exception {
        String saidaObtida = executarMain(nomeClasse(), casoDeTeste.entrada());

        assertEquals(
                normalizar(casoDeTeste.saidaEsperada()),
                normalizar(saidaObtida),
                "Falha no caso de teste: " + casoDeTeste.nome()
        );
    }

    protected abstract String nomeClasse();

    Stream<CasoDeTeste> casosDeTeste() throws Exception {
        String nomeClasse = nomeClasse();
        String nomePasta = obterNomeSimples(nomeClasse);

        URL urlPasta = Objects.requireNonNull(
                TesteGenerico.class.getClassLoader().getResource(nomePasta),
                "Pasta não encontrada em src/test/resources: " + nomePasta
        );

        Path pasta = Paths.get(urlPasta.toURI());

        List<Path> arquivosDeEntrada;

        try (Stream<Path> arquivos = Files.list(pasta)) {
            arquivosDeEntrada = arquivos
                    .filter(Files::isRegularFile)
                    .filter(arquivo -> arquivo.getFileName().toString().endsWith(".in"))
                    .sorted(Comparator.comparing(Path::toString))
                    .toList();
        }

        assertTrue(
                !arquivosDeEntrada.isEmpty(),
                "Nenhum arquivo .in encontrado na pasta " + nomePasta
        );

        List<CasoDeTeste> casos = new ArrayList<>();

        for (Path arquivoEntrada : arquivosDeEntrada) {
            String nomeArquivo = arquivoEntrada.getFileName().toString();
            String nomeCaso = nomeArquivo.substring(0, nomeArquivo.length() - 3);

            Path arquivoSaida = pasta.resolve(nomeCaso + ".out");

            assertTrue(
                    Files.exists(arquivoSaida),
                    "Arquivo de saída não encontrado: " + nomeCaso + ".out"
            );

            String entrada = Files.readString(
                    arquivoEntrada,
                    StandardCharsets.UTF_8
            );

            String saidaEsperada = Files.readString(
                    arquivoSaida,
                    StandardCharsets.UTF_8
            );

            casos.add(
                    new CasoDeTeste(
                            nomeCaso,
                            entrada,
                            saidaEsperada
                    )
            );
        }

        return casos.stream();
    }

    private static String executarMain(
            String nomeClasse,
            String entrada
    ) throws Exception {
        InputStream entradaOriginal = System.in;
        PrintStream saidaOriginal = System.out;

        ByteArrayInputStream entradaDoTeste = new ByteArrayInputStream(
                entrada.getBytes(StandardCharsets.UTF_8)
        );

        ByteArrayOutputStream saidaDoTeste = new ByteArrayOutputStream();

        try {
            System.setIn(entradaDoTeste);

            System.setOut(
                    new PrintStream(
                            saidaDoTeste,
                            true,
                            StandardCharsets.UTF_8
                    )
            );

            Class<?> classe = Class.forName(nomeClasse);
            Method main = classe.getMethod("main", String[].class);

            main.invoke(null, (Object) new String[0]);

            return saidaDoTeste.toString(StandardCharsets.UTF_8);
        } finally {
            System.setIn(entradaOriginal);
            System.setOut(saidaOriginal);
        }
    }

    private static String obterNomeSimples(String nomeClasse) {
        int ultimaPosicaoDoPonto = nomeClasse.lastIndexOf('.');

        if (ultimaPosicaoDoPonto == -1) {
            return nomeClasse;
        }

        return nomeClasse.substring(ultimaPosicaoDoPonto + 1);
    }

    private static String normalizar(String texto) {
        return texto
                .replace("\r\n", "\n")
                .replace('\r', '\n')
                .stripTrailing();
    }

    record CasoDeTeste(
            String nome,
            String entrada,
            String saidaEsperada
    ) {
        @Override
        public String toString() {
            return nome;
        }
    }
}
