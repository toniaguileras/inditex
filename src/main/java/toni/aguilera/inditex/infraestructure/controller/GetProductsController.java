package toni.aguilera.inditex.infraestructure.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import toni.aguilera.inditex.application.FindPrices;
import toni.aguilera.inditex.application.FindPricesCommand;

import java.util.List;

@RestController
public class GetProductsController {

    @Autowired
    private FindPrices findPrices;
    @GetMapping("v1/prices")
    public ResponseEntity<List<ProductResponse>> get(@PathParam("applicationDate") String applicationDate, @PathParam("productId") String productId, @PathParam("brandId") String brandId) {
        return ResponseEntity.ok(ProductResponse.map(findPrices.execute(new FindPricesCommand(applicationDate, productId, brandId))));
    }
}
