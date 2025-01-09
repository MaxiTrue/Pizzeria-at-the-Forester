package api;

import entity.Pizzeria;

import java.util.Scanner;

public class MainDisplay {
    private final Pizzeria pizzeria;
    private final Scanner scanner = new Scanner(System.in);
    private final AdminDisplay adminDisplay;

    public MainDisplay(Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
        this.adminDisplay = new AdminDisplay(pizzeria);
    }

    public void executeDisplay() {
        System.out.println("Добро пожаловать в пиццерию по адресу: " + pizzeria.getAddress());
        while (true) {
            printCommandList();
            var menuNumber = scanner.nextInt();
            switch (menuNumber) {
                case 0:
                    System.out.println("Ждём вас снова");
                    System.exit(0);
                case 1:
                    break;
                case 2:
                    break;
                case 3:
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
