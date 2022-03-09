package com.user_validation.validators;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.user_validation.User;
import com.user_validation.ValidationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class EmailValidatorTest {

    EmailValidator emailValidator;

    @BeforeEach
    void setUp() {
        emailValidator = new EmailValidator();
    }

    @Test
    void user_with_valid_email_does_not_throw_exception() {
        User user = new User().email("email@email.com");
        assertDoesNotThrow(() -> emailValidator.validate(user));
    }

    @ParameterizedTest
    @ValueSource(strings = { "email-missing-at-sign",
            "email@email-missing-domain",
            "email.com@no-domain"
    })
    @NullAndEmptySource
    void user_with_invalid_email_throws_exception(String invalidEmail) {
        User user = new User().email(invalidEmail);
        assertThrows(ValidationException.class, () -> emailValidator.validate(user));
    }

}
