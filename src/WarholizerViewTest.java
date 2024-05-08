import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.image.BufferedImage;

public class WarholizerViewTest {

    @Test
    public void testGetSetImagePanel() {
        WarholizerView view = new WarholizerView();
        ImagePanel actual = new ImagePanel();
        view.setImagePanel(actual);
        assertEquals(actual, view.getImagePanel());
    }

    @Test
    public void testSetImage() {
        WarholizerView view = new WarholizerView();
        ImagePanel panel = new ImagePanel();
        view.setImagePanel(panel);

        BufferedImage actual = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
        view.setImage(actual);
        assertEquals(actual, view.getImagePanel().getImage());
    }

    @Test
    public void testImageHeightWidth() {
        WarholizerView view = new WarholizerView();
        assertEquals(500, view.getImageWidth());
        assertEquals(500, view.getImageHeight());
    }

    @Test
    public void testInitComponents() {
        WarholizerView view = new WarholizerView();
        WarholizerModel model = new WarholizerModel(100, 100);
        WarholizerController controller = new WarholizerController(model, view);
        view.initComponents(controller);

        // test that image panel has been created
        assertNotNull(view.getImagePanel());
    }
}
