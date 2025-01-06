package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderStorage {
    private final List<Order> orders;

    public OrderStorage() {
        this.orders = new ArrayList<Order>();
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Order getOrder(UUID id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        System.out.println("Заказ не найден");
        return null;
    }
}
