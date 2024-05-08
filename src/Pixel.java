public class Pixel implements IPixel {
    private int val;

    public Pixel(int val) {
        this.val = val;
    }

    @Override
    public int red() {
        return (val >> 16) & 0xFF;
    }

    @Override
    public int green() {
        return (val >> 8) & 0xFF;
    }

    @Override
    public int blue() {
        return val & 0xFF;
    }

    @Override
    public int grayscale() {
        //Better way?
        return (int) (0.2126 * red() + 0.7152 * green() + 0.0722 * blue());
    }

    @Override
    public boolean isWhite() {
        return grayscale() >= 128;
    }
}
