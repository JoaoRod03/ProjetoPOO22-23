package POO;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List; 
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParseEncomenda {
    public static Map<String,List<Encomenda>> parse(){
        Map<String,List<Encomenda>> encomendas = new HashMap<>();
        try{
            File file = new File("POO/inputs/encomendasIn.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(";");
                Map<String,Encomenda> temp = CreateEncomenda.create(split);
                
                for(Map.Entry<String,Encomenda> entry : temp.entrySet()){
                    if(!encomendas.containsKey(entry.getKey())){
                        List<Encomenda> list = new ArrayList<>();
                        list.add(entry.getValue());
                        encomendas.put(entry.getKey(), list);
                    }
                    else{
                        encomendas.get(entry.getKey()).add(entry.getValue());
                    }
                }
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
