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
    private ArrayList<EntradaTabelaDeSimbolos> simbolos;
    
    public TabelaDeSimbolos(String escopo) {
        simbolos = new ArrayList<EntradaTabelaDeSimbolos>();
        this.escopo = escopo;
    }
    
    public void adicionarSimbolo(String nome, String tipo) {

        simbolos.add(new EntradaTabelaDeSimbolos(nome,tipo));
    }

    public void adicionarSimbolo(String nome, String tipo, boolean ehPoteiro) {

        simbolos.add(new EntradaTabelaDeSimbolos(nome,tipo, ehPoteiro));
    }

    public void adicionarSimbolo(EntradaTabelaDeSimbolos edts) {

        simbolos.add(edts);
    }
    
    public void adicionarSimbolos(List<String> nomes, String tipo) {
        for(String s:nomes) {
            simbolos.add(new EntradaTabelaDeSimbolos(s, tipo));
        }
    }


    /*
    * Retorna a ultima posicao da tabela ocupada por um simbolo, retorna -1 se a tabela estiver vazia
    * */
    public int getUltimaPosicaoOcupada(){
        return (simbolos.size()==0)? -1: simbolos.size()-1;
    }

    /*
    * Editar o nome de um simbolo na posicao indicada. Retorna falso se a posicao não existe
    * */
    public boolean editarNomeSimbolo(int posicao, String novoNome){
        if(posicao<simbolos.size()){
            simbolos.get(posicao).setNome(novoNome);
            return true;
        }else{
            return false;
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

    public boolean existeSimboloNoTipo(String nameAtribuicao, String campo1){
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            if(etds.getNome().equals(nameAtribuicao)) {
                if(!etds.getTipo().getValor().equals("registro")){
                    for(String k : etds.getTipo().getCampos().keySet()){
                        if(k.equals(campo1)){
                            return true;
                        }
                    }
                }
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

    public String getValorTipoSimbolo(String nome) {
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            if(etds.getNome().equals(nome)) {
                return etds.getValorTipo();
            }
        }
        return null;
    }

    public Tipo getTipoSimbolo(String nome) {
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            if(etds.getNome().equals(nome)) {
                return etds.getTipo();
            }
        }
        return null;
    }

    public void removeSimbolosAPartir(int inicio, int fim){
        for (int i = inicio; i<=fim-inicio;i++){
            simbolos.remove(inicio);
        }
    }

    public void removeSimbolosAPartir(int inicio){
        int current_size = simbolos.size();
        for (int i = inicio; i<=current_size-1;i++){
            simbolos.remove(inicio);
        }
    }


    /*
    * Retorna o nome de um simbolo na posicao indicada. Retorna null se a posicao nao existe
    * */
    public String getNomeSimbolo(int posicao){
       if(posicao<simbolos.size()){
           String nome = simbolos.get(posicao).getNome();
           return nome;
       }else{
           return null;
       }
    }

    public boolean ehPonteiro(String nome) {
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            if(etds.getNome().equals(nome)) {
                return etds.isEhPonteiro();
            }
        }
        return false;
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
