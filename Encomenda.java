package POO;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List; 
import java.time.LocalDate;

public class Encomenda {
    public enum Tamanho{Grande,Medio,Pequeno}
    public static double New = 0.5;
    public static double Used = 0.25;
    public enum Estado{Pendente,Finalizada,Expedida}
    
    private List<Artigo> lista;
    private Tamanho tamanho;
    private double preçofinal;
    private double expediçao;
    private Estado estado;
    private LocalDate data; 



}
