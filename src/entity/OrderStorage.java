package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderStorage {
    private final List<Order> orders;

    public OrderStorage() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public Order getOrder(UUID id) {
        return orders.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Заказ не найден");
                    return null;
                });
    }
}
