package POO;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ParseArtigo {
    public static Map<String,Artigo> parse(){
        Map<String,Artigo> art = new HashMap<>();
        try{
            File file = new File("POO/inputs/artigosIn.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String [] split = line.split(";");
                if (split[0].equalsIgnoreCase("Mala")){
                    art.put(split[7], CreateMala.create(split));
                }
                if (split[0].equalsIgnoreCase("Sapatilha")){
                    art.put(split[7],CreateSapatilha.create(split));
                }
                if (split[0].equalsIgnoreCase("Tshirt")){
                    art.put(split[7],CreateTshirt.create(split));
                }
            }
            scanner.close();
        } 
        catch(FileNotFoundException e){
            System.out.println("Erro");
            e.printStackTrace();
        }
    return art;
    }
}