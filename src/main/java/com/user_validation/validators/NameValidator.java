package com.user_validation.validators;

import static com.google.common.base.Strings.isNullOrEmpty;

import com.user_validation.User;
import com.user_validation.ValidationException;
import com.user_validation.Validator;

public class NameValidator implements Validator {

    @Override
    public void validate(User user) {
        if (isNullOrEmpty(user.getFirstName())) {
            throw new ValidationException("First name is required");
        }

        if (isNullOrEmpty(user.getLastName())) {
            throw new ValidationException("Last name is required");
        }
    }

}
