package com.ecommerce.user;

public record User(
        String firstName,
        String lastName,
        String country,
        String address,
        String town,
        String state,
        String zipCode,
        String emailAddress) {
}
