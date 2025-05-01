package toni.aguilera.inditex.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import toni.aguilera.inditex.domain.ApplicationTime;
import toni.aguilera.inditex.domain.Brand;
import toni.aguilera.inditex.domain.ProductId;
import toni.aguilera.inditex.domain.ProductQuery;
import toni.aguilera.inditex.domain.ProductRepository;

@Service
public class FindProduct {

    private final ProductRepository productRepository;

    @Autowired
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
