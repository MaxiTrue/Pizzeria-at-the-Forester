package service;

import entity.Product;
import storage.MenuStorage;
import util.MenuLoader;

public class MenuService {
    private static final String FILE_PATH = "menu.csv";

    private String description;
    private final MenuStorage menuStorage;


    public MenuService() {
        this.menuStorage = new MenuStorage(MenuLoader.loadMenu(FILE_PATH));
    }

    public String getMenu() {
        if (description == null) {
            description = menuToString();
        }

        return description;
    }

    public void reloadMenu() {
        menuStorage.setProducts(MenuLoader.loadMenu(FILE_PATH));
        description = menuToString();
    }

    public Product getProductById(int id) {
        return menuStorage.getProductById(id);
    }

    private String menuToString() {
        StringBuilder sb = new StringBuilder();
        for (Product product : menuStorage.getProducts()) {
            sb.append(product.id())
                    .append(". ")
                    .append(product.name())
                    .append(" ")
                    .append(product.price())
                    .append(" руб.\n");
        }
        return sb.toString();
    }
}
