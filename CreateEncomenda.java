package POO;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class CreateEncomenda {
    public static Encomenda create(String []arg){
        Encomenda encomenda = new Encomenda();
        if(arg[1].equalsIgnoreCase("grande")) encomenda.setTamanho(Encomenda.Tamanho.grande);
        if(arg[1].equalsIgnoreCase("medio")) encomenda.setTamanho(Encomenda.Tamanho.medio);
        if(arg[1].equalsIgnoreCase("pequeno")) encomenda.setTamanho(Encomenda.Tamanho.pequeno);
        encomenda.setPrecofinal(Double.parseDouble(arg[2]));
        if(arg[3].equalsIgnoreCase("pendente")) encomenda.setEstado(Encomenda.Estado.pendente);
        if(arg[3].equalsIgnoreCase("finalizada")) encomenda.setEstado(Encomenda.Estado.finalizada);
        if(arg[3].equalsIgnoreCase("expedida")) encomenda.setEstado(Encomenda.Estado.expedida);
        encomenda.setData(LocalDate.parse(arg[4]));
        encomenda.setNrartigos(Integer.parseInt(arg[5])); 
        List temp = new ArrayList<String>();
        for(int i = 0; i < Integer.parseInt(arg[5]); i++){
            temp.add(arg[i+6]);
        }
        encomenda.setLista(temp);
        return encomenda;
    }
}
