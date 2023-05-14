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

public class ParseData {
    public static LocalDate parse(){
        LocalDate data = LocalDate.now();
        try{
            File file = new File("POO/inputs/data.txt");
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                data = LocalDate.parse(line);
            }
            scanner.close();
        } 
        catch(FileNotFoundException e){
            System.out.println("Erro");
            e.printStackTrace();
        }
    return data;
    }
}
