package toni.aguilera.inditex.domain.product;

import java.util.Objects;

public class Brand {
    private final Integer id;

    public Brand(String id) {
        this.id = parseBrand(id);
    }

    private Integer parseBrand(String id) {
        try {
            return Integer.valueOf(id);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid format for brand", ex);
        }
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(id, brand.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
