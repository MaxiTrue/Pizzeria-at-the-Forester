import java.util.Scanner;

public class MainDisplay {

    private final Scanner scanner = new Scanner(System.in);

    public void executeDisplay() {
        System.out.println("""
                0. Покинуть заведение
                1. Меню
                2. Мой заказ
                3. Табло заказов
                                
                4. Я сотрудник
                """); // представим что обычный пользователь не сможет попасть во вкладку сотрудника(там аутентификация)

        var menuNumber = scanner.nextInt();

        while (true) {
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
                    break; // сделать класс для управления админкой
            }
        }
    }
}
