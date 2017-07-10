package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String shippingMethod;
    private String strategy;
    private List<Product> products;

    public Order(){
        this.setProducts(new ArrayList<>());
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
