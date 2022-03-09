package com.user_validation.validators;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.user_validation.User;
import com.user_validation.ValidationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class NameValidatorTest {

    NameValidator nameValidator;

    @BeforeEach
    void setUp() {
        nameValidator = new NameValidator();
    }

   @Test
    void user_with_first_and_last_name_is_valid() {
        User user = new User().firstName("firstName").lastName("lastName");
        assertDoesNotThrow(() -> nameValidator.validate(user));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void user_missing_first_name_is_invalid(String lastName){
        User user = new User().lastName(lastName);
        assertThrows(ValidationException.class, () -> nameValidator.validate(user));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void user_missing_last_name_is_invalid(String firstName){
        User user = new User().firstName(firstName);
        assertThrows(ValidationException.class, () -> nameValidator.validate(user));
    }

}
