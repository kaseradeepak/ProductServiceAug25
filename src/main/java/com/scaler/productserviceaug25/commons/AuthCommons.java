package com.scaler.productserviceaug25.commons;

import com.scaler.productserviceaug25.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthCommons {
    private static RestTemplate restTemplate;

    public AuthCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public static boolean validateToken(String tokenValue) {
        //Call the UserService to validate the token.
        UserDto userDto =  restTemplate.getForObject(
                "http://localhost:8080/users/validate/" + tokenValue,
                UserDto.class
        );

        if (userDto == null) {
            //Invalid token
            return false;
        }

        return true;
    }
}
