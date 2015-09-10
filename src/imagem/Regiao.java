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

    public String getRegiao(int x, int y) {
        if ((x >= 0) && (x < 66.25)) {
            if ((y >= 0) && (y < 59.875)) {
                return "a1";
            } else if ((y >= 59.875) && (y < 119.75)) {
                return "b2";
            } else if ((y >= 119.75) && (y < 179.625)) {
                return "c3";
            } else if ((y >= 179.625) && (y < 239.5)) {
                return "d4";
            } else if ((y >= 239.5) && (y < 299.375)) {
                return "e5";
            } else if ((y >= 299.375) && (y < 359.25)) {
                return "f6";
            } else if ((y >= 359.25) && (y < 419.125)) {
                return "g7";
            } else if ((y >= 419.125) && (y < 479)) {
                return "h8";
            }
        } else if ((x >= 66.25) && (x < 132.5)) {

        } else if ((x >= 132.5) && (x < 198.75)) {

        } else if ((x >= 198.75) && (x < 265)) {

        }
        return null;
    }

}
