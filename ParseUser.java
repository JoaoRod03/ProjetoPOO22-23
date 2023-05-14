package POO;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class ParseUser {
    public static Map<Integer,User> parse(Map <String,Artigo> artigos){
        Map<Integer,User> users = new HashMap<>();
        try{
            File file = new File("POO/inputs/usersIn.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String [] split = line.split(";");
                users.put(Integer.parseInt(split[1]),CreateUser.create(split));
            }
            scanner.close();         
        }
        catch(FileNotFoundException e){
            System.out.println("Erro");
            e.printStackTrace();
        }
    return users; 
    }
}