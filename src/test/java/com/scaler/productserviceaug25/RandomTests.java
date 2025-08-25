package com.scaler.productserviceaug25;

import com.scaler.productserviceaug25.controllers.ProductController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomTests {
    private ProductController productController;

    //Test Case - method which gets executed automatically at the
    // time of building or deployment etc.
    @Test
    public void sampleTest() {
        //arrange
        int a = 10;
        int b = 7;

        //act
        int result = a + b;

        //assert
        // assert result == 10;
        assertEquals(17, result);

        //assertNotEquals(x, y);
        //assertNull(object);
        //assertNotNull(object);

//        assertThrows(
//                ProductNotFoundException.class,
//                () -> productController.getSinlgeProduct(-1)
//        );

//        assertTimeout(
//             Duration.ofMillis(1000),
//                () ->  productController.getSingleProduct(10L)
//        );

//        assertInstanceOf(
//                Eagle.class,
//                BirdFactory.getBirdForType(BirdType.EAGLE)
//        );
    }
}

/*
    AAA framework

    A : Arrange (input params)
    A : Act (Call the function that we want to test.)
    A : Assert (Validate the actual output against the expected.)

 */