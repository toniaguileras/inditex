package toni.aguilera.inditex.domain.repository;

import toni.aguilera.inditex.domain.product.Product;
import toni.aguilera.inditex.domain.product.ProductQuery;

public interface ProductRepository {
    Product find(ProductQuery productQuery);
}
