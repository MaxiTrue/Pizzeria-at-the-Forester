package util;

import entity.Product;
import entity.ProductCategory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MenuLoader {
    private static final String SEP = ",";
    private static int id = 0;

    public static List<Product> loadMenu(String filePath) {
        var products = new ArrayList<Product>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Пропуск 1 строки с названиями столбцов
            while (br.ready()) {
                String line = br.readLine();
                Product product = fromString(line);
                products.add(product);
            }
            id = 0;

            return products;
        } catch (IOException e) {
            // типо логируем
            System.out.printf("ERROR: При загрузки файла из пути - %s, произошла ошибка - %s%n", filePath, e.getMessage());
        }

        return Collections.emptyList();
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


