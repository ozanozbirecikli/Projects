package FarmBank;

import Exercises.Farm;

import javax.swing.*;
import java.awt.event.*;

import static FarmBank.RegisterListener.customer;
import static FarmBank.RegisterListener.farmer;


public class LoginListener extends FarmBank implements ActionListener {


    private JTextField username;
    private JTextField password;
    private JFrame frame;
    private Account acc;
    private Account acc2;

    public LoginListener(Account acc, Account acc2, JTextField username, JTextField password, JFrame frame) {
        this.acc = acc;
        this.username = username;
        this.password = password;
        this.frame = frame;
        this.acc2 = acc2;
    }

    public void actionPerformed(ActionEvent e) {
        if (acc instanceof Account && (FarmBankchecker(username, password))) {
            FarmBankAccount farmbank = new FarmBankAccount();
            frame.setVisible(false);
        }
        if (acc instanceof Farmer) {
            if (checker(acc, username, password) == true) {
                FarmerView view2 = new FarmerView((Farmer) login(acc, username, password));
                frame.setVisible(false);
            } else
                JOptionPane.showMessageDialog(null, "Wrong Username or Password");
        }
        if (acc instanceof Customer) {
            if (checker(acc, username, password) == true) {
                CustomerView view2 = new CustomerView((Customer) login(acc, username, password));
                frame.setVisible(false);
            } else
                JOptionPane.showMessageDialog(null, "Wrong Username or Password");
        }

    }
}



