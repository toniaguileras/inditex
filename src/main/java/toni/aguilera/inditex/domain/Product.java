package toni.aguilera.inditex.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Product {
    private ProductId productId;
    private String startDate;
    private String endDate;
    private Integer priceList;
    private Double price;

    public Product(ProductId productId, LocalDateTime startDate, LocalDateTime endDate, Integer priceList, Double price) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.productId = productId;
        this.startDate = formatter.format(startDate);
        this.endDate = formatter.format(endDate);
        this.priceList = priceList;
        this.price = price;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public Double getPrice() {
        return price;
    }

}
