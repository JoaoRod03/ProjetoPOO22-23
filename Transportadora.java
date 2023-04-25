package POO;

public class Transportadora {
    private String nome;
    /*private static double basePequena;
    private static double baseMedia;
    private static double baseGrande;
    private static double imposto;
    private double expedicao;
    private double lucro;
    private boolean premium;
    private double expedicaoPrem;
    */

    public Transportadora(){
        this.nome = "";
    }

    public Transportadora(String nome){
        this.nome = nome;
    }

    public Transportadora(Transportadora transportadora){
        this.nome = transportadora.getNome();
    }

    public Transportadora clone(){
        return new Transportadora(this);
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}
