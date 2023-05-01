package POO;
import java.time.LocalDate;


public class Sapatilha extends Artigo{
 
    private double tamanho;
    private boolean laces;
    private String cor;
    private int colecao;
    private boolean premium;

    public Sapatilha(){
        super();
        this.tamanho = 0;
        this.laces = false;
        this.cor = "";
        this.colecao = 0;
        this.premium = false;
    }

    public Sapatilha(int codigoUser, Uso uso, double avaliacao, int donos, String desc, String marca, String cod, double preco, double correcao, String transp, double tamanho, boolean laces, String cor, int colecao, boolean premium){
        super (codigoUser, uso, avaliacao, donos, desc, marca, cod, preco, correcao, transp);
        this.tamanho = tamanho;
        this.laces = laces;
        this.cor = cor;
        this.colecao = colecao;
        this.premium = premium;
    }

    public Sapatilha(Sapatilha sapatilha){
        super(sapatilha.getCodigouser(), sapatilha.getUsado(), sapatilha.getAvaliacao(), sapatilha.getDonos(), sapatilha.getDescricao(), sapatilha.getMarca(), sapatilha.getCodigo(), sapatilha.getPreco(), sapatilha.getCorrecao(), sapatilha.getTransportadora());
        this.tamanho = sapatilha.getTamanho();
        this.laces = sapatilha.getLaces();
        this.cor = sapatilha.getCor();
        this.colecao = sapatilha.getColecao();
        this.premium = sapatilha.getPremium();
    }

    public Sapatilha clone(){
        return new Sapatilha(this);
    }

    public double getTamanho(){
        return this.tamanho;
    }

    public boolean getLaces(){
        return this.laces;
    }

    public String getCor(){
        return this.cor;
    }

    public int getColecao(){
        return this.colecao;
    }

    public boolean getPremium(){
        return this.premium;
    }

    public void setTamanho(double tamanho){
        this.tamanho = tamanho;
    }
    
    public void setLaces(boolean laces){
        this.laces = laces;
    }

    public void setCor(String cor){
        this.cor = cor;
    }

    public void setColecao(int colecao){
        this.colecao = colecao;
    }
    
    public void setPremium(boolean premium){
        this.premium = premium;
    }

}
