package POO;


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

    public double calculaPreco(){
        double res = 0;
        if (this.premium) {res = this.getPreco() * 1.4; return res;}
        res = this.getPreco() - this.getCorrecao() ;
        return res;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sapatilha;").append(this.getCodigouser())
                .append(";").append(this.getUsado())
                .append(";").append(this.getAvaliacao())
                .append(";").append(this.getDonos())
                .append(";").append(this.getDescricao())
                .append(";").append(this.getMarca())
                .append(";").append(this.getCodigo())
                .append(";").append(this.getPreco())
                .append(";").append(this.getCorrecao())
                .append(";").append(this.getTransportadora())
                .append(";").append(this.tamanho)
                .append(";").append(this.laces)
                .append(";").append(this.cor)
                .append(";").append(this.colecao)
                .append(";").append(this.premium);
        return sb.toString();
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass())) return false;

        Sapatilha sapatilha = (Sapatilha) o;
        return sapatilha.getCodigouser() == (this.getCodigouser()) &&
                sapatilha.getUsado() == this.getUsado() &&
                sapatilha.getAvaliacao() == this.getAvaliacao() &&
                sapatilha.getDonos() == this.getDonos() &&
                sapatilha.getDescricao().equals(this.getDescricao()) &&
                sapatilha.getMarca().equals(this.getMarca()) &&
                sapatilha.getCodigo().equals(this.getCodigo()) &&
                sapatilha.getPreco() == this.getPreco() &&
                sapatilha.getCorrecao() == this.getCorrecao() &&
                sapatilha.getTransportadora().equals(this.getTransportadora()) &&
                sapatilha.getTamanho() == this.tamanho &&
                sapatilha.getLaces() == this.laces &&
                sapatilha.getCor().equals(this.cor) &&
                sapatilha.getColecao() == this.colecao &&
                sapatilha.getPremium() == this.premium;
    }


}
