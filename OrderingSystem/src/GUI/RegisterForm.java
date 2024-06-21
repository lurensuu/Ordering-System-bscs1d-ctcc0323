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

public class RegisterForm extends Form {
    public RegisterForm() {
        super("Register");
        addGuiComponents();
    }
    private void addGuiComponents(){
        JLabel registerLabel = new JLabel("Register");
        registerLabel.setBounds(0, 25, 520, 100);
        registerLabel.setForeground(color.TEXT_COLOR);
        registerLabel.setFont(new Font("Dialog", Font.BOLD, 40));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(registerLabel);
        
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
        passwordLabel.setBounds(30, 255, 400, 25);
        passwordLabel.setForeground(color.TEXT_COLOR);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(30, 285, 450, 55);
        passwordField.setBackground(color.SECONDARY_COLOR);
        passwordField.setForeground(color.TEXT_COLOR);
        passwordField.setFont(new Font("DIALOG", Font.PLAIN, 24));

        add(passwordLabel);
        add(passwordField);

        JLabel rePasswordLabel = new JLabel("Re-enter Password: ");
        rePasswordLabel.setBounds(30, 365, 400, 25);
        rePasswordLabel.setForeground(color.TEXT_COLOR);
        rePasswordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        JPasswordField rePasswordField = new JPasswordField();
        rePasswordField.setBounds(30, 395, 450, 55);
        rePasswordField.setBackground(color.SECONDARY_COLOR);
        rePasswordField.setForeground(color.TEXT_COLOR);
        rePasswordField.setFont(new Font("DIALOG", Font.PLAIN, 24));

        add(rePasswordLabel);
        add(rePasswordField);

        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("DIALOG", Font.PLAIN, 18));
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.setBackground(color.SECONDARY_COLOR);
        registerButton.setForeground(color.TEXT_COLOR);
        registerButton.setBounds(125, 520, 250, 50);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String rePassword = new String(rePasswordField.getPassword());

                if(validateUserInput(username, password, rePassword)){

                    if(MyData.register(username, password)){
                        RegisterForm.this.dispose();

                        loginForm loginForm = new loginForm();
                        loginForm.setVisible(true);

                        JOptionPane.showMessageDialog(loginForm, "Registered Account Succesfully!");

                    }else{
                        JOptionPane.showMessageDialog(RegisterForm.this, "This username is already taken");
                    }

                }else{
                    JOptionPane.showMessageDialog(RegisterForm.this, "Username must be atleast 6 characters \n" + 
                    "and/or Password must match");
                }
            }
        });

        add(registerButton);
        
        ImageIcon logoPic = new ImageIcon("./Image/Logo2.png");
        Image image = logoPic.getImage();
        Image resizedImage = image.getScaledInstance(460, 460, java.awt.Image.SCALE_SMOOTH);
        logoPic = new ImageIcon(resizedImage);
        JLabel logoLabel = new JLabel(logoPic);
        logoLabel.setBounds(580, 0, 300, 600);

        add(logoLabel);

        JLabel loginLabel = new JLabel("Login Here");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setFont(new Font("DIALOG", Font.PLAIN, 15));
        loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginLabel.setForeground(color.TEXT_COLOR);

        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               RegisterForm.this.dispose();

               new loginForm().setVisible(true);
            }
        });
        loginLabel.setBounds(125, 610, 250, 30);
        
        add(loginLabel);
    }

    private boolean validateUserInput(String username, String password, String rePassword){
        if(username.length() == 0 || password.length() == 0 || rePassword.length() == 0) return false;
        
        if(username.length() < 6) return false;

        if(!password.equals(rePassword)) return false;

        return true;
    }
}
