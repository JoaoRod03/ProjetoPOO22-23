package POO;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

    public Encomenda(){
        this.lista = new ArrayList<String>();
        this.tamanho = Tamanho.media;
        this.estado = Estado.pendente;
        this.data = LocalDate.now();
    }

    public Encomenda(List<String> lista, Tamanho tamanho, double precofinal, Estado estado, LocalDate data){
        this.lista = new ArrayList<String>();
        this.lista.addAll(lista);
        this.tamanho = tamanho;
        this.estado = estado;
        this.data = data;
    }

    public Encomenda(Encomenda encomenda){
        this.lista = encomenda.getLista();
        this.tamanho = encomenda.getTamanho();
        this.estado = encomenda.getEstado();
        this.data = encomenda.getData();
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

    public void addArt(String artigo){
        this.lista.add(artigo);
    }
    
    public double getPrecoFinal(){
        double res = 0;
        for(String temp : this.lista){
            res += Vintage.getArtigo(temp).getPreco();
        }
        return res;
    }

    public Tamanho calculaTamanho(){
        Tamanho tamanho = Tamanho.pequena;
        if(lista.size() == 1) tamanho = Tamanho.pequena;
        if(lista.size() > 1 && lista.size() < 5) tamanho = Tamanho.media;
        if(lista.size() > 5) tamanho = Tamanho.grande;
        return tamanho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Encomenda")
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
