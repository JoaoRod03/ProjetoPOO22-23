package POO;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List; 
import java.time.LocalDate;
import java.util.stream.Collectors;

public class Vintage {
        private static Map <String,Artigo> market = ParseArtigo.parse();
        private static Map <Integer,User> users = ParseUser.parse(market);
        private static Map <String,Transportadora> transportadoras = ParseTransportadora.parse();
        private static Map <String,List<Encomenda>> encomendas = ParseEncomenda.parse();
        private static Map <String,Artigo> vendidos = new HashMap<>();

        public static Artigo getArtigo(String cod){
            return market.get(cod).clone();
        }
        
        public static void addMarket(Artigo artigo){
            market.put(artigo.getCodigo(),artigo.clone()); 
        }

        public static void removeMarket(String cod){
            market.remove(cod);
        }

        public static void addUser(User user){
            users.put(user.getCodigo(), user.clone());
        }

        public static void removeUser(Integer cod){
            users.remove(cod);
        }

        public static void addTransportadora(Transportadora transportadora){
            transportadoras.put(transportadora.getNome(), transportadora.clone());
        }

        public static void removeTransportadora(String nome){
            transportadoras.remove(nome);
        }

        public static void addEncomenda(String transportadora, Encomenda encomenda){
            if(!encomendas.containsKey(transportadora)){
                List <Encomenda> temp = new ArrayList<>();
                temp.add(encomenda.clone());
                encomendas.put(transportadora,temp);
            }
            else encomendas.get(transportadora).add(encomenda.clone());
        }



        public static List <Artigo> getArtsUser(int cod){
            return market.values().stream().filter(a -> a.getCodigouser() == cod).collect(Collectors.toList());
        }


        public static void testar(String []args){

        System.out.println("\n-------------------------------------------------------------------------------------------------------\n");

        for(Artigo art : market.values()){System.out.println(art.toString());}
        System.out.println("");
        for(User user : users.values()){System.out.println(user.toString());}
        System.out.println("");
        for(Transportadora trans : transportadoras.values()){System.out.println(trans.toString());}
        System.out.println("");
        for(List<Encomenda> enc : encomendas.values()){System.out.println(enc.toString());}
        
        System.out.println("\n-------------------------------------------------------------------------------------------------------");

        
        InterativoAdd.start();
        

        System.out.println("\n-------------------------------------------------------------------------------------------------------\n");
        
        for(Artigo art : market.values()){System.out.println(art.toString());}
        System.out.println("");
        for(User user : users.values()){System.out.println(user.toString());}
        System.out.println("");
        for(Transportadora trans : transportadoras.values()){System.out.println(trans.toString());}
        System.out.println("");
        for(List<Encomenda> enc : encomendas.values()){for(Encomenda es : enc){ System.out.println(es.toString());}}
        
        System.out.println("\n-------------------------------------------------------------------------------------------------------\n");
    
    } 
}
