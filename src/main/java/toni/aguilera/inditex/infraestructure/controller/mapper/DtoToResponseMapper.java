package toni.aguilera.inditex.infraestructure.controller.mapper;

import org.mapstruct.Mapper;
import toni.aguilera.inditex.application.product.ProductDto;
import toni.aguilera.inditex.infraestructure.controller.product.ProductResponse;

@Mapper(componentModel = "spring")
public interface DtoToResponseMapper {
    ProductResponse toResponse(ProductDto dto);
}
