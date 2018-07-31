package FarmBank;


import java.util.ArrayList;

public class Farmer extends Account {


    private double farmbalance;
    private ArrayList<Product> myProducts = new ArrayList<Product>();
    public Farmer() {

    }

    public Farmer(String username, String name, String surname, String password, String password_again, String listoflocations) {
        super(username, name, surname, password, password_again, listoflocations);
        this.farmbalance = 0;
        System.out.println("Farmer has been registered");

    }
    public double getFarmbalance() {
        return farmbalance;
    }

    public void setFarmbalance(double d){
        farmbalance +=d;
    }

    public String toString() {
        return super.toString();
    }
    public ArrayList getmyProducts() {
        return myProducts;
    }
    public void setMyProductsAmnt(int n, int a){
        myProducts.get(n).setAmount(a);
    }

    public String getInfo2(int n){
        return myProducts.get(n).getInfo();
    }

    public int getAmnt(int n){
        return myProducts.get(n).getAmount();
    }

    public double getMyPrice(int n){
        return  myProducts.get(n).getPrice();
    }
}
