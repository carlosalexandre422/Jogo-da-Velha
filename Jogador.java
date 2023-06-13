package jogodavelha;

public abstract class Jogador {
    String simbolo;
    
    public Jogador(String simbolo) {
        this.simbolo = simbolo;
    }
    
    public String getSimbolo() {
        return simbolo;
    }

}
