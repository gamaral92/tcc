/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author a11030
 */
public class Regiao {

    public static void main(String[] args) {
        try {
            BufferedImage image1 = ImageIO.read(new File("erosao.jpg"));
            int[][] matriz = new int[image1.getWidth()][image1.getHeight()];
            for (int y = 0; y < image1.getHeight(); y++) {
                for (int x = 0; x < image1.getWidth(); x++) {
                    matriz[x][y] = image1.getRGB(x, y) & 0xFF;
                }
            }
            for (int y = 0; y < image1.getHeight(); y++) {
                for (int x = 0; x < image1.getWidth(); x++) {
                    System.out.print(matriz[x][y] + "\t");
                }
                System.out.println("");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
