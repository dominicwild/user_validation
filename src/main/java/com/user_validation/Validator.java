package com.user_validation;

public interface Validator<T> {

    void validate(T toValidate);

}
