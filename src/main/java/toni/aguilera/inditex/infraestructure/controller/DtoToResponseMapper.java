package toni.aguilera.inditex.infraestructure.controller;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import toni.aguilera.inditex.application.ProductDto;

@Mapper(componentModel = "spring")
public interface DtoToResponseMapper {
    DtoToResponseMapper INSTANCE = Mappers.getMapper(DtoToResponseMapper.class);

    ProductResponse toResponse(ProductDto dto);
}
