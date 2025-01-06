package entity;

import java.math.BigDecimal;

public class Product {
    private final int id;
    private final String name;
    private final String description;
    private final ProductCategory category;
    private final BigDecimal price;

    public Product(int id, String name, String description, ProductCategory category, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
