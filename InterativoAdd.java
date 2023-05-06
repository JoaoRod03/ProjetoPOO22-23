package POO;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List; 
import java.time.LocalDate;
import java.util.stream.Collectors;

public class InterativoAdd {
    public static void start(){
        System.out.println("\nWelcome to Vinted!\nChoose one of the following commands\n");
        System.out.println("add Mala Mala;CodigoUser;Uso;avaliacao;donos;descricao;marca;codigo;preco;correcao;transportadora;comprimento;largura;altura;material;Colecao;premium");
        System.out.println("add Tshirt Tshirt;CodigoUser;Uso;avaliacao;donos;descricao;marca;codigo;preco;correcao;transportadora;tamanho;padrao");
        System.out.println("add Sapatilha Sapatilha;CodigoUser;Uso;avaliacao;donos;descricao;marca;codigo;preco;correcao;transportadora;tamanho;laces;cor;Colecao;premium");
        System.out.println("add Encomenda Encomenda;estado;data;nrartigos;artigo1;artigoN");
        System.out.println("add User User;codigo;email;nome;morada;nif");
        System.out.println("add Transportadora Transportadora;nome;basePequena;baseMedia;baseGrande;imposto;lucro;tempoexpedicao");
        System.out.println("exit");
        System.out.println("save\n");
        Scanner comando = new Scanner(System.in);

        while(comando.hasNextLine()){ 
            String line = comando.nextLine();
            String []splitEspaco = line.split(" ");
            if (splitEspaco[0].equalsIgnoreCase("exit")) return;
            if (splitEspaco[0].equalsIgnoreCase("save")) {
                //Save.save(market, users, transportadoras, encomendas);
                return;
            }
            String specs = splitEspaco[2];
            String []split = specs.split(";");
            if (splitEspaco[1].equalsIgnoreCase("Mala")){
                Vintage.addMarket(CreateMala.create(split));
            }
            if (splitEspaco[1].equalsIgnoreCase("Tshirt")){
                Vintage.addMarket(CreateTshirt.create(split));
            }
            if (splitEspaco[1].equalsIgnoreCase("Sapatilha")){
                Vintage.addMarket(CreateSapatilha.create(split));
            }
            if (splitEspaco[1].equalsIgnoreCase("User")){
                Vintage.addUser(CreateUser.create(split));
            }
            if (splitEspaco[1].equalsIgnoreCase("Transportadora")){
                Vintage.addTransportadora(CreateTransportadora.create(split));
            }
            if (splitEspaco[1].equalsIgnoreCase("Encomenda")){
                for(Map.Entry <String,Encomenda> entry : CreateEncomenda.create(split).entrySet()) Vintage.addEncomenda(entry.getKey(), entry.getValue());
            }

        }
        comando.close(); 
    }
}