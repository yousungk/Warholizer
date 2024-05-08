import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WarholizerControllerTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void testUploadImage() {

        WarholizerModel model = new WarholizerModel(500, 500);
        WarholizerView view = new WarholizerView();
        WarholizerController controller = new WarholizerController(model, view);
        view.initComponents(controller);

        try {
            // create mock image of size 50 x 50
            BufferedImage image = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = image.createGraphics();
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, 50, 50);
            g2d.dispose();

            // write image to file
            Path tempFile = Files.createTempFile("image", ".jpeg");
            ImageIO.write(image, "jpeg", tempFile.toFile());

            // creating a scaled image from original image
            Image scaledImage =
                    image.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
            BufferedImage expectedImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2dExpected = expectedImage.createGraphics();
            g2dExpected.drawImage(scaledImage, 0, 0, null);
            g2dExpected.dispose();

            // upload image to controller
            controller.uploadImage(tempFile.toFile());

            // controller should return scaled image
            assertEquals(500, view.getImageWidth());
            assertEquals(500, view.getImageHeight());

        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    @Test
    public void testConvertNotEqual() {

        WarholizerModel model = new WarholizerModel(500, 500);
        WarholizerView view = new WarholizerView();
        WarholizerController controller = new WarholizerController(model, view);
        view.initComponents(controller);

        try {
            // create mock image
            BufferedImage image = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = image.createGraphics();
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, 50, 50);
            g2d.dispose();

            // write image to file
            Path tempFile = Files.createTempFile("image", ".jpeg");
            ImageIO.write(image, "jpeg", tempFile.toFile());

            // creating a scaled image from original image
            Image scaledImage =
                    image.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
            BufferedImage expectedImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2dExpected = expectedImage.createGraphics();
            g2dExpected.drawImage(scaledImage, 0, 0, null);
            g2dExpected.dispose();

            controller.uploadImage(tempFile.toFile());

            // actual image before convert
            BufferedImage actualImage = model.getImage();

            // convert image
            controller.convert();

            // after converting, image should be different
            assertNotEquals(actualImage, model.getImage());

        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
