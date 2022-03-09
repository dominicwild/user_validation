package com.user_validation.validators;

import static com.google.common.base.Strings.isNullOrEmpty;

import com.user_validation.User;
import com.user_validation.ValidationException;
import com.user_validation.Validator;

public class EmailValidator implements Validator {

    @Override
    public void validate(User user) {
        String email = user.getEmail();
        if (isNullOrEmpty(email)) {
            throw new ValidationException("Email is required");
        }

        if(!email.contains("@")) {
            throw new ValidationException("Email must contain an @");
        }

        if(!containsADomain(email)) {
            throw new ValidationException("Email must contain a domain.");
        }
    }

    private boolean containsADomain(String email) {
        return email.split("@")[1].contains(".");
    }

}
