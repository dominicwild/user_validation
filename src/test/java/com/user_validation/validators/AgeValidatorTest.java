package com.user_validation.validators;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.user_validation.User;
import com.user_validation.ValidationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AgeValidatorTest {

    AgeValidator ageValidator;

    @BeforeEach
    void setUp() {
        ageValidator = new AgeValidator();
    }

    @Test
    void user_above_18_does_not_throw_exception() {
        User user = new User().age(19);
        assertDoesNotThrow(() -> ageValidator.validate(user));
    }

    @ParameterizedTest
    @ValueSource(ints = { -18, 1, 17 })
    void user_below_18_throws_exception() {
        User user = new User().age(17);
        assertThrows(ValidationException.class, () -> ageValidator.validate(user));
    }
}
