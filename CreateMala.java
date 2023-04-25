package POO;

public class CreateMala {
    public static Mala create(String []arg){
        Mala mala = new Mala();
        
        mala.setCodigouser(Integer.parseInt(arg[1])); 
        if(arg[2].equals("Novo")) mala.setUsado(Mala.Uso.Novo);
        else mala.setUsado(Mala.Uso.Usado);
        mala.setAvaliacao(Double.parseDouble(arg[3]));
        mala.setDonos(Integer.parseInt(arg[4]));
        mala.setDescricao(arg[5]);
        mala.setMarca(arg[6]);
        mala.setCodigo(arg[7]);
        mala.setPreco(Double.parseDouble(arg[8]));
        mala.setCorrecao(Double.parseDouble(arg[9]));
        mala.setTransportadora(arg[10]);
        mala.setComprimento(Double.parseDouble(arg[11]));
        mala.setLargura(Double.parseDouble(arg[12]));
        mala.setAltura(Double.parseDouble(arg[13]));
        mala.setMaterial(arg[14]);
        mala.setAnocolecao(Integer.parseInt(arg[15]));
        mala.setPremium(arg[16].equals("true"));  
        return mala;
    }
}
