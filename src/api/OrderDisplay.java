package api;

import entity.Pizzeria;
import service.OrderService;

import java.util.Scanner;

public class OrderDisplay {
    private final OrderService orderService;
    private final Scanner scanner = new Scanner(System.in);

    public OrderDisplay(Pizzeria pizzeria) {
        this.orderService = new OrderService(pizzeria);
    }

    public void executeDisplay() {
        orderService.createCustomer();
        while (true) {
            printCommandList();
            var menuNumber = scanner.nextInt();
            switch (menuNumber) {
                case 0:
                    return;
                case 1:
                    System.out.println("Введите id продукта: ");
                    orderService.addToOrder(scanner.nextInt());
                    orderService.printOrder();
                    break;
                case 2:
                    if(orderService.checkOrderStatus()) {
                        orderService.printOrder();
                        System.out.println("Выберите позицию, которую нужно убрать: ");
                        orderService.removeFromOrder(scanner.nextInt());
                    }
                    break;
                case 3:
                    if (orderService.checkOrderStatus()) {
                        orderService.cleanOrder();
                    }
                    break;
                case 4:
                    if (orderService.checkOrderStatus()) {
                        orderService.sendOrder();
                    }
                    break;
                default:
                    System.out.println("Такой команды нет!");
            }
        }
    }

    private void printCommandList() {
        System.out.println("""
                0. Вернуться в главное меню
                1. Добавить в заказ
                2. Убрать из заказа
                3. Очистить заказ
                4. Оформить заказ
                """);
    }
}
