package toni.aguilera.inditex.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import toni.aguilera.inditex.domain.ApplicationTime;
import toni.aguilera.inditex.domain.Brand;
import toni.aguilera.inditex.domain.Product;
import toni.aguilera.inditex.domain.ProductId;
import toni.aguilera.inditex.domain.ProductQuery;
import toni.aguilera.inditex.domain.ProductRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FindProductShould {

    @Test
    void return_products_with_correct_parameters() {
        var applicationDate = LocalDateTime.of(2024, 6, 16, 21, 0);
        var productId = "1111";
        var brand = "1";
        var startDate = LocalDateTime.of(2024, 6, 16, 21, 30);
        var endDate = LocalDateTime.of(2024, 6, 16, 22, 0);

        var priceRepository = Mockito.mock(ProductRepository.class);
        var mapper = Mockito.mock(PriceToDtoMapper.class);
        Mockito.when(mapper.map(Mockito.any(Product.class))).thenReturn(
                new ProductDto(1111, startDate.toString(), endDate.toString(), 1, 22D));

        Mockito.when(priceRepository.find(
                new ProductQuery(new ApplicationTime(applicationDate),
                        new ProductId(productId),
                        new Brand(brand)))).thenReturn(
                new Product(
                        new ProductId(productId), startDate, endDate, 1, 22D));
        var findPrices = new FindProduct(priceRepository, mapper);

        var result = findPrices.execute(new FindProductCommand(applicationDate.toString(), productId, brand));
        assertNotNull(result);
        assertEquals(22D, result.price());
    }

    @Test
    void fail_when_applicationDate_format_is_invalid() {
        var invalidApplicationDate = "2024-12-31";
        var productId = "1111";
        var brand = "1";

        var priceRepository = Mockito.mock(ProductRepository.class);
        var mapper = Mockito.mock(PriceToDtoMapper.class);
        var findPrices = new FindProduct(priceRepository, mapper);

        assertThrows(IllegalArgumentException.class, () -> {
            findPrices.execute(new FindProductCommand(invalidApplicationDate, productId, brand));
        });
    }
}