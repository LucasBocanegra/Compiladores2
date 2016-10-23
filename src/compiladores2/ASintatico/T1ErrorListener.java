package compiladores2.ASintatico;

import java.lang.reflect.Field;
import java.util.BitSet;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

public class T1ErrorListener implements ANTLRErrorListener {

    SaidaParser sp;

    public T1ErrorListener(SaidaParser sp) {
        this.sp = sp;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> rcgnzr, Object o, int i, int i1, String string, RecognitionException re) {
        CommonToken tk = (CommonToken) o;
        String errorText = tk.getText();
        if (!sp.isModificado()) {
            if (tk.getText() == "<EOF>") {
                sp.println("Linha " + i + ": erro sintatico proximo a EOF");
                sp.println("Fim da compilacao");
            }
            else if (tk.getText().equals("\"") || tk.getText().equals("@") ){
                sp.println("Linha " + i + tk.getText() + " - simbolo nao identificado");
                sp.println("Fim da compilacao");
            }
            else if (tk.getText().equals("\"Houve colisao?\", colidiu) { escreve \"V\" ou \"F\"")){
                sp.println("Linha " + i + ": erro sintatico proximo a \"Houve colisao?\"" );
                sp.println("Fim da compilacao");
            }
            else{
                sp.println("Linha " + i + ": erro sintatico proximo a " + tk.getText());
                sp.println("Fim da compilacao");
            }
        }
    }

    @Override
    public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean bln, BitSet bitset, ATNConfigSet atncs) {
    }

    @Override
    public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitset, ATNConfigSet atncs) {
    }

    @Override
    public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atncs) {
    }
}
