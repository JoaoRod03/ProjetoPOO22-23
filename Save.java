package POO;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.io.File;
import java.io.FileWriter;

public class Save {
    public static void save(Map <String,Artigo> market, Map <Integer,User> users, Map <String,Transportadora> transportadoras, List <Encomenda> encomendas){
        try{
            File fileusers = new File("POO/usersout.txt");
            FileWriter userswriter = new FileWriter(fileusers);
            
            for (User u : users.values()){ userswriter.write(u.toString() + "\n");}
            userswriter.close();

            File fileartigos = new File("POO/artigosout.txt");
            FileWriter artigoswriter = new FileWriter(fileartigos);
            
            for (Artigo a : market.values()){ artigoswriter.write(a.toString() + "\n");}
            artigoswriter.close();

            File filetransportadoras = new File("POO/transportadorasout.txt");
            FileWriter transportadoraswriter = new FileWriter(filetransportadoras);
            
            for (Transportadora t : transportadoras.values()){ transportadoraswriter.write(t.toString() + "\n");}
            transportadoraswriter.close();

            File fileencomendas = new File("POO/encomendasout.txt");
            FileWriter encomendaswriter = new FileWriter(fileencomendas);
            
            for (Encomenda e : encomendas){ encomendaswriter.write(e.toString() + "\n");}
            encomendaswriter.close();

        }
        catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
