package POO;

public class CreateTransportadora {
    public static Transportadora create(String []arg){
        Transportadora transportadora = new Transportadora();
        transportadora.setNome(arg[0]);
        transportadora.setBasepequena(Double.parseDouble(arg[1]));
        transportadora.setBasemedia(Double.parseDouble(arg[2]));
        transportadora.setBasegrande(Double.parseDouble(arg[3]));
        transportadora.setImposto(Double.parseDouble(arg[4]));
        transportadora.setLucro(Double.parseDouble(arg[5]));
        return transportadora;
    }
}
