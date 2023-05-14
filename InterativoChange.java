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
        System.out.println("\nFinalizarEncomenda codigoArtigo data");
        System.out.println("AvançarDias xDias");
        System.out.println("RemoverArtigo codigoComprador codigoArtigo");
        System.out.println("AdicionarArtigo codigoComprador codigoArtigo");
        System.out.println("PreçoFinalEncomenda codigoComprador transportadora");
        System.out.println("DevolverEncomenda codigoComprador transportadora");
        System.out.println("Exit");
        System.out.println("Save\n");

        Scanner comando = new Scanner(System.in);
        Vintage.atualizarMarket();

        while(comando.hasNextLine()){ 
            String line = comando.nextLine();
            String []splitEspaco = line.split(" ");
            if (splitEspaco[0].equalsIgnoreCase("exit")) return;
            if (splitEspaco[0].equalsIgnoreCase("save")) {
                Vintage.save();
                return;
            }
            if (splitEspaco[0].equalsIgnoreCase("finalizarEncomenda")){
                Vintage.finalizarEncomenda(splitEspaco[1],LocalDate.parse(splitEspaco[2]));
            }
            if (splitEspaco[0].equalsIgnoreCase("avançarDias")){
                Vintage.setData(Vintage.getData().plusDays(Long.parseLong(splitEspaco[1])));
                Vintage.atualizarMarket();
            }
            if (splitEspaco[0].equalsIgnoreCase("removerArtigo")){
                Vintage.removerArtigoEncomenda(Integer.parseInt(splitEspaco[1]), splitEspaco[2]);
            }
            if (splitEspaco[0].equalsIgnoreCase("adicionarArtigo")){
                Vintage.adicionarArtigoEncomenda(Integer.parseInt(splitEspaco[1]), splitEspaco[2]);
            }
            if (splitEspaco[0].equalsIgnoreCase("Preçofinalencomenda")){
                double res = Vintage.precoEncomenda(Integer.parseInt(splitEspaco[1]), splitEspaco[2]);
                System.out.println(res + "$");
            }
            if (splitEspaco[0].equalsIgnoreCase("devolverEncomenda")){
                Vintage.devolverEncomenda(Integer.parseInt(splitEspaco[1]), splitEspaco[2]);
            }
        }
        comando.close();
    }
}
