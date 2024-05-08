public class NullImageSegmenterFactory implements ImageSegmenterAbstractFactory {

    @Override
    public IImageSegmenter createImageSegmenter(int height, int width) {
        return null;
    }
}
