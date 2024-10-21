package toni.aguilera.inditex.domain;

import java.sql.Timestamp;

public class ProductQuery {
    private final ApplicationTime time;
    private final ProductId productId;
    private final Brand brand;

    public ProductQuery(ApplicationTime time, ProductId productId, Brand brand) {
        this.time = time;
        this.productId = productId;
        this.brand = brand;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Brand getBrand() {
        return brand;
    }

    public ApplicationTime getTime() {
        return time;
    }
}
