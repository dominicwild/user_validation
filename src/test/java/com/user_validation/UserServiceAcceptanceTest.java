package com.user_validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserServiceAcceptanceTest {
    
    UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(new UserValidator(), new UserRepository());
    }

    @Test
    void valid_user_does_not_throw_exception() {
        User user = UserFixture.validUser();
    
        assertDoesNotThrow(() -> userService.createUser(user)); 
    }

    @Test
    void invalid_user_throws_exception() {
        User user = UserFixture.invalidUser();
    
        assertThrows(ValidationException.class, () -> userService.createUser(user)); 
    }
}
