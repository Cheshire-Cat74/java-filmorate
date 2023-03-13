package ru.yandex.practicum.filmorate.storage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import ru.yandex.practicum.filmorate.exception.NotFoundException;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.storage.user.UserDbStorage;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@AutoConfigureTestDatabase
class UserDbStorageTest {

    @Autowired
    private UserDbStorage userDbStorage;

    @Test
    void findAll() {
        List<User> list = userDbStorage.findAll();

        assertNotNull(list);
    }

    @Test
    void findById() {
        User user = userDbStorage.findById(2l);

        assertNotNull(user);
        assertEquals(2, user.getId());
        assertThrows(NotFoundException.class, ()->{userDbStorage.findById(9999l);});
    }

    @Test
    void insert() {
        User user = new User();
        user.setEmail("mail@google.com");
        user.setLogin("login");
        user.setBirthday(LocalDate.of(1999,1,5));

        User newUser = userDbStorage.insert(user);
        user = userDbStorage.findById(newUser.getId());

        assertNotNull(newUser);
        assertEquals(user, newUser);
    }

    @Test
    void update() {
        User user = userDbStorage.findById(3l);
        user.setEmail("newmail@yandex.ru");
        user.getFriends().add(1l);
        userDbStorage.update(user);
        User updUser = userDbStorage.findById(user.getId());

        assertEquals(user, updUser);

        user.setId(9999l);

        assertThrows(NotFoundException.class, ()->{userDbStorage.update(user);});
    }
}