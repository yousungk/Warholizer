import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;

public class WarholizerView extends JFrame {
    private Container cp;
    private ImagePanel imagePanel;
    private WarholizerController controller;
    public static final int APP_WIDTH = 600;
    public static final int APP_HEIGHT = 600;
    private JPanel buttonPanel;
    private Button uploadButton;
    private Button convertButton;
    private JFileChooser fileChooser;


    public WarholizerView() {
    }

    public ImagePanel getImagePanel() {
        return imagePanel;
    }

    public void setImagePanel(ImagePanel panel) {
        this.imagePanel = panel;
    }

    public void initComponents(WarholizerController inputController) {
        // (0) set controller
        controller = inputController;

        // (1) set app settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Warholizer");
        setSize(APP_WIDTH, APP_HEIGHT);
        setResizable(false);

        // (2) create container
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // (3) create button panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        uploadButton = new Button("Upload image");
        convertButton = new Button("Warholize");
        buttonPanel.add(uploadButton);
        buttonPanel.add(convertButton);
        cp.add(buttonPanel, BorderLayout.NORTH);

        // (4) create image panel
        imagePanel = new ImagePanel();
        cp.add(imagePanel, BorderLayout.CENTER);

        // (5) create upload image event listener
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(
                new javax.swing.filechooser.FileNameExtensionFilter(
                        "Images", "jpg", "png", "gif"));
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileChooser.showOpenDialog(WarholizerView.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    controller.uploadImage(file);
                }
            }
        });
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.convert();
            }
        });
    }

    public void setImage(BufferedImage image) {
        imagePanel.setImage(image);
        imagePanel.repaintPanel();
    }

    public int getImageWidth() {
        return ImagePanel.IMAGE_WIDTH;
    }

    public int getImageHeight() {
        return ImagePanel.IMAGE_HEIGHT;
    }
}
