package FarmBank;

import javax.swing.*;
import java.awt.*;

public class FarmBankAccount extends FarmBank{
    private Account farmbank;
    private static double balance = 0;

    public FarmBankAccount() {

        farmbank = new Account("FarmBank", "FarmBank", "Account", "farmbank", "farmbank", " ");
        farmbankview();

    }

    public void farmbankview() {
        JFrame frame = new JFrame("Farm Bank");
        frame.setSize(new Dimension(1250, 750));
        frame.setLayout(new BorderLayout());
        frame.setLocation(170, 75);

        JPanel uppanel = new JPanel();
        uppanel.setBackground(Color.LIGHT_GRAY);
        frame.add(uppanel, BorderLayout.NORTH);

        JLabel balance2 = new JLabel("Balance: " + balance);
        uppanel.add(balance2);

        JLabel username = new JLabel(farmbank.getUsername() + "    ");
        uppanel.add(username);

        JLabel name = new JLabel(farmbank.getName() + " " + farmbank.getSurname() + "    ");
        uppanel.add(name);

        JButton quit = new JButton("Quit");
        uppanel.add(quit, BorderLayout.CENTER);

        quit.addActionListener(q1 -> {
            frame.setVisible(false);
        });

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1,3));
        frame.add(center, BorderLayout.CENTER);

        JPanel productPanel = new JPanel();
        productPanel.setBounds(50, 100, 300, 500);
        JLabel products = new JLabel("        ----PRODUCTS----        ");
        productPanel.add(products);
        for (Object p : getproductArray()) {
            productPanel.add(new JLabel(p.toString()));
        }
        center.add(productPanel);

        JPanel farmerPanel = new JPanel();
        farmerPanel.setBounds(380, 100, 300, 500);
        JLabel farmers = new JLabel("        ----FARMERS----        ");
        farmerPanel.add(farmers);
        for (Farmer f : getFarmerList()) {
            farmerPanel.add(new JLabel(f.toString()));
        }
        center.add(farmerPanel);

        JPanel cstomerPanel = new JPanel();
        cstomerPanel.setBounds(710, 100, 300, 500);
        JLabel customers = new JLabel("        ----CUSTOMERS----        ");
        cstomerPanel.add(customers);
        for (Customer c : getCustomerList()) {
            cstomerPanel.add(new JLabel(c.toString()));
        }
        center.add(cstomerPanel);

        frame.setVisible(true);
    }
    public static void setBalance(double n){
        balance += n;
        System.out.println(balance);

    }

}


