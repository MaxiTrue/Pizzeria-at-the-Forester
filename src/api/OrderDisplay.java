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
        System.out.println("Введите имя: ");
        pizzeria.createCustomerFromOrder(scanner.nextLine());
        while (true) {
            printCommandList();
            var menuNumber = scanner.nextInt();
            switch (menuNumber) {
                case 0:
                    return;
                case 1:
                    System.out.println("Введите id продукта: ");
                    pizzeria.addProductToOrder(scanner.nextInt());
                    pizzeria.printOrder();
                    break;
                case 2:
                    if (pizzeria.isOrderExists()) {
                        pizzeria.printOrder();
                        System.out.println("Выберите позицию, которую нужно убрать: ");
                        pizzeria.removeFromOrder(scanner.nextInt());
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
