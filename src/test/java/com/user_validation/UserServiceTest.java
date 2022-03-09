package com.user_validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
class UserServiceTest {

    private static final User VALID_USER = UserBuilder.validUser();
    private static final User INVALID_USER = UserBuilder.invalidUser();
    private static final User CREATED_USER = UserBuilder.createdUser();

    @Mock
    UserRepository userRepository;

    @Mock
    UserValidator userValidator;

    UserService service;

    @BeforeEach
    void setUp() {
        service = new UserService(userValidator, userRepository);
    }

    @Test
    void valid_user_creates_user() {
        service.createUser(VALID_USER);

        verify(userRepository).create(VALID_USER);
    }

    @Test
    void user_created_by_repository_is_returned() {
        when(userRepository.create(VALID_USER)).thenReturn(CREATED_USER);

        User user = service.createUser(VALID_USER);

        assertEquals(CREATED_USER, user);
    }

    @Test
    void invalid_user_throws_exception() {
        doThrow(new ValidationException()).when(userValidator).validate(any());

        assertThrows(ValidationException.class, () -> service.createUser(INVALID_USER));
    }

}
