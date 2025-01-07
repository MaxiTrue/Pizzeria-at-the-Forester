package entity;

import java.util.ArrayList;
import java.util.List;


public class MenuStorage {
    private List<Product> products;
    private String description;

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

    public static MenuStorage createEmptyMenuStorage() {
        return new MenuStorage(new ArrayList<>());
    }


    private MenuStorage(List<Product> products) {
        this.products = products;
        this.description = menuToString();
    }

    private String menuToString() {
        StringBuilder sb = new StringBuilder();
        for (Product product : products) {
            sb.append(product.getId())
                    .append(". ")
                    .append(product.getName())
                    .append(" ")
                    .append(product.getPrice())
                    .append(" руб.\n");
        }
        return sb.toString();
    }
}
