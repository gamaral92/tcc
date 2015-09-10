package util;

import java.awt.*;
import java.awt.image.BufferedImage;


public class ImagemPGM extends Component {

    private BufferedImage img;

    private void pixelParaImagem(int[][] pixels) {
        int g;
        img = new BufferedImage(pixels[0].length, pixels.length, BufferedImage.TYPE_INT_ARGB);
        // copy the pixels values
        for (int row = 0; row < pixels.length; ++row) {
            for (int col = 0; col < pixels[row].length; ++col) {
                g = pixels[row][col];
                img.setRGB(col, row, ((255 << 24) | (g << 16) | (g << 8) | g));
            }
        }
    }
    
    public ImagemPGM(int[][] imagem) {
        pixelParaImagem(imagem);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize() {
        if (img == null) {
            return new Dimension(600, 480);
        } else {
            return new Dimension(Math.max(600, img.getWidth(null)),
                    Math.max(480, img.getHeight(null)));
        }
    }
}
