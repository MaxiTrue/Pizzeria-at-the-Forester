package entity;

public enum OrderStatus {
    NEW("new"), // создан
    IN_PROGRESS("inProgress"), // в работе (готовится)
    READY("ready"), // готов (к выдаче)
    ISSUED("issued"), // выдан
    CANCELED("canceled"); // отменён

    public final String value;

    OrderStatus(String value) {
        this.value = value;
    }

}
