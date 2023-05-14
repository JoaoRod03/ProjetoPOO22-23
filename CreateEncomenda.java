package POO;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CreateEncomenda {
    public static Map <String,Encomenda> create(String[] arg){
        Map <String,Encomenda> res = new HashMap<String,Encomenda>();
        Integer nrart = Integer.parseInt(arg[4]);
        
        for(int i = 0; i < nrart; i++){
            Artigo art = Vintage.getArtigo(arg[i+5]);
            String trans = art.getTransportadora();
            
            if(!res.containsKey(trans)){
                Encomenda encomenda = new Encomenda();

                encomenda.setCodigoComprador(Integer.parseInt(arg[1]));
                if(arg[2].equalsIgnoreCase("pendente")) encomenda.setEstado(Encomenda.Estado.pendente);
                if(arg[2].equalsIgnoreCase("finalizada")) encomenda.setEstado(Encomenda.Estado.finalizada);
                if(arg[2].equalsIgnoreCase("expedida")) encomenda.setEstado(Encomenda.Estado.expedida);
                encomenda.setData(LocalDate.parse(arg[3]));
                List<String> temp = new ArrayList<String>();
                
                if (Vintage.getArtigo(arg[i+5]).getTransportadora().equals(trans)){temp.add(arg[i+5]);}
                encomenda.setLista(temp);

                res.put(trans, encomenda);
            }
            else{
                res.get(trans).addArt(art.getCodigo());
            }
        }
        
        
        return res;
    }
}
