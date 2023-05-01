package POO;
import java.util.HashMap;
import java.util.Map;

public class CreateUser {
    public static User create(String []arg, Map <String,Artigo> artigos){
        User user = new User();
        user.setCodigo(Integer.parseInt(arg[1]));
        user.setEmail(arg[2]);
        user.setNome(arg[3]);
        user.setMorada(arg[4]);
        user.setNif(Integer.parseInt(arg[5]));
        user.setValortotal(Double.parseDouble(arg[6]));
        Map<String,Artigo> res = new HashMap<String,Artigo>();
        for(String temp: artigos.keySet()){if(artigos.get(temp).getCodigouser() == user.getCodigo()) res.put(temp,artigos.get(temp).clone());}
        user.setVenda(res);
        return user;
    }
}
