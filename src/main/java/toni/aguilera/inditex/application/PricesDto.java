package toni.aguilera.inditex.application;

import toni.aguilera.inditex.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class PricesDto {
    private int productId;
    private String startDate;
    private String endDate;
    private Integer priceList;
    private Double price;

    public PricesDto(int productId, String startDate, String endDate, Integer priceList, Double price) {
        this.productId = productId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public Double getPrice() {
        return price;
    }

    public static List<PricesDto> map(List<Product> products) {
        List<PricesDto> response = new ArrayList<>();
        products.forEach(it -> response.add(new PricesDto(it.getProductId().getId(), it.getStartDate().format(), it.getEndDate().format(), it.getPriceList(), it.getPrice())));
        return response;
    }
}
