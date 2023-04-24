package POO;

public class Tshirt extends Artigo{
    public enum Tamanho{S,M,L,XL}
    private Tamanho tamanho;
    public enum Padrao{liso,riscas,palmeiras} 
    private Padrao padrao;
    private double desconto;
    
    public Tshirt(){
        super();
        this.tamanho = Tamanho.M;
        this.padrao = Padrao.liso;
        this.desconto = 0;
    }

    public Tshirt(Uso uso, double avaliacao, int donos, String desc, String marca, String cod, double preco, double preco2, String transp, Tamanho tamanho, Padrao padrao, double desconto){
        super (uso, avaliacao, donos, desc, marca, cod, preco, preco2, transp);
        this.tamanho = tamanho;
        this.padrao = padrao;
        this.desconto = desconto;
    }

    public Tshirt(Tshirt tshirt){
        super(tshirt.getUsado(), tshirt.getAvaliacao(), tshirt.getDonos(), tshirt.getDescricao(), tshirt.getMarca(), tshirt.getCodigo(), tshirt.getPreco(), tshirt.getPreco2(), tshirt.getTransportadora());
        this.tamanho = tshirt.getTamanho();
        this.padrao = tshirt.getPadrao();
        this.desconto = tshirt.getDesconto();
    }

    public Tshirt clone(){
        return new Tshirt(this);
    }

    public Tamanho getTamanho(){
        return this.tamanho;
    }

    public Padrao getPadrao(){
        return this.padrao;
    }

    public double getDesconto(){
        return this.desconto;
    }

    public void setTamanho(Tamanho tamanho){
        this.tamanho = tamanho;
    }

    public void setPadrao(Padrao padrao){
        this.padrao = padrao;
    }

    public void setDesconto(double desconto){
        this.desconto = desconto;
    }

}
