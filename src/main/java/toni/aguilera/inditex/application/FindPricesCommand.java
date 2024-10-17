package toni.aguilera.inditex.application;

public class FindPricesCommand {

    private String applicationDate;
    private String productId;
    private String brand;

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public FindPricesCommand(String applicationDate, String productId, String brand) {
        this.applicationDate = applicationDate;
        this.productId = productId;
        this.brand = brand;
    }
}
