/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            ee.carregarElementoEstruturante(new File("ee_1.ee"));
            BufferedImage image1 = ImageIO.read(new File("erosao.jpg"));
            int[][] matriz = new int[image1.getWidth()][image1.getHeight()];
            for (int y = 0; y < image1.getHeight(); y++) {
                for (int x = 0; x < image1.getWidth(); x++) {
                    matriz[x][y] = image1.getRGB(x, y) & 0xFF;
                }
            }
            Imagem i = new Imagem(matriz);
            Imagem imagem = OperacaoMorfologica.abertura(i, ee);
            matriz = imagem.getImagem();
            BufferedImage image3 = new BufferedImage(image1.getWidth(), image1.getHeight(), image1.getType());
            for (int y = 0; y < image1.getHeight(); y++) {
                for (int x = 0; x < image1.getWidth(); x++) {
                    int bDiff = matriz[x][y];
                    int diff = (255 << 24) | (bDiff << 16) | (bDiff << 8) | bDiff;
                    image3.setRGB(x, y, diff);
                }
            }
            ImageIO.write(image3, "jpg", new File("erosao.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
