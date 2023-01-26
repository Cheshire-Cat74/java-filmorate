package ru.yandex.practicum.filmorate.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.service.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {
    private User user;
    private UserController userController;

    @BeforeEach
    void beforeEach() {
        userController = new UserController(new UserService(new HashMap<>()));
        user =buildUser(1, "test@test.com", "login", "UserName",
                LocalDate.of(1990, 10, 01));

    }

    @Test
    void shouldCreateUser() {
        userController.createUser(user);
        assertEquals(1, userController.findAllUsers().size());
    }

    @Test
    void shouldUpdateUser() {
        User user2 = buildUser(1, "test22@test.com", "login2", "UserNewName",
                LocalDate.of(1990, 10, 01));

        userController.createUser(user);
        userController.updateUser(user2);
        List<User> userList = new ArrayList<>();
        userList.addAll(userController.findAllUsers());
        assertEquals("login2", userList.get(0).getLogin());
    }

    @Test
    void shouldThrowExceptionThenAddEmptyEmail() {
        User user2 = buildUser(2, "", "login2", "User2Name",
                LocalDate.of(1990, 10, 01));

        ValidationException exception = assertThrows(ValidationException.class, () -> userController.createUser(user2));
        assertEquals(exception.getMessage(), exception.getMessage());
    }

    @Test
    void shouldThrowExceptionThenAddEmailWithoutAtSign() {
        User user2 = buildUser(2, "test.test.com", "login2", "User2Name",
                LocalDate.of(1990, 10, 01));

        ValidationException exception = assertThrows(ValidationException.class, () -> userController.createUser(user2));
        assertEquals(exception.getMessage(), exception.getMessage());
    }

    @Test
    void shouldThrowExceptionThenAddEmptyLogin() {
        User user2 = buildUser(2, "test@test.com", "", "User2Name",
                LocalDate.of(1990, 10, 01));

        ValidationException exception = assertThrows(ValidationException.class, () -> userController.createUser(user2));
        assertEquals(exception.getMessage(), exception.getMessage());
    }

    @Test
    void shouldThrowExceptionThenAddLoginWithSpaces() {
        User user2 = buildUser(2,"test@test.com", " login", "User2Name",
                LocalDate.of(1990, 10, 01));

        ValidationException exception = assertThrows(ValidationException.class, () -> userController.createUser(user2));
        assertEquals(exception.getMessage(), exception.getMessage());
    }

    @Test
    void shouldThrowExceptionThenAddBirthdayInFuture() {
        User user2 = buildUser(2, "test@test.com", "login", "User2Name",
                LocalDate.of(2025, 10, 01));

        ValidationException exception = assertThrows(ValidationException.class, () -> userController.createUser(user2));
        assertEquals(exception.getMessage(), exception.getMessage());
    }

    @Test
    void shouldBingLoginToNameFieldThenIsEmpty() {
        User user2 =  buildUser(2, "test@test.com", "login", "",
                LocalDate.of(1990, 10, 01));

        userController.createUser(user2);
        List<User> userList = new ArrayList<>();
        userList.addAll(userController.findAllUsers());
        assertEquals("login", userList.get(0).getName());
    }

    private User buildUser(int id, String email, String login, String name, LocalDate birthday) {

        return User.builder()
                .id(id)
                .email(email)
                .login(login)
                .name(name)
                .birthday(birthday)
                .build();
    }
}
