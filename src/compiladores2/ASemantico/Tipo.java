package compiladores2.ASemantico;

import java.util.HashMap;

/**
 * Created by lucas on 02/11/16.
 */
public class Tipo {
    private String valor; //valor do tipo (inteiro, literal, real, logico ou registro)
    private HashMap<String, String> campos;

    public Tipo(String valor) {
        this.valor = valor;
        //se for um tipo complexo, adiciona os campos dentro do registro como tipo
        if(valor.equals("registro")){
            campos = new HashMap<>();
        }else
            campos = null;
    }

    public boolean addCampo(String nome,String valor){
        if(campos != null){
            campos.put(nome,valor);
            return true;
        }else{
            return false;
        }
    }

    public String getValorCampo(String nome){
        if(campos != null)
            return campos.get(nome);
        else
            return null;
    }

    public boolean ehTipoComplexo() {
        if (campos != null) {
            return true; //eh tipo complexo pq eh um registro
        } else {
            return false; // nao he tipo complexo, eh um tipo básico
        }
    }

    public HashMap<String,String> getCampos(){
        return campos;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor;
    }
}
