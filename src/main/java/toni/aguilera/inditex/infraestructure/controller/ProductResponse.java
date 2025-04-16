package toni.aguilera.inditex.infraestructure.controller;

import toni.aguilera.inditex.application.PricesDto;

import java.util.ArrayList;
import java.util.List;

public record ProductResponse(Integer productId,
                              String startDate,
                              String endDate,
                              Integer priceList,
                              Double price) {

    public static List<ProductResponse> map(List<PricesDto> dtos) {
        return dtos.stream()
                .map(it -> new ProductResponse(
                        it.productId(),
                        it.startDate(),
                        it.endDate(),
                        it.priceList(),
                        it.price()))
                .toList();
    }
}
