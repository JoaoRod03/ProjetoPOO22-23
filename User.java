package POO;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.security.DrbgParameters.Reseed;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.Map;

public class User {
    private int codigo;
    private String email;
    private String nome;
    private String morada;
    private int nif;
    private Map<String,Artigo> venda;
    private Map<String,Artigo> vendidos;
    private Map<String,Artigo> adquiridos;

    public User(){
        this.codigo = 0;
        this.email = "";
        this.nome = "";
        this.morada = "";
        this.nif = 0;
        this.venda = new HashMap<String,Artigo>();
        this.vendidos = new HashMap<String,Artigo>();
        this.adquiridos = new HashMap<String,Artigo>();
    }

    public User (int codigo, String email, String nome, String morada, int nif, Map<String,Artigo> venda1,Map<String,Artigo> vendidos1, Map<String,Artigo> adquiridos1){
        this.codigo = codigo;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        Map<String,Artigo> res1 = new HashMap<>(); for (String temp : venda1.keySet()) {res1.put(temp, venda1.get(temp).clone());}
        this.venda = res1;
        Map<String,Artigo> res2 = new HashMap<>(); for (String temp : vendidos1.keySet()) {res2.put(temp, vendidos1.get(temp).clone());}
        this.vendidos = res2;
        Map<String,Artigo> res3 = new HashMap<>(); for (String temp : adquiridos1.keySet()) {res3.put(temp, adquiridos1.get(temp).clone());}
        this.adquiridos = res3;
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

    public Map<String,Artigo> getVenda(){
        Map<String,Artigo> res = new HashMap<String,Artigo>();
        for (String temp : this.venda.keySet()){
            res.put(temp, this.venda.get(temp).clone());
        }
        return res;
    }

    public Map<String,Artigo> getVendidos(){
        Map<String,Artigo> res = new HashMap<String,Artigo>();
        for (String temp : this.vendidos.keySet()){
            res.put(temp, this.vendidos.get(temp).clone());
        }
        return res;
    }

    public Map<String,Artigo> getAdquiridos(){
        Map<String,Artigo> res = new HashMap<String,Artigo>();
        for (String temp : this.adquiridos.keySet()){
            res.put(temp, this.adquiridos.get(temp).clone());
        }
        return res;
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

    public void setVenda(Map<String,Artigo> x){
        Map<String,Artigo> res = new HashMap<String,Artigo>();
        for (String temp : x.keySet()){
            res.put(temp, x.get(temp).clone());
        }
        this.venda = res;
    }

    public void setVendidos(Map<String,Artigo> x){
        Map<String,Artigo> res = new HashMap<String,Artigo>();
        for (String temp : x.keySet()){
            res.put(temp, x.get(temp).clone());
        }
        this.vendidos = res;
    }

    public void setAdquiridos(Map<String,Artigo> x){
        Map<String,Artigo> res = new HashMap<String,Artigo>();
        for (String temp : x.keySet()){
            res.put(temp, x.get(temp).clone());
        }
        this.adquiridos= res;
    }

    public double calculaValor(){
        double res = 0;
        for(Artigo art : this.vendidos.values()) res += art.calculaPreco();
        return res;
    }

    public void removeVenda(String cod){
        venda.remove(cod);
    }

    public void addVendidos(String cod){
        vendidos.put(cod, Vintage.getArtigo(cod));
    }



    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User;").append(this.codigo)
                .append(";").append(this.email)
                .append(";").append(this.nome)
                .append(";").append(this.morada)
                .append(";").append(this.nif)
                .append(";").append(this.calculaValor());
        return sb.toString();
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass())) return false;

        User user = (User) o;
        return user.getCodigo() == this.codigo &&
                user.getEmail().equals(this.email) &&
                user.getNome().equals(this.nome) &&
                user.getMorada().equals(this.morada) &&
                user.getNif() == this.nif &&
                user.getVenda().equals(this.venda) &&
                user.getVendidos().equals(this.vendidos) &&
                user.getAdquiridos().equals(this.adquiridos);
    }

}    