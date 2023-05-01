package POO;

import javax.swing.AbstractAction;

public abstract class Artigo {
    private int codigoUser;
    public enum Uso{Novo , Usado}
    private Uso usado;
    private double avaliacao;
    private int donos;
    private String descricao;
    private String marca;
    private String codigo;
    private double preco;
    private double correcao;
    private String transportadora;

    public Artigo(){
        this.codigoUser = 0;
        this.usado = Uso.Usado;
        this.avaliacao = 0;
        this.donos = 0;
        this.descricao = "";
        this.marca = "";
        this.codigo = "";
        this.preco = 0;
        this.correcao = 0;
        this.transportadora = "";
    }

    public Artigo(int codigoUser, Uso uso, double avaliacao, int donos, String desc, String marca, String cod, double preco, double correcao, String transp){
        this.codigoUser = codigoUser;
        this.usado = uso;
        this.avaliacao = avaliacao;
        this.donos = donos;
        this.descricao = desc;
        this.marca = marca;
        this.codigo = cod;
        this.preco = preco;
        this.correcao = correcao;
        this.transportadora = transp; 
    }

    public Artigo(Artigo umArtigo){
        this.codigoUser = umArtigo.getCodigouser();
        this.usado = umArtigo.getUsado();
        this.avaliacao = umArtigo.getAvaliacao();
        this.donos = umArtigo.getDonos();
        this.descricao = umArtigo.getDescricao();
        this.marca = umArtigo.getMarca();
        this.codigo = umArtigo.getCodigo();
        this.preco = umArtigo.getPreco();
        this.correcao = umArtigo.getCorrecao();
        this.transportadora = umArtigo.getTransportadora(); 
    }

    public abstract Artigo clone();

    public int getCodigouser(){
        return this.codigoUser;
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

    public double getCorrecao(){
        return this.correcao;
    } 

    public String getTransportadora(){
        return this.transportadora;
    }

    public void setCodigouser(int codigoUser){
        this.codigoUser = codigoUser;
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

    public void setCorrecao(double correcao){
        this.correcao = correcao;
    } 

    public void setTransportadora(String transportadora){
        this.transportadora = transportadora;
    }

    public abstract double calculaPreco();

}

