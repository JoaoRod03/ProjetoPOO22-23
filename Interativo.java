package POO;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List; 
import java.time.LocalDate;
import java.util.stream.Collectors;

public class Interativo {
    public static void start(Map <String,Artigo> market, Map <Integer,User> users, Map <String,Transportadora> transportadoras, List<Encomenda> encomendas){
        System.out.println("Welcome to Vinted!\nChoose one of the following commands\n");
        System.out.println("add Mala (Mala;CodigoUser;Uso;avaliacao;donos;descricao;marca;codigo;preco;correcao;transportadora;comprimento;largura;altura;material;Colecao;premium)");
        System.out.println("add Tshirt (Tshirt;CodigoUser;Uso;avaliacao;donos;descricao;marca;codigo;preco;correcao;transportadora;tamanho;padrao)");
        System.out.println("add Sapatilha (Sapatilha;CodigoUser;Uso;avaliacao;donos;descricao;marca;codigo;preco;correcao;transportadora;tamanho;laces;cor;Colecao;premium)");
        System.out.println("add Encomenda (Encomenda;tamanho;precofinal;expedicao;estado;data)");
        System.out.println("add User (User;codigo;email;nome;morada;nif;valorTotal");
        System.out.println("add Transportadora (Transportadora;nome;basePequena;baseMedia;baseGrande;imposto;lucro)");
        System.out.println("-- exit\n");
        Scanner comando = new Scanner(System.in);

        while(comando.hasNextLine()){ 
            String line = comando.nextLine();
            String []splitEspaco = line.split(" ");
            if (splitEspaco[1].equalsIgnoreCase("exit")) return;
            String specs = splitEspaco[2];
            String []split = specs.split(";");
            if (splitEspaco[1].equalsIgnoreCase("Mala")){
                market.put(split[7], CreateMala.create(split));
            }
            if (splitEspaco[1].equalsIgnoreCase("Tshirt")){
                market.put(split[7], CreateTshirt.create(split));
            }
            if (splitEspaco[1].equalsIgnoreCase("Sapatilha")){
                market.put(split[7], CreateSapatilha.create(split));
            }
            if (splitEspaco[1].equalsIgnoreCase("User")){
                users.put(Integer.parseInt(split[1]),CreateUser.create(split,market));
            }
            if (splitEspaco[1].equalsIgnoreCase("Transportadora")){
                transportadoras.put((split[1]),CreateTransportadora.create(split));
            }
            if (splitEspaco[1].equalsIgnoreCase("Encomenda")){
                encomendas.add(CreateEncomenda.create(split));
            }

        } 
    }
}