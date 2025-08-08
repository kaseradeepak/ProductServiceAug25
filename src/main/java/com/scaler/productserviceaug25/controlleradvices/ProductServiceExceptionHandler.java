package com.scaler.productserviceaug25.controlleradvices;

import com.scaler.productserviceaug25.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
public class ProductServiceExceptionHandler {
    //@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Void> handleRuntimeException() {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        return new ResponseEntity<>(
                productNotFoundException.getProductId() + " is an invalid product id, Please pass a valid product id",
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException() {
        return new ResponseEntity<>(
                "Please try again with a valid product id",
                HttpStatus.NOT_FOUND);
    }
}
