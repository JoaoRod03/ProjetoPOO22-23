package POO;
import java.util.Scanner;
import java.time.LocalDate;


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
            if (splitEspaco[0].equalsIgnoreCase("exit")) {
                comando.close(); 
                return;
            }
            if (splitEspaco[0].equalsIgnoreCase("save")) {
                Vintage.save();
                comando.close(); 
                return;
            }
            if (splitEspaco[0].equalsIgnoreCase("finalizarEncomenda")){
                Vintage.finalizarEncomenda(splitEspaco[1],LocalDate.parse(splitEspaco[2]));
                System.out.println(" ");
            }
            if (splitEspaco[0].equalsIgnoreCase("avancarDias")){
                Vintage.setData(Vintage.getData().plusDays(Long.parseLong(splitEspaco[1])));
                Vintage.atualizarMarket();
                System.out.println(" ");
            }
            if (splitEspaco[0].equalsIgnoreCase("removerArtigo")){
                Vintage.removerArtigoEncomenda(Integer.parseInt(splitEspaco[1]), splitEspaco[2]);
                System.out.println(" ");
            }
            if (splitEspaco[0].equalsIgnoreCase("adicionarArtigo")){
                Vintage.adicionarArtigoEncomenda(Integer.parseInt(splitEspaco[1]), splitEspaco[2]);
                System.out.println(" ");
            }
            if (splitEspaco[0].equalsIgnoreCase("precofinalencomenda")){
                double res = Vintage.precoEncomenda(Integer.parseInt(splitEspaco[1]), splitEspaco[2]);
                System.out.println(res + "$");
                System.out.println(" ");
            }
            if (splitEspaco[0].equalsIgnoreCase("devolverEncomenda")){
                Vintage.devolverEncomenda(Integer.parseInt(splitEspaco[1]), splitEspaco[2]);
                System.out.println(" ");
            }
        }
        comando.close();
    }
}
