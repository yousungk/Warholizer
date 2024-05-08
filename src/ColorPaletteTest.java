import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;

public class ColorPaletteTest {

    @Test
    public void testGetColorFlamencoRed() {
        ColorPalette palette = new ColorPalette();
        Color actual = palette.getColor(0);

        assertEquals(145, actual.getRed());
        assertEquals(2, actual.getGreen());
        assertEquals(2, actual.getBlue());
    }

    @Test
    public void testGetColorTropicOrange() {
        ColorPalette palette = new ColorPalette();
        Color actual = palette.getColor(3);

        assertEquals(235, actual.getRed());
        assertEquals(89, actual.getGreen());
        assertEquals(111, actual.getBlue());
    }

    @Test
    public void testGetColorApricot() {
        ColorPalette palette = new ColorPalette();
        Color actual = palette.getColor(5);

        assertEquals(244, actual.getRed());
        assertEquals(158, actual.getGreen());
        assertEquals(12, actual.getBlue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetColorOutofBounds() {
        ColorPalette palette = new ColorPalette();
        palette.getColor(-2);
    }


}
