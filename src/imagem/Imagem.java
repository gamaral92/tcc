/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagem;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author a11030
 */
public class Imagem {

    public static void main(String[] args) throws Exception {
        BufferedImage image1 = ImageIO.read(new File("img1.png"));
        BufferedImage image2 = ImageIO.read(new File("img2.png"));
        BufferedImage image3 = new BufferedImage(image1.getWidth(), image1.getHeight(), image1.getType());
        for (int x = 0; x < image1.getWidth(); x++) {
            for (int y = 0; y < image1.getHeight(); y++) {
                int argb0 = image1.getRGB(x, y);
                int argb1 = image2.getRGB(x, y);

                int b0 = argb0 & 0xFF;
                int b1 = argb1 & 0xFF;
                int bDiff = Math.abs(b1 - b0);

                int diff = (255 << 24) | (bDiff << 16) | (bDiff << 8) | bDiff;
                image3.setRGB(x, y, diff);
            }
        }
        ImageIO.write(image3, "png", new File("img.png"));

    }

}
