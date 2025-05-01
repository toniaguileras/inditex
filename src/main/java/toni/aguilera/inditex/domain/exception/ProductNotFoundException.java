package toni.aguilera.inditex.domain.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super("There's no price found for these values");
    }
}
