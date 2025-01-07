package entity;

import java.io.IOException;
import java.util.UUID;

public class Pizzeria {
    private final UUID id;
    private final String address;
    private final MenuStorage menuStorage;
    private final OrderStorage orderStorage;

    public Pizzeria(String address, String menuFilePath) {
        this.id = generateUUID();
        this.address = address;
        this.menuStorage = MenuStorage.createEmptyMenuStorage();
        try {
            MenuUpdater.updateMenu(this, menuFilePath);
        } catch (IOException e) {
            System.out.println("Не удалось выполнить первоначальную загрузку меню");
        }
        this.orderStorage = new OrderStorage();
    }

    public UUID getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public MenuStorage getMenuStorage() {
        return menuStorage;
    }

    public OrderStorage getOrderStorage() {
        return orderStorage;
    }

    private UUID generateUUID() {
        return UUID.randomUUID();
    }


}
