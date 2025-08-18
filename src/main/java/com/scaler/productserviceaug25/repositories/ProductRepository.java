package com.scaler.productserviceaug25.repositories;

import com.scaler.productserviceaug25.models.Category;
import com.scaler.productserviceaug25.models.Product;
import com.scaler.productserviceaug25.projections.ProductWithTitleAndPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //Declared Queries
    Optional<Product> findById(Long aLong);

    // select * from products
    List<Product> findAll();

    //select * from products where title = ?
    List<Product> findByTitle(String title);

    //select * from products where title LIKE '%str%'
    List<Product> findByTitleContainsIgnoreCase(String str);

    // select * from products where price >= start and price <= end
    List<Product> findByPriceBetween(Double start, Double end);


    //select * from products where title LIKE '%str%' and price >= start and price <= end
    List<Product> findByTitleContainsIgnoreCaseAndPriceBetween(String title, Double start, Double end);

    List<Product> findByCreatedAtBetween(Date start, Date end);

    @Override
    void deleteById(Long aLong);

    Product save(Product product);

    //Query : Find the title and price of the product with id = 10;
    // select title, price from products where id = 10;
    @Query(value = "select p.title, p.price from products p where p.id = 2", nativeQuery = true)
    List<ProductWithTitleAndPrice> findTitleAndPriceById();


    Optional<Product> findByCategory(Category category);

    Optional<Product> findByCategory_Title(String title);
}


//CRUD => Read & Delete
/// Create & Update
