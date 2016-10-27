package compiladores2;

import compiladores2.antlr.AnalisadorSemantico;
import compiladores2.antlr.GrammarLALexer;
import compiladores2.antlr.GrammarLAParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

import java.io.*;
import java.util.Arrays;

public class CorrigirSemanticos {

    // Especifique o caminho dos casos de teste.
    // Deve haver dois subdiretorios: entrada e saida
    private final static String CAMINHO_CASOS_TESTE =
          "/home/lucas/Dropbox/bcc/2016/2sem/cc2/casosDeTesteT1/2.arquivos_com_erros_semanticos/teste";


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

                System.out.println("================================================================================");
                System.out.println(casoTeste.getName());
                System.out.println("--------------------------------------------------------------------------------");

                AnalisadorSemantico semantico = new AnalisadorSemantico();
                semantico.visitPrograma(context);

                System.out.println("\n\n");

            }
        }
    }
}