package POO;

public class Tshirt extends Artigo{
    public enum Tamanho{S,M,L,XL}
    private Tamanho tamanho;
    public enum Padrao{liso,riscas,palmeiras} 
    private Padrao padrao;
    
    public Tshirt(){
        super();
        this.tamanho = Tamanho.M;
        this.padrao = Padrao.liso;
    }

    public Tshirt(int codigoUser, Uso uso, double avaliacao, int donos, String desc, String marca, String cod, double preco, double correcao, String transp, Tamanho tamanho, Padrao padrao){
        super (codigoUser, uso, avaliacao, donos, desc, marca, cod, preco, correcao, transp);
        this.tamanho = tamanho;
        this.padrao = padrao;
    }

    public Tshirt(Tshirt tshirt){
        super(tshirt.getCodigouser(), tshirt.getUsado(), tshirt.getAvaliacao(), tshirt.getDonos(), tshirt.getDescricao(), tshirt.getMarca(), tshirt.getCodigo(), tshirt.getPreco(), tshirt.getCorrecao(), tshirt.getTransportadora());
        this.tamanho = tshirt.getTamanho();
        this.padrao = tshirt.getPadrao();
    }

    public Tshirt clone(){
        return new Tshirt(this);
    }

    public Tamanho getTamanho(){
        return this.tamanho;
    }

    public Padrao getPadrao(){
        return this.padrao;
    }

    public void setTamanho(Tamanho tamanho){
        this.tamanho = tamanho;
    }

    public void setPadrao(Padrao padrao){
        this.padrao = padrao;
    }

    public double calculaPreco(){
        double res = 0;
        res = this.getPreco();
        if((this.getPadrao() == Padrao.riscas || this.getPadrao() == Padrao.palmeiras) && (this.getUsado() == Uso.Usado)){
            res = this.getPreco() * 0.5;
        }
        if((this.getPadrao() == Padrao.riscas || this.getPadrao() == Padrao.palmeiras) && (this.getUsado() == Uso.Novo)){
            res = this.getPreco() - (this.getPreco() * this.getCorrecao());
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tshirt;").append(this.getCodigouser())
                .append(";").append(this.getUsado())
                .append(";").append(this.getAvaliacao())
                .append(";").append(this.getDonos())
                .append(";").append(this.getDescricao())
                .append(";").append(this.getMarca())
                .append(";").append(this.getCodigo())
                .append(";").append(this.getPreco())
                .append(";").append(this.getCorrecao())
                .append(";").append(this.getTransportadora())
                .append(";").append(this.tamanho)
                .append(";").append(this.padrao);
        return sb.toString();
    }


    public boolean equals(Object o){
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass())) return false;

        Tshirt tshirt = (Tshirt) o;
        return tshirt.getCodigouser() == (this.getCodigouser()) &&
                tshirt.getUsado() == this.getUsado() &&
                tshirt.getAvaliacao() == this.getAvaliacao() &&
                tshirt.getDonos() == this.getDonos() &&
                tshirt.getDescricao().equals(this.getDescricao()) &&
                tshirt.getMarca().equals(this.getMarca()) &&
                tshirt.getCodigo().equals(this.getCodigo()) &&
                tshirt.getPreco() == this.getPreco() &&
                tshirt.getCorrecao() == this.getCorrecao() &&
                tshirt.getTransportadora().equals(this.getTransportadora()) &&
                tshirt.getTamanho() == this.tamanho &&
                tshirt.getPadrao() == this.padrao;
    }


}
