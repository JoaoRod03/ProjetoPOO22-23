package POO;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class CreateUser {
    public static User create(String []arg){
        User user = new User();
        user.setCodigo(Integer.parseInt(arg[1]));
        user.setEmail(arg[2]);
        user.setNome(arg[3]);
        user.setMorada(arg[4]);
        user.setNif(Integer.parseInt(arg[5]));
        
        List <Artigo> artigos = Vintage.getArtsUser(Integer.parseInt(arg[1]));
        Map<String,Artigo> res = new HashMap<String,Artigo>();

        for(Artigo temp : artigos){res.put(temp.getCodigo(),temp);}
        user.setVenda(res);
        
        return user;
    }
}
