package POO;
import java.time.LocalDate;

public class Mala extends Artigo{
    private double comprimento;
    private double largura;
    private double altura;
    private String material;
    private int anocolecao;
    private boolean premium;

    public Mala(){
        super();
        this.comprimento = 0;
        this.largura = 0;
        this.altura = 0;
        this.material = "";
        this.anocolecao = 0;
        this.premium = false;
    }

    public Mala(int codigoUser, Uso uso, double avaliacao, int donos, String desc, String marca, String cod, double preco, double correcao, String transp, double comprimento, double largura, double altura, String material, int anocolecao, boolean premium){
        super (codigoUser,uso, avaliacao, donos, desc, marca, cod, preco, correcao, transp);
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
        this.material = material;
        this.anocolecao = anocolecao;
        this.premium = premium;
    }

    public Mala(Mala mala){
        super(mala.getCodigouser(), mala.getUsado(), mala.getAvaliacao(), mala.getDonos(), mala.getDescricao(), mala.getMarca(), mala.getCodigo(), mala.getPreco(), mala.getCorrecao(), mala.getTransportadora());
        this.comprimento = mala.getComprimento();
        this.largura = mala.getLargura();
        this.altura = mala.getAltura();
        this.material = mala.getMaterial();
        this.anocolecao = mala.getAnocolecao();
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

    public String getMaterial(){
        return this.material;
    }

    public int getAnocolecao(){
        return this.anocolecao;
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

    public void setMaterial(String material){
        this.material = material;
    }

    public void setAnocolecao(int anocolecao){
        this.anocolecao = anocolecao;
    }

    public void setPremium(boolean premium){
        this.premium = premium;
    }

    public double calculaPreco(){
        double res = 0;
        if (this.premium) {res = this.getPreco() * 1.4; return res;}
        res = this.getPreco() - this.getCorrecao() ;
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mala;").append(this.getCodigouser())
                .append(";").append(this.getUsado())
                .append(";").append(this.getAvaliacao())
                .append(";").append(this.getDonos())
                .append(";").append(this.getDescricao())
                .append(";").append(this.getMarca())
                .append(";").append(this.getCodigo())
                .append(";").append(this.getPreco())
                .append(";").append(this.getCorrecao())
                .append(";").append(this.getTransportadora())
                .append(";").append(this.comprimento)
                .append(";").append(this.largura)
                .append(";").append(this.altura)
                .append(";").append(this.material)
                .append(";").append(this.anocolecao)
                .append(";").append(this.premium);
        return sb.toString();
    }
}
