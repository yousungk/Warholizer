public class UnionFindImageSegmenterFactory implements ImageSegmenterAbstractFactory {

    @Override
    public IImageSegmenter createImageSegmenter(int height, int width) {
        return new UnionFindImageSegmenter(height, width);
    }
}
