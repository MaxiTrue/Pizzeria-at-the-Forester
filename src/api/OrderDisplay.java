package api;

import entity.Pizzeria;

import java.util.Scanner;

public class OrderDisplay {
    private final Scanner scanner = new Scanner(System.in);
    private final Pizzeria pizzeria;

    public OrderDisplay(Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
    }

    public void executeDisplay() {
        System.out.print("Введите имя: \n");
        pizzeria.createCustomerFromOrder(scanner.nextLine());
        while (true) {
            printCommandList();
            var menuNumber = Integer.parseInt(scanner.nextLine());
            switch (menuNumber) {
                case 0:
                    return;
                case 1:
                    System.out.println(pizzeria.getMenu());
                    System.out.println("Введите id продукта: ");
                    pizzeria.addProductToOrder(Integer.parseInt(scanner.nextLine()));
                    pizzeria.printOrder();
                    break;
                case 2:
                    if (pizzeria.isOrderExists()) {
                        pizzeria.printOrder();
                        System.out.println("Введите id продукта, который желаете убрать: ");
                        pizzeria.removeFromOrder(Integer.parseInt(scanner.nextLine()));
                    }
                    break;
                case 3:
                    if (pizzeria.isOrderExists()) {
                        pizzeria.cleanOrder();
                    }
                    break;
                case 4:
                    if (pizzeria.isOrderExists()) {
                        pizzeria.sendOrder();
                        return;
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
