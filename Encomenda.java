package POO;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import POO.Artigo.Uso;

import java.time.LocalDate;

public class Encomenda {
    public enum Tamanho{grande,media,pequena}
    public static final double New = 0.5;
    public static final double Used = 0.25;
    public enum Estado{pendente,finalizada,expedida}
    
    private List<String> lista;
    private Tamanho tamanho;
    private Estado estado;
    private LocalDate data;
    private Integer codComprador;

    public Encomenda(){
        this.lista = new ArrayList<String>();
        this.tamanho = Tamanho.media;
        this.estado = Estado.pendente;
        this.data = LocalDate.now();
        this.codComprador = 0;
    }

    public Encomenda(List<String> lista, Tamanho tamanho, double precofinal, Estado estado, LocalDate data, Integer codComprador){
        this.lista = new ArrayList<String>();
        this.lista.addAll(lista);
        this.tamanho = tamanho;
        this.estado = estado;
        this.data = data;
        this.codComprador = codComprador;
    }

    public Encomenda(Encomenda encomenda){
        this.lista = encomenda.getLista();
        this.tamanho = encomenda.getTamanho();
        this.estado = encomenda.getEstado();
        this.data = encomenda.getData();
        this.codComprador = encomenda.getCodigoComprador();
    }

    public Encomenda clone(){
        return new Encomenda(this);
    }

    public List<String> getLista(){
        List <String> res = new ArrayList<String>();
        res.addAll(this.lista);
        return res;
    }

    public Tamanho getTamanho(){
        return this.tamanho;
    }

    public Estado getEstado(){
        return this.estado;
    }

    public LocalDate getData(){
        return this.data;
    }

    public Integer getCodigoComprador(){
        return this.codComprador;
    }

    public void setLista(List<String> lista){
        List <String> res = new ArrayList<String>();
        res.addAll(lista);
        this.lista = res;
    }

    public void setTamanho(Tamanho tamanho){
        this.tamanho = tamanho;
    }

    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    public void setCodigoComprador(Integer codComprador){
        this.codComprador = codComprador;
    }

    public void addArt(String artigo){
        this.lista.add(artigo);
    }

    public void removeArt(String artigo){
        this.lista.remove(artigo);
    }
    
    public double getPrecoFinal(){
        double res = 0;
        String transportadora = "";
        for(String temp : this.lista){
            res += Vintage.getArtigo(temp).calculaPreco();
            if (Vintage.getArtigo(temp).getUsado() == Uso.Novo) res += 0.5;
            if (Vintage.getArtigo(temp).getUsado() == Uso.Usado) res += 0.25;
        }
        transportadora = Vintage.getArtigo(this.lista.get(0)).getTransportadora();
        Transportadora transp = Vintage.getTransportadoraNome(transportadora); 
        res += transp.calculaExpedicao(this.lista.size());
        return res;
    }

    public Tamanho calculaTamanho(){
        Tamanho tamanho = Tamanho.pequena;
        if(lista.size() == 1) tamanho = Tamanho.pequena;
        if(lista.size() > 1 && lista.size() < 5) tamanho = Tamanho.media;
        if(lista.size() > 5) tamanho = Tamanho.grande;
        return tamanho;
    }

    
    public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Encomenda")
                .append(";").append(this.codComprador)
                .append(";").append(this.calculaTamanho())
                .append(";").append(this.getPrecoFinal())
                .append(";").append(this.estado)
                .append(";").append(this.data)
                .append(";").append(this.lista.size())
                .append(";");
                for (int i = 0; i < this.lista.size(); i++) {
                    sb.append(this.lista.get(i));
                    if (i < this.lista.size() - 1) {
                        sb.append(";");
                    }
                }
        return sb.toString();
    }

    public String toStringSave() {
        StringBuilder sb = new StringBuilder();
            sb.append("Encomenda")
                .append(";").append(this.codComprador)
                .append(";").append(this.estado)
                .append(";").append(this.data)
                .append(";").append(this.lista.size())
                .append(";");
                for (int i = 0; i < this.lista.size(); i++) {
                    sb.append(this.lista.get(i));
                    if (i < this.lista.size() - 1) {
                        sb.append(";");
                    }
                }
        return sb.toString();
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass())) return false;

        Encomenda enc = (Encomenda) o;
        return enc.getLista().equals(this.lista) &&
                enc.getTamanho() == this.tamanho &&
                enc.getEstado() == this.estado &&
                enc.getData() == this.data;
    }
}
