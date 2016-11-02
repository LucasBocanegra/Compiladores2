package compiladores2;

import compiladores2.antlr.AnalisadorSemantico;
import compiladores2.antlr.GeradorCodigo;
import compiladores2.antlr.GrammarLALexer;
import compiladores2.antlr.GrammarLAParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import sun.awt.CharsetString;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CorrigirGeracao {

    // Especifique o caminho dos casos de teste.
    // Deve haver dois subdiretorios: entrada e saida
    private final static String CAMINHO_CASOS_TESTE =
            "/media/leo/421B33D37F4D6D97/Comp2/Compiladores2/src/compiladores2/casosDeTesteT1/3.arquivos_sem_erros/teste";

    private final static String CAMINHO_CASOS_SAIDA =
            "/media/leo/421B33D37F4D6D97/Comp2/Compiladores2/src/compiladores2/casosDeTesteT1/3.arquivos_sem_erros/testeC";


    public static void main(String[] args) throws IOException, RecognitionException, NullPointerException{
        File diretorioCasosTeste = new File(CAMINHO_CASOS_TESTE);
        File[] casosTeste = diretorioCasosTeste.listFiles();

        if(casosTeste != null){
            Arrays.sort(casosTeste);
            for (File casoTeste : casosTeste) {

                ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(casoTeste));
                GrammarLALexer lexer = new GrammarLALexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                GrammarLAParser parser = new GrammarLAParser(tokens);
                GrammarLAParser.ProgramaContext context = parser.programa();
                GeradorCodigo geracao = new GeradorCodigo();

                System.out.println("================================================================================");
                System.out.println(casoTeste.getName());
                System.out.println("--------------------------------------------------------------------------------");

                geracao.visitPrograma(context);

                System.out.println("############################### ESPERADO (ORIGINAL) ##############################");
                List<String> out = Files.readAllLines(Paths.get(CAMINHO_CASOS_SAIDA+"/"+casoTeste.getName()+".c"), StandardCharsets.UTF_8);
                for (String t : out){
                    System.out.println(t);
                }

                System.out.println("\n");
            }
        }
    }
}