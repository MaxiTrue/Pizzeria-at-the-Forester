package api;

import entity.Order;
import entity.OrderStatus;
import entity.Pizzeria;

import java.util.Scanner;

public class MainDisplay {

    private final Scanner scanner = new Scanner(System.in);
    private final Pizzeria pizzeria;
    private final AdminDisplay adminDisplay;
    private final OrderDisplay orderDisplay;

    public MainDisplay(Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
        this.adminDisplay = new AdminDisplay(pizzeria);
        this.orderDisplay = new OrderDisplay(pizzeria);
    }

    public void executeDisplay() {
        System.out.println("Добро пожаловать в пиццерию по адресу: " + pizzeria.getAddress());
        while (true) {
            printCommandList();

            var menuNumber = Integer.parseInt(scanner.nextLine());
            switch (menuNumber) {
                case 0:
                    System.out.println("Ждём вас снова");
                    System.exit(0);
                case 1:
                    System.out.println(pizzeria.getMenu());
                    break;
                case 2:
                    orderDisplay.executeDisplay();
                    break;
                case 3:
                    if (pizzeria.getOrders().isEmpty()) {
                        System.out.println("    Ожидаем ваши заказы");
                        break;
                    }
                    System.out.printf("%-3s | %-15s | %s %n",
                            "№",
                            "Имя",
                            "Статус");
                    for (Order order : pizzeria.getOrders()) {
                        if (order.getStatus() == OrderStatus.CANCELED || order.getStatus() == OrderStatus.ISSUED)
                            continue;
                        System.out.printf("%-3d | %-15s | %s %n",
                                order.getNumber(),
                                order.getCustomer().name(),
                                order.getStatus());
                    }
                    break;
                case 4:
                    adminDisplay.executeDisplay();
                    break;
                default:
                    System.out.println("Нет такой команды!");
            }
        }
    }

    private void printCommandList() {
        System.out.println("""
                0. Покинуть заведение
                1. Меню
                2. Мой заказ
                3. Табло заказов
                
                4. Я сотрудник
                """); // представим что обычный пользователь не сможет попасть во вкладку сотрудника(там аутентификация)
    }
}
