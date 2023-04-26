package POO;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List; 
import java.time.LocalDate;
import java.util.stream.Collectors;

public class Vinted {
    Map <String,Artigo> artigos = ParseArtigo.parse(); // key -> codigo artigo 
    Map <Integer,User> users = ParseUser.parse(artigos); // key -> codigo 
    Map <String,Transportadora> transportadoras = ParseTransportadora.parse(); // key -> nome transportadora
}
