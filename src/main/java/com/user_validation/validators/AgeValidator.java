package com.user_validation.validators;

import com.user_validation.User;
import com.user_validation.ValidationException;
import com.user_validation.Validator;

public class AgeValidator implements Validator<User> {

    @Override
    public void validate(User user) {
        int age = user.getAge();
        if (age < 18) {
            throw new ValidationException("Age must be above 18.");
        }
    }
    
}
