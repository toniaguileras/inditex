package toni.aguilera.inditex.infraestructure.controller;

import org.mapstruct.Mapper;
import toni.aguilera.inditex.application.ProductDto;

@Mapper(componentModel = "spring")
public interface DtoToResponseMapper {
    ProductResponse toResponse(ProductDto dto);
}
