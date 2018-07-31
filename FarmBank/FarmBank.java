package FarmBank;

import javax.swing.*;
import java.util.ArrayList;

public class FarmBank {

    private static ArrayList<Farmer> farmerList = new ArrayList<>();
    private static ArrayList<Customer> customerList = new ArrayList<>();
    private static ArrayList<Product> productList = new ArrayList<>();


    public void farmerDataBase(Farmer acc) {
        if (!farmerList.contains(acc))
            farmerList.add(acc);
    }

    public void customerDataBase(Customer acc) {
        if (!customerList.contains(acc))
            customerList.add(acc);
    }

    public void addProduct(Product product) {
        productList.add(product);

    }

    public ArrayList getproductArray() {
        return productList;
    }

    public static ArrayList<Farmer> getFarmerList() {
        return farmerList;
    }

    public static ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public boolean checker(Account acct, JTextField Jusername, JTextField Jpassword) {
        if (acct instanceof Farmer) {
            for (Farmer farmer : farmerList) {
                if (farmer.getUsername().equals(Jusername.getText()) && farmer.getPassword().equals(Jpassword.getText())) {
                    return true;
                }
            }
        }

        if (acct instanceof Customer) {
            for (Customer customer : customerList) {
                if (customer.getUsername().equals(Jusername.getText()) && customer.getPassword().equals(Jpassword.getText())) {
                    return true;
                }
            }
        }


        return false;
    }

    public boolean FarmBankchecker(JTextField Jusername, JTextField Jpassword) {
        if (Jusername.getText().equals("FarmBank") && Jpassword.getText().equals("farmbank")) {
            return true;
        }
        return false;
    }

    public Account login(Account acct, JTextField Jusername, JTextField Jpassword) {
        if (acct instanceof Farmer) {
            for (Farmer farmer : farmerList) {
                if (farmer.getUsername().equals(Jusername.getText()) && farmer.getPassword().equals(Jpassword.getText())) {
                    return farmer;
                }
            }
        }
        if (acct instanceof Customer) {
            for (Customer customer : customerList) {
                if (customer.getUsername().equals(Jusername.getText()) && customer.getPassword().equals(Jpassword.getText())) {
                    return customer;
                }
            }
        }
        return null;
    }
}





