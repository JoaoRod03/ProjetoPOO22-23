package POO;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ParseTransportadora {
    public static Map<String,Transportadora> parse(){
        Map<String,Transportadora> transportadoras = new HashMap<>();
        try{
            File file = new File("POO/inputs/transportadorasIn.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String [] split = line.split(";");
                transportadoras.put((split[1]),CreateTransportadora.create(split));
            }
            scanner.close();
        } 
        catch(FileNotFoundException e){
            System.out.println("Erro");
            e.printStackTrace();
        }
    return transportadoras;
    }
}
