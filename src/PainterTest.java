import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PainterTest {

    @Test
    public void testPaintCheckImageHeightWidth() {
        Painter painter = new Painter();
        int height = 2;
        int width = 2;

        int[][] actualCluster = new int[height][width];
        int[] actualSizes = new int[1];

        BufferedImage actualImage = painter.paint(actualCluster, actualSizes);
        assertEquals(height, actualImage.getHeight());
        assertEquals(width, actualImage.getWidth());
    }

    @Test
    public void testPaintOrangeImage() {
        // create 2d array of pixels in a single cluster
        // size of cluster is 4
        // should get color orange
        Painter painter = new Painter();

        int height = 2;
        int width = 2;

        int[][] actualCluster = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                actualCluster[i][j] = 0;
            }
        }

        int[] actualSizes = new int[1];
        actualSizes[0] = width * height;

        BufferedImage actualImage = painter.paint(actualCluster, actualSizes);
        ColorPalette palette = new ColorPalette();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                assertEquals(palette.getColor(4).getRGB(), actualImage.getRGB(j, i));
            }
        }
    }

    @Test
    public void testPaintFlamencoRedImage() {
        // create 2d array of pixels in a single cluster
        // size of cluster is 30
        // should get color Flamenco Red
        Painter painter = new Painter();

        int height = 6;
        int width = 5;

        int[][] actualCluster = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                actualCluster[i][j] = 0;
            }
        }

        int[] actualSizes = new int[1];
        actualSizes[0] = width * height;

        BufferedImage actualImage = painter.paint(actualCluster, actualSizes);
        ColorPalette palette = new ColorPalette();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                assertEquals(palette.getColor(0).getRGB(), actualImage.getRGB(j, i));
            }
        }
    }



}
