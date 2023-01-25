package ru.yandex.practicum.filmorate.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Data
@Builder
public class User {

    private int id;
    private String email;
    private String login;
    private String name;
    private LocalDate birthday;

   /* public User(int userId, String email, String login, String userName, LocalDate birthday) {
        this.userId = userId;
        this.email = email;
        this.login = login;
        this.userName = userName;
        this.birthday = birthday;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }*/
}
