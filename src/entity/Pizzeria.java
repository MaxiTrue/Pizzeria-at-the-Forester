package entity;

import java.util.UUID;

public class Pizzeria {
    private final UUID id;
    private final String address;

    public Pizzeria(String address) {
        this.id = generateUUID();
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    private UUID generateUUID() {
        return UUID.randomUUID();
    }

}
