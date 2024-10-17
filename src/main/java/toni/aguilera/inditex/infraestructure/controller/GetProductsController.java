package toni.aguilera.inditex.infraestructure.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetProductsController {
    // fecha de aplicación, identificador de producto, identificador de cadena (?)
    @GetMapping("v1/products")
    public ResponseEntity<ProductResponse> get(
            @PathParam("applicationDate") String applicationDate,
            @PathParam("productId") String productId
    ) {
        return ResponseEntity.notFound().build();
    }
}
