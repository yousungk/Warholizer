import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnionFindImageSegmenterFactoryTest {
    private UnionFindImageSegmenterFactory factory;

    @Before
    public void setUp() {
        factory = new UnionFindImageSegmenterFactory();
    }

    @After
    public void tearDown() {
        factory = null;
    }

    @Test
    public void createImageSegmeterTest() {
        IImageSegmenter ret = factory.createImageSegmenter(100, 100);
        assertNotNull(ret);
        assertTrue(ret instanceof UnionFindImageSegmenter);
    }
}
