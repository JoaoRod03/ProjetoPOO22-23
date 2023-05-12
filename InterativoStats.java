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
        System.out.println("\nTransportadoraMaiorFaturação");
        System.out.println("exit\n");

        Scanner comando = new Scanner(System.in);

        while(comando.hasNextLine()){ 
            String line = comando.nextLine();
            String []splitEspaco = line.split(" ");
            if (splitEspaco[0].equalsIgnoreCase("exit")) return;
            if (splitEspaco[0].equalsIgnoreCase("UserMaiorFaturacao")){
                System.out.println(Vintage.userMaisFaturou() + ";" + (Vintage.getUser(Vintage.userMaisFaturou()).calculaValor()));
            }
        }
        comando.close();
    }
}
