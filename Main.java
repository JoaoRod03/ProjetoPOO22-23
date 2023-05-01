package POO;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List; 
import java.time.LocalDate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String []args){
        Map <String,Artigo> market = ParseArtigo.parse();
        Map <Integer,User> users = ParseUser.parse(market);
        Map <String,Transportadora> transportadoras = ParseTransportadora.parse();
        List <Encomenda> encomendas = ParseEncomenda.parse();

        Interativo.start(market, users, transportadoras,encomendas);
        
        
    
    
    
    
    
    }
}
