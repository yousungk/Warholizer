import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

public class WarholizerModelTest {
    private WarholizerModel model;

    @Before
    public void setUp() {
        model = new WarholizerModel(100, 100);
    }

    @After
    public void tearDown() {
        model = null;
    }

    @Test
    public void testGetSetWideImage() {
        BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_ARGB);
        model.setImage(image);
        BufferedImage ret = model.getImage();
        assertEquals(50, ret.getHeight());
        assertEquals(100, ret.getWidth());
    }

    @Test
    public void testGetSetLongImage() {
        BufferedImage image = new BufferedImage(100, 200, BufferedImage.TYPE_INT_ARGB);
        model.setImage(image);
        BufferedImage ret = model.getImage();
        assertEquals(100, ret.getHeight());
        assertEquals(50, ret.getWidth());
    }

    @Test
    public void convertAllWhiteImage() {
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        g.dispose();

        model.setImage(image);
        model.convert();
        BufferedImage convertedImage = model.getImage();
        assertNotEquals(image, convertedImage);
    }
}
