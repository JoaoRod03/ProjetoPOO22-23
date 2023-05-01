package POO;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List; 
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ParseEncomenda {
    public static List<Encomenda> parse(){
        List<Encomenda> encomendas = new ArrayList<>();
        try{
            File file = new File("encomendas.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String [] split = line.split(";");
                encomendas.add(CreateEncomenda.create(split));
            }
            scanner.close();
        } 
        catch(FileNotFoundException e){
            System.out.println("Erro");
            e.printStackTrace();
        }
    return encomendas;
    }
}
