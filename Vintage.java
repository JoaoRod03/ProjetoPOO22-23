package POO;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.List; 
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.Collections;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Iterator;
import java.util.*;
import java.util.Map.Entry;

import POO.Artigo.Uso;
import POO.Encomenda.Estado;

public class Vintage {
    private static Map <String,Artigo> market = ParseArtigo.parse();
    private static Map <Integer,User> users = ParseUser.parse(market);
    private static Map <String,Transportadora> transportadoras = ParseTransportadora.parse();
    private static Map <String,List<Encomenda>> encomendas = ParseEncomenda.parse();
    private static Map <String,Artigo> vendidos = new HashMap<>();
    private static List<Encomenda> encomendasRealizadas = new ArrayList<Encomenda>();
    private static LocalDate data = ParseData.parse();
    private static double faturacaoVintage; 

    public static double getFaturacao(){
        return faturacaoVintage;
    }

    public static Artigo getArtigo(String cod){
        return market.get(cod).clone();
    }
        
    public static Artigo getArtigoVendidos(String cod){
        return vendidos.get(cod).clone();
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

    public static User getUser(Integer cod){
        return users.get(cod).clone();
    }

    public static void removeUser(Integer cod){
        users.remove(cod);
    }

    public static void addTransportadora(Transportadora transportadora){
        transportadoras.put(transportadora.getNome(), transportadora.clone());
    }

    public static Transportadora getTransportadoraNome(String transp){
        return transportadoras.get(transp).clone();
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

    public static void removeEncomenda(String transportadora, Encomenda enc){
        Iterator <Encomenda> iterator = encomendas.get(transportadora).iterator();
        while(iterator.hasNext()){
            Encomenda temp = iterator.next();
            if(temp.equals(enc)) iterator.remove();
        }
    }

    public static LocalDate getData(){
        return data;
    }

    public static void setData(LocalDate data){
        Vintage.data = data;
    }

    public static List <String> getArtsUser(int cod){
        List <String> res = new ArrayList<>();
        for(Artigo art : market.values()){
            if(art.getCodigouser() == cod) res.add(art.getCodigo());
        }
        return res;
    }

    public static List <String> getVendidosUSer(int cod){
        List <String> res = new ArrayList<>();
        for(Artigo art : vendidos.values()){
            if(art.getCodigouser() == cod) res.add(art.getCodigo());
        }
        return res;
    }


    public static void finalizarEncomenda(String art, LocalDate date){
        String trans = getArtigo(art).getTransportadora();
        List <Encomenda> temp = encomendas.get(trans);
        for (Encomenda enc : temp){
            if (enc.getLista().contains(art)){
                if (enc.getEstado().equals(Encomenda.Estado.pendente)) enc.setEstado(Estado.finalizada);enc.setData(date);
            }
        }
    
    }
 

    public static void atualizarMarket(){
        for(Map.Entry <String,List<Encomenda>> entry : encomendas.entrySet()){
            int tempoexpedicao = transportadoras.get(entry.getKey()).getTempoexpedicao();

            Iterator <Encomenda> iterator= entry.getValue().iterator();
            while(iterator.hasNext()){
                Encomenda enc = iterator.next();
                if(enc.getEstado() == Estado.finalizada){
                    LocalDate expedicao = enc.getData().plusDays(tempoexpedicao);

                    if(data.isEqual(expedicao) || data.isAfter(expedicao)){
                        for(String temp : enc.getLista()){
                            User u = users.get(market.get(temp).getCodigouser());
                            if (market.get(temp).getUsado() == Uso.Novo) faturacaoVintage+=0.5;
                            if (market.get(temp).getUsado() == Uso.Usado) faturacaoVintage+=0.25;

                            u.removeVenda(temp);
                            u.addVendidos(temp);
                            vendidos.put(temp, market.get(temp));
                            market.remove(temp);
                        }
                    encomendasRealizadas.add(enc);
                    iterator.remove();
                    }
                }
            }
        }
    }

    public static Integer userMaisFaturou(){
        double temp = 0;
        Integer res = 0;
        for(User user : users.values()){
            if(user.calculaValor() > temp) {
            temp = user.calculaValor();
            res = user.getCodigo();
            }
        }
        return res;
    }

    public static Map<Integer,Double> userMaisFaturouTempo(LocalDate inicio, LocalDate fim){
        double temp = 0;
        Integer tempuser = 0;
        Map <Integer,Double> res = new HashMap<>();
        Map <Integer,Double> userFaturacao = new HashMap<>();
        for(Integer cod : users.keySet()){userFaturacao.put(cod,temp);}
        for(Encomenda enc : encomendasRealizadas){
            if((enc.getData().isAfter(inicio)) && (enc.getData().isBefore(fim))){
                for(String art : enc.getLista()){
                    Double value = userFaturacao.get(getArtigoVendidos(art).getCodigouser());
                    value += (getArtigoVendidos(art).calculaPreco());
                    userFaturacao.put(getArtigoVendidos(art).getCodigouser(),value);
                }
            }
        }
        for(Integer i : userFaturacao.keySet()){
            if (userFaturacao.get(i) > temp){tempuser = i;temp = userFaturacao.get(i);}
        }
        res.put(tempuser,temp);
        return res;
    }

    public static Map<String,Double>  transportadoraMaisFaturou(){
        double temp = 0;
        double i = 0;
        String res = "";
        String transpNome = "";
        Map <String,Double> result = new HashMap<String,Double>();
        Map <String,Double> transportadorasFaturacao = new HashMap<String,Double>();
        for(String cod : transportadoras.keySet()){transportadorasFaturacao.put(cod,temp);}
        for(Encomenda enc : encomendasRealizadas){
            transpNome = getArtigoVendidos(enc.getLista().get(0)).getTransportadora();
            temp = getTransportadoraNome(transpNome).calculaExpedicao(enc.getLista().size());
            double value = transportadorasFaturacao.get(transpNome);
            value += temp;
            transportadorasFaturacao.put(transpNome, value);
        }
        for(String key : transportadorasFaturacao.keySet()){
            if (transportadorasFaturacao.get(key) > i){i = transportadorasFaturacao.get(key);res = key;}
        }
        result.put(res, i);
        return result;
    }

    public static Map<String,Double>  transportadoraMaisFaturouData(LocalDate inicio, LocalDate fim){
        double temp = 0;
        double i = 0;
        String res = "";
        String transpNome = "";
        Map <String,Double> result = new HashMap<String,Double>();
        Map <String,Double> transportadorasFaturacao = new HashMap<String,Double>();
        for(String cod : transportadoras.keySet()){transportadorasFaturacao.put(cod,temp);}
        for(Encomenda enc : encomendasRealizadas){
            if((enc.getData().isAfter(inicio)) && (enc.getData().isBefore(fim))){
                transpNome = getArtigoVendidos(enc.getLista().get(0)).getTransportadora();
                temp = getTransportadoraNome(transpNome).calculaExpedicao(enc.getLista().size());
                double value = transportadorasFaturacao.get(transpNome);
                value += temp;
                transportadorasFaturacao.put(transpNome, value);
            }
        }
        for(String key : transportadorasFaturacao.keySet()){
            if (transportadorasFaturacao.get(key) > i){i = transportadorasFaturacao.get(key);res = key;}
        }
        result.put(res, i);
        return result;
    }


    public static Map<Integer,Double> listMaisFaturouTempo(LocalDate inicio, LocalDate fim){
        double temp = 0;
        Map <Integer,Double> userFaturacao = new HashMap<>();
        for(Integer cod : users.keySet()){userFaturacao.put(cod,temp);}
        for(Encomenda enc : encomendasRealizadas){
            if((enc.getData().isAfter(inicio)) && (enc.getData().isBefore(fim))){
                for(String art : enc.getLista()){
                    Double value = userFaturacao.get(getArtigoVendidos(art).getCodigouser());
                    value += (getArtigoVendidos(art).calculaPreco());
                    userFaturacao.put(getArtigoVendidos(art).getCodigouser(),value);
                }
            }
        }
       
        Map<Integer, Double> res = new LinkedHashMap<>();
        for(int i = 0; i < userFaturacao.size(); i++){
            Map.Entry <Integer,Double> entryMaiorValue = null;

            for (Map.Entry<Integer, Double> entry : userFaturacao.entrySet()) {
                if (entryMaiorValue == null || entry.getValue() > entryMaiorValue.getValue()) {
                    entryMaiorValue = entry;
                }
            }
            res.put(entryMaiorValue.getKey(), entryMaiorValue.getValue());
            userFaturacao.remove(entryMaiorValue.getKey());
        }
        return res;
    }

    public static Map<Integer,Integer> maiorVendedor (LocalDate inicio, LocalDate fim){
        Integer temp = 0;
        Integer tempuser = 0;
        Map <Integer,Integer> res = new HashMap<>();
        Map <Integer,Integer> userNrprodutos = new HashMap<>();
        for(Integer cod : users.keySet()){userNrprodutos.put(cod,temp);}
        for(Encomenda enc : encomendasRealizadas){
            if((enc.getData().isAfter(inicio)) && (enc.getData().isBefore(fim))){
                for(String art : enc.getLista()){
                    Integer value = userNrprodutos.get(getArtigoVendidos(art).getCodigouser());
                    value += 1;
                    userNrprodutos.put(getArtigoVendidos(art).getCodigouser(),value);
                }
            }
        }
        for(Integer i : userNrprodutos.keySet()){
            if (userNrprodutos.get(i) > temp){tempuser = i;temp = userNrprodutos.get(i);}
        }
        res.put(tempuser,temp);
        return res;
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
        
        System.out.println("\n-------------------------------------------------------------------------------------------------------\n");

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
        else if(choice.equalsIgnoreCase("nao")){
            atualizarMarket();System.out.println("\n-------------------------------------------------------------------------------------------------------\n");
        }
        
        System.out.println("Deseja mudar elementos?\n");
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
        }
        
        System.out.println("Deseja verificar estatísticas?\n");
        String choice3 = sc.nextLine();
        if(choice3.equalsIgnoreCase("sim")){
            InterativoStats.start();
            System.out.println("\n-------------------------------------------------------------------------------------------------------\n");
        }
        else if(choice3.equalsIgnoreCase("nao")){
                System.out.println("\n-------------------------------------------------------------------------------------------------------\n");
        }
        
        sc.close();
        
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
