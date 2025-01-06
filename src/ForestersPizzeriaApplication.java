import entity.Pizzeria;

public class
ForestersPizzeriaApplication {
    public static void main(String[] args) {
        execute();
    }

    private static void execute() {
        Pizzeria pizzeria1 = new Pizzeria("Политехническая ул., 122");
        var display = new MainDisplay(pizzeria1);

        display.executeDisplay();
    }
}