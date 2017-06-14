import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    String name;
    List<Product> products;
    List<String> shippingMethods;
    int capacity;

    public Warehouse(String name, List<String> shippingMethods, int capacity){
        this.name = name;
        this.shippingMethods = shippingMethods;
        this.capacity = capacity;
        this.products = new ArrayList<>();
    }

    public Warehouse(String name, List<Product> products){
        this.name = name;
        this.products = products;
    }

    public Warehouse(){

    }
}
