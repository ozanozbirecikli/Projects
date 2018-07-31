package FarmBank;

import javax.swing.*;
import java.awt.*;

public class  Openingscreen {
    public static void main(String[] args){
        JFrame frame = new JFrame("Farm Bank");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(350,200));
        frame.setLocation(550,300);
        frame.setLayout(new FlowLayout());

        JPanel userpanel = new JPanel();
        frame.add(userpanel, BorderLayout.CENTER);
        userpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JRadioButton login = new JRadioButton("Login");
        JRadioButton register = new JRadioButton("Register");
        ButtonGroup group1 = new ButtonGroup();
        group1.add(login);
        group1.add(register);


        userpanel.add(login);
        userpanel.add(register);

        JButton customer = new JButton("Customer");
        userpanel.add(customer);

        JButton farmer = new JButton("Farmer");
        userpanel.add(farmer);

        OpeningScreenListener listener = new OpeningScreenListener(register, login, customer, farmer);



        customer.addActionListener(listener);
        farmer.addActionListener(listener);



        frame.setVisible(true);
    }
}
