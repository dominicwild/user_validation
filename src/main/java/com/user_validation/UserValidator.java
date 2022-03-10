package com.user_validation;

import java.util.Set;

public class UserValidator {

    Set<Validator<User>> validators;

    public UserValidator(Validator<User>... validators) {
        this.validators = Set.of(validators);
    }

    public void validate(User user) {
        validators.forEach(validator -> validator.validate(user));
    }

}
