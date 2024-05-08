public class ImageSegmenterFactory {
    private static ImageSegmenterFactory instance;

    private ImageSegmenterFactory() {
    }

    public static ImageSegmenterFactory getInstance() {
        if (instance == null) {
            instance = new ImageSegmenterFactory();
        }
        return instance;
    }

    public IImageSegmenter getImageSegmenter(ImageSegmenterAbstractFactory factory,
                                             int height, int width) {
        return factory.createImageSegmenter(height, width);
    }
}
