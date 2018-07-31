package FarmBank;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerView extends FarmBank {

    private Customer customer;
    private JFrame frame;
    private JComboBox farmers;
    private JList<String> productlist;
    private String[] prdcts;
    private DefaultListModel <String> listModel;
    private JPanel mainpanel2;
    private int text;


    public CustomerView(Customer customer) {
        this.customer = customer;
        custView();
    }


    public void custView() {
        frame = new JFrame("Customer View");
        frame.setSize(new Dimension(1250, 750));
        frame.setLayout(new BorderLayout());
        frame.setLocation(170, 75);

        JPanel uppanel = new JPanel();
        uppanel.setBackground(Color.LIGHT_GRAY);
        frame.add(uppanel, BorderLayout.NORTH);

        JLabel balance2 = new JLabel("Balance: " + customer.getCustBalance() + "    ");
        uppanel.add(balance2);

        JLabel username = new JLabel(customer.getUsername() + "    ");
        uppanel.add(username);

        JLabel name = new JLabel(customer.getName() + " " + customer.getSurname() + "    ");
        uppanel.add(name);

        JLabel location = new JLabel("Location: " + customer.getListoflocations());
        uppanel.add(location);

        JButton quit = new JButton("QUIT");
        uppanel.add(quit, BorderLayout.EAST);

        quit.addActionListener(q1 -> {
            frame.setVisible(false);
        });

        JPanel mainpanel = new JPanel();
        mainpanel.setBackground(Color.WHITE);
        frame.add(mainpanel, BorderLayout.CENTER);
        mainpanel.setLayout(null);

        JButton deposit = new JButton("Deposit");
        mainpanel.add(deposit);
        deposit.setBounds(500, 30, 100, 30);

        deposit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                JFrame dframe = new JFrame();
                dframe.setSize(new Dimension(500, 300));
                dframe.setLocation(250, 250);

                JPanel dpanel = new JPanel();
                dframe.add(dpanel);
                dpanel.setLayout(null);

                JLabel amount = new JLabel("Enter The Amount");
                amount.setBounds(50, 50, 150, 50);
                dpanel.add(amount);

                JTextField amount2 = new JTextField();
                amount2.setBounds(200, 50, 150, 50);
                dpanel.add(amount2);

                JButton enter = new JButton("Enter");
                enter.setBounds(225, 150, 100, 50);
                dpanel.add(enter);


                enter.addActionListener(a -> {
                    double amount3 = Double.parseDouble(amount2.getText());
                    double balance = customer.getCustBalance();
                    balance += amount3;
                    customer.setCustbalance(balance);
                    balance2.setText("Balance: " + customer.getCustBalance() + "    ");
                    dframe.setVisible(false);
                });

                dframe.setVisible(true);
            }
        });



        ArrayList<String> frms = new ArrayList<>();
        for (Farmer f : getFarmerList()) {
            if (customer.getListoflocations().equals(f.getListoflocations())) {
                frms.add(f.getName() + " " + f.getSurname());

            }

        }

        String[] frms2 = new String[frms.size()];
        for (int i = 0; i < frms2.length; i++) {
            frms2[i] = frms.get(i);
        }

        JLabel buy = new JLabel("Order Product");
        mainpanel.add(buy);
        buy.setBounds(150, 50, 200, 30);

        farmers = new JComboBox(frms2);
        farmers.setBounds(150, 100, 250, 40);
        mainpanel.add(farmers);

        prdcts = new String[getproductArray().size()];

        farmers.addActionListener(e -> {

                    listModel.removeAllElements();

            String selected = (String)farmers.getSelectedItem();

            for(Farmer fr: getFarmerList()){
                String f = fr.getName() + " " + fr.getSurname();
                if(f.equals(selected)){
                    for(int i =0; i<fr.getmyProducts().size(); i++){
                        prdcts[i] = fr.getmyProducts().get(i).toString();
                        listModel.addElement(prdcts[i]);
                    }
                }
            }
        });



         listModel = new DefaultListModel<>();
        productlist = new JList(listModel);
        productlist.setBounds(100,200,500,350);
        productlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productlist.setLayoutOrientation(JList.VERTICAL);
        productlist.setVisibleRowCount(10);


        JScrollPane listScroller = new JScrollPane(productlist);
        listScroller.setPreferredSize(new Dimension(250,80));

        mainpanel.add(productlist);

        JButton order = new JButton("Order");
        order.setBounds(650,200,100,30);
        mainpanel.add(order);

        JButton remove = new JButton("Remove");
        remove.setBounds(650, 250, 100, 30);
        mainpanel.add(remove);

        remove.addActionListener(e ->{

            mainpanel2.removeAll();
        });

        order.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                JFrame frame2 = new JFrame("Order");
                frame2.setLocation(300,300);
                frame2.setSize(new Dimension(500,300));

                JPanel amount = new JPanel();
                frame2.add(amount);
                JLabel amount2 = new JLabel("Enter The Amount");
                amount2.setSize(new Dimension(50, 100));
                amount.add(amount2);

                JTextField amnt = new JTextField(" Enter The Amount You Want to Order ");
                amnt.setSize(360, 100);
                amount.add(amnt);

                JButton enteramnt = new JButton("Enter");
                amount.add(enteramnt);

                frame2.setVisible(true);

                enteramnt.addActionListener(a -> {
                    String selected = productlist.getSelectedValue();
                    String selected2 =(String)farmers.getSelectedItem();
                    for(Farmer f: getFarmerList()){
                        if((f.getName() + " " + f.getSurname()).equals(selected2)){
                            for(int i =0; i< f.getmyProducts().size(); i++){
                            if(f.getmyProducts().get(i).toString().equals(selected)){
                                try {
                                    text = Integer.parseInt(amnt.getText());
                                }catch (NumberFormatException ex){
                                        JOptionPane.showMessageDialog(null, "Please Enter an Integer");
                                    }
                                if(text > f.getAmnt(i)){
                                    JOptionPane.showMessageDialog(null, "There is not available product exist that you want");
                                }
                                else{
                                    if(customer.getCustBalance() < f.getMyPrice(i)* text){
                                        JOptionPane.showMessageDialog(null, "you don't have enough money to order this product");
                                    }
                                    else{
                                        f.setMyProductsAmnt(i,text);
                                        String item = f.getInfo2(i);
                                        mainpanel2.add(new JLabel(item + "Amount: " + text + " - Price:  " + f.getMyPrice(i)* text + "TL"));
                                        double cost = text * f.getMyPrice(i);
                                        customer.setRemoveBalance(cost);
                                        double profit = (cost*2) /100;
                                        f.setFarmbalance(cost - profit);
                                        FarmBankAccount.setBalance(profit);
                                        balance2.setText("Balance: " + customer.getCustBalance() + "    ");
                                    }
                                }
                                }
                            }
                        }
                        }

                    frame2.setVisible(false);
                });

            }

        });



        mainpanel2 = new JPanel();
        mainpanel2.setBackground(Color.GREEN);
        mainpanel2.setLayout(new GridLayout(25, 1));
        frame.add(mainpanel2, BorderLayout.EAST);



        JLabel orderlabel = new JLabel("    Previous Orders    ");
        mainpanel2.add(orderlabel);



        frame.setVisible(true);
    }

}