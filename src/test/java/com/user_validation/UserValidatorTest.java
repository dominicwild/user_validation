package com.user_validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserValidatorTest {

    private static final User VALID_USER = UserFixture.validUser();

    @Mock
    Validator validator1;

    @Mock
    Validator validator2;

    @Mock
    Validator validator3;

    UserValidator userValidator;

    @BeforeEach
    void setUp() {
        userValidator = new UserValidator(validator1, validator2, validator3);
    }

    @Test
    void valid_user_does_not_throw_exception() {
        assertDoesNotThrow(() -> userValidator.validate(VALID_USER));

        verify(validator1).validate(any());
        verify(validator2).validate(any());
        verify(validator3).validate(any());
    }

    @Test 
    void invalid_user_failing_a_vaildator_throws_exception(){
        doThrow(new ValidationException()).when(validator1).validate(any());

        assertThrows(ValidationException.class, () -> userValidator.validate(VALID_USER));
    }

}
