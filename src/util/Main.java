package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import util.elementos.ElementoEstruturante;
import util.elementos.Imagem;
import util.operacao.OperacaoMorfologica;

/**
 *
 * @author a11030
 */
public class Main {

    public static void main(String[] args) {
        try {
            ElementoEstruturante ee = new ElementoEstruturante();
            ee.carregarElementoEstruturante(new File("EE15.ee"));

            Imagem imageI = new Imagem(ImageIO.read(new File("img/d1_b6/test-2.jpg")));
            Imagem imageF = new Imagem(ImageIO.read(new File("img/d1_b6/test-1.jpg")));

            Imagem imagemsub = OperacaoMorfologica.subtracao(imageI, imageF);
            Imagem imagem = OperacaoMorfologica.erodir(imagemsub, ee);

            BufferedImage image2 = new BufferedImage(imagemsub.getLinha(), imagemsub.getColuna(), imageI.getType());

            int[][] matriz = imagemsub.getImagem();
            for (int y = 0; y < image2.getHeight(); y++) {
                for (int x = 0; x < image2.getWidth(); x++) {
                    int bDiff = matriz[x][y];
                    if (bDiff <= 20) {
                        bDiff = 0;
                    } else {
                        bDiff = 255;
                    }
                    int diff = (255 << 24) | (bDiff << 16) | (bDiff << 8) | bDiff;
                    image2.setRGB(x, y, diff);
                }
            }
            ImageIO.write(image2, "jpg", new File("sub.jpg"));
            matriz = imagem.getImagem();

            BufferedImage image3 = new BufferedImage(imagem.getLinha(), imagem.getColuna(), imageI.getType());
            for (int y = 0; y < image3.getHeight(); y++) {
                for (int x = 0; x < image3.getWidth(); x++) {
                    int bDiff = matriz[x][y];
                    if (bDiff <= 30) {
                        bDiff = 0;
                        matriz[x][y] = 0;
                    } else {
                        bDiff = 255;
                        matriz[x][y] = 255;
                    }
                    int diff = (255 << 24) | (bDiff << 16) | (bDiff << 8) | bDiff;
                    image3.setRGB(x, y, diff);
                }
            }
            ImageIO.write(image3, "jpg", new File("erosao.jpg"));

            StringBuilder builder = new StringBuilder();
            for (int y = 6; y < 462; y++) {
                for (int x = 45; x < 503; x++) {
                    try {
                        int bDiff = matriz[x][y];
                        if (bDiff == 255) {
                            builder.append(posicao(x, y));
                            x += 56;
                            y += 56;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
            }
            System.out.println(builder.toString());
            //Imagem i = new Imagem(matriz);
            //i.mostrarMatriz();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String posicao(int x, int y) {
        StringBuilder saida = new StringBuilder();
        if (y >= 6 && y < 62) {
            if (x >= 45 && x < 101) {
                saida.append("a8");
            } else if (x >= 101 && x < 157) {
                saida.append("b8");
            } else if (x >= 157 && x < 213) {
                saida.append("c8");
            } else if (x >= 213 && x < 269) {
                saida.append("d8");
            } else if (x >= 269 && x < 325) {
                saida.append("e8");
            } else if (x >= 325 && x < 385) {
                saida.append("f8");
            } else if (x >= 385 && x < 443) {
                saida.append("g8");
            } else if (x >= 443 && x < 503) {
                saida.append("h8");
            }
        } else if (y >= 62 && y < 118) {
            if (x >= 45 && x < 101) {
                saida.append("a7");
            } else if (x >= 101 && x < 157) {
                saida.append("b7");
            } else if (x >= 157 && x < 213) {
                saida.append("c7");
            } else if (x >= 213 && x < 269) {
                saida.append("d7");
            } else if (x >= 269 && x < 325) {
                saida.append("e7");
            } else if (x >= 325 && x < 385) {
                saida.append("f7");
            } else if (x >= 385 && x < 443) {
                saida.append("g7");
            } else if (x >= 443 && x < 500) {
                saida.append("h7");
            }
        } else if (y >= 118 && y < 176) {
            if (x >= 45 && x < 101) {
                saida.append("a6");
            } else if (x >= 101 && x < 157) {
                saida.append("b6");
            } else if (x >= 157 && x < 213) {
                saida.append("c6");
            } else if (x >= 213 && x < 269) {
                saida.append("d6");
            } else if (x >= 269 && x < 325) {
                saida.append("e6");
            } else if (x >= 325 && x < 385) {
                saida.append("f6");
            } else if (x >= 385 && x < 443) {
                saida.append("g6");
            } else if (x >= 443 && x < 500) {
                saida.append("h6");
            }
        } else if (y >= 176 && y < 234) {
            if (x >= 45 && x < 101) {
                saida.append("a5");
            } else if (x >= 101 && x < 157) {
                saida.append("b5");
            } else if (x >= 157 && x < 213) {
                saida.append("c5");
            } else if (x >= 213 && x < 269) {
                saida.append("d5");
            } else if (x >= 269 && x < 325) {
                saida.append("e5");
            } else if (x >= 325 && x < 385) {
                saida.append("f5");
            } else if (x >= 385 && x < 443) {
                saida.append("g5");
            } else if (x >= 443 && x < 498) {
                saida.append("h5");
            }
        } else if (y >= 234 && y < 292) {
            if (x >= 45 && x < 101) {
                saida.append("a4");
            } else if (x >= 101 && x < 157) {
                saida.append("b4");
            } else if (x >= 157 && x < 213) {
                saida.append("c4");
            } else if (x >= 213 && x < 269) {
                saida.append("d4");
            } else if (x >= 269 && x < 325) {
                saida.append("e4");
            } else if (x >= 325 && x < 385) {
                saida.append("f4");
            } else if (x >= 385 && x < 443) {
                saida.append("g4");
            } else if (x >= 443 && x < 497) {
                saida.append("h4");
            }
        } else if (y >= 292 && y < 348) {
            if (x >= 45 && x < 101) {
                saida.append("a3");
            } else if (x >= 101 && x < 157) {
                saida.append("b3");
            } else if (x >= 157 && x < 213) {
                saida.append("c3");
            } else if (x >= 213 && x < 269) {
                saida.append("d3");
            } else if (x >= 269 && x < 325) {
                saida.append("e4");
            } else if (x >= 325 && x < 385) {
                saida.append("f3");
            } else if (x >= 385 && x < 443) {
                saida.append("g3");
            } else if (x >= 443 && x < 496) {
                saida.append("h3");
            }
        } else if (y >= 348 && y < 406) {
            if (x >= 45 && x < 101) {
                saida.append("a2");
            } else if (x >= 101 && x < 157) {
                saida.append("b2");
            } else if (x >= 157 && x < 213) {
                saida.append("c3");
            } else if (x >= 213 && x < 269) {
                saida.append("d4");
            } else if (x >= 269 && x < 325) {
                saida.append("e5");
            } else if (x >= 325 && x < 385) {
                saida.append("f2");
            } else if (x >= 385 && x < 443) {
                saida.append("g2");
            } else if (x >= 443 && x < 497) {
                saida.append("h2");
            }
        } else if (y >= 406 && y < 462) {
            if (x >= 45 && x < 101) {
                saida.append("a1");
            } else if (x >= 101 && x < 157) {
                saida.append("b1");
            } else if (x >= 157 && x < 213) {
                saida.append("c1");
            } else if (x >= 213 && x < 269) {
                saida.append("d1");
            } else if (x >= 269 && x < 325) {
                saida.append("e1");
            } else if (x >= 325 && x < 385) {
                saida.append("f1");
            } else if (x >= 385 && x < 443) {
                saida.append("g1");
            } else if (x >= 443 && x < 496) {
                saida.append("h1");
            }
        }
        return saida.toString();
    }

}
