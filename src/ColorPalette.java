import java.awt.*;

public class ColorPalette {
    private final Color[] palette;

    public static final Color FLAMENCO_RED = new Color(145, 2, 2);
    public static final Color RED = Color.RED;
    public static final Color PINK = Color.PINK;
    public static final Color TROPIC_ORANGE = new Color(235, 89, 111);
    public static final Color ORANGE = Color.ORANGE;
    public static final Color APRICOT = new Color(244, 158, 12);
    public static final Color YELLOW_OCHRE = new Color(191, 156, 10);
    public static final Color YELLOW = Color.YELLOW;
    public static final Color KIWI = new Color(195, 244, 11);
    public static final Color LIME_TREE = new Color(138, 245, 19);
    public static final Color PALM_LEAF = new Color(103, 208, 11);
    public static final Color GREEN = Color.GREEN;
    public static final Color HOLLY_BRANCH = new Color(22, 120, 14);
    public static final Color ENGLISH_IVY = new Color(45, 76, 5);
    public static final Color LAGUNA = new Color(52, 220, 137);
    public static final Color TUSCAN_TEAL = new Color(32, 125, 164);
    public static final Color TURQUOISE = new Color(69, 202, 244);
    public static final Color POOL_BLUE = new Color(117, 245, 240);
    public static final Color BLUE_COTTON = new Color(193, 243, 244);
    public static final Color BLUE = Color.BLUE;
    public static final Color ADMIRAL_BLUE = new Color(2, 11, 122);
    public static final Color VIOLET = new Color(62, 2, 246);
    public static final Color WILD_IRIS = new Color(123, 3, 246);
    public static final Color LILAC_MIST = new Color(193, 158, 244);
    public static final Color KHAKI = new Color(193, 183, 131);
    public static final Color TERRITORIAL_BEIGE = new Color(127, 83, 50);
    public static final Color BURNT_UMBER = new Color(75, 38, 3);
    public static final Color GRAY = Color.GRAY;
    public static final Color BLACK = Color.BLACK;
    public static final Color WHITE = Color.WHITE;

    public ColorPalette() {
        // array of colors
        palette = new Color[]{
            FLAMENCO_RED, RED, PINK, TROPIC_ORANGE, ORANGE, APRICOT, YELLOW_OCHRE, YELLOW, KIWI,
            LIME_TREE, PALM_LEAF, GREEN, HOLLY_BRANCH, ENGLISH_IVY, LAGUNA, TUSCAN_TEAL, TURQUOISE,
            POOL_BLUE, BLUE_COTTON, BLUE, ADMIRAL_BLUE, VIOLET, WILD_IRIS, LILAC_MIST, KHAKI,
            TERRITORIAL_BEIGE, BURNT_UMBER, GRAY, BLACK, WHITE
        };
    }

    public Color getColor(int count) {
        // hashing by modulus function
        int index = count % 30;
        if (index < 0 || index >= palette.length) {
            throw new IllegalArgumentException();
        }
        return palette[index];
    }
}
