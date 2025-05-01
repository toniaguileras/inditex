package toni.aguilera.inditex.application;


public record ProductDto(int productId, String startDate, String endDate, Integer priceList, Double price) {
}
