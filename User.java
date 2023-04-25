package POO;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List; 
import java.time.LocalDate;
import java.util.stream.Collectors;

public class User {
    private int codigo;
    private String email;
    private String nome;
    private String morada;
    private int nif;
    private List<Artigo> venda;
    private List<Artigo> vendidos;
    private List<Artigo> adquiridos;
    private double valorTotal;

    public User(){
        this.codigo = 0;
        this.email = "";
        this.nome = "";
        this.morada = "";
        this.nif = 0;
        this.venda = new ArrayList<Artigo>();
        this.vendidos = new ArrayList<Artigo>();
        this.adquiridos = new ArrayList<Artigo>();
        this.valorTotal = 0;
    }

    public User (int codigo, String email, String nome, String morada, int nif, List<Artigo> venda, List<Artigo> vendidos, List<Artigo> adquiridos, double valorTotal){
        this.codigo = codigo;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        this.venda = venda.stream().map(a -> a.clone()).collect(Collectors.toList());
        this.vendidos = vendidos.stream().map(a -> a.clone()).collect(Collectors.toList());   
        this.adquiridos = adquiridos.stream().map(a -> a.clone()).collect(Collectors.toList());
        this.valorTotal = valorTotal;
    }

    public User (User user){
        this.codigo = user.getCodigo();
        this.email = user.getEmail();
        this.nome = user.getNome();
        this.morada = user.getMorada();
        this.nif = user.getNif();
        this.venda = user.getVenda();
        this.vendidos = user.getVendidos();
        this.adquiridos = user.getAdquiridos();
        this.valorTotal = user.getValortotal();
    }

    public User clone(){
        return new User(this); 
    }

    public int getCodigo(){
        return this.codigo;
    }
    
    public String getEmail(){
        return this.email;
    }

    public String getNome(){
        return this.nome;
    }

    public String getMorada(){
        return this.morada;
    }

    public int getNif(){
        return this.nif;
    }

    public List<Artigo> getVenda(){
        return this.venda.stream().map(a -> a.clone()).collect(Collectors.toList());
    }

    public List<Artigo> getVendidos(){
        return this.vendidos.stream().map(a -> a.clone()).collect(Collectors.toList());
    }

    public List<Artigo> getAdquiridos(){
        return this.adquiridos.stream().map(a -> a.clone()).collect(Collectors.toList());
    }

    public double getValortotal(){
        return this.valorTotal;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setMorada(String morada){
        this.morada = morada;
    }

    public void setNif(int nif){
        this.nif = nif;
    }

    public void setVenda(List<Artigo> venda){
        this.venda = venda.stream().map(a -> a.clone()).collect(Collectors.toList());
    }

    public void setVendidos(List<Artigo> vendidos){
        this.venda = vendidos.stream().map(a -> a.clone()).collect(Collectors.toList());
    }

    public void setAdquiridos(List<Artigo> adquiridos){
        this.venda = adquiridos.stream().map(a -> a.clone()).collect(Collectors.toList());
    }

    public void setValortotal(double valorTotal){
        this.valorTotal = valorTotal;
    }



}    