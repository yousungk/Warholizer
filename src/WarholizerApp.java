import javax.swing.*;

public class WarholizerApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WarholizerView view = new WarholizerView();
                WarholizerModel model = new WarholizerModel(view.getImageWidth(),
                        view.getImageHeight());
                WarholizerController controller = new WarholizerController(model, view);

                view.initComponents(controller);

                view.setVisible(true);
            }
        });
    }
}
