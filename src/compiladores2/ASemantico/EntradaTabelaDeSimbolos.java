/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladores2.ASemantico;

import java.util.HashMap;

/**
 *
 * @author daniel
 */
public class EntradaTabelaDeSimbolos {
    private String nome;
    private  Tipo tipo;
    private boolean  ehPonteiro;
    
    public EntradaTabelaDeSimbolos(String nome, String tipo) {
        this.nome = nome;
        this.tipo = new Tipo(tipo); //setando o valor do tipo
        this.ehPonteiro = false;
    }

    public EntradaTabelaDeSimbolos(String nome, String tipo, boolean ehPonteiro) {
        this.nome = nome;
        this.tipo = new Tipo(tipo);
        this.ehPonteiro = ehPonteiro;
    }

    public EntradaTabelaDeSimbolos(EntradaTabelaDeSimbolos etds) {
        this.nome = etds.getNome();
        this.tipo = new Tipo(etds.getValorTipo());
        this.ehPonteiro = etds.isEhPonteiro();
        if(etds.getTipo().ehTipoComplexo()) {
            for (String k : etds.getTipo().getCampos().keySet()) {
                this.addCampoNoTipo(k, etds.getTipo().getCampos().get(k));

            }
        }
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getValorTipo() {
        return tipo.toString();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValueTipo(String tipo) {
        this.tipo.setValor(tipo);
    }

    public Tipo getTipo(){
        return this.tipo;
    }


    //valor é o tipo do campo e nome o nome: Ex. x:real
    public boolean addCampoNoTipo(String name, String valor){
        return  this.tipo.addCampo(name, valor);
    }


    public void setEhPonteiro(boolean ehPonteiro) {
        this.ehPonteiro = ehPonteiro;
    }
    
    

    public boolean isEhPonteiro() {
        return ehPonteiro;
    }



    @Override
    public String toString() {
        return nome+"("+tipo.toString()+")";
    }
}
