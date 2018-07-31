package FarmBank;

import javax.swing.*;
import java.awt.event.*;


public class OpeningScreenListener implements ActionListener {

    private JRadioButton register;
    private JRadioButton login;
    private JButton customer;
    private JButton farmer;



    public OpeningScreenListener(JRadioButton reg, JRadioButton log, JButton cust, JButton far){
        register = reg;
        login = log;
        customer = cust;
        farmer = far;
    }

    public void actionPerformed(ActionEvent e){
        JButton source = (JButton) e.getSource();
        if(login.isSelected() == true) {
             if (source.getText().equals("Customer")) {
                 System.out.println("Login selected");
                 Account fkcustomer = new Customer();
                 AccountLogin customer1 = new AccountLogin(fkcustomer);

            }
            if (source.getText().equals("Farmer")) {
                System.out.println("Login selected");
                Account fkfarmer = new Farmer();
                AccountLogin farmer1 = new AccountLogin(fkfarmer);

             }


        }
        if(register.isSelected() == true) {
            if (source.getText().equals("Farmer")) {
                System.out.println("Register selected");
                Account farmer = new Farmer();
                RegisterView view1 = new RegisterView(farmer);
            }
            if (source.getText().equals("Customer")) {
                System.out.println("Register selected");
                Account customer = new Customer();
                RegisterView view2 = new RegisterView(customer);
            }

        }

    }
}
