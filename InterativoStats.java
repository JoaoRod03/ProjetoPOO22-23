package POO;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List; 
import java.time.LocalDate;
import java.util.stream.Collectors;

public class InterativoStats {
    public static void start(){
        System.out.println("\nUserMaiorFaturação");
        System.out.println("UserMaiorFaturaçãoData DataInício DataFim");
        System.out.println("UsersFaturacaoOrdenados DataInício DataFim");
        System.out.println("TransportadoraMaiorFaturação DataInício DataFim");
        System.out.println("TransportadoraMaiorFaturaçãoData DataInício DataFim");
        System.out.println("MaiorVendedor DataInício DataFim");
        System.out.println("FaturaçãoVintage");
        System.out.println("exit\n");

        Scanner comando = new Scanner(System.in);

        while(comando.hasNextLine()){ 
            String line = comando.nextLine();
            String []splitEspaco = line.split(" ");
            if (splitEspaco[0].equalsIgnoreCase("exit")) return;
            if (splitEspaco[0].equalsIgnoreCase("UserMaiorFaturacao")){
                System.out.println(Vintage.userMaisFaturou() + ";" + Vintage.getUser(Vintage.userMaisFaturou()).getNome() + ";" + (Vintage.getUser(Vintage.userMaisFaturou()).calculaValor()));
                System.out.println(" ");
            }
            if (splitEspaco[0].equalsIgnoreCase("UserMaiorFaturacaoData")){
                System.out.println("");
                Map<Integer,Double> res = Vintage.userMaisFaturouTempo(LocalDate.parse(splitEspaco[1]), LocalDate.parse(splitEspaco[2]));
                for(Map.Entry <Integer,Double> entry : res.entrySet()){System.out.println(entry.getKey() + ";" + Vintage.getUser(entry.getKey()).getNome() + ";" + entry.getValue());};
                System.out.println(" ");
            }
            if (splitEspaco[0].equalsIgnoreCase("FaturacaoVintage")){
                System.out.println("");
                System.out.println(Vintage.getFaturacao());
                System.out.println(" ");
            }
            if (splitEspaco[0].equalsIgnoreCase("TransportadoraMaiorFaturacao")){
                System.out.println("");
                Map<String,Double> res = Vintage.transportadoraMaisFaturou();
                for(Map.Entry <String,Double> entry : res.entrySet()){System.out.println(entry.getKey() + ";" + Vintage.getTransportadoraNome(entry.getKey()).getNome() + ";" + entry.getValue());};
                System.out.println(" ");
            }
            if (splitEspaco[0].equalsIgnoreCase("TransportadoraMaiorFaturacaoData")){
                System.out.println("");
                Map<String,Double> res = Vintage.transportadoraMaisFaturouData(LocalDate.parse(splitEspaco[1]),LocalDate.parse(splitEspaco[2]));
                for(Map.Entry <String,Double> entry : res.entrySet()){System.out.println(entry.getKey() + ";" + Vintage.getTransportadoraNome(entry.getKey()).getNome() + ";" + entry.getValue());};
                System.out.println(" ");
            }
            if (splitEspaco[0].equalsIgnoreCase("UsersFaturacaoOrdenados")){
                System.out.println("");
                Map<Integer,Double> res = Vintage.listMaisFaturouTempo(LocalDate.parse(splitEspaco[1]),LocalDate.parse(splitEspaco[2]));
                for(Map.Entry <Integer,Double> entry : res.entrySet()){System.out.println(entry.getKey() + ";" + Vintage.getUser(entry.getKey()).getNome() + ";" + entry.getValue());};
                System.out.println(" ");
            }
            if (splitEspaco[0].equalsIgnoreCase("MaiorVendedor")){
                System.out.println("");
                Map<Integer,Integer> res = Vintage.maiorVendedor(LocalDate.parse(splitEspaco[1]),LocalDate.parse(splitEspaco[2]));
                for(Map.Entry <Integer,Integer> entry : res.entrySet()){System.out.println(entry.getKey() + ";" + Vintage.getUser(entry.getKey()).getNome() + ";" + entry.getValue() + "artigos");};
                System.out.println(" ");
            }
        }
        comando.close();
    }
}
