package toni.aguilera.inditex.application;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import toni.aguilera.inditex.domain.ApplicationTime;
import toni.aguilera.inditex.domain.Product;
import toni.aguilera.inditex.domain.ProductId;

@Mapper(componentModel = "spring")
public interface PriceToDtoMapper {

    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "startDate", target = "startDate", qualifiedByName = "applicationTimeToString")
    @Mapping(source = "endDate", target = "endDate", qualifiedByName = "applicationTimeToString")
    ProductDto map(Product product);

    default int map(ProductId productId) {
        if (productId == null) {
            return 0;
        }
        return productId.getId();
    }

    @Named("applicationTimeToString")
    default String applicationTimeToString(ApplicationTime time) {
        if (time == null) {
            return null;
        }
        return time.format();
    }
}
