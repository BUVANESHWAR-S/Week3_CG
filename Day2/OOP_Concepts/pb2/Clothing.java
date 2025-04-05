package Day2.OOP_Concepts.pb2;

public class Clothing extends Product implements Taxable {
    private int Discount;
    private int tax;

    Clothing(int ProductId, String Name, int Price) {
        super(ProductId, Name, Price);
    }

    @Override
    public int Calculate_Discount() {
        int Price = getPrice();
        Discount = Price * 20 / 100;
        return Discount;
    }

    public int getDiscount() {
        Calculate_Discount();
        return Discount;
    }

    @Override
    public int CalculateTax() {
        int price = getPrice();
        tax = price * 7 / 100;
        return tax;
    }

    @Override
    public int getTax() {
        CalculateTax();
        return tax;
    }
    @Override
    public String toString(){
        return getProductId()+", "+getName()+", "+get_actual_price();
    }

    public int get_actual_price() {
        return getPrice() + getTax() - getDiscount();
    }
}
