package Day2.OOP_Concepts.pb2;

public abstract class Product {
    private int ProductId;
    private String Name;
    private int Price;

    public Product(int ProductId, String Name, int Price){
        this.Name = Name;
        this.ProductId = ProductId;
        this.Price = Price;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
    @Override
    public String toString(){
        return ProductId + ", "+Name+", ";
    }

    public abstract int Calculate_Discount();
}
interface  Taxable {
    int CalculateTax();
    int getTax();
}
