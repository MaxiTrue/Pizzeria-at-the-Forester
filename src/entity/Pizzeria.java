package entity;

import service.MenuService;
import service.OrderService;

import java.util.UUID;

public class Pizzeria {
    private final String address;
    private final MenuService menuService;
    private final OrderService orderService;

    public Pizzeria(String address) {
        this.address = address;

        this.menuService = new MenuService();
        this.orderService = new OrderService();
    }

    public String getAddress() {
        return address;
    }

    // Методы для работы с сущностью Menu
    public String getMenu() {
        return menuService.getMenu();
    }

    public void reloadMenu() {
        menuService.reloadMenu();
    }

    // Методы для работы с сущностью Product
    public Product getProductById(int productId) {
        return menuService.getProductById(productId);
    }

    // Методы для работы с сущностью Order
    public Order getOrderById(UUID id) {
        return orderService.getOrderById(id);
    }

    public void addProductToOrder(int productId) {
        var product = menuService.getProductById(productId);

        if (product != null) {
            orderService.addToOrder(product);
        } else {
            System.out.printf("Продукт с id - %d не существует или не доступен", productId);
        }
    }

    public void removeFromOrder(int productId) {
        var product = menuService.getProductById(productId);

        if (product != null) {
            orderService.removeFromOrder(product);
        } else {
            System.out.printf("Продукт с id - %d не существует или не доступен\n", productId);
        }
    }

    public void sendOrder() {
        orderService.sendOrder();
    }
    public void cleanOrder() {
        orderService.cleanOrder();
    }

    public void printOrder() {
        orderService.printOrder();
    }

    public boolean isOrderExists() {
        return orderService.checkOrderStatus();
    }

    public void createCustomerFromOrder(String name){
        orderService.createCustomer(name);
    }

}
