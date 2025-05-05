package toni.aguilera.inditex.application.product;

import org.springframework.stereotype.Service;
import toni.aguilera.inditex.application.mapper.PriceToDtoMapper;
import toni.aguilera.inditex.domain.product.ApplicationTime;
import toni.aguilera.inditex.domain.product.Brand;
import toni.aguilera.inditex.domain.product.ProductId;
import toni.aguilera.inditex.domain.product.ProductQuery;
import toni.aguilera.inditex.domain.repository.ProductRepository;

@Service
public class FindProduct {

    private final ProductRepository productRepository;
    private final PriceToDtoMapper mapper;

    public FindProduct(ProductRepository productRepository, PriceToDtoMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    public ProductDto execute(FindProductCommand command) {
        var time = new ApplicationTime(command.applicationDate());
        var productId = new ProductId(command.productId());
        var brand = new Brand(command.brand());
        var products = productRepository.find(new ProductQuery(time, productId, brand));
        return mapper.map(products);
    }
}
