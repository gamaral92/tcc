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

            Imagem imageI = new Imagem(ImageIO.read(new File("folder/test-0.jpg")));
            Imagem imageF = new Imagem(ImageIO.read(new File("folder/test-1.jpg")));

            Imagem imagemsub = OperacaoMorfologica.subtracao(imageI, imageF);
            Imagem imagem = OperacaoMorfologica.erodir(imagemsub, ee);
            
            BufferedImage image2 = new BufferedImage(imagemsub.getLinha(), imagemsub.getColuna(), imageI.getType());
            
            int[][] matriz = imagemsub.getImagem();
            for (int y = 0; y < image2.getHeight(); y++) {
                for (int x = 0; x < image2.getWidth(); x++) {
                    int bDiff = matriz[x][y];
//                    if (bDiff <= 20) {
//                        bDiff = 0;
//                    } else {
//                        bDiff = 255;
//                    }
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
                    } else {
                        bDiff = 255;
                    }
                    int diff = (255 << 24) | (bDiff << 16) | (bDiff << 8) | bDiff;
                    image3.setRGB(x, y, diff);
                }
            }
            ImageIO.write(image3, "jpg", new File("erosao.jpg"));
            //Imagem i = new Imagem(matriz);
            //i.mostrarMatriz();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
