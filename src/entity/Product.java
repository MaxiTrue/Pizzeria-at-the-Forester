package entity;

import java.math.BigDecimal;

public record Product(
        int id,
        String name,
        String description,
        ProductCategory category,
        BigDecimal price
) {
}
