package POO;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class Encomenda {
    public enum Tamanho{grande,medio,pequeno}
    public static final double New = 0.5;
    public static final double Used = 0.25;
    public enum Estado{pendente,finalizada,expedida}
    
    private List<String> lista;
    private Tamanho tamanho;
    private double precofinal;
    private Estado estado;
    private LocalDate data;
    private int nrartigos;

    public Encomenda(){
        this.lista = new ArrayList<String>();
        this.tamanho = Tamanho.medio;
        this.precofinal = 0;
        this.estado = Estado.pendente;
        this.data = LocalDate.now();
        this.nrartigos = 0;
    }

    public Encomenda(List<String> lista, Tamanho tamanho, double precofinal, Estado estado, LocalDate data, int nrartigos){
        this.lista = new ArrayList<String>();
        this.lista.addAll(lista);
        this.tamanho = tamanho;
        this.precofinal = precofinal;
        this.estado = estado;
        this.data = data;
        this.nrartigos = nrartigos;
    }

    public Encomenda(Encomenda encomenda){
        this.lista = encomenda.getLista();
        this.tamanho = encomenda.getTamanho();
        this.precofinal = encomenda.getPrecofinal();
        this.estado = encomenda.getEstado();
        this.data = encomenda.getData();
        this.nrartigos = encomenda.getNrartigos();
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

    public double getPrecofinal(){
        return this.precofinal;
    }

    public Estado getEstado(){
        return this.estado;
    }

    public LocalDate getData(){
        return this.data;
    }

    public int getNrartigos(){
        return this.nrartigos;
    }

    public void setLista(List<String> lista){
        List <String> res = new ArrayList<String>();
        res.addAll(lista);
        this.lista = res;
    }

    public void setTamanho(Tamanho tamanho){
        this.tamanho = tamanho;
    }

    public void setPrecofinal(double precofinal){
        this.precofinal = precofinal;
    }
    
    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    public void setNrartigos(int nrartigos){
        this.nrartigos = nrartigos;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Encomenda")
                .append(";").append(this.tamanho)
                .append(";").append(this.precofinal)
                .append(";").append(this.estado)
                .append(";").append(this.data)
                .append(";").append(this.nrartigos)
                .append(";");
                for (int i = 0; i < this.lista.size(); i++) {
                    sb.append(this.lista.get(i));
                    if (i < this.lista.size() - 1) {
                        sb.append(";");
                    }
                }
        return sb.toString();
    }


}
