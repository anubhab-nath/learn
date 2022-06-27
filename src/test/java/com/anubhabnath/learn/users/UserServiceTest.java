package com.anubhabnath.learn.users;

import com.anubhabnath.learn.users.models.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootTest(
        properties = "spring.main.allow-bean-definition-overriding = true",
        classes = {AppConfig.class})
public class UserServiceTest {
    @Autowired
    IUserService fUserService;

    @Test
    void createUserWhenDtoIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> fUserService.createUser(null));
    }

    @Test
    void createUserWithAllTheFields() {
        final var userDto = new UserDto("Ramsey", "9884588551", "someone@gmailcon");
        Assertions.assertDoesNotThrow(() -> fUserService.createUser(userDto));
    }

    @Test
    void createUser() {
        final var expected = new UserDto("Ramsey", "9884588551", "someone@gmail.con");
        final var actual = fUserService.createUser(expected);
        Assertions.assertEquals(expected.getName(), actual.getName());
        Assertions.assertEquals(expected.getPhone(), actual.getPhone());
        Assertions.assertEquals(expected.getEmail(), actual.getEmail());
    }

    @Test
    void getUserWhenIdIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> fUserService.getUser(null));
    }

    @Test
    void getUserWhenUserIsNotPresent() {
        Assertions.assertThrows(NoSuchElementException.class, () -> fUserService.getUser(UUID.randomUUID()));
    }

    @Test
    void getUser() {
        final var userDto = new UserDto("Joseph", "8787897134", "joey@gmail.com");
        final var expected = fUserService.createUser(userDto);
        final var actual = fUserService.getUser(expected.getId());
        Assertions.assertEquals(expected.getId(), actual.getId());
        Assertions.assertEquals(expected.getName(), actual.getName());
        Assertions.assertEquals(expected.getPhone(), actual.getPhone());
        Assertions.assertEquals(expected.getEmail(), actual.getEmail());
    }

    @ParameterizedTest
    @MethodSource("streamForUpdateUserWhenParamsAreNull")
    void updateUserWhenParamsAreNull(UUID userId, UserDto userDto) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> fUserService.updateUser(userId, userDto));
    }

    private static Stream<Arguments> streamForUpdateUserWhenParamsAreNull() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, new UserDto("Ross", "8787897139", "rossgeller@friends.com")),
                Arguments.of(UUID.randomUUID(), null)
        );
    }

    @Test
    void updateUserWhenUserIsNotPresent() {
        Assertions.assertThrows(NoSuchElementException.class, () -> fUserService.updateUser(UUID.randomUUID(), new UserDto("Racheal", "9876543214", "racheal@friends.com")));
    }

    @Test
    void updateUser() {
        UserDto userDto = new UserDto("Chandler", "9876483456", "chandler@friends.com");
        var user = fUserService.createUser(userDto);
        var newName = "Monica";
        var newPhone = "7583929275";
        var newEmail = "monica@friends.com";
        var newUserDto = new UserDto(newName, newPhone, newEmail);
        fUserService.updateUser(user.getId(), newUserDto);
        var actual = fUserService.getUser(user.getId());
        Assertions.assertEquals(user.getId(), actual.getId());
        Assertions.assertEquals(newName, actual.getName());
        Assertions.assertEquals(newPhone, actual.getPhone());
        Assertions.assertEquals(newEmail, actual.getEmail());
    }

    @Test
    void deleteUserWhenIdIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> fUserService.deleteUser(null));
    }

    @Test
    void deleteUserWhenUserIsNotPresent() {
        Assertions.assertThrows(NoSuchElementException.class, () -> fUserService.deleteUser(UUID.randomUUID()));
    }

    @Test
    void deleteUser() {
        UserDto userDto = new UserDto("Phoebe", "9876483457", "phoebe@friends.com");
        var user = fUserService.createUser(userDto);
        Assertions.assertDoesNotThrow(() -> fUserService.deleteUser(user.getId()));
    }
}
