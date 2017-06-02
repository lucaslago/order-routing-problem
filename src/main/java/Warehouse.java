import java.util.List;

public class Warehouse {
    String name;
    String product;
    int quantity;
    List<String> shippingMethods;
    int capacity;

    public Warehouse(String name, List<String> shippingMethods, int capacity){
        this.name = name;
        this.shippingMethods = shippingMethods;
        this.capacity = capacity;
    }

    public Warehouse(String name, String product, int quantity){
        this.name = name;
        this.product = product;
        this.quantity = quantity;
    }

    public Warehouse(){

    }
}
