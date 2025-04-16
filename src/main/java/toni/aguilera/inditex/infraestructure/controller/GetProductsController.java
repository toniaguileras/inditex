package toni.aguilera.inditex.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import toni.aguilera.inditex.application.FindPrices;
import toni.aguilera.inditex.application.FindPricesCommand;

import java.util.List;

@RestController
public class GetProductsController {

    @Autowired
    private final FindPrices findPrices;

    public GetProductsController(FindPrices findPrices) {
        this.findPrices = findPrices;
    }

    @GetMapping("v1/prices")
    public ResponseEntity<List<ProductResponse>> get(@RequestParam("applicationDate") String applicationDate, @RequestParam("productId") String productId, @RequestParam("brandId") String brandId) {
        try {
            var products = findPrices.execute(new FindPricesCommand(applicationDate, productId, brandId));
            if (products.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(ProductResponse.map(products));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
