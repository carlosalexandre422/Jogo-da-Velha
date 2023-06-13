package jogodavelha;

import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;
    private JogadorX jogadorX;
    private JogadorO jogadorO;
    private Scanner scanner;
    
    public Jogo() {
        tabuleiro = new Tabuleiro();
        jogadorX = new JogadorX();
        jogadorO = new JogadorO();
        scanner = new Scanner(System.in);
    }
    
    public void iniciar() {
        boolean jogarNovamente = true;
        
        while (jogarNovamente) {
            tabuleiro.limpar();
            tabuleiro.imprimir();
            
            while (!tabuleiro.isCompleto() && !tabuleiro.houveVencedor()) {
                jogada(jogadorX);
                tabuleiro.imprimir();
                if (!tabuleiro.isCompleto() && !tabuleiro.houveVencedor()) {
                    jogada(jogadorO);
                    tabuleiro.imprimir();
                }
                
            }
            
            
            
            if (tabuleiro.houveVencedor()) {
                System.out.println("Jogador " + tabuleiro.getVencedor() + " venceu!");
            } else {
                System.out.println("Empate!");
            }
            
            System.out.print("Deseja jogar novamente? (s/n): ");
            String resposta = scanner.next();
            
            if (!resposta.equalsIgnoreCase("s")) {
                jogarNovamente = false;
            }
        }
        
        scanner.close();
        System.out.println("Obrigado por jogar!");
    }
    
    private void jogada(Jogador jogador) {
        System.out.print("Jogador " + jogador.getSimbolo() + ", digite a posição (linha coluna): ");
        int linha = scanner.nextInt();
        int coluna = scanner.nextInt();

        
        if (!tabuleiro.jogadaValida(linha, coluna)) {
            System.out.println("Posição inválida! Tente novamente.");
            jogada(jogador);
        } else {
            tabuleiro.fazerJogada(linha, coluna, jogador);
        }
    }
}
