package toni.aguilera.inditex.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import toni.aguilera.inditex.domain.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindPricesShould {

    @Test
    void return_products_with_correct_parameters() {
        var applicationDate = LocalDateTime.of(2024, 6, 16, 21, 0);
        var productId = "1111";
        var brand = "1";
        var startDate = LocalDateTime.of(2024, 6, 16, 21, 30);
        var endDate = LocalDateTime.of(2024, 6, 16, 22, 0);

        var priceRepository = Mockito.mock(PricesRepository.class);
        Mockito.when(priceRepository.find(new ProductQuery(
                        new ApplicationTime(applicationDate),
                        new ProductId(Integer.valueOf(productId)),
                        new Brand(Integer.valueOf(brand)))))
                .thenReturn(List.of(
                        new Product(new ProductId(Integer.valueOf(productId)), startDate, endDate, 1, 22D)
                ));
        var findPrices = new FindPrices(priceRepository);

        var result = findPrices.execute(new FindPricesCommand(applicationDate.toString(), productId, brand));
        assertEquals(1, result.size());
        assertEquals(22D, result.getFirst().price());
    }

    @Test
    void fail_when_applicationDate_format_is_invalid() {
        var invalidApplicationDate = "2024-12-31";
        var productId = "1111";
        var brand = "1";

        var priceRepository = Mockito.mock(PricesRepository.class);
        var findPrices = new FindPrices(priceRepository);

        assertThrows(IllegalArgumentException.class, () -> {
            findPrices.execute(new FindPricesCommand(invalidApplicationDate, productId, brand));
        });
    }
}