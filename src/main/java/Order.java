public class Order {
    String shippingMethod;
    String strategy;
    String product;
    int quantity;

    public Order(){

    }

    public Order(String shippingMethod, String strategy, String product, int quantity){
        this.shippingMethod = shippingMethod;
        this.strategy = strategy;
        this.product = product;
        this.quantity = quantity;
    }
}
