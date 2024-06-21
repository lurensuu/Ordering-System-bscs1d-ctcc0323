import javax.swing.SwingUtilities;
import GUI.loginForm;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                new loginForm().setVisible(true);              
            }
        });

    }
}
