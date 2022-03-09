package com.user_validation;

import java.util.Set;

public class UserValidator {

    Set<Validator> validators;

    public UserValidator(Validator... validators) {
        this.validators = Set.of(validators);
    }

    public void validate(User user) {
        validators.forEach(validator -> validator.validate(user));
    }

}
