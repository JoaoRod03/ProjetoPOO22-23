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
        System.out.println("TransportadoraMaiorFaturação");
        System.out.println("exit\n");

        Scanner comando = new Scanner(System.in);

        while(comando.hasNextLine()){ 
            String line = comando.nextLine();
            String []splitEspaco = line.split(" ");
            if (splitEspaco[0].equalsIgnoreCase("exit")) return;
            if (splitEspaco[0].equalsIgnoreCase("UserMaiorFaturacao")){
                System.out.println(Vintage.userMaisFaturou() + ";" + (Vintage.getUser(Vintage.userMaisFaturou()).calculaValor()));
            }
            if (splitEspaco[0].equalsIgnoreCase("UserMaiorFaturacaoData")){
                Map<Integer,Double> res = Vintage.userMaisFaturouTempo(LocalDate.parse(splitEspaco[1]), LocalDate.parse(splitEspaco[2]));
                for(Map.Entry <Integer,Double> entry : res.entrySet()){System.out.println(entry.getKey() + ";" + entry.getValue());};
            }
            
        }
        comando.close();
    }
}
