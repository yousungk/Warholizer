import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

public class WarholizerController {
    // This is the Controller for this App
    private WarholizerModel model;
    private WarholizerView view;

    public WarholizerController(WarholizerModel model, WarholizerView view) {
        this.model = model;
        this.view = view;
    }

    public void uploadImage(File file) {
        try {
            // read buffered image from the file
            BufferedImage originalImage = ImageIO.read(file);
            // model creates scaled image
            model.setImage(originalImage);
            // visualize the scaled image
            view.setImage(model.getImage());
        } catch (IOException e) {
            // throw exception
            throw new NoSuchElementException();
        }
    }

    public void convert() {
        model.convert();
        view.setImage(model.getImage());
    }
}
