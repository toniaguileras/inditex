package toni.aguilera.inditex.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import toni.aguilera.inditex.application.product.ProductDto;
import toni.aguilera.inditex.domain.product.ApplicationTime;
import toni.aguilera.inditex.domain.product.Product;
import toni.aguilera.inditex.domain.product.ProductId;

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
