package FarmBank;

import javax.swing.*;
import java.awt.*;

public class RegisterView extends JFrame {

    private JPanel mainpanel;
    private Account accountF;
    private Account accountC;
    public JFrame frame;

    public RegisterView(Account acc) {
        if (acc instanceof Farmer) {
            accountF = new Farmer();
            frame = new JFrame("Farmer Register");
            FarmerRegister();
            frame.setVisible(true);
        }

        if (acc instanceof Customer) {
            accountC = new Customer();
            frame = new JFrame("Customer Register");
            Customerregister();
            frame.setVisible(true);

        }
    }


    public void Customerregister() {


        frame.setSize(new Dimension(500, 500));
        frame.setLocation(70, 100);

        mainpanel = new JPanel();
        frame.add(mainpanel);
        mainpanel.setLayout(null);

        JLabel label1 = new JLabel("Username: ");
        label1.setBounds(20, 20, 100, 30);
        mainpanel.add(label1);

        JLabel label2 = new JLabel("Name: ");
        label2.setBounds(20, 60, 100, 30);
        mainpanel.add(label2);

        JLabel label3 = new JLabel("Surname: ");
        label3.setBounds(20, 100, 100, 30);
        mainpanel.add(label3);

        JLabel label4 = new JLabel("Password: ");
        label4.setBounds(20, 140, 100, 30);
        mainpanel.add(label4);

        JLabel label5 = new JLabel("Confirm Password:");
        label5.setBounds(20, 180, 120, 30);
        mainpanel.add(label5);

        JTextField username = new JTextField("Please Enter Your Username");
        username.setBounds(220, 20, 220, 30);
        mainpanel.add(username);


        JTextField name = new JTextField("Please Enter Your Name");
        name.setBounds(220, 60, 220, 30);
        mainpanel.add(name);


        JTextField surname = new JTextField("Please Enter Your Surname");
        surname.setBounds(220, 100, 220, 30);
        mainpanel.add(surname);


        JTextField password = new JTextField("Please Enter Your Password");
        password.setBounds(220, 140, 220, 30);
        mainpanel.add(password);

        JTextField password_again = new JTextField("Please Enter Your Password again");
        password_again.setBounds(220, 180, 220, 30);
        mainpanel.add(password_again);


        JCheckBox robot = new JCheckBox("I am not a robot");
        mainpanel.add(robot);
        robot.setBounds(20, 300, 200, 20);

        JLabel listofloc = new JLabel("Your Locations:");
        mainpanel.add(listofloc);
        listofloc.setBounds(20, 220, 100, 30);

        JTextField list = new JTextField("Enter Your Location");
        mainpanel.add(list);
        list.setBounds(220, 220, 220, 30);

        JButton enter = new JButton("Enter");
        enter.setBounds(200, 350, 100, 50);
        mainpanel.add(enter);


        enter.addActionListener(new RegisterListener(username, name, surname, password, password_again, list, accountC, frame));


    }



    public void FarmerRegister() {


        frame.setSize(new Dimension(500, 500));
        frame.setLocation(70, 100);

        mainpanel = new JPanel();
        frame.add(mainpanel);
        mainpanel.setLayout(null);

        JLabel label1 = new JLabel("Username: ");
        label1.setBounds(20, 20, 100, 30);
        mainpanel.add(label1);

        JLabel label2 = new JLabel("Name: ");
        label2.setBounds(20, 60, 100, 30);
        mainpanel.add(label2);

        JLabel label3 = new JLabel("Surname: ");
        label3.setBounds(20, 100, 100, 30);
        mainpanel.add(label3);

        JLabel label4 = new JLabel("Password: ");
        label4.setBounds(20, 140, 100, 30);
        mainpanel.add(label4);

        JLabel label5 = new JLabel("Confirm Password:");
        label5.setBounds(20, 180, 120, 30);
        mainpanel.add(label5);

        JTextField username = new JTextField("Please Enter Your Username");
        username.setBounds(220, 20, 220, 30);
        mainpanel.add(username);


        JTextField name = new JTextField("Please Enter Your Name");
        name.setBounds(220, 60, 220, 30);
        mainpanel.add(name);


        JTextField surname = new JTextField("Please Enter Your Surname");
        surname.setBounds(220, 100, 220, 30);
        mainpanel.add(surname);


        JTextField password = new JTextField("Please Enter Your Password");
        password.setBounds(220, 140, 220, 30);
        mainpanel.add(password);

        JTextField password_again = new JTextField("Please Enter Your Password again");
        password_again.setBounds(220, 180, 220, 30);
        mainpanel.add(password_again);


        JCheckBox robot = new JCheckBox("I am not a robot");
        mainpanel.add(robot);
        robot.setBounds(20, 300, 200, 20);


        JButton enter = new JButton("Enter");
        enter.setBounds(200, 350, 100, 50);
        mainpanel.add(enter);

        JLabel listofloc = new JLabel("List Of Locations:");
        mainpanel.add(listofloc);
        listofloc.setBounds(20, 220, 100, 30);

        JTextField list = new JTextField("Enter The List Of Locations");
        mainpanel.add(list);
        list.setBounds(220, 220, 220, 30);

        enter.addActionListener(new RegisterListener(username, name, surname, password, password_again, list, accountF, frame));


    }


}

