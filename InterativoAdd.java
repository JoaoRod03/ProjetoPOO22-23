package POO;
import java.util.Map;
import java.util.Scanner;

public class InterativoAdd {
    public static void start(){
        System.out.println("\nBem-vindo à Vintage!\nPara prosseguir escolha um dos seguintes comandos\n");
        System.out.println("Add Mala Mala;CodigoUser;Uso;avaliacao;donos;descricao;marca;codigo;preco;correcao;transportadora;comprimento;largura;altura;material;Colecao;premium");
        System.out.println("Add Tshirt Tshirt;CodigoUser;Uso;avaliacao;donos;descricao;marca;codigo;preco;correcao;transportadora;tamanho;padrao");
        System.out.println("Add Sapatilha Sapatilha;CodigoUser;Uso;avaliacao;donos;descricao;marca;codigo;preco;correcao;transportadora;tamanho;laces;cor;Colecao;premium");
        System.out.println("Add Encomenda Encomenda;CodComprador;estado;data;nrartigos;artigo1;artigoN");
        System.out.println("Add User User;codigo;email;nome;morada;nif");
        System.out.println("Add Transportadora Transportadora;nome;basePequena;baseMedia;baseGrande;imposto;lucro;tempoexpedicao");
        System.out.println("Exit");
        System.out.println("Save\n");
        Scanner comando = new Scanner(System.in);

        while(comando.hasNextLine()){ 
            String line = comando.nextLine();
            String []splitEspaco = line.split(" ");
            if (splitEspaco[0].equalsIgnoreCase("exit")) {
                comando.close(); return;
            }
            if (splitEspaco[0].equalsIgnoreCase("save")) {
                Vintage.save();
                comando.close(); 
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