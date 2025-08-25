package com.scaler.productserviceaug25.exceptions;

public class ProductNotFoundException extends Exception {
    private Long productId;

    public ProductNotFoundException(Long productId) {
        this.productId = productId;
    }

    public ProductNotFoundException() {

    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
