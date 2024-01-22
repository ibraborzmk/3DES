import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Execute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interface();
            }
        });
	}

}
