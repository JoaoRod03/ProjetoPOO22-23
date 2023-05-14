package POO;

public class CreateSapatilha {
    public static Sapatilha create(String []arg){
        Sapatilha sapatilha = new Sapatilha();
        
        sapatilha.setCodigouser(Integer.parseInt(arg[1])); 
        if(arg[2].equals("Novo")) sapatilha.setUsado(Sapatilha.Uso.Novo);
        else sapatilha.setUsado(Sapatilha.Uso.Usado);
        sapatilha.setAvaliacao(Double.parseDouble(arg[3]));
        sapatilha.setDonos(Integer.parseInt(arg[4]));
        sapatilha.setDescricao(arg[5]);
        sapatilha.setMarca(arg[6]);
        sapatilha.setCodigo(arg[7]);
        sapatilha.setPreco(Double.parseDouble(arg[8]));
        sapatilha.setCorrecao(Double.parseDouble(arg[9]));
        sapatilha.setTransportadora(arg[10]);
        sapatilha.setTamanho(Double.parseDouble(arg[11]));
        sapatilha.setLaces(arg[12].equals("true"));
        sapatilha.setCor(arg[13]);
        sapatilha.setColecao(Integer.parseInt(arg[14]));
        sapatilha.setPremium(arg[15].equals("true"));  
        return sapatilha;
    }
}
