package toni.aguilera.inditex.application;

import toni.aguilera.inditex.domain.Product;

import java.util.ArrayList;
import java.util.List;

public record PricesDto(int productId, String startDate, String endDate, Integer priceList, Double price) {

    public static List<PricesDto> map(List<Product> products) {
        return products.stream()
                .map(it -> new PricesDto(
                        it.getProductId().id(),
                        it.getStartDate().format(),
                        it.getEndDate().format(),
                        it.getPriceList(),
                        it.getPrice()))
                .toList();
    }
}
