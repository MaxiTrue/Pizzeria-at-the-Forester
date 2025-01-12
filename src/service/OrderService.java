package service;

import entity.Customer;
import entity.Order;
import entity.OrderStatus;
import entity.Product;
import storage.OrderStorage;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class OrderService {
    private Order currentOrder;
    private Customer currentCustomer;

    private final OrderStorage orderStorage;

    private long orderNumber;

    public OrderService() {
        orderStorage = new OrderStorage();
    }

    public Order getOrderById(UUID id) {
        return orderStorage.getOrder(id);
    }

    public void createCustomer(String name) {
        currentCustomer = new Customer(name);
    }

    public void addToOrder(Product product) {
        if (currentOrder == null) {
            currentOrder = new Order(
                    orderNumber++,
                    OrderStatus.NEW,
                    currentCustomer,
                    new ArrayList<>());
        }

        currentOrder.addProduct(product);
    }

    public void removeFromOrder(Product product) {
        currentOrder.removeProduct(product);
    }

    public void printOrder() {
        System.out.println(currentOrder.getProducts());
    }

    public void cleanOrder() {
        currentOrder.removeAllProducts();
        System.out.println("Текущий заказ пуст.");
    }

    public void sendOrder() {
        //pizzeria.addOrder(currentOrder);
        currentOrder.setStatus(OrderStatus.IN_PROGRESS);
        System.out.println("Заказ успешно оформлен!");
    }

    public boolean checkOrderStatus() {
        if (currentOrder == null) {
            System.out.println("Вы не создали заказ");
            return false;
        } else {
            return true;
        }
    }
}
