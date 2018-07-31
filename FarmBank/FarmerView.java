package FarmBank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class FarmerView extends FarmBank {

    private JFrame frame;
    private Farmer farmer;
    private JComboBox products;
    private JTextField info2;
    private JComboBox units;
    private JTextField price2;
    private JTextField amount2;
    private JPanel items;
    private int amnt;
    private double prc;


    public FarmerView(Farmer farmer){
        this.farmer = farmer;
        farmView();
    }

    public void farmView(){
        frame = new JFrame("Farmer View");
        frame.setSize(new Dimension(1250, 750));
        frame.setLayout(new BorderLayout());
        frame.setLocation(170,75);


        JPanel uppanel = new JPanel();
        uppanel.setBackground(Color.LIGHT_GRAY);
        frame.add(uppanel, BorderLayout.NORTH);

        JLabel balance = new JLabel("Balance: " + farmer.getFarmbalance() + "    ");
        uppanel.add(balance);

        JLabel username = new JLabel(farmer.getUsername() + "    ");
        uppanel.add(username);

        JLabel name = new JLabel(farmer.getName() + " " + farmer.getSurname() + "    ");
        uppanel.add(name);


        JButton quit = new JButton("QUIT");
        uppanel.add(quit, BorderLayout.EAST);

        quit.addActionListener(q2 ->{
            frame.setVisible(false);
        } );


        JPanel mainpanel = new JPanel();
        mainpanel.setBackground(Color.WHITE);
        mainpanel.setLayout(new BorderLayout());
        

        JPanel mainpanel2 = new JPanel();
        mainpanel2.setBackground(Color.GREEN);
        mainpanel.add(mainpanel2, BorderLayout.EAST);

        JLabel orderlabel = new JLabel("Orders That Have Been Taken");
        mainpanel2.add(orderlabel);

        JLabel orders = new JLabel();
        mainpanel2.add(orders);

        JTabbedPane tabbedPane = new JTabbedPane();
        frame.add(tabbedPane);

        tabbedPane.addTab("ACCOUNT", null, mainpanel, "You can see your Account");

        JPanel additem = new JPanel();
        additem.setLayout(null);
        additem.setBackground(Color.WHITE);

        tabbedPane.addTab("CREATE ITEM",null, additem, "You can create items");

        JLabel type = new JLabel("Product Type");
        type.setBounds(50,30,150,30);
        additem.add(type);

        String [] productTypes = {"Cheese", "Milk", "Eggs", "Meat", "Chicken", "Butter", "Vegetables", "Fruits"};

        products = new JComboBox(productTypes);
        products.setBounds(205,30,150,40);
        products.setSelectedIndex(0);

        additem.add(products);

        JLabel info = new JLabel("Description: ");
        info.setBounds(50,100,150,30);
        additem.add(info);

        info2 = new JTextField("");
        info2.setBounds(205,100,250,50);
        additem.add(info2);

        JLabel amount = new JLabel("Amount");
        amount.setBounds(50,180,150,30);
        additem.add(amount);

        amount2 = new JTextField("Enter the Amount");
        amount2.setBounds(205,180,100,30);
        additem.add(amount2);

        String [] unit = {"kg", "piece", "liter"};

        units = new JComboBox(unit);
        units.setBounds(315,180,75,40);
        additem.add(units);

        JLabel price = new JLabel("Price:");
        price.setBounds(50,250,150,30);
        additem.add(price);

        price2 = new JTextField("Enter the Price");
        price2.setBounds(205,250,100,30);
        additem.add(price2);

        JButton create = new JButton("Create");
        create.setBounds(250,350,100,50);
        additem.add(create);


        items = new JPanel();
        items.setBounds(800,100,450,650);
        items.setBackground(Color.YELLOW);

        JLabel items2 = new JLabel("        --------    Created Items    --------        ");
        items2.setBounds(900,120, 200,20);
        items.add(items2);

        create.addActionListener(new FarmerViewListener());

        for(Object pr: farmer.getmyProducts()){
            items.add(new JLabel(pr.toString()));
        }
        additem.add(items);




        frame.setVisible(true);
    }

    class FarmerViewListener extends FarmBank implements ActionListener{

        int x = 800;
        int y = 150;

        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            if (source.getText().equals("Create")) {
                String item = (String) products.getSelectedItem();
                String descriptn = info2.getText();
                String unit = (String)units.getSelectedItem();
                try {
                    amnt = Integer.parseInt(amount2.getText());
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Please Enter an Integer");
                }
                try {
                    prc = Double.parseDouble(price2.getText());
                    Product product1 = new Product(item, descriptn, amnt, unit, prc);
                    addProduct(product1);
                    farmer.getmyProducts().add(product1);
                    JLabel label = new JLabel(getproductArray().get(getproductArray().size() - 1).toString());
                    label.setBounds(x, y, 250, 30);
                    items.add(label);
                    y += 30;
                }catch (NumberFormatException ex2){
                    JOptionPane.showMessageDialog(null,"Please Enter a Double");
                }





            }
        }
    }


}
