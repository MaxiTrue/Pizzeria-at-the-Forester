package entity;

import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID id;
    private final Long number; // в рамках дня
    private OrderStatus status;
    private final Customer customer;
    private final List<Product> products;

    public Order(Long number, OrderStatus status, Customer customer, List<Product> products) {
        this.id = generateUUID();
        this.number = number;
        this.status = status;
        this.customer = customer;
        this.products = products;
    }

    public UUID getId() {
        return id;
    }

    public Long getNumber() {
        return number;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    private UUID generateUUID() {
        return UUID.randomUUID();
    }
}
