package toni.aguilera.inditex.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Product {
    private final ProductId productId;
    private final ApplicationTime startDate;
    private final ApplicationTime endDate;
    private final Integer priceList;
    private final Double price;

    public Product(ProductId productId, LocalDateTime startDate, LocalDateTime endDate, Integer priceList, Double price) {
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date must be before end date");
        }
        this.productId = productId;
        this.startDate = new ApplicationTime(startDate);
        this.endDate = new ApplicationTime(endDate);
        this.priceList = priceList;
        this.price = price;
    }

    public ApplicationTime getStartDate() {
        return startDate;
    }

    public ApplicationTime getEndDate() {
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
