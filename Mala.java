package POO;
import java.time.LocalDate;

public class Mala extends Artigo{
    private double comprimento;
    private double largura;
    private double altura;
    private double desconto;
    private String material;
    private LocalDate colecao;
    private boolean premium;

    public Mala(){
        super();
        this.comprimento = 0;
        this.largura = 0;
        this.altura = 0;
        this.desconto = 0;
        this.material = "";
        this.colecao = LocalDate.now();
        this.premium = false;
    }

    public Mala(Uso uso, double avaliacao, int donos, String desc, String marca, String cod, double preco, double preco2, String transp, double comprimento, double largura, double altura, double desconto, String material, LocalDate colecao, boolean premium){
        super (uso, avaliacao, donos, desc, marca, cod, preco, preco2, transp);
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
        this.desconto = desconto;
        this.material = material;
        this.colecao = colecao;
        this.premium = premium;
    }

    public Mala(Mala mala){
        super(mala.getUsado(), mala.getAvaliacao(), mala.getDonos(), mala.getDescricao(), mala.getMarca(), mala.getCodigo(), mala.getPreco(), mala.getPreco2(), mala.getTransportadora());
        this.comprimento = mala.getComprimento();
        this.largura = mala.getLargura();
        this.altura = mala.getAltura();
        this.desconto = mala.getDesconto();
        this.material = mala.getMaterial();
        this.colecao = mala.getColecao();
        this.premium = mala.getPremium();
    }

    public Mala clone(){
        return new Mala(this);
    }

    public double getComprimento(){
        return this.comprimento;
    }

    public double getLargura(){
        return this.largura;
    }

    public double getAltura(){
        return this.altura;
    }

    public double getDesconto(){
        return this.desconto;
    }

    public String getMaterial(){
        return this.material;
    }

    public LocalDate getColecao(){
        return this.colecao;
    }

    public boolean getPremium(){
        return this.premium;
    }

    public void setComprimento(double comprimento){
        this.comprimento = comprimento;
    }

    public void setLargura(double largura){
        this.largura = largura;
    }

    public void setAltura(double altura){
        this.altura = altura;
    }

    public void setDesconto(double desconto){
        this.desconto = desconto;
    }

    public void setMaterial(String material){
        this.material = material;
    }

    public void setColecao(LocalDate colecao){
        this.colecao = colecao;
    }

    public void setPremium(boolean premium){
        this.premium = premium;
    }


}
