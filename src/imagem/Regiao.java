/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
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
            Set<String> set = new HashSet<>();
            for (int y = 0; y < image1.getHeight(); y++) {
                for (int x = 0; x < image1.getWidth(); x++) {
                    if(matriz[x][y] > 40){
                        set.add(getRegiao(x, y).toUpperCase());
                    }
                }
            }
            for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
                String next = iterator.next();
                System.out.print(next);
            }
            System.out.println("");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String getRegiao(int x, int y) {
        if ((x >= 0) && (x < 66.25)) {
            if ((y >= 0) && (y < 59.875)) {
                return "a1";
            } else if ((y >= 59.875) && (y < 119.75)) {
                return "b1";
            } else if ((y >= 119.75) && (y < 179.625)) {
                return "c1";
            } else if ((y >= 179.625) && (y < 239.5)) {
                return "d1";
            } else if ((y >= 239.5) && (y < 299.375)) {
                return "e1";
            } else if ((y >= 299.375) && (y < 359.25)) {
                return "f1";
            } else if ((y >= 359.25) && (y < 419.125)) {
                return "g1";
            } else if ((y >= 419.125) && (y < 479)) {
                return "h1";
            }
        } else if ((x >= 66.25) && (x < 132.5)) {
            if ((y >= 0) && (y < 59.875)) {
                return "a2";
            } else if ((y >= 59.875) && (y < 119.75)) {
                return "b2";
            } else if ((y >= 119.75) && (y < 179.625)) {
                return "c2";
            } else if ((y >= 179.625) && (y < 239.5)) {
                return "d2";
            } else if ((y >= 239.5) && (y < 299.375)) {
                return "e2";
            } else if ((y >= 299.375) && (y < 359.25)) {
                return "f2";
            } else if ((y >= 359.25) && (y < 419.125)) {
                return "g2";
            } else if ((y >= 419.125) && (y < 479)) {
                return "h2";
            }
        } else if ((x >= 132.5) && (x < 198.75)) {
            if ((y >= 0) && (y < 59.875)) {
                return "a3";
            } else if ((y >= 59.875) && (y < 119.75)) {
                return "b3";
            } else if ((y >= 119.75) && (y < 179.625)) {
                return "c3";
            } else if ((y >= 179.625) && (y < 239.5)) {
                return "d3";
            } else if ((y >= 239.5) && (y < 299.375)) {
                return "e3";
            } else if ((y >= 299.375) && (y < 359.25)) {
                return "f3";
            } else if ((y >= 359.25) && (y < 419.125)) {
                return "g3";
            } else if ((y >= 419.125) && (y < 479)) {
                return "h3";
            }
        } else if ((x >= 198.75) && (x < 265)) {
            if ((y >= 0) && (y < 59.875)) {
                return "a4";
            } else if ((y >= 59.875) && (y < 119.75)) {
                return "b4";
            } else if ((y >= 119.75) && (y < 179.625)) {
                return "c4";
            } else if ((y >= 179.625) && (y < 239.5)) {
                return "d4";
            } else if ((y >= 239.5) && (y < 299.375)) {
                return "e4";
            } else if ((y >= 299.375) && (y < 359.25)) {
                return "f4";
            } else if ((y >= 359.25) && (y < 419.125)) {
                return "g4";
            } else if ((y >= 419.125) && (y < 479)) {
                return "h4";
            }
        }
        return null;
    }

}
