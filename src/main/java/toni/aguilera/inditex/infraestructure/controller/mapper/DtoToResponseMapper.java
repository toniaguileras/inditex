package toni.aguilera.inditex.infraestructure.controller.mapper;

import org.mapstruct.Mapper;
import toni.aguilera.generated.model.ProductResponse;
import toni.aguilera.inditex.application.product.ProductDto;

@Mapper(componentModel = "spring")
public interface DtoToResponseMapper {
    ProductResponse toResponse(ProductDto dto);
}
