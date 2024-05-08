import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NullImageSegmenterFactoryTest {
    private NullImageSegmenterFactory factory;

    @Before
    public void setUp() {
        factory = new NullImageSegmenterFactory();
    }

    @After
    public void tearDown() {
        factory = null;
    }

    @Test
    public void createImageSegmeterTest() {
        assertNull(factory.createImageSegmenter(100, 100));
    }
}
