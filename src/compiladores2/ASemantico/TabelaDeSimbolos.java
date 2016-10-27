/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladores2.ASemantico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class TabelaDeSimbolos {
    private String escopo;
    private List<EntradaTabelaDeSimbolos> simbolos;
    
    public TabelaDeSimbolos(String escopo) {
        simbolos = new ArrayList<EntradaTabelaDeSimbolos>();
        this.escopo = escopo;
    }
    
    public void adicionarSimbolo(String nome, String tipo) {
        simbolos.add(new EntradaTabelaDeSimbolos(nome,tipo));
    }
    
    public void adicionarSimbolos(List<String> nomes, String tipo) {
        for(String s:nomes) {
            simbolos.add(new EntradaTabelaDeSimbolos(s, tipo));
        }
    }

    //procura o simbolo em todos os escopos, começando do atual para os mais geral até chegar no global
    public boolean existeSimbolo(String nome) {
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            if(etds.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    //Verifica se na tabela de simbolos existe um simbolo com o nome X e tipo Y
    public boolean existeSimboloComTipo(String nome, String tipo) {
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            if(etds.getNome().equals(nome) && etds.getTipo().equals(tipo)) {
                return true;
            }
        }
        return false;
    }

    public String getTipoSimbolo(String nome) {
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            if(etds.getNome().equals(nome)) {
                return etds.getTipo();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String ret = "Escopo: "+escopo;
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            ret += "\n   "+etds;
        }
        return ret;
    }
}
