package toni.aguilera.inditex.domain;

import java.util.List;

public interface PricesRepository {
    List<Product> find(ProductQuery productQuery);
}
