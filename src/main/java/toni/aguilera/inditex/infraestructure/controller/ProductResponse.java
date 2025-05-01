package toni.aguilera.inditex.infraestructure.controller;

import toni.aguilera.inditex.application.ProductDto;

public record ProductResponse(Integer productId,
                              String startDate,
                              String endDate,
                              Integer priceList,
                              Double price) {

    public static ProductResponse map(ProductDto dto) {
        return new ProductResponse(
                dto.productId(),
                dto.startDate(),
                dto.endDate(),
                dto.priceList(),
                dto.price());
    }
}
