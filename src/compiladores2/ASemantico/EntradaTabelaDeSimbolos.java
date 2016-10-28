/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladores2.ASemantico;

/**
 *
 * @author daniel
 */
public class EntradaTabelaDeSimbolos {
    private String nome, tipo;
    private boolean  ehPonteiro;
    
    public EntradaTabelaDeSimbolos(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.ehPonteiro = false;
    }

    public EntradaTabelaDeSimbolos(String nome, String tipo, boolean ehPonteiro) {
        this.nome = nome;
        this.tipo = tipo;
        this.ehPonteiro = ehPonteiro;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    @Override
    public String toString() {
        return nome+"("+tipo+")";
    }
}
