import java.awt.*;
import java.awt.image.BufferedImage;

public class Painter {
    private ColorPalette palette;

    public Painter() {
        palette = new ColorPalette();
    }

    private Color findPixelColor(int clusterSize) {
        return palette.getColor(clusterSize);
    }

    public BufferedImage paint(int[][] clusterInfo, int[] clusterSizes) {
        // given 2D array of cluster ID and cluster size array, draw image
        // pixels with identical cluster ID will have same color
        int height = clusterInfo.length;
        int width = clusterInfo[0].length;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                // find color
                Color color = findPixelColor(clusterSizes[clusterInfo[row][col]]);
                // set color
                image.setRGB(col, row, color.getRGB());
            }
        }
        return image;
    }
}
