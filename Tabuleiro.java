package jogodavelha;

import java.util.ArrayList;

public class Tabuleiro implements ITabuleiro {
    private ArrayList<ArrayList<Character>> matriz;

    public Tabuleiro() {
        matriz = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ArrayList<Character> linha = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                linha.add(' ');
            }
            matriz.add(linha);
        }
    }

    @Override
    public void limpar() {
        for (ArrayList<Character> linha : matriz) {
            linha.replaceAll(ignored -> ' ');
        }
    }

    @Override
    public void imprimir() {
        for (int i = 0; i < matriz.size(); i++) {

            ArrayList<Character> linha = matriz.get(i);
            for (int j = 0; j < linha.size(); j++) {
                System.out.print(linha.get(j));
                if (j < linha.size() - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < matriz.size() - 1) {
                System.out.println("--+---+--");
            }
        }
    }

    @Override
    public boolean jogadaValida(int linha, int coluna) {
        return linha >= 0 && linha < matriz.size() && coluna >= 0 && coluna < matriz.get(linha).size() && matriz.get(linha).get(coluna) == ' ';
    }

    @Override
    public void fazerJogada(int linha, int coluna, Jogador jogador) {
        matriz.get(linha).set(coluna, jogador.getSimbolo().charAt(0));
    }

    @Override
    public boolean isCompleto() {
        for (ArrayList<Character> linha : matriz) {
            for (char c : linha) {
                if (c == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean houveVencedor() {
        // Verificar linhas
        for (ArrayList<Character> linha : matriz) {
            if (linha.get(0) != ' ' && linha.get(0) == linha.get(1) && linha.get(1) == linha.get(2)) {
                return true;
            }
        }

        // Verificar colunas
        for (int j = 0; j < matriz.get(0).size(); j++) {
            if (matriz.get(0).get(j) != ' ' && matriz.get(0).get(j) == matriz.get(1).get(j) && matriz.get(1).get(j) == matriz.get(2).get(j)) {
                return true;
            }
        }

        // Verificar diagonais
        if (matriz.get(0).get(0) != ' ' && matriz.get(0).get(0) == matriz.get(1).get(1) && matriz.get(1).get(1) == matriz.get(2).get(2)) {
            return true;
        }

        if (matriz.get(0).get(2) != ' ' && matriz.get(0).get(2) == matriz.get(1).get(1) && matriz.get(1).get(1) == matriz.get(2).get(0)) {
            return true;
        }

        return false;
    }

    @Override
    public String getVencedor() {
        // Verificar linhas
        for (ArrayList<Character> linha : matriz) {
            if (linha.get(0) != ' ' && linha.get(0) == linha.get(1) && linha.get(1) == linha.get(2)) {
                return String.valueOf(linha.get(0));
            }
        }

        // Verificar colunas
        for (int j = 0; j < matriz.get(0).size(); j++) {
            if (matriz.get(0).get(j) != ' ' && matriz.get(0).get(j) == matriz.get(1).get(j) && matriz.get(1).get(j) == matriz.get(2).get(j)) {
                return String.valueOf(matriz.get(0).get(j));
            }
        }

        // Verificar diagonais
        if (matriz.get(0).get(0) != ' ' && matriz.get(0).get(0) == matriz.get(1).get(1) && matriz.get(1).get(1) == matriz.get(2).get(2)) {
            return String.valueOf(matriz.get(0).get(0));
        }

        if (matriz.get(0).get(2) != ' ' && matriz.get(0).get(2) == matriz.get(1).get(1) && matriz.get(1).get(1) == matriz.get(2).get(0)) {
            return String.valueOf(matriz.get(0).get(2));
        }

        return null;
    }
}
