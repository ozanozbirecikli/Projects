package FarmBank;

public class Product extends FarmBank {

    private String Type;
    private String Description;
    private int Amount;
    private double Price;
    private String unit;

    public Product(String type, String description, int amount, String unit, double price){
        this.Type = type;
        this.Description = description;
        this.Amount = amount;
        this.Price = price;
        this.unit = unit;
    }
    public String toString(){
        return ("--------" + Type + " - " + Description + " - "  + Price + "TL" + " per " + unit + " Total amount: " + Amount + unit + "--------");
    }

    public int getAmount(){
        return Amount;
    }

    public void setAmount(int n){
        this.Amount -= n;
    }

    public String getInfo(){
        return this.Type + " - " + this.Description + " | " ;
    }
    public double getPrice(){
        return this.Price;
    }
}
