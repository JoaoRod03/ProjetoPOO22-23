package POO;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List; 
import java.time.LocalDate;
import java.util.stream.Collectors;

public class InterativoChange {
    public static void start(){
        System.out.println("finalizarEncomenda codArtigo");
        System.out.println("avançarDias xDias");
        System.out.println("exit");
        System.out.println("save\n");

        Scanner comando = new Scanner(System.in);

        while(comando.hasNextLine()){ 
            String line = comando.nextLine();
            String []splitEspaco = line.split(" ");
            if (splitEspaco[0].equalsIgnoreCase("exit")) return;
            if (splitEspaco[0].equalsIgnoreCase("save")) {
                Vintage.save();
                return;
            }
            if (splitEspaco[0].equalsIgnoreCase("finalizarEncomenda")){
                Vintage.finalizarEncomenda(splitEspaco[1]);
            }
            if (splitEspaco[0].equalsIgnoreCase("avançarDias")){
  //              Vintage.alterarData(splitEspaco[1]);
            }
        }
        comando.close();
    }
}
