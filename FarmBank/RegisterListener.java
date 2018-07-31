package FarmBank;

import javax.swing.*;
import java.awt.event.*;

public class RegisterListener extends FarmBank implements ActionListener {

    private JTextField username;
    private JTextField name;
    private JTextField surname;
    private JTextField password;
    private JTextField password_again;
    private JTextField listoflocations;
    private String username2;
    private String name2;
    private String surname2;
    private String password2;
    private String password_again2;
    private String listoflocat;
    private Account acc;
    public JFrame frame;
    public static Customer customer;
    public static Farmer farmer;

    public RegisterListener(JTextField username, JTextField name, JTextField surname, JTextField password, JTextField password_again,
                            JTextField listoflocations, Account acc, JFrame frame) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.password_again = password_again;
        this.listoflocations = listoflocations;
        this.acc = acc;
        this.frame = frame;
    }


    public void actionPerformed(ActionEvent e) {
        if (acc instanceof Customer) {
            registerer();
            customer = new Customer(username2, name2, surname2, password2, password_again2, listoflocat);
            customerDataBase(customer);
            frame.setVisible(false);

        }
        if (acc instanceof Farmer) {
            registerer();
            farmer = new Farmer(username2, name2, surname2, password2, password_again2, listoflocat);
            farmerDataBase(farmer);
            frame.setVisible(false);

        }
    }

    public void registerer() {
        username2 = username.getText();
        name2 = name.getText();
        surname2 = surname.getText();
        password2 = password.getText();
        password_again2 = password_again.getText();
        listoflocat = listoflocations.getText();
    }


}

