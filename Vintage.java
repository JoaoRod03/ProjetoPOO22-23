package POO;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List; 
import java.time.LocalDate;
import java.util.stream.Collectors;

public class Vintage {
    public static void execute(String []args){
        Map <String,Artigo> market = ParseArtigo.parse();
        Map <Integer,User> users = ParseUser.parse(market);
        Map <String,Transportadora> transportadoras = ParseTransportadora.parse();
        List <Encomenda> encomendas = ParseEncomenda.parse();
        //Map <Transportadora,List <Encomenda>> encomendas1 = ParseEncomenda.parse();

        System.out.println("\n-------------------------------------------------------------------------------------------------------\n");

        for(Artigo art : market.values()){System.out.println(art.toString());}
        System.out.println("");
        for(User user : users.values()){System.out.println(user.toString());}
        System.out.println("");
        for(Transportadora trans : transportadoras.values()){System.out.println(trans.toString());}
        System.out.println("");
        for(Encomenda enc : encomendas){System.out.println(enc.toString());}
        
        System.out.println("\n-------------------------------------------------------------------------------------------------------");

        
        Interativo.start(market, users, transportadoras,encomendas);
        

        System.out.println("\n-------------------------------------------------------------------------------------------------------\n");
        
        for(Artigo art : market.values()){System.out.println(art.toString());}
        System.out.println("");
        for(User user : users.values()){System.out.println(user.toString());}
        System.out.println("");
        for(Transportadora trans : transportadoras.values()){System.out.println(trans.toString());}
        System.out.println("");
        for(Encomenda enc : encomendas){System.out.println(enc.toString());}
        
        System.out.println("\n-------------------------------------------------------------------------------------------------------\n");
    
    } 
}
