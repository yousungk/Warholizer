import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class UnionFindImageSegmenterTest {
    private final int width = 5;
    private final int height = 5;
    private UnionFindImageSegmenter segmenter;
    private Pixel[][] pixels;

    @Before
    public void setUp() {
        segmenter = new UnionFindImageSegmenter(height, width);
        pixels = new Pixel[height][width];
    }

    @After
    public void tearDown() {
        segmenter = null;
        pixels = null;
    }

    @Test
    public void allWhiteTest() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[y][x] = new Pixel(Color.WHITE.getRGB());
            }
        }

        segmenter.processPixels(pixels);

        assertEquals(1, segmenter.getNumberOfClusters());

        int[][] clusterInfo = segmenter.getClusterInfo();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                assertEquals(0, clusterInfo[y][x]);
                assertEquals(0, segmenter.getCluster(y, x));
            }
        }

        assertEquals(height * width, segmenter.getClusterSizes()[0]);
        assertEquals(height * width, segmenter.getClusterSize(0));
    }

    @Test
    public void topLeftAndBottomRightBoxTest() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[y][x] = new Pixel(Color.WHITE.getRGB());
            }
        }

        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 2; x++) {
                pixels[y][x] = new Pixel(Color.BLACK.getRGB());
            }
        }

        for (int y = height - 2; y < height; y++) {
            for (int x = width - 2; x < width; x++) {
                pixels[y][x] = new Pixel(Color.BLACK.getRGB());
            }
        }

        segmenter.processPixels(pixels);

        assertEquals(3, segmenter.getNumberOfClusters());
        assertEquals(4, segmenter.getClusterSizes()[0]);
        assertEquals(17, segmenter.getClusterSizes()[1]);
        assertEquals(4, segmenter.getClusterSizes()[2]);
    }
}
