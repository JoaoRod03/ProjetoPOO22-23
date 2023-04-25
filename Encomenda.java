package POO;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class Encomenda {
    public enum Tamanho{grande,medio,pequeno}
    public static final double New = 0.5;
    public static final double Used = 0.25;
    public enum Estado{pendente,finalizada,expedida}
    
    private List<Artigo> lista;
    private Tamanho tamanho;
    private double precofinal;
    private double expedicao;
    private Estado estado;
    private LocalDate data;

    public Encomenda(){
        this.lista = new ArrayList<Artigo>();
        this.tamanho = Tamanho.medio;
        this.precofinal = 0;
        this.expedicao = 0;
        this.estado = Estado.pendente;
        this.data = LocalDate.now();
    }

    public Encomenda(List<Artigo> lista, Tamanho tamanho, double precofinal, double expedicao, Estado estado, LocalDate data){
        this.lista = lista.stream().map(a -> a.clone()).collect(Collectors.toList());
        this.tamanho = tamanho;
        this.precofinal = precofinal;
        this.expedicao = expedicao;
        this.estado = estado;
        this.data = data;
    }

    public Encomenda(Encomenda encomenda){
        this.lista = encomenda.getLista();
        this.tamanho = encomenda.getTamanho();
        this.precofinal = encomenda.getPrecofinal();
        this.expedicao = encomenda.getExpedicao();
        this.estado = encomenda.getEstado();
        this.data = encomenda.getData();
    }

    public Encomenda clone(){
        return new Encomenda(this);
    }

    public List<Artigo> getLista(){
        return this.lista.stream().map(a -> a.clone()).collect(Collectors.toList());
    }

    public Tamanho getTamanho(){
        return this.tamanho;
    }

    public double getPrecofinal(){
        return this.precofinal;
    }

    public double getExpedicao(){
        return this.expedicao;
    }

    public Estado getEstado(){
        return this.estado;
    }

    public LocalDate getData(){
        return this.data;
    }

    public void setLista(List<Artigo> lista){
        this.lista = lista.stream().map(a -> a.clone()).collect(Collectors.toList());
    }

    public void setTamanho(Tamanho tamanho){
        this.tamanho = tamanho;
    }

    public void setPrecofinal(double precofinal){
        this.precofinal = precofinal;
    }

    public void setExpedicao(double expedicao){
        this.expedicao = expedicao;
    }

    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    



}
