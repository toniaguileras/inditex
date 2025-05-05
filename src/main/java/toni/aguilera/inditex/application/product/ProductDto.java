package toni.aguilera.inditex.application.product;


public record ProductDto(int productId, String startDate, String endDate, Integer priceList, Double price) {
}
