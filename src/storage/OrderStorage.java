package storage;

import entity.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OrderStorage {
    private final Map<Long, Order> orders;

    public OrderStorage() {
        this.orders = new HashMap<>();
    }

    public void addOrder(Order order) {
        this.orders.put(order.getNumber(), order);
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }

    public Order getOrder(UUID id) {
        return orders.values().stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Заказ не найден");
                    return null;
                });
    }
}
