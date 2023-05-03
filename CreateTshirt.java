package POO;

public class CreateTshirt {
    public static Tshirt create(String []arg){
        Tshirt shirt = new Tshirt();
        
        shirt.setCodigouser(Integer.parseInt(arg[1])); 
        if(arg[2].equals("Novo")) shirt.setUsado(Tshirt.Uso.Novo);
        else shirt.setUsado(Tshirt.Uso.Usado);
        shirt.setAvaliacao(Double.parseDouble(arg[3]));
        shirt.setDonos(Integer.parseInt(arg[4]));
        shirt.setDescricao(arg[5]);
        shirt.setMarca(arg[6]);
        shirt.setCodigo(arg[7]);
        shirt.setPreco(Double.parseDouble(arg[8]));
        shirt.setCorrecao(Double.parseDouble(arg[9]));
        shirt.setTransportadora(arg[10]);
        if(arg[11].equals("S")) shirt.setTamanho(Tshirt.Tamanho.S);
        if(arg[11].equals("M")) shirt.setTamanho(Tshirt.Tamanho.M);
        if(arg[11].equals("L")) shirt.setTamanho(Tshirt.Tamanho.L);
        if(arg[11].equals("XL")) shirt.setTamanho(Tshirt.Tamanho.XL);
        if(arg[12].equals("liso")) shirt.setPadrao(Tshirt.Padrao.liso);
        if(arg[12].equals("riscas")) shirt.setPadrao(Tshirt.Padrao.riscas);
        if(arg[12].equals("palmeiras")) shirt.setPadrao(Tshirt.Padrao.palmeiras);
        return shirt;
    }
}
