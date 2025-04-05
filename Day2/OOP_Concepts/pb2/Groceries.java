package Day2.OOP_Concepts.pb2;

public class Groceries extends Product implements Taxable{
    private int Discount;
    private int tax;
    Groceries(int ProductId, String Name, int Price){
        super(ProductId, Name, Price);
    }
    @Override
    public int Calculate_Discount(){
        int Price = getPrice();
        Discount = Price*25/100;
        return Discount;
    }
    public int getDiscount(){
        Calculate_Discount();
        return Discount;
    }

    @Override
    public int CalculateTax() {
        int price = getPrice();
        tax = price*3/100;
        return tax;
    }
    @Override
    public int getTax(){
        CalculateTax();
        return tax;
    }
    @Override
    public String toString(){
        return getProductId()+", "+getName()+", "+get_actual_price();
    }

    public int get_actual_price(){
        return getPrice() + getTax() - getDiscount();
    }
}
