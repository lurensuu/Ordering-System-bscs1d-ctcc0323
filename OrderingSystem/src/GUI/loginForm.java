package GUI;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import colors.color;
import data.MyData;

public class loginForm extends Form{

    public loginForm() {
        super("Login");
        addGuiComponents();
    }
    private void addGuiComponents(){
        JLabel LoginLabel = new JLabel("Login");
        LoginLabel.setBounds(0, 25, 520, 100);
        LoginLabel.setForeground(color.TEXT_COLOR);
        LoginLabel.setFont(new Font("Dialog", Font.BOLD, 40));
        LoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(LoginLabel);
        
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setBounds(30, 150, 400, 25);
        usernameLabel.setForeground(color.TEXT_COLOR);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        JTextField usernameField = new JTextField();
        usernameField.setBounds(30, 185, 450, 55);
        usernameField.setBackground(color.SECONDARY_COLOR);
        usernameField.setForeground(color.TEXT_COLOR);
        usernameField.setFont(new Font("DIALOG", Font.PLAIN, 24));

        add(usernameLabel);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(30, 335, 400, 25);
        passwordLabel.setForeground(color.TEXT_COLOR);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(30, 365, 450, 55);
        passwordField.setBackground(color.SECONDARY_COLOR);
        passwordField.setForeground(color.TEXT_COLOR);
        passwordField.setFont(new Font("DIALOG", Font.PLAIN, 24));

        add(passwordLabel);
        add(passwordField);

        JButton LoginButton = new JButton("Login");
        LoginButton.setFont(new Font("DIALOG", Font.PLAIN, 18));
        LoginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        LoginButton.setBackground(color.SECONDARY_COLOR);
        LoginButton.setForeground(color.TEXT_COLOR);
        LoginButton.setBounds(125, 520, 250, 50);
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if(MyData.validateLogin(username, password)){
                    JOptionPane.showMessageDialog(loginForm.this, "Login Successful!");

                }else{
                    JOptionPane.showMessageDialog(loginForm.this, "Login Failed.");
                }
            }
        });

        add(LoginButton);
        
        ImageIcon logoPic = new ImageIcon("./Image/Logo2.png");
        Image image = logoPic.getImage();
        Image resizedImage = image.getScaledInstance(460, 460, java.awt.Image.SCALE_SMOOTH);
        logoPic = new ImageIcon(resizedImage);
        JLabel logoLabel = new JLabel(logoPic);
        logoLabel.setBounds(580, 0, 300, 600);

        add(logoLabel);

        JLabel registerLabel = new JLabel("Register Here");
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setFont(new Font("DIALOG", Font.PLAIN, 15));
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.setForeground(color.TEXT_COLOR);

        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               loginForm.this.dispose();

               new RegisterForm().setVisible(true);
            }
        });
        registerLabel.setBounds(125, 610, 250, 30);
        
        add(registerLabel);




    }   
}