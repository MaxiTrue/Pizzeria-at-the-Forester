package entity;

import java.util.List;

public class MenuStorage {
    private List<Product> products;

    private String description;

    public MenuStorage(List<Product> products) {
        this.products = products;
        this.description = menuToString();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        this.description = menuToString();
    }

    public String getDescription() {
        return description;
    }

    private String menuToString() {
        return "";
    }
}
