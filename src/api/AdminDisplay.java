package api;

import util.MenuLoader;
import entity.Order;
import entity.OrderStatus;
import entity.Pizzeria;

import java.util.Scanner;
import java.util.UUID;

public class AdminDisplay {
    private final Pizzeria pizzeria;

    Scanner scanner = new Scanner(System.in);

    public AdminDisplay(Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
    }

    public void executeDisplay() {
        while (true) {
            printCommandList();
            var menuNumber = scanner.nextInt();
            switch (menuNumber) {
                case 0:
                    System.out.println("Выходим из админ меню....");
                    return;
                case 1:
                    updateMenuCommand(pizzeria);
                    break;
                case 2:
                    try {
                        updateStatus(pizzeria);
                    } catch (Exception e) {
                        System.out.println("Сбой обновления статуса заказа: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Нет такой команды!");
            }
        }
    }

    private void printCommandList() {
        System.out.println("""
                0. Выйти из меню
                1. Обновить меню из csv файла
                2. Изменить статус заказа по ID
                """);
    }

    private void updateMenuCommand(Pizzeria pizzeria) {
        System.out.println("Текущее меню: " + pizzeria.getMenuStorage().getDescription());
        System.out.println("""
                Желаете обновить его?
                1. Да, обновить из файла menu.csv
                2. Нет, оставить как есть
                """);

        var menuNumber = scanner.nextInt();
        switch (menuNumber) {
            case 1:
                    MenuLoader.loadMenu("menu.csv");
                    //MenuLoader.updateMenu(pizzeria, "menu.csv");
                    System.out.println("Теперь меню выглядит так\n" + pizzeria.getMenuStorage().getDescription());
                break;
            case 2:
                System.out.println("Меню не было обновлено");
                return;
            default:
                System.out.println("Нет такой команды!");
        }
    }

    private void updateStatus(Pizzeria pizzeria) {
        System.out.println("Введите id заказа");

        UUID id = UUID.fromString(scanner.next());
        Order order = pizzeria.getOrderStorage().getOrder(id);

        if (order != null) {
            System.out.println("Заказ на имя: " + order.getCustomer().name() + " Статус: " + order.getStatus());
            System.out.println("На какой статус поменять? Введите один из следующих");

            for (OrderStatus status : OrderStatus.values()) {
                System.out.println(status);
            }
            order.setStatus(OrderStatus.valueOf(scanner.next()));

            System.out.println("Статус обновлен");
        }
        System.out.println("Статус не обновлен");
    }
}
