package toni.aguilera.inditex.application;

import org.springframework.stereotype.Service;
import toni.aguilera.inditex.domain.*;


import java.util.List;

@Service
public class FindPrices {

    private final PricesRepository pricesRepository;

    public FindPrices(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    public List<PricesDto> execute(FindPricesCommand command) {
        var time = new ApplicationTime(command.applicationDate());
        var productId = new ProductId(Integer.valueOf(command.productId()));
        var brand = new Brand(Integer.valueOf(command.brand()));
        var products = pricesRepository.find(new ProductQuery(time, productId, brand));
        return PricesDto.map(products);
    }
}
