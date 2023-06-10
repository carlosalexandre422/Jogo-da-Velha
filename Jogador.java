package jogodavelha;

public abstract class Jogador {
    protected String simbolo;
    
    public Jogador(String simbolo) {
        this.simbolo = simbolo;
    }
    
    public String getSimbolo() {
        return simbolo;
    }

}
