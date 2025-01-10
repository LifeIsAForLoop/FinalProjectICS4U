package gymsim;

import java.awt.Image;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Map {
    private int width;
    private int height;
    private Image mapImage;

    public Map(String url, int width, int height) {
        this.width = width;
        this.height = height;

        try {
            mapImage = ImageIO.read(new File(url));
        } catch (IOException ex) {
            System.out.println("Image handling error: " + ex.getMessage());
        }
    }

    public void draw(Graphics g) {
        if (mapImage != null) {
            g.drawImage(mapImage, 0, 0, width, height, null);
        }
    }
}
