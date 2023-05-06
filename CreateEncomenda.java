package POO;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CreateEncomenda {
    public static Map <String,Encomenda> create(String[] arg){
        Map <String,Encomenda> res = new HashMap<String,Encomenda>();
        Integer nrart = Integer.parseInt(arg[3]);
        
        for(int i = 0; i < nrart; i++){
            Artigo art = Vintage.getArtigo(arg[i+4]);
            String trans = art.getTransportadora();
            
            if(!res.containsKey(trans)){
                List <String> cods = new ArrayList<>();
                cods.add(art.getCodigo());
                Encomenda encomenda = new Encomenda();
                double preco = 0;

                if(arg[1].equalsIgnoreCase("pendente")) encomenda.setEstado(Encomenda.Estado.pendente);
                if(arg[1].equalsIgnoreCase("finalizada")) encomenda.setEstado(Encomenda.Estado.finalizada);
                if(arg[1].equalsIgnoreCase("expedida")) encomenda.setEstado(Encomenda.Estado.expedida);
                encomenda.setData(LocalDate.parse(arg[2]));
                List<String> temp = new ArrayList<String>();
                for(int j = 0; j < nrart; j++){
                    if (Vintage.getArtigo(arg[j+4]).getTransportadora().equals(trans))temp.add(arg[j+4]);
                }
                encomenda.setLista(temp);
                
                if(temp.size() == 1) encomenda.setTamanho(Encomenda.Tamanho.pequena);
                if(temp.size() > 1 && temp.size() < 5) encomenda.setTamanho(Encomenda.Tamanho.media);
                if(temp.size() > 1) encomenda.setTamanho(Encomenda.Tamanho.grande);
            
                for(String a : temp){preco += Vintage.getArtigo(a).getPreco();}
                res.put(trans, encomenda);
            }
            else{
                res.get(trans).addArt(art.getCodigo());
            }
        }
        
        
        return res;
    }
}
