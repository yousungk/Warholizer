import java.awt.*;
import java.awt.image.BufferedImage;

public class WarholizerModel {
    private int panelWidth;
    private int panelHeight;
    private BufferedImage image;
    private IPixel[][] pixels;
    private Painter painter;

    public WarholizerModel(int panelWidth, int panelHeight) {
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
        this.image = null;
        this.pixels = null;
        this.painter = new Painter();
    }

    public void setImage(BufferedImage originalImage) {
        // creating a scaled image from original image
        int imageWidth = originalImage.getWidth();
        int imageHeight = originalImage.getHeight();
        float aspectRatio = (float) imageWidth / imageHeight;
        int newWidth, newHeight;
        if (panelWidth > panelHeight * aspectRatio) {
            newWidth = (int) (panelHeight * aspectRatio);
            newHeight = panelHeight;
        } else {
            newWidth = panelWidth;
            newHeight = (int) (panelWidth / aspectRatio);
        }
        Image scaledImage =
                originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.drawImage(scaledImage, 0, 0, null);
        g2d.dispose();

        setPixels();
    }

    public BufferedImage getImage() {
        return image;
    }

    private void setPixels() {
        // method to create a 2D array of Pixel objects from image
        int height = image.getHeight();
        int width = image.getWidth();
        pixels = new Pixel[height][width];

        int[] rgbData = new int[width * height];
        image.getRGB(0, 0, width, height, rgbData, 0, width);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[y][x] = new Pixel(rgbData[y * width + x]);
            }
        }
    }

    public void convert() {
        // method to repaint image
        IImageSegmenter segmenter =
                ImageSegmenterFactory
                        .getInstance()
                        .getImageSegmenter(new UnionFindImageSegmenterFactory(),
                                image.getHeight(), image.getWidth());
        segmenter.processPixels(pixels);

        int[][] clusterInfo = segmenter.getClusterInfo();
        int[] clusterSizes = segmenter.getClusterSizes();

        // [ToDo] What happens if convert is called multiple times?
        image = painter.paint(clusterInfo, clusterSizes);
    }
}
