import api.MainDisplay;
import entity.Pizzeria;

public class
ForestersPizzeriaApplication {
    public static void main(String[] args) {
        execute();
    }

    private static void execute() {
        Pizzeria pizzeria1 = new Pizzeria("Политехническая ул., 122", "menu.csv");
        // потенциально расширить, что бы обрабатывал список с пиццериями
        var display = new MainDisplay(pizzeria1);

        display.executeDisplay();
    }
}