package com.anubhabnath.learn.users;

import com.anubhabnath.learn.users.models.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class UserDtoTests {
    @ParameterizedTest
    @MethodSource("streamForCreateUserInvalidInput")
    void createUserInvalidInputs(String name, String phone, String email) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new UserDto(name, phone, email));
    }

    private static Stream<Arguments> streamForCreateUserInvalidInput() {
        return Stream.of(
                // checkWhenPhoneNumContainsAlphabets
                Arguments.of("Julie", "78978972ab", "abc@de.com"),
                //checkWhenPhoneNumLengthIsNot10
                Arguments.of("Julie", "78978", "abc@de.com"),
                // checkWhenEmailFormatIsNotCorrect
                Arguments.of("Julie", "7897897280", "abc@"),

                // checkIfAnyOfTheInputsIsNull
                Arguments.of(null, "7897897280", "julie@san"),
                Arguments.of("Julie", null, "julie@anything"),
                Arguments.of("julie", "7897897280", null)
        );
    }

    @Test
    void createUserWhenValidInput() {
        Assertions.assertDoesNotThrow(() -> new UserDto("Julie", "7897897280", "julie@hmcom"));
    }
}
