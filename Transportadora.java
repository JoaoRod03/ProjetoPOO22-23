package POO;

public class Transportadora {
    private String nome;
    private double basePequena;  //1 artigo
    private double baseMedia;    //2 a 5 artigos
    private double baseGrande;   //+ 5 artigos
    private double imposto;
    private double lucro;
    private int tempoexpedicao;
    

    public Transportadora(){
        this.nome = "";
        this.basePequena = 0;
        this.baseMedia = 0;
        this.baseGrande = 0;
        this.imposto = 0;
        this.lucro = 0;
        this.tempoexpedicao = 0;
    }

    public Transportadora(String nome, double basePequena, double baseMedia, double baseGrande, double imposto, double lucro, int tempoexpedicao){
        this.nome = nome;
        this.basePequena = basePequena;
        this.baseMedia = baseMedia;
        this.baseGrande = baseGrande;
        this.imposto = imposto;
        this.lucro = lucro;
        this.tempoexpedicao = tempoexpedicao;
    }

    public Transportadora(Transportadora transportadora){
        this.nome = transportadora.getNome();
        this.basePequena = transportadora.getBasePequena();
        this.baseMedia = transportadora.getBaseMedia();
        this.baseGrande = transportadora.getBaseGrande();
        this.imposto = transportadora.getImposto();
        this.lucro = transportadora.getLucro();
        this.tempoexpedicao = transportadora.getTempoexpedicao();
    }

    public Transportadora clone(){
        return new Transportadora(this);
    }

    public String getNome(){
        return this.nome;
    }

    public double getBasePequena(){
        return this.basePequena;
    }

    public double getBaseMedia(){
        return this.baseMedia;
    }

    public double getBaseGrande(){
        return this.baseGrande;
    }
    
    public double getImposto(){
        return this.imposto;
    }

    public double getLucro(){
        return this.lucro;
    }    

    public int getTempoexpedicao(){
        return this.tempoexpedicao;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setBasepequena(double basePequena){
        this.basePequena = basePequena;
    }

    public void setBasemedia(double baseMedia){
        this.baseMedia = baseMedia;
    }

    public void setBasegrande(double baseGrande){
        this.baseGrande = baseGrande;
    }

    public void setImposto(double imposto){
        this.imposto = imposto;
    }

    public void setLucro(double lucro){
        this.lucro = lucro;
    }

    public void setTempoexpedicao(int tempoexpedicao){
        this.tempoexpedicao = tempoexpedicao;
    }

    public double calculaExpedicao(int nrArtigos){
        double res = 0;
        double expedicao = 0;
        if(nrArtigos == 1){res = this.getBasePequena();}
        if(nrArtigos > 1 || nrArtigos < 6){res = this.getBaseMedia();}
        if(nrArtigos > 5){res = this.getBaseGrande();}
        
        expedicao = (res * lucro *(1 + imposto)) * 0.9;
        return expedicao;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transportadora")
                .append(";").append(this.nome)
                .append(";").append(this.basePequena)
                .append(";").append(this.baseMedia)
                .append(";").append(this.baseGrande)
                .append(";").append(this.imposto)
                .append(";").append(this.lucro)
                .append(";").append(this.tempoexpedicao);
        return sb.toString();
    }

}
