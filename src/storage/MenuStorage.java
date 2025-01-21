package storage;

import entity.Product;
import util.MenuLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class MenuStorage {
    private Map<Integer, Product> products;

    public MenuStorage(List<Product> products) {
        saveToMap(products);
        //this.description = menuToString();
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public void setProducts(List<Product> products) {
        saveToMap(products);
    }

    public static MenuStorage createMenuStorage(String menuFilePath) {
        return new MenuStorage(MenuLoader.loadMenu(menuFilePath));
    }

    public Product getProductById(int id) {
        return products.get(id);
    }

    private void saveToMap(List<Product> products) {
        this.products = products
                .stream()
                .collect(Collectors.toMap(Product::id, product -> product));
    }
}
