package com.scaler.productserviceaug25;

import com.scaler.productserviceaug25.models.Product;
import com.scaler.productserviceaug25.projections.ProductWithTitleAndPrice;
import com.scaler.productserviceaug25.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceAug25ApplicationTests {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }


    @Test
    public void testQuery() {
        List<ProductWithTitleAndPrice> productWithTitleAndPrices =
                productRepository.findTitleAndPriceById();


        for (ProductWithTitleAndPrice productWithTitleAndPrice : productWithTitleAndPrices) {
            System.out.println(productWithTitleAndPrice.getTitle() + " " + productWithTitleAndPrice.getPrice());
        }

        Optional<Product> optionalProduct = productRepository.findByCategory_Title("mobile");

        System.out.println(optionalProduct.get().getPrice());
    }

}
