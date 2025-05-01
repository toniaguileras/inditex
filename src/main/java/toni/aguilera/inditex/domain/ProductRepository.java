package toni.aguilera.inditex.domain;

public interface ProductRepository {
    Product find(ProductQuery productQuery);
}
