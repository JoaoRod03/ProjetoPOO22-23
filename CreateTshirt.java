package POO;

public class CreateTshirt {
    public static Tshirt create(String []arg){
        Tshirt tshirt = new Tshirt();
        
        tshirt.setNif(Integer.parseInt(arg[1])); 
        if(arg[2].equals("Novo")) tshirt.setUsado(Tshirt.Uso.Novo);
        else tshirt.setUsado(Tshirt.Uso.Usado);
        tshirt.setAvaliacao(Double.parseDouble(arg[3]));
        tshirt.setDonos(Integer.parseInt(arg[4]));
        tshirt.setDescricao(arg[5]);
        tshirt.setMarca(arg[6]);
        tshirt.setCodigo(arg[7]);
        tshirt.setPreco(Double.parseDouble(arg[8]));
        tshirt.setCorrecao(Double.parseDouble(arg[9]));
        tshirt.setTransportadora(arg[10]);
        if(arg[11].equals("S")) tshirt.setTamanho(Tshirt.Tamanho.S);
        if(arg[11].equals("M")) tshirt.setTamanho(Tshirt.Tamanho.M);
        if(arg[11].equals("L")) tshirt.setTamanho(Tshirt.Tamanho.L);
        if(arg[11].equals("XL")) tshirt.setTamanho(Tshirt.Tamanho.XL);
        if(arg[12].equals("liso")) tshirt.setPadrao(Tshirt.Padrao.liso);
        if(arg[12].equals("riscas")) tshirt.setPadrao(Tshirt.Padrao.riscas);
        if(arg[12].equals("palmeiras")) tshirt.setPadrao(Tshirt.Padrao.palmeiras);
        return tshirt;
    }
}
