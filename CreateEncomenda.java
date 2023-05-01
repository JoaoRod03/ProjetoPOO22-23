package POO;
import java.time.LocalDate;

public class CreateEncomenda {
    public static Encomenda create(String []arg){
        Encomenda encomenda = new Encomenda();
        
        if(arg[0].equalsIgnoreCase("grande")) encomenda.setTamanho(Encomenda.Tamanho.grande);
        if(arg[0].equalsIgnoreCase("medio")) encomenda.setTamanho(Encomenda.Tamanho.medio);
        if(arg[0].equalsIgnoreCase("pequeno")) encomenda.setTamanho(Encomenda.Tamanho.pequeno);
        encomenda.setPrecofinal(Double.parseDouble(arg[1]));
        encomenda.setExpedicao(Double.parseDouble(arg[2]));
        if(arg[3].equalsIgnoreCase("pendente")) encomenda.setEstado(Encomenda.Estado.pendente);
        if(arg[3].equalsIgnoreCase("finalizada")) encomenda.setEstado(Encomenda.Estado.finalizada);
        if(arg[3].equalsIgnoreCase("expedida")) encomenda.setEstado(Encomenda.Estado.expedida);
        encomenda.setData(LocalDate.parse(arg[4]));
        return encomenda;
    }
}
