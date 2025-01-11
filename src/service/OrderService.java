package service;

import entity.Customer;
import entity.Order;
import entity.OrderStatus;
import entity.Pizzeria;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderService {

    private Order currentOrder;
    private Customer currentCustomer;
    private final Pizzeria pizzeria;
    private long orderNumber;
    private final Scanner scanner = new Scanner(System.in);

    public OrderService(Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
    }

    public void createCustomer() {
        System.out.println("Введите имя: ");
        currentCustomer = new Customer(scanner.nextLine());
    }

    public void addToOrder(int index) {
        if (currentOrder == null) {
            currentOrder = new Order(orderNumber++,
                    OrderStatus.NEW,
                    currentCustomer,
                    new ArrayList<>());
        }
        var product = pizzeria.getMenuStorage().getProductById(index);
        currentOrder.addProduct(product);
    }

    public void printOrder() {
        System.out.println(currentOrder.getProducts());
    }

    public void removeFromOrder(int index) {
        currentOrder.removeProduct(--index);
    }

    public void cleanOrder() {
        currentOrder.removeAllProducts();
        System.out.println("Текущий заказ пуст.");
    }

    public void sendOrder() {
        pizzeria.addOrder(currentOrder);
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
