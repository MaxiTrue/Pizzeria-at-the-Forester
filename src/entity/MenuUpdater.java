package entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class MenuUpdater {
    private static final String SEP = ",";
    private static int id = 0;

    public static void updateMenu(Pizzeria pizzeria, String filePath) throws IOException {
        List<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Пропуск 1 строки с названиями столбцов
            while (br.ready()) {
                String line = br.readLine();
                Product product = fromString(line);
                products.add(product);
            }
            pizzeria.getMenuStorage().setProducts(products);
            id = 0;
        } catch (IOException e) {
            throw new IOException("Ошибка чтения/записи файла");
        }
    }

    private static Product fromString(String value) {
        String[] valueArr = value.split(SEP);
        String name = valueArr[0];
        String description = valueArr[1];
        ProductCategory category = ProductCategory.valueOf(valueArr[2]);
        BigDecimal price = new BigDecimal(valueArr[3]);
        id++;
        return new Product(id, name, description, category, price);
    }
}


