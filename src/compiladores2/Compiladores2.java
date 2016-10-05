package compiladores2;

import compiladores2.antlr.GramarLALexer;
import compiladores2.antlr.GramarLAParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

public class Compiladores2 {

    public static void main(String args[]) throws IOException, RecognitionException {
         // Descomente as linhas abaixo para testar o analisador gerado.
         // Obs: a linha abaixo está configurada para usar como entrada o arquivo lua1.txt   
         // Modifique-a para testar os demais exemplos

         ANTLRInputStream input = new ANTLRInputStream(
                 new FileInputStream("/home/lucas/Dropbox/bcc/2016/2sem/cc2/Compiladores2/src/compiladores2/casosDeTesteT1/arquivos_com_erros_sintaticos/entrada/1-algoritmo_2-2_apostila_LA_1_erro_linha_3_acusado_linha_10.txt")
         );
         GramarLALexer lexer = new GramarLALexer(input);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         GramarLAParser parser = new GramarLAParser(tokens);
         parser.programa();
    }
}