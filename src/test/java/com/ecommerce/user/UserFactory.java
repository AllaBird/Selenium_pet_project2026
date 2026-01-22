package com.ecommerce.user;

import com.github.javafaker.Faker;

import java.util.Locale;

public class UserFactory {

    static Faker faker = new Faker(new Locale("en-US"));

    public static User randomUser() {
        return new User(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.address().country(),
                faker.address().streetAddress(),
                faker.address().city(),
                faker.address().state(),
                faker.address().zipCode(),
                faker.internet().emailAddress()
        );
    }
}
