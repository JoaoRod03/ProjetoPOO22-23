package POO;

public class TransportadoraPremium extends Transportadora {
    public double calculaExpedicaoPremium(int nrArtigos){
        double res = 0;
        double expedicao = 0;
        if(nrArtigos == 1){res = this.getBasePequena();}
        if(nrArtigos > 1 || nrArtigos < 6){res = this.getBaseMedia();}
        if(nrArtigos > 5){res = this.getBaseGrande();}
        
        expedicao = (res * (this.getLucro() + (this.getLucro() * 0.3)) * (1 + this.getImposto())) * 0.9;
        return expedicao;
    }
}
