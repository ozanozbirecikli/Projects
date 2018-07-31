package FarmBank;

public class Customer extends Account {

    private double balance;


    public Customer() {

    }

    public Customer(String username, String name, String surname, String password, String password_again, String location) {
        super(username, name, surname, password, password_again, location);
        this.balance = 0;
        System.out.println("Customer has been registered");
    }


    public double getCustBalance() {
        return balance;
    }

    public void setCustbalance(double b) {
        this.balance += b;
    }
    public void setRemoveBalance(double b){
        this.balance -= b;
    }

}
