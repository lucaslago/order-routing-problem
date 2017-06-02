import java.util.ArrayList;
import java.util.List;

public class Order {
    String shippingMethod;
    String strategy;
    List<Product> products;

    public Order(){
        this.products = new ArrayList<>();
    }

    public Order(String shippingMethod, String strategy){
        this.shippingMethod = shippingMethod;
        this.strategy = strategy;
    }
}
