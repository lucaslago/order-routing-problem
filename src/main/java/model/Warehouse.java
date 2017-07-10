package model;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private String name;
    private List<Product> products;
    private List<String> shippingMethods;
    private int capacity;

    public Warehouse(String name, List<String> shippingMethods, int capacity){
        this.setName(name);
        this.setShippingMethods(shippingMethods);
        this.setCapacity(capacity);
        this.setProducts(new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<String> getShippingMethods() {
        return shippingMethods;
    }

    public void setShippingMethods(List<String> shippingMethods) {
        this.shippingMethods = shippingMethods;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
