package POO;

public class Artigo {
    public enum Uso{Novo , Usado}
    private Uso usado;
    private double avaliacao;
    private int donos;
    private String descricao;
    private String marca;
    private String codigo;
    private double preco;
    private double preco2;
    private String transportadora;

    public Artigo(){
        this.usado = Uso.Usado;
        this.avaliacao = 0;
        this.donos = 0;
        this.descricao = "";
        this.marca = "";
        this.codigo = "";
        this.preco = 0;
        this.preco2 = 0;
        this.transportadora = "";
    }

    public Artigo(Uso uso, double avaliacao, int donos, String desc, String marca, String cod, double preco, double preco2, String transp){
        this.usado = uso;
        this.avaliacao = avaliacao;
        this.donos = donos;
        this.descricao = desc;
        this.marca = marca;
        this.codigo = cod;
        this.preco = preco;
        this.preco2 = preco2;
        this.transportadora = transp; 
    }

    public Artigo(Artigo umArtigo){
        this.usado = umArtigo.getUsado();
        this.avaliacao = umArtigo.getAvaliacao();
        this.donos = umArtigo.getDonos();
        this.descricao = umArtigo.getDescricao();
        this.marca = umArtigo.getMarca();
        this.codigo = umArtigo.getCodigo();
        this.preco = umArtigo.getPreco();
        this.preco2 = umArtigo.getPreco2();
        this.transportadora = umArtigo.getTransportadora(); 
    }

    public Artigo clone(){
        return new Artigo(this);
    }

    public Uso getUsado(){
        return this.usado;
    }

    public double getAvaliacao(){
        return this.avaliacao;
    }

    public int getDonos(){
        return this.donos;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public String getMarca(){
        return this.marca;
    }

    public String getCodigo(){
        return this.codigo;
    }

    public double getPreco(){
        return this.preco;
    }

    public double getPreco2(){
        return this.preco2;
    } 

    public String getTransportadora(){
        return this.transportadora;
    }

    public void setUsado(Uso usado){
        this.usado = usado;
    }

    public void setAvaliacao(double avaliacao){
        this.avaliacao = avaliacao;
    }

    public void setDonos(int donos){
        this.donos = donos;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public void setPreco2(double preco2){
        this.preco2 = preco2;
    } 

    public void setTransportadora(String transportadora){
        this.transportadora = transportadora;
    }

}

