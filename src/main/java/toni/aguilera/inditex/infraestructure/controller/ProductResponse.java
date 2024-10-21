package toni.aguilera.inditex.infraestructure.controller;

import toni.aguilera.inditex.application.PricesDto;

import java.util.ArrayList;
import java.util.List;

public class ProductResponse {
    private Integer productId;
    private String startDate;
    private String endDate;
    private Integer priceList;
    private Double price;

    public Integer getProductId() {
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

    public ProductResponse(Integer productId, String startDate, String endDate, Integer priceList, Double price) {
        this.productId = productId;
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public static List<ProductResponse> map(List<PricesDto> dtos) {
        List<ProductResponse> response = new ArrayList<>();
        dtos.forEach(it -> response.add(new ProductResponse(it.getProductId(), it.getStartDate(), it.getEndDate(), it.getPriceList(), it.getPrice())));
        return response;
    }
}
