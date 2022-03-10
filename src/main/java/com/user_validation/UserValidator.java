package com.user_validation;

import java.util.Set;

import com.user_validation.validators.AgeValidator;
import com.user_validation.validators.EmailValidator;
import com.user_validation.validators.NameValidator;

public class UserValidator {

    Set<Validator<User>> validators;

    public UserValidator() {
        validators = Set.of(new AgeValidator(), new EmailValidator(), new NameValidator());
    }

    public UserValidator(Validator<User>... validators) {
        this.validators = Set.of(validators);
    }

    public void validate(User user) {
        validators.forEach(validator -> validator.validate(user));
    }

}
