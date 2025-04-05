package Day2.OOP_Concepts.pb2;

public class pb2 {

    public static void main(String[] args) {
        Electronics elec = new Electronics(1, "Bulb", 400);
        Clothing cloth1 = new Clothing(2, "Shirt", 2000);
        Groceries Groc = new Groceries(3, "Biscuit", 20);
        System.out.println(elec.toString());
        System.out.println(cloth1.toString());
        System.out.println(Groc.toString());
    }
}
