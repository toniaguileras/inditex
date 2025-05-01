package toni.aguilera.inditex.domain;

import java.util.Objects;

public class ProductId {
    private final Integer id;

    public ProductId(String id) {
        this.id = parseProductId(id);
    }

    public ProductId(Integer id) {
        this.id = id;
    }

    private Integer parseProductId(String id) {
        try {
            return Integer.valueOf(id);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid format for product", ex);
        }
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductId productId = (ProductId) o;
        return Objects.equals(id, productId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
