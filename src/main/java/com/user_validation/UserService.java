package com.user_validation;

public class UserService {

    private UserValidator validator;
    private UserRepository userRepository;

    public UserService(UserValidator userValidator, UserRepository userRepository) {
        this.validator = userValidator;
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        validator.validate(user);
        return userRepository.create(user);
    }

}
