import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePanelTest {
    private ImagePanel panel;

    @Before
    public void setUp() {
        panel = new ImagePanel();

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        Container cp = frame.getContentPane();
        cp.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    @After
    public void tearDown() {
        panel = null;
    }

    @Test
    public void basicGetSetTest() {
        BufferedImage image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
        panel.setImage(image);
        panel.repaintPanel();
        assertEquals(image, panel.getImage());
    }
}
