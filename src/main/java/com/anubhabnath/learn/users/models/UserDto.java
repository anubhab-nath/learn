package com.anubhabnath.learn.users.models;

import static com.anubhabnath.learn.users.models.Preconditions.*;

public class UserDto {
    private final String name;
    private final String phone;
    private final String email;

    /**
     * @param name Name of the user
     * @param phone Phone number of the user
     * @param email Email address of the user
     * @throws IllegalArgumentException if any of the following fails to conform:
     *      1. Phone Number: Must be 10 characters in length and all numeric.
     *      2. Email: Must contain @ in the middle of the string.
     */
    public UserDto(String name, String phone, String email) throws IllegalArgumentException {
        validateNotNull(name);
        validateNotNull(phone);
        validateNotNull(email);
        validatePhoneNumber(phone);
        validateEmail(email);

        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
