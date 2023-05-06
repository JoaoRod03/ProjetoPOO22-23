package POO;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List; 
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


import POO.Encomenda.Estado;

public class Vintage {
    private static Map <String,Artigo> market = ParseArtigo.parse();
    private static Map <Integer,User> users = ParseUser.parse(market);
    private static Map <String,Transportadora> transportadoras = ParseTransportadora.parse();
    private static Map <String,List<Encomenda>> encomendas = ParseEncomenda.parse();
    private static Map <String,Artigo> vendidos = new HashMap<>();

    public static Artigo getArtigo(String cod){
        return market.get(cod).clone();
    }
        
    public static void addMarket(Artigo artigo){
        market.put(artigo.getCodigo(),artigo.clone()); 
    }

    public static void removeMarket(String cod){
        market.remove(cod);
    }

    public static void addUser(User user){
        users.put(user.getCodigo(), user.clone());
    }

    public static void removeUser(Integer cod){
        users.remove(cod);
    }

    public static void addTransportadora(Transportadora transportadora){
        transportadoras.put(transportadora.getNome(), transportadora.clone());
    }

    public static void removeTransportadora(String nome){
        transportadoras.remove(nome);
    }

    public static void addEncomenda(String transportadora, Encomenda encomenda){
        if(!encomendas.containsKey(transportadora)){
            List <Encomenda> temp = new ArrayList<>();
            temp.add(encomenda.clone());
            encomendas.put(transportadora,temp);
        }
        else encomendas.get(transportadora).add(encomenda.clone());
    }

    public static List <Artigo> getArtsUser(int cod){
        return market.values().stream().filter(a -> a.getCodigouser() == cod).collect(Collectors.toList());
    }


    public static void finalizarEncomenda(String art){
        String trans = getArtigo(art).getTransportadora();
        List <Encomenda> temp = encomendas.get(trans);
        for (Encomenda enc : temp){
            if (enc.getLista().contains(art)){if (enc.getEstado().equals(Encomenda.Estado.pendente)) enc.setEstado(Estado.finalizada);}
        }
    }

    public static void executar(String []args){

        Scanner sc = new Scanner(System.in);

        System.out.println("\n-------------------------------------------------------------------------------------------------------\n");

        for(Artigo art : market.values()){System.out.println(art.toString());}
        System.out.println("");
        for(User user : users.values()){System.out.println(user.toString());}
        System.out.println("");
        for(Transportadora trans : transportadoras.values()){System.out.println(trans.toString());}
        System.out.println("");
        for(List<Encomenda> enc : encomendas.values()){for(Encomenda e : enc){System.out.println(e.toString());}}
        
        System.out.println("\n-------------------------------------------------------------------------------------------------------");

        System.out.println("Deseja adicionar elementos?\n");
        String choice = sc.nextLine();
        if(choice.equalsIgnoreCase("sim")){
            InterativoAdd.start();
            System.out.println("\n-------------------------------------------------------------------------------------------------------\n");
        
            for(Artigo art : market.values()){System.out.println(art.toString());}
            System.out.println("");
            for(User user : users.values()){System.out.println(user.toString());}
            System.out.println("");
            for(Transportadora trans : transportadoras.values()){System.out.println(trans.toString());}
            System.out.println("");
            for(List<Encomenda> enc : encomendas.values()){for(Encomenda es : enc){ System.out.println(es.toString());}}
            System.out.println("\n-------------------------------------------------------------------------------------------------------\n");
        }
        else if(choice.equalsIgnoreCase("nao")){System.out.println("\n-------------------------------------------------------------------------------------------------------\n");}
        
        System.out.println("Deseja manipular elementos?\n");
        String choice2 = sc.nextLine();
        if(choice2.equalsIgnoreCase("sim")){
            InterativoChange.start();
            System.out.println("\n-------------------------------------------------------------------------------------------------------\n");
        
            for(Artigo art : market.values()){System.out.println(art.toString());}
            System.out.println("");
            for(User user : users.values()){System.out.println(user.toString());}
            System.out.println("");
            for(Transportadora trans : transportadoras.values()){System.out.println(trans.toString());}
            System.out.println("");
            for(List<Encomenda> enc : encomendas.values()){for(Encomenda es : enc){ System.out.println(es.toString());}}
            System.out.println("\n-------------------------------------------------------------------------------------------------------\n");
        }
        else if(choice2.equalsIgnoreCase("nao")){
                
                System.out.println("\n-------------------------------------------------------------------------------------------------------\n");

                for(Artigo art : market.values()){System.out.println(art.toString());}
                System.out.println("");
                for(User user : users.values()){System.out.println(user.toString());}
                System.out.println("");
                for(Transportadora trans : transportadoras.values()){System.out.println(trans.toString());}
                System.out.println("");
                for(List<Encomenda> enc : encomendas.values()){for(Encomenda es : enc){ System.out.println(es.toString());}}
        
                System.out.println("\n-------------------------------------------------------------------------------------------------------\n");
        }
        
        
    
    } 

    public static void save(){
        try{
            File fileusers = new File("txts/usersOut.txt");
            FileWriter userswriter = new FileWriter(fileusers);
            
            for (User u : users.values()){ userswriter.write(u.toString() + "\n");}
            userswriter.close();

            File fileartigos = new File("txts/artigosOut.txt");
            FileWriter artigoswriter = new FileWriter(fileartigos);
            
            for (Artigo a : market.values()){ artigoswriter.write(a.toString() + "\n");}
            artigoswriter.close();

            File filetransportadoras = new File("txts/transportadorasOut.txt");
            FileWriter transportadoraswriter = new FileWriter(filetransportadoras);
            
            for (Transportadora t : transportadoras.values()){ transportadoraswriter.write(t.toString() + "\n");}
            transportadoraswriter.close();

            File fileencomendas = new File("txts/encomendasOut.txt");
            FileWriter encomendaswriter = new FileWriter(fileencomendas);
            
            for(List <Encomenda> temp : encomendas.values()){
                for (Encomenda e : temp){ encomendaswriter.write(e.toString() + "\n");}
            }
            encomendaswriter.close();
        }
        catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }


}
