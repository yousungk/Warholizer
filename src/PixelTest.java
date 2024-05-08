import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class PixelTest {
    private Color[] testSet;

    @Before
    public void setUp() {
        testSet = new Color[]{
            ColorPalette.FLAMENCO_RED, ColorPalette.RED, ColorPalette.PINK,
            ColorPalette.TROPIC_ORANGE, ColorPalette.ORANGE, ColorPalette.APRICOT,
            ColorPalette.YELLOW_OCHRE, ColorPalette.YELLOW, ColorPalette.KIWI,
            ColorPalette.LIME_TREE, ColorPalette.PALM_LEAF, ColorPalette.GREEN,
            ColorPalette.HOLLY_BRANCH, ColorPalette.ENGLISH_IVY, ColorPalette.LAGUNA,
            ColorPalette.TUSCAN_TEAL, ColorPalette.TURQUOISE, ColorPalette.POOL_BLUE,
            ColorPalette.BLUE_COTTON, ColorPalette.BLUE, ColorPalette.ADMIRAL_BLUE,
            ColorPalette.VIOLET, ColorPalette.WILD_IRIS, ColorPalette.LILAC_MIST,
            ColorPalette.KHAKI, ColorPalette.TERRITORIAL_BEIGE, ColorPalette.BURNT_UMBER,
            ColorPalette.GRAY, ColorPalette.BLACK, ColorPalette.WHITE
        };
    }

    @After
    public void tearDown() {
        testSet = null;
    }

    @Test
    public void paletteRGBTest() {
        for (Color color : testSet) {
            Pixel pixel = new Pixel(color.getRGB());
            assertEquals(color.getRed(), pixel.red());
            assertEquals(color.getGreen(), pixel.green());
            assertEquals(color.getBlue(), pixel.blue());
        }
    }

    @Test
    public void blackWhiteIsWhiteTest() {
        Pixel black = new Pixel(Color.BLACK.getRGB());
        Pixel white = new Pixel(Color.WHITE.getRGB());

        assertFalse(black.isWhite());
        assertTrue(white.isWhite());
    }
}
