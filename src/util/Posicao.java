/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import util.elementos.Imagem;

/**
 *
 * @author Gabriel
 */
public class Posicao {

    public static void main(String[] args) throws IOException {
        Imagem image = new Imagem(ImageIO.read(new File("img/test-1.jpg")));
        BufferedImage image2 = new BufferedImage(image.getLinha(), image.getColuna(), image.getType());
        for (int y = 0; y < image2.getHeight(); y++) {
            for (int x = 0; x < image2.getWidth(); x++) {
                if (y >= 6 && y < 62) {
                    if (x >= 45 && x < 101) {
                        image2.setRGB(x, y, Color.blue.getRGB());
                    } else if (x >= 101 && x < 157) {
                        image2.setRGB(x, y, Color.pink.getRGB());
                    } else if (x >= 157 && x < 213) {
                        image2.setRGB(x, y, Color.red.getRGB());
                    } else if (x >= 213 && x < 269) {
                        image2.setRGB(x, y, Color.GREEN.getRGB());
                    } else if (x >= 269 && x < 325) {
                        image2.setRGB(x, y, Color.MAGENTA.getRGB());
                    } else if (x >= 325 && x < 385) {
                        image2.setRGB(x, y, Color.ORANGE.getRGB());
                    } else if (x >= 385 && x < 443) {
                        image2.setRGB(x, y, Color.YELLOW.getRGB());
                    } else if (x >= 443 && x < 503) {
                        image2.setRGB(x, y, Color.cyan.getRGB());
                    } else {
                        int bDiff = image.getImagem()[x][y];
                        int diff = (255 << 24) | (bDiff << 16) | (bDiff << 8) | bDiff;
                        image2.setRGB(x, y, diff);
                    }
                } else if (y >= 62 && y < 118) {
                    if (x >= 45 && x < 101) {
                        image2.setRGB(x, y, Color.pink.getRGB());
                    } else if (x >= 101 && x < 157) {
                        image2.setRGB(x, y, Color.blue.getRGB());
                    } else if (x >= 157 && x < 213) {
                        image2.setRGB(x, y, Color.GREEN.getRGB());
                    } else if (x >= 213 && x < 269) {
                        image2.setRGB(x, y, Color.red.getRGB());
                    } else if (x >= 269 && x < 325) {
                        image2.setRGB(x, y, Color.ORANGE.getRGB());
                    } else if (x >= 325 && x < 385) {
                        image2.setRGB(x, y, Color.MAGENTA.getRGB());
                    } else if (x >= 385 && x < 443) {
                        image2.setRGB(x, y, Color.cyan.getRGB());
                    } else if (x >= 443 && x < 500) {
                        image2.setRGB(x, y, Color.YELLOW.getRGB());
                    } else {
                        int bDiff = image.getImagem()[x][y];
                        int diff = (255 << 24) | (bDiff << 16) | (bDiff << 8) | bDiff;
                        image2.setRGB(x, y, diff);
                    }
                } else if (y >= 118 && y < 176) {
                    if (x >= 45 && x < 101) {
                        image2.setRGB(x, y, Color.blue.getRGB());
                    } else if (x >= 101 && x < 157) {
                        image2.setRGB(x, y, Color.pink.getRGB());
                    } else if (x >= 157 && x < 213) {
                        image2.setRGB(x, y, Color.red.getRGB());
                    } else if (x >= 213 && x < 269) {
                        image2.setRGB(x, y, Color.GREEN.getRGB());
                    } else if (x >= 269 && x < 325) {
                        image2.setRGB(x, y, Color.MAGENTA.getRGB());
                    } else if (x >= 325 && x < 385) {
                        image2.setRGB(x, y, Color.ORANGE.getRGB());
                    } else if (x >= 385 && x < 443) {
                        image2.setRGB(x, y, Color.YELLOW.getRGB());
                    } else if (x >= 443 && x < 500) {
                        image2.setRGB(x, y, Color.cyan.getRGB());
                    } else {
                        int bDiff = image.getImagem()[x][y];
                        int diff = (255 << 24) | (bDiff << 16) | (bDiff << 8) | bDiff;
                        image2.setRGB(x, y, diff);
                    }
                } else if (y >= 176 && y < 234) {
                    if (x >= 45 && x < 101) {
                        image2.setRGB(x, y, Color.pink.getRGB());
                    } else if (x >= 101 && x < 157) {
                        image2.setRGB(x, y, Color.blue.getRGB());
                    } else if (x >= 157 && x < 213) {
                        image2.setRGB(x, y, Color.GREEN.getRGB());
                    } else if (x >= 213 && x < 269) {
                        image2.setRGB(x, y, Color.red.getRGB());
                    } else if (x >= 269 && x < 325) {
                        image2.setRGB(x, y, Color.ORANGE.getRGB());
                    } else if (x >= 325 && x < 385) {
                        image2.setRGB(x, y, Color.MAGENTA.getRGB());
                    } else if (x >= 385 && x < 443) {
                        image2.setRGB(x, y, Color.cyan.getRGB());
                    } else if (x >= 443 && x < 498) {
                        image2.setRGB(x, y, Color.YELLOW.getRGB());
                    } else {
                        int bDiff = image.getImagem()[x][y];
                        int diff = (255 << 24) | (bDiff << 16) | (bDiff << 8) | bDiff;
                        image2.setRGB(x, y, diff);
                    }
                } else if (y >= 234 && y < 292) {
                    if (x >= 45 && x < 101) {
                        image2.setRGB(x, y, Color.blue.getRGB());
                    } else if (x >= 101 && x < 157) {
                        image2.setRGB(x, y, Color.pink.getRGB());
                    } else if (x >= 157 && x < 213) {
                        image2.setRGB(x, y, Color.red.getRGB());
                    } else if (x >= 213 && x < 269) {
                        image2.setRGB(x, y, Color.GREEN.getRGB());
                    } else if (x >= 269 && x < 325) {
                        image2.setRGB(x, y, Color.MAGENTA.getRGB());
                    } else if (x >= 325 && x < 385) {
                        image2.setRGB(x, y, Color.ORANGE.getRGB());
                    } else if (x >= 385 && x < 443) {
                        image2.setRGB(x, y, Color.YELLOW.getRGB());
                    } else if (x >= 443 && x < 497) {
                        image2.setRGB(x, y, Color.cyan.getRGB());
                    } else {
                        int bDiff = image.getImagem()[x][y];
                        int diff = (255 << 24) | (bDiff << 16) | (bDiff << 8) | bDiff;
                        image2.setRGB(x, y, diff);
                    }
                } else if (y >= 292 && y < 348) {
                    if (x >= 45 && x < 101) {
                        image2.setRGB(x, y, Color.pink.getRGB());
                    } else if (x >= 101 && x < 157) {
                        image2.setRGB(x, y, Color.blue.getRGB());
                    } else if (x >= 157 && x < 213) {
                        image2.setRGB(x, y, Color.GREEN.getRGB());
                    } else if (x >= 213 && x < 269) {
                        image2.setRGB(x, y, Color.red.getRGB());
                    } else if (x >= 269 && x < 325) {
                        image2.setRGB(x, y, Color.ORANGE.getRGB());
                    } else if (x >= 325 && x < 385) {
                        image2.setRGB(x, y, Color.MAGENTA.getRGB());
                    } else if (x >= 385 && x < 443) {
                        image2.setRGB(x, y, Color.cyan.getRGB());
                    } else if (x >= 443 && x < 496) {
                        image2.setRGB(x, y, Color.YELLOW.getRGB());
                    } else {
                        int bDiff = image.getImagem()[x][y];
                        int diff = (255 << 24) | (bDiff << 16) | (bDiff << 8) | bDiff;
                        image2.setRGB(x, y, diff);
                    }
                } else if (y >= 348 && y < 406) {
                    if (x >= 45 && x < 101) {
                        image2.setRGB(x, y, Color.blue.getRGB());
                    } else if (x >= 101 && x < 157) {
                        image2.setRGB(x, y, Color.pink.getRGB());
                    } else if (x >= 157 && x < 213) {
                        image2.setRGB(x, y, Color.red.getRGB());
                    } else if (x >= 213 && x < 269) {
                        image2.setRGB(x, y, Color.GREEN.getRGB());
                    } else if (x >= 269 && x < 325) {
                        image2.setRGB(x, y, Color.MAGENTA.getRGB());
                    } else if (x >= 325 && x < 385) {
                        image2.setRGB(x, y, Color.ORANGE.getRGB());
                    } else if (x >= 385 && x < 443) {
                        image2.setRGB(x, y, Color.YELLOW.getRGB());
                    } else if (x >= 443 && x < 497) {
                        image2.setRGB(x, y, Color.cyan.getRGB());
                    } else {
                        int bDiff = image.getImagem()[x][y];
                        int diff = (255 << 24) | (bDiff << 16) | (bDiff << 8) | bDiff;
                        image2.setRGB(x, y, diff);
                    }
                } else if (y >= 406 && y < 462) {
                    if (x >= 45 && x < 101) {
                        image2.setRGB(x, y, Color.pink.getRGB());
                    } else if (x >= 101 && x < 157) {
                        image2.setRGB(x, y, Color.blue.getRGB());
                    } else if (x >= 157 && x < 213) {
                        image2.setRGB(x, y, Color.GREEN.getRGB());
                    } else if (x >= 213 && x < 269) {
                        image2.setRGB(x, y, Color.red.getRGB());
                    } else if (x >= 269 && x < 325) {
                        image2.setRGB(x, y, Color.ORANGE.getRGB());
                    } else if (x >= 325 && x < 385) {
                        image2.setRGB(x, y, Color.MAGENTA.getRGB());
                    } else if (x >= 385 && x < 443) {
                        image2.setRGB(x, y, Color.cyan.getRGB());
                    } else if (x >= 443 && x < 496) {
                        image2.setRGB(x, y, Color.YELLOW.getRGB());
                    } else {
                        int bDiff = image.getImagem()[x][y];
                        int diff = (255 << 24) | (bDiff << 16) | (bDiff << 8) | bDiff;
                        image2.setRGB(x, y, diff);
                    }
                } else {
                    int bDiff = image.getImagem()[x][y];
                    int diff = (255 << 24) | (bDiff << 16) | (bDiff << 8) | bDiff;
                    image2.setRGB(x, y, diff);
                }
            }
        }
        ImageIO.write(image2, "jpg", new File("blue.jpg"));
    }

}
