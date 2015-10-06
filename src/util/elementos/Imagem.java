package util.elementos;

import java.awt.image.BufferedImage;

/**
 *
 * @author Gabriel Amaral
 */
public class Imagem {

    private int coluna;
    private int linha;
    private int maximumGray;
    private int[][] imagem;
    private int type;

    public Imagem() {
    }

    public Imagem(BufferedImage bufferedImage) {
        this.type = bufferedImage.getType();
        imagem = new int[bufferedImage.getWidth()][bufferedImage.getHeight()];
        for (int y = 0; y < bufferedImage.getHeight(); y++) {
            for (int x = 0; x < bufferedImage.getWidth(); x++) {
                imagem[x][y] = bufferedImage.getRGB(x, y) & 0xFF;
            }
        }
        this.linha = imagem.length;
        this.coluna = imagem[0].length;
        this.maximumGray = maiorValorNaMatriz(imagem);
    }

    public Imagem(int[][] imagem) {
        this.imagem = imagem;
        this.linha = imagem.length;
        this.coluna = imagem[0].length;
        this.maximumGray = maiorValorNaMatriz(imagem);
    }

    public int getType() {
        return type;
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
