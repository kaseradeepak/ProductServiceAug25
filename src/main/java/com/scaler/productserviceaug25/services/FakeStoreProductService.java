package com.scaler.productserviceaug25.services;

import com.scaler.productserviceaug25.exceptions.ProductNotFoundException;
import com.scaler.productserviceaug25.models.Category;
import com.scaler.productserviceaug25.models.Product;
import com.scaler.productserviceaug25.dtos.FakeStoreProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //Random change.

    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(
                        "https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class
                );

        FakeStoreProductDto[] fakeStoreProductDtos = responseEntity.getBody();

        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }

        return products;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        //make a http call to fakestore api to get the product with the given id.
        // https://fakestoreapi.com/products/1

//        throw new RuntimeException("Something went wrong");

        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(
                        "https://fakestoreapi.com/products/" + productId,
                        FakeStoreProductDto.class
                );

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        if (fakeStoreProductDto == null) {
            //Invalid productId.
            throw new ProductNotFoundException(productId);
        }


        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        product.setId(fakeStoreProductDto.getId());

        return product;
    }
}
