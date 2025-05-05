package toni.aguilera.inditex.infraestructure.controller.product;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import toni.aguilera.generated.api.ProductPricesApi;
import toni.aguilera.generated.model.ProductResponse;
import toni.aguilera.inditex.application.product.FindProduct;
import toni.aguilera.inditex.application.product.FindProductCommand;
import toni.aguilera.inditex.domain.exception.ProductNotFoundException;
import toni.aguilera.inditex.infraestructure.controller.mapper.DtoToResponseMapper;

@RestController
@Tag(name = "Product Prices", description = "@GET to retrieve information about product prices")
public class GetProductController implements ProductPricesApi {

    private final FindProduct findProduct;
    private final DtoToResponseMapper mapper;

    public GetProductController(FindProduct findProduct, DtoToResponseMapper mapper) {
        this.findProduct = findProduct;
        this.mapper = mapper;
    }

    @GetMapping("v1/prices")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product price found successfully"),
            @ApiResponse(responseCode = "404", description = "Product price not found"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters used")
    })
    @Override
    public ResponseEntity<ProductResponse> getProductPrice(@RequestParam("applicationDate") String applicationDate, @RequestParam("productId") String productId, @RequestParam("brandId") String brandId) {
        try {
            var product = findProduct.execute(new FindProductCommand(applicationDate, productId, brandId));
            if (product == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(mapper.toResponse(product));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}