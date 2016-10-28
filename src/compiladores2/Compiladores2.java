package compiladores2;

import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import compiladores2.ASintatico.SaidaParser;
import compiladores2.ASintatico.T1ErrorListener;
import compiladores2.antlr.AnalisadorSemantico;
import compiladores2.antlr.GrammarLALexer;
import compiladores2.antlr.GrammarLAParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

// Palomino PATH SP3: C:\Users\Gabriel Palomino\OneDrive\UFSCar\6° Semestre\CC II\T1\Compiladores2\src\compiladores2\casosDeTesteT1\arquivos_com_erros_sintaticos\entrada\1-algoritmo_2-2_apostila_LA_1_erro_linha_3_acusado_linha_10.txt
// Palomino Command SP3: java -jar "CorretorTrabalho1.jar" "java -jar C:\\Users\\Gabriel Palomino\\OneDrive\\UFSCar\\6° Semestre\\CC II\\T1\\Compiladores2\\out\\artifacts\\Compiladores2_jar\\Compiladores2.jar" gcc "C:\\Users\\Gabriel Palomino\\Desktop\\CorretorTrabalho1\\temp"  "C:\\Users\\Gabriel Palomino\\OneDrive\\UFSCar\\6° Semestre\\CC II\\T1\\Compiladores2\\src\\compiladores2\\casosDeTesteT1" "551562, 551732, 551686" sintatico

public class Compiladores2 {

    public static void main(String args[]) throws IOException, RecognitionException {

         File arquivo = new File(args[0]);
         ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(arquivo));
         File saidaCasoTeste = new File(args[1]);
         PrintWriter pw = new PrintWriter(new FileWriter(saidaCasoTeste));

         SaidaParser out = new SaidaParser();
         GrammarLALexer lexer = new GrammarLALexer(input);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         GrammarLAParser parser = new GrammarLAParser(tokens);
         parser.addErrorListener(new T1ErrorListener(out));
         GrammarLAParser.ProgramaContext context = parser.programa();
         
         pw.print(out.toString());
         pw.flush();
         pw.close();

         AnalisadorSemantico semantico = new AnalisadorSemantico();
         semantico.visitPrograma(context);
    }
}