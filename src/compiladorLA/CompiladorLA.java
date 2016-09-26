package compiladorLA;

import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

public class CompiladorLA {

    public static void main(String args[]) throws IOException, RecognitionException {
         // Descomente as linhas abaixo para testar o analisador gerado.
         // Obs: a linha abaixo está configurada para usar como entrada o arquivo lua1.txt   
         // Modifique-a para testar os demais exemplos
         ANTLRInputStream input = new ANTLRInputStream(new FileInputStream("/home/lucas/Documents/bcc/2016/2sem/CC2/Compiladores2/src/compiladorLA/exemplos/lua1.txt"));
         ExpressoesLexer lexer = new ExpressoesLexer(input);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         ExpressoesParser parser = new ExpressoesParser(tokens);

         int val = parser.programa().count;
         System.out.println("Total de operadores = "+val);
    }
}