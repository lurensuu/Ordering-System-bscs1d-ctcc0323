package GUI;

import javax.swing.JFrame;
import colors.color;

public class Form extends JFrame {
     public Form(String title){
        super(title);

        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(color.PRIMARY_COLOR);


     }
}