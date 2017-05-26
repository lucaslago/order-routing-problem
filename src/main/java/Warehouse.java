import java.util.List;

public class Warehouse {
    String name;
    String product;
    int quantity;
    List<String> shippingMethods;

    public Warehouse(String name, List<String> shippingMethods){
        this.name = name;
        this.shippingMethods = shippingMethods;
    }

    public Warehouse(String name, String product, int quantity){
        this.name = name;
        this.product = product;
        this.quantity = quantity;
    }
}
