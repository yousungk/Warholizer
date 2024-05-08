import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ImageSegmenterFactoryTest {
    @Test
    public void getInstanceTest() {
        ImageSegmenterFactory factory = ImageSegmenterFactory.getInstance();
        assertNotNull(factory);
        assertTrue(factory instanceof ImageSegmenterFactory);
    }

    @Test
    public void getImageSegmenterTest() {
        IImageSegmenter ret = ImageSegmenterFactory
                .getInstance()
                .getImageSegmenter(new UnionFindImageSegmenterFactory(),
                        100, 100);
        assertNotNull(ret);
        assertTrue(ret instanceof UnionFindImageSegmenter);
    }
}
