package FarmBank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AccountLogin extends JFrame {

    private Account acc;

    public AccountLogin(Account acc) {
        this.acc = acc;
        accountLogin();

    }

    public void accountLogin(){
        JFrame frame = new JFrame("Login");
        int width = 400;
        int height = 400;
        frame.setSize(new Dimension(width, height));

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel username = new JLabel("Username: ");
        panel.add(username);
        username.setBounds(30, 50, 120, 30);


        JTextField username2 = new JTextField("Enter Your Username");
        panel.add(username2);
        username2.setBounds(100, 50, 150, 30);

        JLabel password = new JLabel("Password: ");
        panel.add(password);
        password.setBounds(30, 100, 120, 30);

        JTextField password2 = new JTextField("Enter Your Password");
        panel.add(password2);
        password2.setBounds(100, 100, 150, 30);


        JButton enter = new JButton("Enter");
        panel.add(enter);
        enter.setBounds(width/2 - 50 , height / 2, 100, 50);

        enter.addActionListener(new LoginListener(acc, null, username2, password2, frame));


        frame.setVisible(true);
    }


}