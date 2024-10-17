package toni.aguilera.inditex.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import toni.aguilera.inditex.domain.*;

import java.sql.Timestamp;
import java.util.List;

@Service
public class FindPrices {

    @Autowired
    private PricesRepository pricesRepository;

    public List<PricesDto> execute(FindPricesCommand command) {
        Timestamp time = Timestamp.valueOf(command.getApplicationDate());
        ProductId productId = new ProductId(Integer.valueOf(command.getProductId()));
        Brand brand = new Brand(Integer.valueOf(command.getBrand()));
        List<Product> products = pricesRepository.find(new ProductQuery(time, productId, brand));
        return PricesDto.map(products);
    }
}
