/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.elementos;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Gabriel Amaral
 * @author Jefferson Ribeiro
 */
public class Imagem {

    private String magicNumber = "P2";
    private int coluna;
    private int linha;
    private int maximumGray;
    private int[][] imagem;

    public Imagem() {
    }

    public Imagem(int[][] imagem) {
        this.imagem = imagem;
        this.linha = imagem.length;
        this.coluna = imagem[0].length;
        this.maximumGray = maiorValorNaMatriz(imagem);
    }

    public String getMagicNumber() {
        return magicNumber;
    }

    public int getColuna() {
        return coluna;
    }

    public int getLinha() {
        return linha;
    }

    public int getMaximumGray() {
        return maximumGray;
    }

    public int[][] getImagem() {
        return imagem;
    }

    public void setImagem(int[][] imagem) {
        this.imagem = imagem;
    }

    public int getRegioesPretas() {
        return contarRegioesPretas();
    }

    public int getRegioesBrancas() {
        return contarRegioesBrancas();
    }

    /**
     *
     * @param file Imagem PGM
     * @return True se carregou e False caso contrário
     */
    public boolean carregarImagem(File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                if (br.ready()) {
                    magicNumber = br.readLine();
                }
                while (br.ready()) {
                    String linhaDoArquivo = br.readLine();
                    if (linhaDoArquivo.startsWith("#")) {
                        continue;
                    }
                    String[] elementos = linhaDoArquivo.split(" ");
                    if (elementos.length == 2) {
                        coluna = Integer.parseInt(elementos[0]);
                        linha = Integer.parseInt(elementos[1]);

                        imagem = new int[linha][coluna];
                    } else if (elementos.length == 1) {
                        maximumGray = Integer.parseInt(elementos[0]);
                        break;
                    }
                }
                int lin = 0, col = 0;
                while (br.ready()) {
                    String linhaDoArquivo = br.readLine();
                    String[] elementos = linhaDoArquivo.split(" ");
                    int numElementos = elementos.length;
                    for (int i = 0; i < numElementos; i++) {
                        try {
                            imagem[lin][col++] = Integer.parseInt(elementos[i]);
                        } catch (NumberFormatException exception) {
                            if (elementos[i].equals("")) {
                                col--;
                            } else {
                                System.out.println(exception.getMessage());
                            }
                        }
                        if (col == coluna) {
                            lin++;
                            col = 0;
                        }
                    }

                }
                br.close();
            } catch (IOException ex) {
                System.out.println("Impossivel ler arquivo!");
                return false;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
            return false;
        }
        return true;
    }

    /**
     *
     * @param nomeArquivo Nome da nova Imagem PGM
     * @param comentario Comentário dentro da imagem (texto)
     */
    public boolean criaImagem(String nomeArquivo, String comentario) {
        File file = new File("./images/" + nomeArquivo + ".pgm");
        if (!file.exists()) {
            try {
                file.createNewFile();
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                    bufferedWriter.write(magicNumber);
                    bufferedWriter.newLine();

                    bufferedWriter.write("# " + comentario);
                    bufferedWriter.newLine();

                    bufferedWriter.write(imagem[0].length + " " + imagem.length);
                    bufferedWriter.newLine();

                    bufferedWriter.write(maximumGray + "");
                    bufferedWriter.newLine();

                    for (int i = 0; i < imagem.length; i++) {
                        for (int j = 0; j < imagem[i].length; j++) {
                            bufferedWriter.write(imagem[i][j] + " ");
                        }
                        bufferedWriter.newLine();
                    }

                    bufferedWriter.flush();
                }
            } catch (IOException ex) {
                System.out.println("Impossível escrever no arquivo!");
                return false;
            }
        } else {
            System.out.println("Arquivo já existe!");
            return false;
        }
        return true;
    }

    private int maiorValorNaMatriz(int[][] matriz) {
        int maior = matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] > maior) {
                    maior = matriz[i][j];
                }
            }
        }
        return maior;
    }

    private int contarRegioesPretas() {
        int soma = 0;
        for (int i = 0; i < imagem.length; i++) {
            for (int j = 0; j < imagem[i].length; j++) {
                if (imagem[i][j] == 0) {
                    soma++;
                }
            }
        }
        return soma;
    }

    private int contarRegioesBrancas() {
        int soma = 0;
        for (int i = 0; i < imagem.length; i++) {
            for (int j = 0; j < imagem[i].length; j++) {
                if (imagem[i][j] == 255) {
                    soma++;
                }
            }
        }
        return soma;
    }

    public void mostrarMatriz() {
        for (int i = 0; i < imagem.length; i++) {
            for (int j = 0; j < imagem[i].length; j++) {
                System.out.printf("%3d ", imagem[i][j]);
            }
            System.out.println("");
        }
    }

    public int contaRegioes(int limiteInferior, int limiteSuperior) {
        int[][] matrizRegioes = new int[imagem.length][imagem[0].length];
        int regioes = 0;

        for (int i = 0; i < imagem.length; i++) {
            for (int j = 0; j < imagem[0].length; j++) {
                if ((imagem[i][j] >= limiteInferior) && (imagem[i][j] <= limiteSuperior) && (matrizRegioes[i][j] == 0)) {
                    matrizRegioes = verificaVizinhos(i, j, matrizRegioes);
                    if (matrizRegioes[i][j] == 0) {
                        regioes++;
                        matrizRegioes[i][j] = regioes;
                    }
                }
            }
        }
        regioes = achaNumRegioes(matrizRegioes);
        return regioes;
    }

    public int[][] verificaVizinhos(int linha, int coluna, int[][] matrizRegioes) {
        int regiao = 0;
        for (int i = (linha - 1); i <= (linha + 1); i++) {
            for (int j = (coluna - 1); j <= (coluna + 1); j++) {
                try {
                    if (matrizRegioes[i][j] > 0) {
                        if (regiao == 0) {
                            regiao = matrizRegioes[i][j];
                            matrizRegioes[linha][coluna] = regiao;
                        } else {
                            if (!(regiao == matrizRegioes[i][j])) {
                                if (regiao < matrizRegioes[i][j]) {
                                    matrizRegioes = igualaRegiao(regiao, matrizRegioes[i][j], matrizRegioes);
                                } else {
                                    matrizRegioes = igualaRegiao(matrizRegioes[i][j], regiao, matrizRegioes);
                                }
                                regiao = matrizRegioes[i][j];
                            }
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }
        return matrizRegioes;
    }

    public int[][] igualaRegiao(int menor, int maior, int[][] matrizRegioes) {
        for (int i = 0; i < matrizRegioes.length; i++) {
            for (int j = 0; j < matrizRegioes[0].length; j++) {
                if (matrizRegioes[i][j] == maior) {
                    matrizRegioes[i][j] = menor;
                } else if (matrizRegioes[i][j] > maior) {
                    matrizRegioes[i][j]--;
                }
            }
        }
        return matrizRegioes;
    }

    public int achaNumRegioes(int[][] matrizRegioes) {
        int maior = 0;
        for (int i = 0; i < matrizRegioes.length; i++) {
            for (int j = 0; j < matrizRegioes[0].length; j++) {
                if (matrizRegioes[i][j] > maior) {
                    maior = matrizRegioes[i][j];
                }
            }
        }
        return maior;
    }
}
