package POO;
import java.time.LocalDate;


public class Sapatilha extends Artigo{
 
    private double tamanho;
    private boolean laces;
    private String cor;
    private LocalDate colecao;
    private double desconto;
    private boolean premium;

    public Sapatilha(){
        super();
        this.tamanho = 0;
        this.laces = false;
        this.cor = "";
        this.colecao = LocalDate.now();
        this.desconto = 0;
        this.premium = false;
    }

    public Sapatilha(Uso uso, double avaliacao, int donos, String desc, String marca, String cod, double preco, double preco2, String transp, double tamanho, boolean laces, String cor, LocalDate colecao, double desconto, boolean premium){
        super (uso, avaliacao, donos, desc, marca, cod, preco, preco2, transp);
        this.tamanho = tamanho;
        this.laces = laces;
        this.cor = cor;
        this.colecao = colecao;
        this.desconto = desconto;
        this.premium = premium;
    }

    public Sapatilha(Sapatilha sapatilha){
        super(sapatilha.getUsado(), sapatilha.getAvaliacao(), sapatilha.getDonos(), sapatilha.getDescricao(), sapatilha.getMarca(), sapatilha.getCodigo(), sapatilha.getPreco(), sapatilha.getPreco2(), sapatilha.getTransportadora());
        this.tamanho = sapatilha.getTamanho();
        this.laces = sapatilha.getLaces();
        this.cor = sapatilha.getCor();
        this.colecao = sapatilha.getColecao();
        this.desconto = sapatilha.getDesconto();
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

    public LocalDate getColecao(){
        return this.colecao;
    }

    public double getDesconto(){
        return this.desconto;
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

    public void setColecao(LocalDate colecao){
        this.colecao = colecao;
    }

    public void setDesconto(double desconto){
        this.desconto = desconto;
    }

    public void setPremium(boolean premium){
        this.premium = premium;
    }

}
