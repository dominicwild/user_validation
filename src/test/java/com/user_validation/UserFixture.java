package com.user_validation;

public class UserFixture {

    public static User invalidUser() {
        return new User();
    }

    public static User validUser() {
        return new User()
                .firstName("John")
                .lastName("Doe")
                .email("john@doe.com")
                .age(20);
    }

    public static User createdUser() {
        return new User()
                .firstName("Database")
                .lastName("User")
                .email("created@database.com");
    }

}
