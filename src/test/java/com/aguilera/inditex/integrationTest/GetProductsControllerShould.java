package com.aguilera.inditex.integrationTest;

import com.aguilera.inditex.configuration.IntegrationTestBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GetProductsControllerShould extends IntegrationTestBase {
    @ParameterizedTest
    @CsvSource({
            "14, 10:00, 35451, ZARA",
            "14, 16:00, 35452, ZARA",
            "14, 21:00, 35453, ZARA",
            "15, 10:00, 35454, ZARA",
            "16, 21:00, 35454, ZARA"
    })
    void return_expected_products_by_given_parameters() {
    //TODO: Not yet implemented
    }
}
