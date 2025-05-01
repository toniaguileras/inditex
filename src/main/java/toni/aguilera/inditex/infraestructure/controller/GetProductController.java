package toni.aguilera.inditex.infraestructure.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import toni.aguilera.inditex.application.FindProduct;
import toni.aguilera.inditex.application.FindProductCommand;
import toni.aguilera.inditex.domain.exception.ProductNotFoundException;

@RestController
@Tag(name = "Product Prices", description = "@GET to retrieve information about product prices")
public class GetProductController {

    @Autowired
    private final FindProduct findPrice;
    @Autowired
    private DtoToResponseMapper mapper;

    public GetProductController(FindProduct findPrice) {
        this.findPrice = findPrice;
    }

    @GetMapping("v1/prices")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product price found successfully"),
            @ApiResponse(responseCode = "404", description = "Product price not found"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters used")
    })
    public ResponseEntity<ProductResponse> get(@RequestParam("applicationDate") String applicationDate, @RequestParam("productId") String productId, @RequestParam("brandId") String brandId) {
        try {
            var price = findPrice.execute(new FindProductCommand(applicationDate, productId, brandId));
            if (price == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(mapper.toResponse(price));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
