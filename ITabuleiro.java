package jogodavelha;

public interface ITabuleiro {
    void limpar();
    void imprimir();
    boolean jogadaValida(int linha, int coluna);
    void fazerJogada(int linha, int coluna, Jogador jogador);
    boolean isCompleto();
    boolean houveVencedor();
    String getVencedor();
}
