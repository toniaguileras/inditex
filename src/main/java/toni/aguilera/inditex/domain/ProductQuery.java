package toni.aguilera.inditex.domain;

import java.sql.Timestamp;

public class ProductQuery {
    private Timestamp time;
    private ProductId productId;
    private Brand brand;

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public ProductId getProductId() {
        return productId;
    }

    public void setProductId(ProductId productId) {
        this.productId = productId;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public ProductQuery(Timestamp time, ProductId productId, Brand brand) {
        this.time = time;
        this.productId = productId;
        this.brand = brand;
    }
}
